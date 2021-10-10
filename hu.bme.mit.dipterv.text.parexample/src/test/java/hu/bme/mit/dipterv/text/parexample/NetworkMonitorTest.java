package hu.bme.mit.dipterv.text.parexample;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import generated.Specification;
import util.Clock;
import util.IClock;
import util.IMonitor;
import util.ISystem;
import util.Monitor;

public class NetworkMonitorTest implements ISystem {
	@Test
	public void testNetworkRequirementSatisfied() {
		Specification specification = new Specification();
		specification.listAutomatas();
		IClock clock = new Clock();
		IMonitor monitor = new Monitor(specification.getAutomata().get(0), clock, this);
		
		Server server = new Server(monitor);
		Computer computer = new Computer(server, monitor, true);
		Assertions.assertTrue(monitor.goodStateReached());
		Assertions.assertTrue(monitor.requirementSatisfied());
	}
	
	@Test
	public void testNetworkOtherRequirementSatisfied() {
		Specification specification = new Specification();
		specification.listAutomatas();
		IClock clock = new Clock();
		IMonitor monitor = new Monitor(specification.getAutomata().get(0), clock, this);
		
		Server server = new Server(monitor);
		Computer computer = new Computer(server, monitor, false);
		Assertions.assertTrue(monitor.goodStateReached());
		Assertions.assertTrue(monitor.requirementSatisfied());
	}

	@Override
	public void receiveMonitorStatus(String message) {
		System.out.println("[NetworkMonitorTest]Received status from monitor: " + message);
	}
}
