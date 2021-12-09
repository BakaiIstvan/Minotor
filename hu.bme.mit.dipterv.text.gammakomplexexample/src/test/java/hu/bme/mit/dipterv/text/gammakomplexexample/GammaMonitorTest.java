package hu.bme.mit.dipterv.text.gammakomplexexample;

import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import hu.bme.mit.gamma.tutorial.extra.VirtualTimerService;
import hu.bme.mit.gamma.tutorial.extra.monitoredcrossroad.ReflectiveMonitoredCrossroad;
import util.ISystem;

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
	public void testCrossroadRequirementSatisfied() {
		resetValues();
		
		reflectiveMonitoredCrossroad.getWrappedComponent().checkForPoliceRaise();
		
		timer.reset(); // Timer before the system
		reflectiveMonitoredCrossroad.reset();
		
		timer.elapse(2000);
		reflectiveMonitoredCrossroad.getWrappedComponent().runFullCycle();
		
		Assertions.assertTrue(reflectiveMonitoredCrossroad.getWrappedComponent().getMonitor().goodStateReached());
		Assertions.assertTrue(reflectiveMonitoredCrossroad.getWrappedComponent().getMonitor().requirementSatisfied());
		Assertions.assertTrue(requirementSatisfied);
		Assertions.assertFalse(errorDetected);
		tearDown();
	}
	
	@Test
	public void testPoliceCaseRequirementSatisfied() {
		resetValues();
		
		timer.reset(); // Timer before the system
		reflectiveMonitoredCrossroad.reset();

		reflectiveMonitoredCrossroad.raiseEvent("police", "police", new String[] {});
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		reflectiveMonitoredCrossroad.schedule(null);

		timer.elapse(2000);
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		reflectiveMonitoredCrossroad.schedule(null);

		Assertions.assertTrue(reflectiveMonitoredCrossroad.isRaisedEvent("priorityOutput", "displayYellow", new Object[] {}));
		Assertions.assertTrue(reflectiveMonitoredCrossroad.isRaisedEvent("secondaryOutput", "displayYellow", new Object[] {}));

		timer.elapse(1000);
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		reflectiveMonitoredCrossroad.schedule(null);

		Assertions.assertTrue(reflectiveMonitoredCrossroad.isRaisedEvent("secondaryOutput", "displayNone", new Object[] {}));
		Assertions.assertTrue(reflectiveMonitoredCrossroad.isRaisedEvent("priorityOutput", "displayNone", new Object[] {}));

		timer.elapse(1000);
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		reflectiveMonitoredCrossroad.schedule(null);

		timer.elapse(1000);
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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
