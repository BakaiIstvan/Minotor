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
	private boolean requirementSatisfied = false;
	private boolean errorDetected = false;
	
	//TODO: use @BeforeEach, didn't work for some reason last time
	public void resetValues() {
		requirementSatisfied = false;
		errorDetected = false;
		System.out.println("[NetworkMonitorTest] Resetting values");
	}
	
	@Test
	public void testNetworkRequirementSatisfied() {
		resetValues();
		Specification specification = new Specification();
		specification.listAutomatas();
		IClock clock = new Clock();
		IMonitor monitor = new Monitor(specification.getAutomata().get(0), clock, this);
		
		monitor.update("computer", "computer", "checkEmail", new String[] {}, true);
		monitor.update("computer", "server", "newEmail", new String[] {}, true);
		
		Assertions.assertTrue(monitor.goodStateReached());
		Assertions.assertTrue(monitor.requirementSatisfied());
		Assertions.assertTrue(requirementSatisfied);
		Assertions.assertFalse(errorDetected);
	}
	
	@Test
	public void testNetworkOtherRequirementSatisfied() {
		resetValues();
		Specification specification = new Specification();
		specification.listAutomatas();
		IClock clock = new Clock();
		IMonitor monitor = new Monitor(specification.getAutomata().get(0), clock, this);
		
		monitor.update("computer", "server", "newEmail", new String[] {}, true);
		monitor.update("computer", "computer", "checkEmail", new String[] {}, true);
		
		Assertions.assertTrue(monitor.goodStateReached());
		Assertions.assertTrue(monitor.requirementSatisfied());
		Assertions.assertTrue(requirementSatisfied);
		Assertions.assertFalse(errorDetected);
	}

	@Override
	public void receiveMonitorStatus(String message) {
		System.out.println("[NetworkMonitorTest]Received status from monitor: " + message);
	}

	@Override
	public void receiveMonitorError(String actualMessage, String lastAcceptedMessage) {
		System.out.println("[NetworkMonitorTest] Received error report from Monitor for " + actualMessage + " message.");
		System.out.println("Last accepted message was: " + lastAcceptedMessage);
		errorDetected = true;
	}

	@Override
	public void receiveMonitorSuccess() {
		System.out.println("[NetworkMonitorTest] Monitor reported that the requirement was satisfied");
		requirementSatisfied = true;
	}
}
