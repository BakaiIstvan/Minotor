package util;

import java.util.List;
import java.util.Map;

public class EpsilonTransition extends Transition {
	private AltExpressionInterface altExpression;

	public EpsilonTransition(State sender
						   , State receiver
						   , String reset
						   , AltExpressionInterface altExpression) {

		super(sender, receiver, reset);
		this.altExpression = altExpression;
	}

	@Override
	public boolean canTrigger(Map<String, Integer> clockValues
							, String receivedMessage
							, List<String> previousMessages
							, boolean parameterValue) {

		if (altExpression != null) {
			System.out.println("[EpsilonTransition]" + toString() + " canTrigger is " + altExpression.altExpression(parameterValue));
			return altExpression.altExpression(parameterValue);
		}
		
		System.out.println("[EpsilonTransition]" + toString() + " canTrigger is true");
		return true;
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
