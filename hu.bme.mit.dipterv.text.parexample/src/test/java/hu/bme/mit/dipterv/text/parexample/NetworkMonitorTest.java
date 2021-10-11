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
		
		monitor.update("computer", "computer", "checkEmail", new String[] {});
		monitor.update("computer", "server", "newEmail", new String[] {});
		
		Assertions.assertTrue(monitor.goodStateReached());
		Assertions.assertTrue(monitor.requirementSatisfied());
	}
	
	@Test
	public void testNetworkOtherRequirementSatisfied() {
		Specification specification = new Specification();
		specification.listAutomatas();
		IClock clock = new Clock();
		IMonitor monitor = new Monitor(specification.getAutomata().get(0), clock, this);
		
		monitor.update("computer", "server", "newEmail", new String[] {});
		monitor.update("computer", "computer", "checkEmail", new String[] {});
		
		Assertions.assertTrue(monitor.goodStateReached());
		Assertions.assertTrue(monitor.requirementSatisfied());
	}

	@Override
	public void receiveMonitorStatus(String message) {
		System.out.println("[NetworkMonitorTest]Received status from monitor: " + message);
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
