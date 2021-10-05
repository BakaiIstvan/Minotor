package util;

import java.util.List;
import java.util.Map;

public abstract class Constraint {
	protected List<String> constraints;
	protected ClockConstraint clockConstraint;
	protected String reset;
	
	public Constraint(List<String> constraints, ClockConstraint clockConstraint, String reset) {
		this.constraints = constraints;
		this.clockConstraint = clockConstraint;
		this.reset = reset;
	}
	
	public List<String> getConstraints() { 
		return this.constraints;
	}
	
	public ClockConstraint getClockConstraint() {
		return this.clockConstraint;
	}

	public String getReset() {
		return reset;
	}
	
	public abstract boolean getSatisfied(Map<String, Integer> clockValues, List<String> previousMessages);
}
