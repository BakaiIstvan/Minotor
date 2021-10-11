package hu.bme.mit.dipterv.text.example;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Assertions;

import generated.Specification;
import util.IClock;
import util.IMonitor;
import util.ISystem;
import util.Monitor;
import util.Clock;

public class NetworkMonitorTest implements ISystem {

	@Test
	public void testNetworkRequirementSatisfied() {
		Specification specification = new Specification();
		specification.listAutomatas();
		IClock clock = new Clock();
		IMonitor monitor = new Monitor(specification.getAutomata().get(0), clock, this);
		
		monitor.update("computer", "computer", "checkEmail", new String[] {});
		monitor.update("computer", "server", "sendUnsentEmail", new String[] {});
		monitor.update("computer", "server", "newEmail", new String[] {"receiver", "subject"});
		try {
			TimeUnit.SECONDS.sleep(11);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		monitor.update("computer", "server", "downloadEmail", new String[] {"timeout"});
		
		Assertions.assertTrue(monitor.goodStateReached());
		Assertions.assertTrue(monitor.requirementSatisfied());
	}
	
	@Test
	public void testNetworkNoErrors() {
		Specification specification = new Specification();
		specification.listAutomatas();
		IClock clock = new Clock();
		IMonitor monitor = new Monitor(specification.getAutomata().get(0), clock, this);
		
		monitor.update("computer", "computer", "checkEmail", new String[] {});
		monitor.update("computer", "server", "sendUnsentEmail", new String[] {});
		monitor.update("computer", "server", "newEmail", new String[] {"receiver", "subject"});
		
		Assertions.assertTrue(monitor.goodStateReached());
		Assertions.assertFalse(monitor.requirementSatisfied());
	}
	
	@Test
	public void testNetworkWithErrors() {
		Specification specification = new Specification();
		specification.listAutomatas();
		IClock clock = new Clock();
		IMonitor monitor = new Monitor(specification.getAutomata().get(0), clock, this);
		
		monitor.update("computer", "computer", "checkEmail", new String[] {});
		monitor.update("computer", "server", "sendUnsentEmail", new String[] {});
		monitor.update("computer", "server", "logout", new String[] {});
		monitor.update("computer", "server", "newEmail", new String[] {"receiver", "subject"});
		try {
			TimeUnit.SECONDS.sleep(11);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		monitor.update("computer", "server", "downloadEmail", new String[] {"timeout"});
		
		Assertions.assertFalse(monitor.goodStateReached());
		Assertions.assertFalse(monitor.requirementSatisfied());
	}
	
	@Test
	public void testNetworkWithNoDelay() {
		Specification specification = new Specification();
		specification.listAutomatas();
		IClock clock = new Clock();
		IMonitor monitor = new Monitor(specification.getAutomata().get(0), clock, this);
		
		monitor.update("computer", "computer", "checkEmail", new String[] {});
		monitor.update("computer", "server", "sendUnsentEmail", new String[] {});
		monitor.update("computer", "server", "newEmail", new String[] {"receiver", "subject"});
		monitor.update("computer", "server", "downloadEmail", new String[] {"timeout"});
		
		Assertions.assertFalse(monitor.goodStateReached());
		Assertions.assertFalse(monitor.requirementSatisfied());
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
