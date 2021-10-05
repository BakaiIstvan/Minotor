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
	private boolean requirementFullfilled;
	private IClock clock;
	private ISystem system;
	
	public Monitor(Automaton automaton
				 , IClock clock
				 , ISystem system) {
		this.automaton = automaton;
		this.actualState = automaton.getInitial();
		this.previousMessages = new ArrayList<String>();

		this.goodStates = automaton.getStates().stream()
	           .filter(state -> state.getType().equals(StateType.NORMAL) || state.getType().equals(StateType.FINAL))
	           .collect(Collectors.toList());

		this.requirementFullfilled = true;
		this.clock = clock;
		this.system = system;
	}
	
	@Override
	public boolean goodStateReached() {
		return this.goodStates.contains(actualState) && this.requirementFullfilled;
	}

	@Override
	public void update(String sender, String receiver, String messageType, String[] parameters) {
		List<Transition> transitions = automaton.findSender(this.actualState);
		String receivedMessage = getReceivedMessage(sender, receiver, messageType, parameters);
		previousMessages.add(receivedMessage);
		System.out.println("Received Message: " + receivedMessage);
		boolean edgeTriggered = false;
		
		ListIterator<Transition> iterator = transitions.listIterator();
		while (iterator.hasNext()) {
			Transition transition = iterator.next();
			System.out.println("Transition: " + transition.toString());
			if (transition instanceof EpsilonTransition) {
				List<Transition> newTransitions = new ArrayList<Transition>(automaton.findSender(transition.getReceiver()));

				for (Transition t : newTransitions) {
					iterator.add(t);
					iterator.previous();
				}
				Transition prevTransition = iterator.previous();
				System.out.println("PrevTransition: " + prevTransition.toString());
				
				if (transitions.size() == 1) {
					this.actualState = transition.getReceiver();
					updateMonitorStatus(transition);
				}
				
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
					
					if (btransition.getConstraint() != null) {
						clockValues.put(btransition.getConstraint().getClockConstraint().getClockName()
								      , (int)clock.getClock(btransition.getConstraint().getClockConstraint().getClockName()));
					}
				}
				
				if (transition.canTrigger(clockValues, receivedMessage, previousMessages)) {
					this.actualState = transition.getReceiver();
					updateMonitorStatus(transition);
					edgeTriggered = true;
				}
			}
			
			if (edgeTriggered) {
				break;
			}
		}
		
		if (!edgeTriggered) {
			this.requirementFullfilled = false;
			System.out.println("Failure: receivedMessage didn't match any transitions.");
			errorDetected(sender, receiver, messageType, parameters);
		}
	}
	
	private void updateMonitorStatus(Transition transition) {
		if (actualState.getType().equals(StateType.FINAL)) {
			List<Transition> transitions = automaton.findSender(this.actualState);
			if (transitions.size() == 1 
			 && transitions.stream().anyMatch(t -> t instanceof EpsilonTransition)
			 && transitions.get(0).getReceiver().getType().equals(StateType.FINAL)) {
				transition = transitions.get(0);
				this.actualState = transition.getReceiver();
			}
		}
		
		System.out.println("transition triggered: " + transition.toString());
		System.out.println(actualState.getId());
				
		if (goodStateReached()) {
			system.receiveMonitorStatus("System is in good state.");
		} else {
			system.receiveMonitorStatus("System is in bad state.");
		}
		
		if (requirementSatisfied()) {
			system.receiveMonitorStatus("Requirement satisfied");
		}
		
		if (transition.hasReset()) {
			clock.resetClock(transition.getReset());
		}
		
		BasicTransition btransition = (BasicTransition) transition;
		if (btransition.getConstraint() != null) {
			if (btransition.getConstraint().getReset() != null && !btransition.getConstraint().getReset().isEmpty()) {
				clock.resetClock(btransition.getConstraint().getReset());
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
		return this.actualState == this.automaton.getFinale();
	}

	@Override
	public void errorDetected(String sender, String receiver, String messageType, String[] parameters) {
		System.out.println("Error detected when receiving message: " + getReceivedMessage(sender, receiver, messageType, parameters));
		//TODO: implement error tolerance here
	}
}
