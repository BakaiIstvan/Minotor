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
		
		UserInterface ui = new UserInterface();
		ATM atm = new ATM();
		BankDB db = new BankDB();
		ui.atm = atm;
		atm.ui = ui;
		atm.db = db;
		ui.monitor = monitor;
		atm.monitor = monitor;
		db.monitor = monitor;
		
		ui.start(true);
		
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
		
		UserInterface ui = new UserInterface();
		ATM atm = new ATM();
		BankDB db = new BankDB();
		ui.atm = atm;
		atm.ui = ui;
		atm.db = db;
		ui.monitor = monitor;
		atm.monitor = monitor;
		db.monitor = monitor;
		
		ui.start(false);
		
		Assertions.assertTrue(monitor.goodStateReached());
		Assertions.assertFalse(monitor.requirementSatisfied());
		System.out.println("==/==");
	}

	@Override
	public void receiveMonitorStatus(String message) {
		System.out.println("[BankMonitorTest]Received status from monitor: " + message);
	}
}