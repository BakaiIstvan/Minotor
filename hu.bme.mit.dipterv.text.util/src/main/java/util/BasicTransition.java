package util;

import java.util.List;
import java.util.Map;

public class BasicTransition extends Transition {
	private String label;
	private Constraint constraint;
	private ClockConstraint clockConstraint;
	
	public BasicTransition(State sender
						 , State receiver
						 , String reset
						 , String label
						 , Constraint constraint
						 , ClockConstraint clockConstraint) {
		
		super(sender, receiver, reset);
		this.setLabel(label);
		this.setConstraint(constraint);
		this.setClockConstraint(clockConstraint);
	}

	public BasicTransition(BasicTransition basict) {
		super(basict.getSender(), basict.getReceiver(), basict.getReset());
		this.setLabel(basict.getLabel());
		this.setConstraint(basict.getConstraint());
		this.setClockConstraint(basict.getClockConstraint());
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Constraint getConstraint() {
		return constraint;
	}

	public void setConstraint(Constraint constraint) {
		this.constraint = constraint;
	}

	public ClockConstraint getClockConstraint() {
		return clockConstraint;
	}

	public void setClockConstraint(ClockConstraint clockConstraint) {
		this.clockConstraint = clockConstraint;
	}
	
	public boolean canTrigger(Map<String, Integer> clockValues, String receivedMessage, List<String> previousMessages) {
		
		return (receivedMessage.equals(label) || label.contains("!"))
			&& (constraint != null ? constraint.getSatisfied(clockValues, previousMessages) : true)
			&& (clockConstraint != null ? clockConstraint.isSatisfied(clockValues.get(clockConstraint.getClockName())) : true);
	}
}
