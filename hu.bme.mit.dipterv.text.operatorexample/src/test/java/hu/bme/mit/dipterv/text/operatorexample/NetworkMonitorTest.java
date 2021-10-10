package hu.bme.mit.dipterv.text.operatorexample;

import util.Clock;
import util.IClock;
import util.IMonitor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import generated.Specification;
import util.Monitor;
import util.ISystem;

public class NetworkMonitorTest implements ISystem {
    @Test
	public void testNetworkRequirementSatisfied() {
		Specification specification = new Specification();
		specification.listAutomatas();
		IClock clock = new Clock();
		IMonitor monitor = new Monitor(specification.getAutomata().get(0), clock, this);

		Server server = new Server(monitor, false);
		Computer computer = new Computer(server, monitor, 1, false, 4, false);
		server.initiateLogout();
		Assertions.assertTrue(monitor.goodStateReached());
		Assertions.assertTrue(monitor.requirementSatisfied());
	}
    
    @Test
	public void testNetworkRequirementSatisfiedTwice() {
    	System.out.println("Twice ---------------------------------------------------------------------------");
		Specification specification = new Specification();
		specification.listAutomatas();
		IClock clock = new Clock();
		IMonitor monitor = new Monitor(specification.getAutomata().get(0), clock, this);

		Server server = new Server(monitor, false);
		Computer computer = new Computer(server, monitor, 2, false, 4, false);
		server.initiateLogout();
		Assertions.assertTrue(monitor.goodStateReached());
		Assertions.assertTrue(monitor.requirementSatisfied());
		System.out.println("Twice --------------------------------------------------------------------------- END");
	}
    
    /*@Test
	public void testNetworkRequirementSatisfiedThreeTimes() {
    	System.out.println("Three times ---------------------------------------------------------------------------");
		Specification specification = new Specification();
		specification.listAutomatas();
		IClock clock = new Clock();
		IMonitor monitor = new Monitor(specification.getAutomata().get(0), clock, this);

		Server server = new Server(monitor, false);
		Computer computer = new Computer(server, monitor, 3, false, 4, false);
		server.initiateLogout();
		Assertions.assertTrue(monitor.goodStateReached());
		Assertions.assertTrue(monitor.requirementSatisfied());
		System.out.println("Three times --------------------------------------------------------------------------- END");
	}*/
    
    @Test
	public void testNetworkRequirementSatisfiedFourTimes() {
    	System.out.println("Four times ---------------------------------------------------------------------------");
		Specification specification = new Specification();
		specification.listAutomatas();
		IClock clock = new Clock();
		IMonitor monitor = new Monitor(specification.getAutomata().get(0), clock, this);

		Server server = new Server(monitor, false);
		Computer computer = new Computer(server, monitor, 4, false, 4, false);
		server.initiateLogout();
		Assertions.assertFalse(monitor.goodStateReached());
		Assertions.assertFalse(monitor.requirementSatisfied());
		System.out.println("Four times --------------------------------------------------------------------------- END");
	}
    
    @Test
	public void testNetworkAltTrueCase() {
		Specification specification = new Specification();
		specification.listAutomatas();
		IClock clock = new Clock();
		IMonitor monitor = new Monitor(specification.getAutomata().get(0), clock, this);

		Server server = new Server(monitor, true);
		Computer computer = new Computer(server, monitor, 2, true, 4, false);
		Assertions.assertFalse(monitor.goodStateReached());
		Assertions.assertFalse(monitor.requirementSatisfied());
	}
    
    @Test
   	public void testNetworkLogoutTooFast() {
   		Specification specification = new Specification();
   		specification.listAutomatas();
   		IClock clock = new Clock();
   		IMonitor monitor = new Monitor(specification.getAutomata().get(0), clock, this);

   		Server server = new Server(monitor, false);
   		Computer computer = new Computer(server, monitor, 2, false, 2, false);
   		server.initiateLogout();
   		Assertions.assertFalse(monitor.goodStateReached());
   		Assertions.assertFalse(monitor.requirementSatisfied());
   	}
    
    @Test
   	public void testNetworkLogoutConstrait() {
   		Specification specification = new Specification();
   		specification.listAutomatas();
   		IClock clock = new Clock();
   		IMonitor monitor = new Monitor(specification.getAutomata().get(0), clock, this);

   		Server server = new Server(monitor, false);
   		Computer computer = new Computer(server, monitor, 2, false, 4, true);
   		server.initiateLogout();
   		Assertions.assertFalse(monitor.goodStateReached());
   		Assertions.assertFalse(monitor.requirementSatisfied());
   	}

    @Override
	public void receiveMonitorStatus(String message) {
		System.out.println("[NetworkMonitorTest]Received status from monitor: " + message);
	}
}
