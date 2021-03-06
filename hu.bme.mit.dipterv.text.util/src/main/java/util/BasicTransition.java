package util;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
	
	@Override
	public boolean canTrigger(Map<String, Integer> clockValues
							, String receivedMessage
							, List<String> previousMessages
							, Entry<String, Object> parameterValue) {
		if (label != null ) {
			return (!label.contains("!") ? receivedMessage.equals(label) : !receivedMessage.equals(label.substring(2, label.length() - 1)))
					&& (constraint != null ? constraint.getSatisfied(clockValues, previousMessages) : true)
					&& (clockConstraint != null ? clockConstraint.isSatisfied(clockValues.get(clockConstraint.getClockName())) : true);
		} else {
			return (constraint != null ? constraint.getSatisfied(clockValues, previousMessages) : true)
				&& (clockConstraint != null ? clockConstraint.isSatisfied(clockValues.get(clockConstraint.getClockName())) : true);
		}
	}
	
	@Override
	public String toString() {
		return label + ", " + sender.getId() + "->" + receiver.getId()
			 + ", " + (constraint != null ? constraint.getConstraints().toString() : "")
			 + ", " + (clockConstraint != null? clockConstraint.getClockConstraintExpression().toString() : "");
	}

	@Override
	public int compareTo(Transition t2) {
		if (this.toString().contains("!") && t2.toString().contains("!")) {
			if (!this.getSender().getId().equals(this.getReceiver().getId())
			 && t2.getSender().getId().equals(t2.getReceiver().getId())
			 && (this.getReceiver().getType().equals(StateType.NORMAL) || this.getReceiver().getType().equals(StateType.FINAL))) {
				return -1;
			} else if (this.getSender().getId().equals(this.getReceiver().getId())
					&& !t2.getSender().getId().equals(t2.getReceiver().getId())
					&& (t2.getReceiver().getType().equals(StateType.NORMAL) || t2.getReceiver().getType().equals(StateType.FINAL))) {
				return 1;
			} else {
				return 0;
			}
		}
		
		
		if (!this.getSender().getId().equals(this.getReceiver().getId())
		 && t2.getSender().getId().equals(t2.getReceiver().getId())) {
			return -1;
		} else if (this.getSender().getId().equals(this.getReceiver().getId())
				&& !t2.getSender().getId().equals(t2.getReceiver().getId())) {
			return 1;
		}
		
		return 0;
	}
}