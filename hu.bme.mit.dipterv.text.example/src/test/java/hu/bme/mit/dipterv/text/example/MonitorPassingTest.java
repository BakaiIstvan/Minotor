package hu.bme.mit.dipterv.text.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import generated.Specification;
import util.IClock;
import util.IMonitor;
import util.Monitor;
import util.Clock;

public class MonitorPassingTest {

	@Test
	public void testMonitorPassing() {
		Specification specification = new Specification();
		specification.listAutomatas();
		IClock clock = new Clock();
		IMonitor monitor = new Monitor(specification.getAutomata().get(0), clock);
		
		Server server = new Server(monitor);
		Computer computer = new Computer(server, monitor);
		Assertions.assertTrue(monitor.goodStateReached());
	}
}
