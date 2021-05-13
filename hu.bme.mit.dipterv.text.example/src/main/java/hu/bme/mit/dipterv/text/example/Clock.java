package hu.bme.mit.dipterv.text.example;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.time.StopWatch;

public class Clock implements IClock {
	private Map<String, StopWatch> stopwatches;

	public Clock() {
		stopwatches = new HashMap<>();
	}
	
	@Override
	public long getClock(String clock) {
		if (stopwatches.containsKey(clock)) {
			return stopwatches.get(clock).getTime();
		}
		
		return -1;
	}

	@Override
	public void resetClock(String clock) {
		if (stopwatches.containsKey(clock)) {
			stopwatches.get(clock).reset();
		} else {
			StopWatch watch = new StopWatch();
			watch.start();
			stopwatches.put(clock, watch);
		}
	}

}
