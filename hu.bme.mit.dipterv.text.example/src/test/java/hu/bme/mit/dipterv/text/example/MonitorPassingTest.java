package hu.bme.mit.dipterv.text.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import generated.Specification;
import util.IClock;
import util.IMonitor;
import util.ISystem;
import util.Monitor;
import util.Clock;

public class MonitorPassingTest implements ISystem {

	@Test
	public void testMonitorPassing() {
		Specification specification = new Specification();
		specification.listAutomatas();
		IClock clock = new Clock();
		IMonitor monitor = new Monitor(specification.getAutomata().get(0), clock, this);
		
		Server server = new Server(monitor);
		Computer computer = new Computer(server, monitor);
		Assertions.assertTrue(monitor.goodStateReached());
		Assertions.assertTrue(monitor.requirementSatisfied());
	}

	@Override
	public void receiveMonitorStatus(String message) {
		System.out.println("[NetworkMonitorTest]Received status from monitor: " + message);
	}
}
