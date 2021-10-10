package util;

import java.util.List;
import java.util.Map;

public class EpsilonTransition extends Transition {
	private boolean canTrigger;

	public EpsilonTransition(State sender, State receiver, String reset, boolean canTrigger) {
		super(sender, receiver, reset);
		this.canTrigger = canTrigger;
	}

	@Override
	public boolean canTrigger(Map<String, Integer> clockValues, String receivedMessage, List<String> previousMessages) {
		System.out.println("[EpsilonTransition]" + toString() + " canTrigger is " + canTrigger);
		return canTrigger;
	}
	
	@Override
	public String toString() {
		return "epsilon, " + sender.getId() + "->" + receiver.getId();
	}

	@Override
	public int compareTo(Transition t2) {
		return -1;
	}

}
