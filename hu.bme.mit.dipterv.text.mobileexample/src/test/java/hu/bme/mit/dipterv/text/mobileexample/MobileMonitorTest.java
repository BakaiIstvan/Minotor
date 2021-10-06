package hu.bme.mit.dipterv.text.mobileexample;

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
	public void testNetworkRequirementSatisfied() {
		Specification specification = new Specification();
		specification.listAutomatas();
		IClock clock = new Clock();
		IMonitor monitor = new Monitor(specification.getAutomata().get(0), clock, this);
		
		User user = new User();
		Device device = new Device();
		Database db = new Database();
		user.device = device;
		device.user = user;
		device.db = db;
		db.device = device;
		user.monitor = monitor;
		device.monitor = monitor;
		db.monitor = monitor;
		
		user.init();

		Assertions.assertTrue(monitor.goodStateReached());
		Assertions.assertTrue(monitor.requirementSatisfied());
	}

	@Override
	public void receiveMonitorStatus(String message) {
		System.out.println("[MobileMonitorTest] Received status from monitor: " + message);
	}
}
