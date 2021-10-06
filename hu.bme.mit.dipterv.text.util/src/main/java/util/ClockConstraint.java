package util;

public class ClockConstraint {
	private String clockName;
	private ClockExpressionInterface clockConstraintExpression;
	
	public ClockConstraint(String clockName, ClockExpressionInterface clockConstraintExpression) {
		this.setClockName(clockName);
		this.clockConstraintExpression = clockConstraintExpression;
	}

	public String getClockName() {
		return clockName;
	}

	public void setClockName(String clockName) {
		this.clockName = clockName;
	}

	public ClockExpressionInterface getClockConstraintExpression() {
		return clockConstraintExpression;
	}

	public void setClockConstraintExpression(ClockExpressionInterface clockConstraintExpression) {
		this.clockConstraintExpression = clockConstraintExpression;
	}
	
	public boolean isSatisfied(int clockValue) {
		System.out.println("[ClockConstraint] clockValue = " + clockValue);
		return clockConstraintExpression.clockExpression(clockValue);
	}
}
