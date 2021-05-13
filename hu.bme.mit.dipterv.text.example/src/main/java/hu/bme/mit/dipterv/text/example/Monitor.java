package hu.bme.mit.dipterv.text.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class Monitor implements IMonitor {
	private Automaton automaton;
	private State actualState;
	private List<State> goodStates;
	private boolean requirementFullfilled;
	private IClock clock;
	
	public Monitor(Automaton automaton
				 , IClock clock) {
		this.automaton = automaton;
		this.actualState = automaton.getInitial();
		this.goodStates = new ArrayList<State>();
		this.goodStates.add(automaton.getFinale());
		this.requirementFullfilled = true;
		this.clock = clock;
	}
	
	@Override
	public boolean goodStateReached() {
		return this.goodStates.contains(actualState) && this.requirementFullfilled;
	}

	@Override
	public void update(String sender, String receiver, String messageType, String[] parameters) {
		List<Transition> transitions = automaton.findSender(this.actualState);
		String receivedMessage = getReceivedMessage(sender, receiver, messageType, parameters);
		System.out.println("Received Message: " + receivedMessage);
		boolean edgeTriggered = false;
		
		ListIterator<Transition> iterator = transitions.listIterator();
		while (iterator.hasNext()) {
			Transition transition = iterator.next();
			System.out.println("Transition: " + transition.getId());
			if (transition.getId().contains("epsilon")) {
				List<Transition> newTransitions = new ArrayList<Transition>(automaton.findSender(transition.getReceiver()));

				for (Transition t : newTransitions) {
					iterator.add(t);
					iterator.previous();
				}
				Transition prevTransition = iterator.previous();
				System.out.println("PrevTransition: " + prevTransition.getId());
				
				if (transitions.size() == 1) {
					this.actualState = transition.getReceiver();
					updateMonitorStatus(transition);
				}
				
				iterator.remove();
				if (!transitions.stream().anyMatch(t -> t.getId().contains("epsilon"))) {
					iterator = transitions.listIterator();
				}
			} else if (transitions.stream().anyMatch(t -> t.getId().contains("epsilon"))) {
				// do nothing
			} else if (transition.hasClock()) {
				if (transition.clockConditionSatisfied(clock.getClock(transition.getClock()))) {
					edgeTriggered = updateState(transition, messageType, sender, receiver, parameters, receivedMessage);
				}
			} else {
				edgeTriggered = updateState(transition, messageType, sender, receiver, parameters, receivedMessage);
			}
			
			if (edgeTriggered) {
				break;
			}
		}
		
		if (!edgeTriggered) {
			this.requirementFullfilled = false;
			System.out.println("Failure: receivedMessage didn't match any transitions.");
		}
	}
	
	private boolean updateState(Transition transition
						   , String messageType
						   , String sender
						   , String receiver
						   , String[] parameters
						   , String receivedMessage) {

		if (!transition.getId().contains("&")) {
			if (!transition.getId().contains("!")
		     && transition.getMessageType().equals(messageType)
		     && transition.getSenderName().equals(sender)
		     && transition.getReceiverName().equals(receiver)
		     && Arrays.equals(transition.getParameters(), parameters)) {

				this.actualState = transition.getReceiver();
				updateMonitorStatus(transition);
				return true;
			} else if (transition.getId().contains("!")
					&& (!transition.getMessageType().equals(messageType)
					|| !transition.getSenderName().equals(sender)
					|| !transition.getReceiverName().equals(receiver)
					|| !Arrays.equals(transition.getParameters(), parameters))) {

				this.actualState = transition.getReceiver();
				updateMonitorStatus(transition);
				return true;
			}
		} else if (!transition.getId().contains(receivedMessage)) {
			this.actualState = transition.getReceiver();
			updateMonitorStatus(transition);
			return true;
		}
		
		return false;
	}
	
	private void updateMonitorStatus(Transition transition) {
		if (actualState.getType().equals(StateType.FINAL)) {
			List<Transition> transitions = automaton.findSender(this.actualState);
			if (transitions.size() == 1 
			 && transitions.stream().anyMatch(t -> t.getId().equals("epsilon"))
			 && transitions.get(0).getReceiver().getType().equals(StateType.FINAL)) {
				transition = transitions.get(0);
				this.actualState = transition.getReceiver();
			}
		}
		
		System.out.println("transition triggered: " + transition.getId());
		System.out.println(actualState.getId());
				
		if (goodStateReached()) {
			Main.monitorStatus("System is in good state.");
		} else {
			Main.monitorStatus("System is in bad state.");
		}
		
		if (transition.hasReset()) {
			clock.resetClock(transition.getReset());
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
		// TODO Auto-generated method stub
		
	}
}
