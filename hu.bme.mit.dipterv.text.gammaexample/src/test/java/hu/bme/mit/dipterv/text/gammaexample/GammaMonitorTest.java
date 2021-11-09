package hu.bme.mit.dipterv.text.gammaexample;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Assertions;

import generated.Specification;
import hu.bme.mit.gamma.tutorial.extra.VirtualTimerService;
import hu.bme.mit.gamma.tutorial.extra.monitoredcrossroad.ReflectiveMonitoredCrossroad;
import util.IClock;
import util.IMonitor;
import util.ISystem;
import util.Monitor;
import util.Clock;

public class GammaMonitorTest implements ISystem {
	private boolean requirementSatisfied = false;
	private boolean errorDetected = false;
	
	private static ReflectiveMonitoredCrossroad reflectiveMonitoredCrossroad;
	private static VirtualTimerService timer;

	//TODO: use @BeforeEach, didn't work for some reason last time
	public void resetValues() {
		requirementSatisfied = false;
		errorDetected = false;
		timer = new VirtualTimerService();
		reflectiveMonitoredCrossroad = new ReflectiveMonitoredCrossroad(timer, this);  // Virtual timer is automatically set
		System.out.println("[GammaMonitorTest] Resetting values");
	}
	
	public void tearDown() {
		stop();
	}
	
	// Only for override by potential subclasses
	protected void stop() {
		timer = null;
		reflectiveMonitoredCrossroad = null;				
	}

	@Test
	public void testNetworkRequirementSatisfied() {
		resetValues();
		
		timer.reset(); // Timer before the system
		reflectiveMonitoredCrossroad.reset();
		
		timer.elapse(2000);
		reflectiveMonitoredCrossroad.schedule(null);
		
		timer.elapse(2000);
		reflectiveMonitoredCrossroad.schedule(null);
		
		Assertions.assertTrue(reflectiveMonitoredCrossroad.getWrappedComponent().getMonitor().goodStateReached());
		Assertions.assertTrue(reflectiveMonitoredCrossroad.getWrappedComponent().getMonitor().requirementSatisfied());
		Assertions.assertTrue(requirementSatisfied);
		Assertions.assertFalse(errorDetected);
		tearDown();
	}

	@Override
	public void receiveMonitorStatus(String message) {
		System.out.println("[GammaMonitorTest] Received status from monitor: " + message);
	}

	@Override
	public void receiveMonitorError(String actualMessage, String lastAcceptedMessage) {
		System.out.println("[GammaMonitorTest] Received error report from Monitor for " + actualMessage + " message.");
		System.out.println("Last accepted message was: " + lastAcceptedMessage);
		errorDetected = true;
	}

	@Override
	public void receiveMonitorSuccess() {
		System.out.println("[GammaMonitorTest] Monitor reported that the requirement was satisfied");
		requirementSatisfied = true;
	}
}
