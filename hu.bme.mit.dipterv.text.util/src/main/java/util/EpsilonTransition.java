package util;

public class EpsilonTransition extends Transition {

	public EpsilonTransition(State sender, State receiver, String reset) {
		super(sender, receiver, reset);
	}

}
