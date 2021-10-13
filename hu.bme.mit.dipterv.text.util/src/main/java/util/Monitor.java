package util;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.stream.Collectors;

public class Monitor implements IMonitor {
	private Automaton automaton;
	private State actualState;
	private List<State> goodStates;
	private List<String> previousMessages;
	private boolean errorDetected;
	private IClock clock;
	private ISystem system;
	private String lastAcceptedMessage;
	private List<State> epsilonStates;

	public Monitor(Automaton automaton
				 , IClock clock
				 , ISystem system) {
		this.automaton = automaton;
		this.actualState = automaton.getInitial();
		this.previousMessages = new ArrayList<String>();

		this.goodStates = automaton.getStates().stream()
	           .filter(state -> state.getType().equals(StateType.NORMAL) || state.getType().equals(StateType.FINAL))
	           .collect(Collectors.toList());

		this.errorDetected = false;
		this.clock = clock;
		this.system = system;
		this.lastAcceptedMessage = "";
		this.epsilonStates = new ArrayList<State>();
	}

	@Override
	public boolean goodStateReached() {
		return this.goodStates.contains(actualState) && !this.errorDetected;
	}

	@Override
	public void update(String sender, String receiver, String messageType, String[] parameters) {
		List<Transition> transitions = automaton.findSender(this.actualState);
		String receivedMessage = getReceivedMessage(sender, receiver, messageType, parameters);
		previousMessages.add(receivedMessage);
		System.out.println("Received Message: " + receivedMessage);
		boolean edgeTriggered = false;

		if (transitions.stream().anyMatch(t -> t instanceof EpsilonTransition)) {
			updateWithEpsilon(transitions, receivedMessage);
			return;
		} else if(!epsilonStates.isEmpty()) {
			processEpsilonStates(receivedMessage);
			return;
		} else {
			for (Transition transition : transitions) {
				if (canBasicTransitionTrigger(transition, receivedMessage)) {
					this.actualState = transition.getReceiver();
					updateMonitorStatus(transition);
					edgeTriggered = true;

					if (this.actualState.getType().equals(StateType.ACCEPT) || this.actualState.getType().equals(StateType.ACCEPT_ALL)) {
						this.errorDetected = true;
						system.receiveMonitorStatus("Failure: accept state reached.");
						system.receiveMonitorError(receivedMessage, lastAcceptedMessage);
					}
					lastAcceptedMessage = receivedMessage;
				}

				if (edgeTriggered) {
					break;
				}
			}
		}

		if (!edgeTriggered) {
			this.errorDetected = true;
			system.receiveMonitorStatus("Failure: " + receivedMessage + " didn't match any transitions.");
			system.receiveMonitorError(receivedMessage, lastAcceptedMessage);
		}
	}

	private void updateWithEpsilon(List<Transition> transitions, String receivedMessage) {
		for (Transition transition : transitions) {
			EpsilonTransition eTransition = (EpsilonTransition)transition;
			if (eTransition.canTrigger(null, receivedMessage, previousMessages)) {
				epsilonStates.add(eTransition.getReceiver());
			}
		}

		processEpsilonStates(receivedMessage);
	}

	private void processEpsilonStates(String receivedMessage) {
		List<State> newEpsilonStates = new ArrayList<State>();
		boolean edgeTriggered = false;
		for (State state : epsilonStates) {
			List<Transition> availableTransitions = automaton.findSender(state);
			
			ListIterator<Transition> iterator = availableTransitions.listIterator();
			while (iterator.hasNext()) {
				Transition availableTransition = iterator.next();
				if (availableTransition instanceof EpsilonTransition && availableTransition.canTrigger(null, receivedMessage, previousMessages)) {
					List<Transition> newTransitions = new ArrayList<Transition>(automaton.findSender(availableTransition.getReceiver()));

					for (Transition t : newTransitions) {
						iterator.add(t);
						iterator.previous();
					}
					Transition prevTransition = iterator.previous();
					System.out.println("PrevTransition: " + prevTransition.toString());

					if (availableTransitions.size() == 1) {
						// this.actualState = availableTransition.getReceiver();
						updateMonitorStatus(availableTransition);
					}

					iterator.remove();
					if (!availableTransitions.stream().anyMatch(t -> t instanceof EpsilonTransition)) {
						availableTransitions.sort((t1, t2) -> t1.compareTo(t2));
						iterator = availableTransitions.listIterator();
					}
				} else if (availableTransition instanceof EpsilonTransition 
						&& !availableTransition.canTrigger(null, receivedMessage, previousMessages)) {

					iterator.remove();
					if (!availableTransitions.stream().anyMatch(t -> t instanceof EpsilonTransition)) {
						iterator = availableTransitions.listIterator();
					}
				} else if (availableTransitions.stream().anyMatch(t -> t instanceof EpsilonTransition)) {
					// do nothing
				} else {
					if (canBasicTransitionTrigger(availableTransition, receivedMessage)) {
						if (availableTransition.getReceiver().getType().equals(StateType.FINAL)) {
							List<Transition> transitions = automaton.findSender(availableTransition.getReceiver());
							if (transitions.size() == 1
							 && transitions.stream().anyMatch(t -> t instanceof EpsilonTransition)
							 && transitions.get(0).getReceiver().getType().equals(StateType.FINAL)) {
								Transition transition = transitions.get(0);
								newEpsilonStates.add(transition.getReceiver());
	
								System.out.println("[Monitor] Transition triggered: " + transition.toString());
								if (requirementSatisfied()) {
									system.receiveMonitorStatus("Requirement satisfied");
									system.receiveMonitorSuccess();
								}
							}
						}
						newEpsilonStates.add(availableTransition.getReceiver());
						edgeTriggered = true;
						updateMonitorStatus(availableTransition);
						
					}
				}
			}
		}

		epsilonStates = newEpsilonStates;
		if (epsilonStates.stream().allMatch(s -> s.getType().equals(StateType.ACCEPT) || s.getType().equals(StateType.ACCEPT_ALL))) {
			this.errorDetected = true;
			system.receiveMonitorStatus("Failure: accept state reached.");
			system.receiveMonitorError(receivedMessage, lastAcceptedMessage);
		}
		
		if (!edgeTriggered) {
			this.errorDetected = true;
			system.receiveMonitorStatus("Failure: " + receivedMessage + " didn't match any transitions.");
			system.receiveMonitorError(receivedMessage, lastAcceptedMessage);
		}
		
		State finalState = epsilonStates.stream().filter(s -> s == this.automaton.getFinale()).findFirst().orElse(null);
		if (finalState != null) {
			this.actualState = finalState;
			if (requirementSatisfied()) {
				system.receiveMonitorStatus("Requirement satisfied");
				system.receiveMonitorSuccess();
			}
		}
	}

	private boolean canBasicTransitionTrigger(Transition transition, String receivedMessage) {
		BasicTransition btransition = (BasicTransition)transition;
		Map<String, Integer> clockValues = null;
		if (btransition.getConstraint() != null || btransition.getClockConstraint() != null) {
			clockValues = new HashMap<String, Integer>();

			if (btransition.getClockConstraint() != null) {
				clockValues.put(btransition.getClockConstraint().getClockName()
								, (int)clock.getClock(btransition.getClockConstraint().getClockName()));
			}

			if (btransition.getConstraint() != null && btransition.getConstraint().getClockConstraint() != null) {
				clockValues.put(btransition.getConstraint().getClockConstraint().getClockName()
								, (int)clock.getClock(btransition.getConstraint().getClockConstraint().getClockName()));
			}
		}

		if (transition.canTrigger(clockValues, receivedMessage, previousMessages)) {
			return true;
		}

		return false;
	}

	private void updateMonitorStatus(Transition transition) {
		System.out.println("[Monitor] Transition triggered: " + transition.toString());
		System.out.println(actualState.getId());

		if (goodStateReached()) {
			system.receiveMonitorStatus("System is in good state.");
		} else {
			system.receiveMonitorStatus("System is in bad state.");
		}

		if (requirementSatisfied()) {
			system.receiveMonitorStatus("Requirement satisfied");
			system.receiveMonitorSuccess();
		}

		if (transition.hasReset()) {
			clock.resetClock(transition.getReset());
		}

		if (transition instanceof BasicTransition) {
			BasicTransition btransition = (BasicTransition) transition;
			if (btransition.getConstraint() != null) {
				if (btransition.getConstraint().getReset() != null && !btransition.getConstraint().getReset().isEmpty()) {
					clock.resetClock(btransition.getConstraint().getReset());
				}
			}
		}

		if (actualState.getType().equals(StateType.FINAL)) {
			List<Transition> transitions = automaton.findSender(this.actualState);
			if (transitions.size() == 1
			 && transitions.stream().anyMatch(t -> t instanceof EpsilonTransition)
			 && transitions.get(0).getReceiver().getType().equals(StateType.FINAL)) {
				transition = transitions.get(0);
				this.actualState = transition.getReceiver();

				System.out.println("[Monitor] Transition triggered: " + transition.toString());
				if (requirementSatisfied()) {
					system.receiveMonitorStatus("Requirement satisfied");
					system.receiveMonitorSuccess();
				}
			}
		}
	}

	private String getReceivedMessage(String sender, String receiver, String messageType, String[] parameters) {
		String receivedMessage = sender + "." + messageType + "(";
		for (String param : parameters) {
			receivedMessage += param;
			if (!(parameters[parameters.length - 1]).equals(param)) {
				receivedMessage += ", ";
			}
		}
		receivedMessage += ")." + receiver;

		return receivedMessage;
	}

	@Override
	public boolean requirementSatisfied() {
		return this.actualState == this.automaton.getFinale() && goodStateReached();
	}
}
