package hu.bme.mit.dipterv.text.mobileexample;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Assertions;

import generated.Specification;
import util.Clock;
import util.IClock;
import util.IMonitor;
import util.ISystem;
import util.Monitor;

public class MobileMonitorTest implements ISystem {
	private boolean requirementSatisfied = false;
	private boolean errorDetected = false;
	
	@Test
	public void testMobileRequirementSatisfied() {
		resetValues();
		Specification specification = new Specification();
		specification.listAutomatas();
		IClock clock = new Clock();
		IMonitor monitor = new Monitor(specification.getAutomata().get(0), clock, this);
		
		monitor.update("user", "device", "openApp", new String[] {}, true);
		monitor.update("device", "device", "accessWebcam", new String[] {}, true);
		monitor.update("device", "user", "getPhoto", new String[] {}, true);
		monitor.update("someone", "else", "message", new String[] {}, true);
		monitor.update("device", "db", "retrieveMood", new String[] {}, true);
		monitor.update("device", "db", "retrieveMusic", new String[] {}, true);
		monitor.update("db", "device", "generatePlaylist", new String[] {}, true);

		Assertions.assertTrue(monitor.goodStateReached());
		Assertions.assertTrue(monitor.requirementSatisfied());
		Assertions.assertTrue(requirementSatisfied);
		Assertions.assertFalse(errorDetected);
	}
	
	@Test
	public void testMobileWithError() {
		resetValues();
		Specification specification = new Specification();
		specification.listAutomatas();
		IClock clock = new Clock();
		IMonitor monitor = new Monitor(specification.getAutomata().get(0), clock, this);
		
		monitor.update("user", "device", "openApp", new String[] {}, true);
		monitor.update("device", "device", "accessWebcam", new String[] {}, true);
		monitor.update("device", "user", "getPhoto", new String[] {}, true);
		monitor.update("user", "device", "cameraOffline", new String[] {}, true);
		monitor.update("device", "db", "retrieveMood", new String[] {}, true);
		monitor.update("device", "db", "retrieveMusic", new String[] {}, true);
		monitor.update("db", "device", "generatePlaylist", new String[] {}, true);

		Assertions.assertFalse(monitor.goodStateReached());
		Assertions.assertFalse(monitor.requirementSatisfied());
		Assertions.assertFalse(requirementSatisfied);
		Assertions.assertTrue(errorDetected);
	}
	
	@Test
	public void testMobileWithDelay() {
		resetValues();
		System.out.println("---------------------");
		System.out.println("[MobileMonitorTest] Starting delay test");
		Specification specification = new Specification();
		specification.listAutomatas();
		IClock clock = new Clock();
		IMonitor monitor = new Monitor(specification.getAutomata().get(0), clock, this);
	
		monitor.update("user", "device", "openApp", new String[] {}, true);
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		monitor.update("device", "device", "accessWebcam", new String[] {}, true);
		monitor.update("device", "user", "getPhoto", new String[] {}, true);
		monitor.update("someone", "else", "message", new String[] {}, true);
		monitor.update("device", "db", "retrieveMood", new String[] {}, true);
		monitor.update("device", "db", "retrieveMusic", new String[] {}, true);
		monitor.update("db", "device", "generatePlaylist", new String[] {}, true);

		Assertions.assertTrue(monitor.goodStateReached());
		Assertions.assertTrue(monitor.requirementSatisfied());
		Assertions.assertTrue(requirementSatisfied);
		Assertions.assertFalse(errorDetected);
		System.out.println("---------------------");
	}
	
	@Test
	public void testMobileWithTooMuchDelay() {
		resetValues();
		System.out.println("---------------------");
		System.out.println("[MobileMonitorTest] Starting TooMuch delay test");
		Specification specification = new Specification();
		specification.listAutomatas();
		IClock clock = new Clock();
		IMonitor monitor = new Monitor(specification.getAutomata().get(0), clock, this);
		
		monitor.update("user", "device", "openApp", new String[] {}, true);
		try {
			TimeUnit.SECONDS.sleep(6);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		monitor.update("device", "device", "accessWebcam", new String[] {}, true);
		monitor.update("device", "user", "getPhoto", new String[] {}, true);
		monitor.update("someone", "else", "message", new String[] {}, true);
		monitor.update("device", "db", "retrieveMood", new String[] {}, true);
		monitor.update("device", "db", "retrieveMusic", new String[] {}, true);
		monitor.update("db", "device", "generatePlaylist", new String[] {}, true);

		Assertions.assertFalse(monitor.goodStateReached());
		Assertions.assertFalse(monitor.requirementSatisfied());
		Assertions.assertFalse(requirementSatisfied);
		Assertions.assertTrue(errorDetected);
		System.out.println("---------------------");
	}

	@Test
	public void testMobileMissingRequiredMessage() {
		resetValues();
		Specification specification = new Specification();
		specification.listAutomatas();
		IClock clock = new Clock();
		IMonitor monitor = new Monitor(specification.getAutomata().get(0), clock, this);

		monitor.update("user", "device", "openApp", new String[] {}, true);
		monitor.update("device", "device", "accessWebcam", new String[] {}, true);
		monitor.update("device", "user", "getPhoto", new String[] {}, true);
		monitor.update("someone", "else", "message", new String[] {}, true);
		monitor.update("device", "db", "retrieveGoods", new String[] {}, true);
		monitor.update("device", "db", "retrieveMusic", new String[] {}, true);
		monitor.update("db", "device", "generatePlaylist", new String[] {}, true);

		Assertions.assertFalse(monitor.goodStateReached());
		Assertions.assertFalse(monitor.requirementSatisfied());
		Assertions.assertFalse(requirementSatisfied);
		Assertions.assertTrue(errorDetected);
	}

	@Test
	public void testMobileRequiredEventually() {
		resetValues();
		Specification specification = new Specification();
		specification.listAutomatas();
		IClock clock = new Clock();
		IMonitor monitor = new Monitor(specification.getAutomata().get(0), clock, this);
		
		monitor.update("user", "device", "openApp", new String[] {}, true);
		monitor.update("device", "device", "accessWebcam", new String[] {}, true);
		monitor.update("device", "user", "getPhoto", new String[] {}, true);
		monitor.update("someone", "else", "message", new String[] {}, true);
		monitor.update("device", "db", "retrieveMood", new String[] {}, true);
		monitor.update("somebody", "receiver", "getThisMessage", new String[] {}, true);
		monitor.update("you", "me", "didyougetthemessage", new String[] {}, true);
		monitor.update("device", "db", "retrieveMusic", new String[] {}, true);
		monitor.update("db", "device", "generatePlaylist", new String[] {}, true);

		Assertions.assertTrue(monitor.goodStateReached());
		Assertions.assertTrue(monitor.requirementSatisfied());
		Assertions.assertTrue(requirementSatisfied);
		Assertions.assertFalse(errorDetected);
	}

	@Test
	public void testMobileRequiredNotReceived() {
		resetValues();
		Specification specification = new Specification();
		specification.listAutomatas();
		IClock clock = new Clock();
		IMonitor monitor = new Monitor(specification.getAutomata().get(0), clock, this);
		
		monitor.update("user", "device", "openApp", new String[] {}, true);
		monitor.update("device", "device", "accessWebcam", new String[] {}, true);
		monitor.update("device", "user", "getPhoto", new String[] {}, true);
		monitor.update("someone", "else", "message", new String[] {}, true);
		monitor.update("device", "db", "retrieveMood", new String[] {}, true);
		monitor.update("somebody", "receiver", "getThisMessage", new String[] {}, true);
		monitor.update("you", "me", "didyougetthemessage", new String[] {}, true);
		monitor.noMoreMessages();

		Assertions.assertFalse(monitor.goodStateReached());
		Assertions.assertFalse(monitor.requirementSatisfied());
		Assertions.assertFalse(requirementSatisfied);
		Assertions.assertTrue(errorDetected);
	}

	public void resetValues() {
		requirementSatisfied = false;
		errorDetected = false;
	}

	@Override
	public void receiveMonitorStatus(String message) {
		System.out.println("[MobileMonitorTest] Received status from monitor: " + message);
	}

	@Override
	public void receiveMonitorError(String actualMessage, String lastAcceptedMessage) {
		System.out.println("[MobileMonitorTest] Received error report from Monitor for " + actualMessage + " message.");
		System.out.println("Last accepted message was: " + lastAcceptedMessage);
		errorDetected = true;
	}

	@Override
	public void receiveMonitorSuccess() {
		System.out.println("[MobileMonitorTest] Monitor reported that the requirement was satisfied");
		requirementSatisfied = true;
	}
}
