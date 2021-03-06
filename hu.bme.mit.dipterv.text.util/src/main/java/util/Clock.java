package util;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.StopWatch;

public class Clock implements IClock {
	private Map<String, StopWatch> stopwatches;

	public Clock() {
		stopwatches = new HashMap<>();
	}
	
	@Override
	public long getClock(String clock) {
		if (stopwatches.containsKey(clock)) {
			System.out.println("[Clock] clock " + clock + " is: " + stopwatches.get(clock).getTime(TimeUnit.SECONDS));
			return stopwatches.get(clock).getTime(TimeUnit.SECONDS);
		}
		
		return -1;
	}

	@Override
	public void resetClock(String clock) {
		System.out.println("[Clock] reset " + clock);
		if (stopwatches.containsKey(clock)) {
			stopwatches.get(clock).reset();
			if (!stopwatches.get(clock).isStarted()) {
				stopwatches.get(clock).start();
			}
		} else {
			StopWatch watch = new StopWatch();
			watch.start();
			stopwatches.put(clock, watch);
		}
	}

}
