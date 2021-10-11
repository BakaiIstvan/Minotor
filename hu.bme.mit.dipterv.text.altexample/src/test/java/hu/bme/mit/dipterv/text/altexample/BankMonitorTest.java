package hu.bme.mit.dipterv.text.altexample;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import generated.Specification;
import util.Clock;
import util.IClock;
import util.IMonitor;
import util.Monitor;
import util.ISystem;

public class BankMonitorTest implements ISystem {

	@Test
	public void testBankMonitorPassing() {
		System.out.println("[BankMonitorTest] Starting passing test");
		System.out.println("==/==");
		Specification specification = new Specification();
		specification.listAutomatas();
		IClock clock = new Clock();
		IMonitor monitor = new Monitor(specification.getAutomata().get(0), clock, this);
		
		monitor.update("ui", "atm", "login", new String[] {"success"});
		monitor.update("ui", "atm", "wReq", new String[] {});
		monitor.update("atm", "db", "uDB", new String[] {});
		
		Assertions.assertTrue(monitor.goodStateReached());
		Assertions.assertTrue(monitor.requirementSatisfied());
		System.out.println("==/==");
	}
	
	@Test
	public void testBankMonitorFailing() {
		System.out.println("[BankMonitorTest] Starting requirement unsatisfied test");
		System.out.println("==/==");
		Specification specification = new Specification();
		specification.listAutomatas();
		IClock clock = new Clock();
		IMonitor monitor = new Monitor(specification.getAutomata().get(0), clock, this);
		
		monitor.update("ui", "atm", "login", new String[] {"success"});
		monitor.update("ui", "atm", "loginUnsuccesful", new String[] {});
		monitor.update("atm", "ui", "lockMachine", new String[] {});
		
		Assertions.assertTrue(monitor.goodStateReached());
		Assertions.assertFalse(monitor.requirementSatisfied());
		System.out.println("==/==");
	}

	@Override
	public void receiveMonitorStatus(String message) {
		System.out.println("[BankMonitorTest]Received status from monitor: " + message);
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
