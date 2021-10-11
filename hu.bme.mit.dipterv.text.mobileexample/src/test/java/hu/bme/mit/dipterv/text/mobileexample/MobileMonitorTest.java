package hu.bme.mit.dipterv.text.mobileexample;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import generated.Specification;
import util.Clock;
import util.IClock;
import util.IMonitor;
import util.ISystem;
import util.Monitor;

public class MobileMonitorTest implements ISystem {
	
	@Test
	public void testMobileRequirementSatisfied() {
		Specification specification = new Specification();
		specification.listAutomatas();
		IClock clock = new Clock();
		IMonitor monitor = new Monitor(specification.getAutomata().get(0), clock, this);
		
		monitor.update("user", "device", "openApp", new String[] {});
		monitor.update("device", "device", "accessWebcam", new String[] {});
		monitor.update("device", "user", "getPhoto", new String[] {});
		monitor.update("someone", "else", "message", new String[] {});
		monitor.update("device", "db", "retrieveMood", new String[] {});
		monitor.update("device", "db", "retrieveMusic", new String[] {});
		monitor.update("db", "device", "generatePlaylist", new String[] {});

		Assertions.assertTrue(monitor.goodStateReached());
		Assertions.assertTrue(monitor.requirementSatisfied());
	}
	
	@Test
	public void testMobileWithError() {
		Specification specification = new Specification();
		specification.listAutomatas();
		IClock clock = new Clock();
		IMonitor monitor = new Monitor(specification.getAutomata().get(0), clock, this);
		
		monitor.update("user", "device", "openApp", new String[] {});
		monitor.update("device", "device", "accessWebcam", new String[] {});
		monitor.update("device", "user", "getPhoto", new String[] {});
		monitor.update("user", "device", "cameraOffline", new String[] {});
		monitor.update("device", "db", "retrieveMood", new String[] {});
		monitor.update("device", "db", "retrieveMusic", new String[] {});
		monitor.update("db", "device", "generatePlaylist", new String[] {});

		Assertions.assertFalse(monitor.goodStateReached());
		Assertions.assertFalse(monitor.requirementSatisfied());
	}
	
	@Test
	public void testMobileWithDelay() {
		System.out.println("---------------------");
		System.out.println("[MobileMonitorTest] Starting delay test");
		Specification specification = new Specification();
		specification.listAutomatas();
		IClock clock = new Clock();
		IMonitor monitor = new Monitor(specification.getAutomata().get(0), clock, this);
	
		monitor.update("user", "device", "openApp", new String[] {});
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		monitor.update("device", "device", "accessWebcam", new String[] {});
		monitor.update("device", "user", "getPhoto", new String[] {});
		monitor.update("someone", "else", "message", new String[] {});
		monitor.update("device", "db", "retrieveMood", new String[] {});
		monitor.update("device", "db", "retrieveMusic", new String[] {});
		monitor.update("db", "device", "generatePlaylist", new String[] {});

		Assertions.assertTrue(monitor.goodStateReached());
		Assertions.assertTrue(monitor.requirementSatisfied());
		System.out.println("---------------------");
	}
	
	@Test
	public void testMobileWithTooMuchDelay() {
		System.out.println("---------------------");
		System.out.println("[MobileMonitorTest] Starting TooMuch delay test");
		Specification specification = new Specification();
		specification.listAutomatas();
		IClock clock = new Clock();
		IMonitor monitor = new Monitor(specification.getAutomata().get(0), clock, this);
		
		monitor.update("user", "device", "openApp", new String[] {});
		try {
			TimeUnit.SECONDS.sleep(6);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		monitor.update("device", "device", "accessWebcam", new String[] {});
		monitor.update("device", "user", "getPhoto", new String[] {});
		monitor.update("someone", "else", "message", new String[] {});
		monitor.update("device", "db", "retrieveMood", new String[] {});
		monitor.update("device", "db", "retrieveMusic", new String[] {});
		monitor.update("db", "device", "generatePlaylist", new String[] {});

		Assertions.assertFalse(monitor.goodStateReached());
		Assertions.assertFalse(monitor.requirementSatisfied());
		System.out.println("---------------------");
	}

	@Override
	public void receiveMonitorStatus(String message) {
		System.out.println("[MobileMonitorTest] Received status from monitor: " + message);
	}

	@Override
	public void receiveMonitorError(String actualMessage, String lastAcceptedMessage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void receiveMonitorSuccess() {
		// TODO Auto-generated method stub
		
	}
}
