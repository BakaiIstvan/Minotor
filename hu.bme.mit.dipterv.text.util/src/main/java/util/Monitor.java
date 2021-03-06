package util;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Monitor implements IMonitor {
	private Automaton automaton;
	private State actualState;
	private List<State> goodStates;
	private List<String> previousMessages;
	private boolean errorDetected;
	private IClock clock;
	private ISystem system;
	private String lastAcceptedMessage;
	
	private Entry<String, Object> lastParameter;

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
		this.lastParameter = null;
	}

	@Override
	public boolean goodStateReached() {
		return this.goodStates.contains(actualState) && !this.errorDetected;
	}

	@Override
	public void update(String sender
					 , String receiver
					 , String messageType
					 , Map<String, Object> parameters) {
		List<Transition> transitions = automaton.findSender(this.actualState);
		String receivedMessage = getReceivedMessage(sender, receiver, messageType, parameters);
		previousMessages.add(receivedMessage);
		System.out.println("Received Message: " + receivedMessage);
		boolean edgeTriggered = false;

		ListIterator<Transition> iterator = transitions.listIterator();
		while (iterator.hasNext()) {
			System.out.println("[Monitor] available transition are: ");
			System.out.println("------------------------------------");
			for (Transition t : transitions) {
				System.out.println(t.toString());
			}
			System.out.println("=----------------------------------=");
			Transition transition = iterator.next();
			System.out.println("Transition: " + transition.toString());
			if (transition instanceof EpsilonTransition && transition.canTrigger(null, receivedMessage, previousMessages, lastParameter)) {
				List<Transition> newTransitions = new ArrayList<Transition>(automaton.findSender(transition.getReceiver()));

				for (Transition t : newTransitions) {
					iterator.add(t);
					iterator.previous();
				}
				Transition prevTransition = iterator.previous();
				System.out.println("PrevTransition: " + prevTransition.toString());

				if (transitions.size() == 1) {
					if (this.actualState != transition.getReceiver()) {
						previousMessages.clear();
					}
					this.actualState = transition.getReceiver();
					updateMonitorStatus(transition, parameters);
				}

				iterator.remove();
				if (!transitions.stream().anyMatch(t -> t instanceof EpsilonTransition)) {
					transitions.sort((t1, t2) -> t1.compareTo(t2));
					iterator = transitions.listIterator();
				}
			} else if (transition instanceof EpsilonTransition && !transition.canTrigger(null, receivedMessage, previousMessages, lastParameter)) {
				iterator.remove();
				if (!transitions.stream().anyMatch(t -> t instanceof EpsilonTransition)) {
					iterator = transitions.listIterator();
				}
			} else if (transitions.stream().anyMatch(t -> t instanceof EpsilonTransition)) {
				// do nothing
			} else {
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
				
				if (transition.canTrigger(clockValues, receivedMessage, previousMessages, lastParameter)) {
					if (this.actualState != transition.getReceiver()) {
						previousMessages.clear();
					}
					this.actualState = transition.getReceiver();
					updateMonitorStatus(transition, parameters);
					edgeTriggered = true;

					if (this.actualState.getType().equals(StateType.ACCEPT) || this.actualState.getType().equals(StateType.ACCEPT_ALL)) {
						this.errorDetected = true;
						System.out.println("Failure: actual state is accept state -> error.");
						errorDetected(sender, receiver, messageType, parameters);
						system.receiveMonitorStatus("error detected");
						system.receiveMonitorError(receivedMessage, lastAcceptedMessage);
					}
					lastAcceptedMessage = receivedMessage;
				}
			}
			
			if (edgeTriggered) {
				break;
			}
		}
		
		if (!edgeTriggered) {
			this.errorDetected = true;
			System.out.println("Failure: receivedMessage didn't match any transitions.");
			errorDetected(sender, receiver, messageType, parameters);
			system.receiveMonitorStatus("error detected");
			system.receiveMonitorError(receivedMessage, lastAcceptedMessage);
		}
	}
	
	private void updateMonitorStatus(Transition transition, Map<String, Object> parameters) {
		System.out.println("transition triggered: " + transition.toString());
		System.out.println(actualState.getId());
		
		if (parameters.values().stream().anyMatch(o -> o instanceof Boolean)) {
			Entry<String, Object> entry = parameters.entrySet().stream().filter(t -> t.getValue() instanceof Boolean).findFirst().orElse(null);
			if (entry != null) {
				this.lastParameter = entry;
			}
		}

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
				
				System.out.println("transition triggered: " + transition.toString());
				System.out.println(actualState.getId());
				if (requirementSatisfied()) {
					system.receiveMonitorStatus("Requirement satisfied");
					system.receiveMonitorSuccess();
				}
			}
		}
	}

	private String getReceivedMessage(String sender, String receiver, String messageType, Map<String, Object> parameters) {
		String receivedMessage = sender + "." + messageType + "(";
		String[] stringParameters = new String[parameters.keySet().size()];
		parameters.keySet().toArray(stringParameters);
		for (String param : stringParameters) {
			receivedMessage += param;
			if (!(stringParameters[stringParameters.length - 1]).equals(param)) {
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

	@Override
	public void errorDetected(String sender, String receiver, String messageType, Map<String, Object> parameters) {
		System.out.println("Error detected when receiving message: " + getReceivedMessage(sender, receiver, messageType, parameters));
		//TODO: implement error tolerance here
	}

	@Override
	public void noMoreMessages() {
		List<Transition> transitions = automaton.findSender(this.actualState);
		System.out.println("[Monitor] No more messages");
		if (actualState.getType().equals(StateType.FINAL)) {
			if (transitions.stream().anyMatch(t -> t instanceof EpsilonTransition)
			 && transitions.stream().anyMatch(t -> t.getReceiver().getType().equals(StateType.FINAL))) {
				Transition transition = transitions.stream().filter(t -> t.getReceiver().getType().equals(StateType.FINAL)).findFirst().orElse(null);
				if (transition != null) {
					this.actualState = transition.getReceiver();
					
					System.out.println("transition triggered: " + transition.toString());
					System.out.println(actualState.getId());
					if (requirementSatisfied()) {
						system.receiveMonitorStatus("Requirement satisfied");
						system.receiveMonitorSuccess();
					}
					return;
				}
			}
		}
		
		System.out.println("[Monitor] Searching for accept state");
		
		if ((transitions.stream().anyMatch(t -> t.getReceiver().getType().equals(StateType.ACCEPT) && t.toString().contains("!"))
		|| transitions.stream().anyMatch(t -> t.getReceiver().getType().equals(StateType.ACCEPT_ALL) && t.toString().contains("!")))) {
			System.out.println("[Monitor] Accept state found");
			Transition transition = transitions.stream().filter(t -> (t.getReceiver().getType().equals(StateType.ACCEPT) 
																   || t.getReceiver().getType().equals(StateType.ACCEPT_ALL)) 
																   && t.toString().contains("!"))
														.findFirst()
														.orElse(null);
			if (transition != null) {
				this.actualState = transition.getReceiver();
				System.out.println("transition triggered: " + transition.toString());
				System.out.println(actualState.getId());
				
				this.errorDetected = true;
				System.out.println("Failure: actual state is accept state -> error.");
				errorDetected("noMessageSender", "noMessageReceiver", transition.toString(), new HashMap<String, Object>());
				system.receiveMonitorStatus("error detected");
				system.receiveMonitorError(transition.toString(), lastAcceptedMessage);
			}
		}
	}
}
