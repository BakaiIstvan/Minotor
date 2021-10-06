package util;

import java.util.List;
import java.util.Map;

public class EpsilonTransition extends Transition {

	public EpsilonTransition(State sender, State receiver, String reset) {
		super(sender, receiver, reset);
	}

	@Override
	public boolean canTrigger(Map<String, Integer> clockValues, String receivedMessage, List<String> previousMessages) {
		return true;
	}
	
	@Override
	public String toString() {
		return "epsilon, " + sender.getId() + "->" + receiver.getId();
	}

	@Override
	public int compareTo(Transition t2) {
		return 0;
	}

}
