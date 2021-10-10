package hu.bme.mit.dipterv.text.altexample;

import generated.Specification;
import util.IMonitor;
import util.ISystem;
import util.Monitor;
import util.IClock;
import util.Clock;

public class Bank implements ISystem {

	public Bank() {
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
	}

	@Override
	public void receiveMonitorStatus(String message) {
		System.out.println("[Bank]Received status from monitor: " + message);
	}
}
