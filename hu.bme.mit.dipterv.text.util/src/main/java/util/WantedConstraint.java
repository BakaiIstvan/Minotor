package util;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class WantedConstraint extends Constraint {

	public WantedConstraint(List<String> constraints, ClockConstraint clockConstraint, String reset) {
		super(constraints, clockConstraint, reset);
	}

	public boolean getSatisfied(Map<String, Integer> clockValues, List<String> previousMessages) {
		return !Collections.disjoint(constraints, previousMessages) 
			&& (clockConstraint != null ? clockConstraint.isSatisfied(clockValues.get(clockConstraint.getClockName())) : true);
	}
	
}
