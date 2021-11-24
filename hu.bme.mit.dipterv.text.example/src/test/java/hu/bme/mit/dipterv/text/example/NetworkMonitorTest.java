package hu.bme.mit.dipterv.text.example;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.HashMap;

import org.junit.jupiter.api.Assertions;

import generated.Specification;
import util.IClock;
import util.IMonitor;
import util.ISystem;
import util.Monitor;
import util.Clock;

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
		
		monitor.update("computer", "computer", "checkEmail", new HashMap<String, Object>());
		monitor.update("computer", "server", "sendUnsentEmail", new HashMap<String, Object>());
		monitor.update("computer", "server", "updateEmail", new HashMap<String, Object>());
		monitor.update("server", "computer", "updateAccount", new HashMap<String, Object>());
		LinkedHashMap<String, Object> hm = new LinkedHashMap<String, Object>();

		hm.put("receiver", "John");
		hm.put("subject", "Next meeting");
		monitor.update("computer", "server", "newEmail", hm);
		try {
			TimeUnit.SECONDS.sleep(11);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		monitor.update("computer", "server", "downloadEmail", Map.of("timeout", 10));
		
		Assertions.assertTrue(monitor.goodStateReached());
		Assertions.assertTrue(monitor.requirementSatisfied());
		Assertions.assertTrue(requirementSatisfied);
		Assertions.assertFalse(errorDetected);
	}
	
	@Test
	public void testNetworkNoErrors() {
		resetValues();
		Specification specification = new Specification();
		specification.listAutomatas();
		IClock clock = new Clock();
		IMonitor monitor = new Monitor(specification.getAutomata().get(0), clock, this);
		
		monitor.update("computer", "computer", "checkEmail", new HashMap<String, Object>());
		monitor.update("computer", "server", "sendUnsentEmail", new HashMap<String, Object>());
		monitor.update("computer", "server", "updateEmail", new HashMap<String, Object>());
		monitor.update("server", "computer", "updateAccount", new HashMap<String, Object>());
		LinkedHashMap<String, Object> hm = new LinkedHashMap<String, Object>();

		hm.put("receiver", "John");
		hm.put("subject", "Next meeting");
		monitor.update("computer", "server", "newEmail", hm);
		
		Assertions.assertTrue(monitor.goodStateReached());
		Assertions.assertFalse(monitor.requirementSatisfied());
		Assertions.assertFalse(requirementSatisfied);
		Assertions.assertFalse(errorDetected);
	}
	
	@Test
	public void testNetworkWithErrors() {
		resetValues();
		Specification specification = new Specification();
		specification.listAutomatas();
		IClock clock = new Clock();
		IMonitor monitor = new Monitor(specification.getAutomata().get(0), clock, this);
		
		monitor.update("computer", "computer", "checkEmail", new HashMap<String, Object>());
		monitor.update("computer", "server", "sendUnsentEmail", new HashMap<String, Object>());
		monitor.update("computer", "server", "updateEmail", new HashMap<String, Object>());
		monitor.update("server", "computer", "updateAccount", new HashMap<String, Object>());
		monitor.update("computer", "server", "logout", new HashMap<String, Object>());
		LinkedHashMap<String, Object> hm = new LinkedHashMap<String, Object>();

		hm.put("receiver", "John");
		hm.put("subject", "Next meeting");
		monitor.update("computer", "server", "newEmail", hm);
		try {
			TimeUnit.SECONDS.sleep(11);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		monitor.update("computer", "server", "downloadEmail", Map.of("timeout", 10));
		
		Assertions.assertFalse(monitor.goodStateReached());
		Assertions.assertFalse(monitor.requirementSatisfied());
		Assertions.assertFalse(requirementSatisfied);
		Assertions.assertTrue(errorDetected);
	}
	
	@Test
	public void testNetworkWithNoDelay() {
		resetValues();
		Specification specification = new Specification();
		specification.listAutomatas();
		IClock clock = new Clock();
		IMonitor monitor = new Monitor(specification.getAutomata().get(0), clock, this);
		
		monitor.update("computer", "computer", "checkEmail", new HashMap<String, Object>());
		monitor.update("computer", "server", "sendUnsentEmail", new HashMap<String, Object>());
		monitor.update("computer", "server", "updateEmail", new HashMap<String, Object>());
		monitor.update("server", "computer", "updateAccount", new HashMap<String, Object>());
		LinkedHashMap<String, Object> hm = new LinkedHashMap<String, Object>();

		hm.put("receiver", "John");
		hm.put("subject", "Next meeting");
		monitor.update("computer", "server", "newEmail", hm);
		monitor.update("computer", "server", "downloadEmail", Map.of("timeout", 10));
		
		Assertions.assertFalse(monitor.goodStateReached());
		Assertions.assertFalse(monitor.requirementSatisfied());
		Assertions.assertFalse(requirementSatisfied);
		Assertions.assertTrue(errorDetected);
	}

	@Test
	public void testNetworkFirstFail() {
		resetValues();
		Specification specification = new Specification();
		specification.listAutomatas();
		IClock clock = new Clock();
		IMonitor monitor = new Monitor(specification.getAutomata().get(0), clock, this);
		
		monitor.update("computer", "computer", "checkEmail", new HashMap<String, Object>());
		monitor.update("computer", "server", "sendUnsentEmail", new HashMap<String, Object>());
		monitor.update("server", "computer", "computerError", new HashMap<String, Object>());
		monitor.update("server", "computer", "updateAccount", new HashMap<String, Object>());
		LinkedHashMap<String, Object> hm = new LinkedHashMap<String, Object>();

		hm.put("receiver", "John");
		hm.put("subject", "Next meeting");
		monitor.update("computer", "server", "newEmail", hm);
		try {
			TimeUnit.SECONDS.sleep(11);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		monitor.update("computer", "server", "downloadEmail", Map.of("timeout", 10));
		
		Assertions.assertFalse(monitor.goodStateReached());
		Assertions.assertFalse(monitor.requirementSatisfied());
		Assertions.assertFalse(requirementSatisfied);
		Assertions.assertTrue(errorDetected);
	}

	@Test
	public void testNetworkSecondFail() {
		resetValues();
		Specification specification = new Specification();
		specification.listAutomatas();
		IClock clock = new Clock();
		IMonitor monitor = new Monitor(specification.getAutomata().get(0), clock, this);
		
		monitor.update("computer", "computer", "checkEmail", new HashMap<String, Object>());
		monitor.update("computer", "server", "sendUnsentEmail", new HashMap<String, Object>());
		monitor.update("computer", "server", "updateEmail", new HashMap<String, Object>());
		monitor.update("computer", "server", "serverError", new HashMap<String, Object>());
		LinkedHashMap<String, Object> hm = new LinkedHashMap<String, Object>();

		hm.put("receiver", "John");
		hm.put("subject", "Next meeting");
		monitor.update("computer", "server", "newEmail", hm);
		try {
			TimeUnit.SECONDS.sleep(11);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		monitor.update("computer", "server", "downloadEmail", Map.of("timeout", 10));
		
		Assertions.assertFalse(monitor.goodStateReached());
		Assertions.assertFalse(monitor.requirementSatisfied());
		Assertions.assertFalse(requirementSatisfied);
		Assertions.assertTrue(errorDetected);
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
