package hu.bme.mit.dipterv.text.altexample;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Map;
import java.util.HashMap;

import generated.Specification;
import util.Clock;
import util.IClock;
import util.IMonitor;
import util.Monitor;
import util.ISystem;

public class BankMonitorTest implements ISystem {
	private boolean requirementSatisfied = false;
	private boolean errorDetected = false;
	
	public void resetValues() {
		requirementSatisfied = false;
		errorDetected = false;
	}

	@Test
	public void testBankMonitorPassing() {
		resetValues();
		System.out.println("[BankMonitorTest] Starting passing test");
		System.out.println("==/==");
		Specification specification = new Specification();
		specification.listAutomatas();
		IClock clock = new Clock();
		IMonitor monitor = new Monitor(specification.getAutomata().get(0), clock, this);
		
		monitor.update("ui", "atm", "login", Map.of("success", true));
		monitor.update("ui", "atm", "wReq", new HashMap<String, Object>());
		monitor.update("atm", "db", "uDB", new HashMap<String, Object>());
		
		Assertions.assertTrue(monitor.goodStateReached());
		Assertions.assertTrue(monitor.requirementSatisfied());
		Assertions.assertTrue(requirementSatisfied);
		Assertions.assertFalse(errorDetected);
		System.out.println("==/==");
	}
	
	@Test
	public void testBankMonitorFailing() {
		resetValues();
		System.out.println("[BankMonitorTest] Starting requirement unsatisfied test");
		System.out.println("==/==");
		Specification specification = new Specification();
		specification.listAutomatas();
		IClock clock = new Clock();
		IMonitor monitor = new Monitor(specification.getAutomata().get(0), clock, this);
		
		monitor.update("ui", "atm", "login", Map.of("success", true));
		monitor.update("ui", "atm", "loginUnsuccessful", new HashMap<String, Object>());
		monitor.update("atm", "ui", "lockMachine", new HashMap<String, Object>());
		
		Assertions.assertTrue(monitor.goodStateReached());
		Assertions.assertFalse(monitor.requirementSatisfied());
		Assertions.assertFalse(requirementSatisfied);
		Assertions.assertFalse(errorDetected);
		System.out.println("==/==");
	}

	@Test
	public void testBankMonitorFalseCasePassing() {
		resetValues();
		System.out.println("[BankMonitorTest] Starting false case passing test");
		System.out.println("==/==");
		Specification specification = new Specification();
		specification.listAutomatas();
		IClock clock = new Clock();
		IMonitor monitor = new Monitor(specification.getAutomata().get(0), clock, this);
		
		monitor.update("ui", "atm", "login", Map.of("success", false));
		monitor.update("ui", "atm", "loginUnsuccessful", new HashMap<String, Object>());
		monitor.update("atm", "ui", "lockMachine", new HashMap<String, Object>());
		
		Assertions.assertTrue(monitor.goodStateReached());
		Assertions.assertTrue(monitor.requirementSatisfied());
		Assertions.assertTrue(requirementSatisfied);
		Assertions.assertFalse(errorDetected);
		System.out.println("==/==");
	}

	@Test
	public void testBankMonitorFalseCaseFailing() {
		resetValues();
		System.out.println("[BankMonitorTest] Starting requirement unsatisfied test");
		System.out.println("==/==");
		Specification specification = new Specification();
		specification.listAutomatas();
		IClock clock = new Clock();
		IMonitor monitor = new Monitor(specification.getAutomata().get(0), clock, this);
		
		monitor.update("ui", "atm", "login", Map.of("success", false));
		monitor.update("ui", "atm", "wReq", new HashMap<String, Object>());
		monitor.update("atm", "db", "uDB", new HashMap<String, Object>());
		
		Assertions.assertTrue(monitor.goodStateReached());
		Assertions.assertFalse(monitor.requirementSatisfied());
		Assertions.assertFalse(requirementSatisfied);
		Assertions.assertFalse(errorDetected);
		System.out.println("==/==");
	}

	@Override
	public void receiveMonitorStatus(String message) {
		System.out.println("[BankMonitorTest]Received status from monitor: " + message);
	}

	@Override
	public void receiveMonitorError(String actualMessage, String lastAcceptedMessage) {
		System.out.println("[BankMonitorTest] Received error report from Monitor for " + actualMessage + " message.");
		System.out.println("Last accepted message was: " + lastAcceptedMessage);
		errorDetected = true;
	}

	@Override
	public void receiveMonitorSuccess() {
		System.out.println("[BankMonitorTest] Monitor reported that the requirement was satisfied");
		requirementSatisfied = true;
	}
}
