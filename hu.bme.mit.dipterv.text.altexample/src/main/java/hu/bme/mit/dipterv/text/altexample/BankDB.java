package hu.bme.mit.dipterv.text.altexample;

import util.IMonitor;

public class BankDB {
	public IMonitor monitor;
	
	public void uDB() {
		monitor.update("atm", "db", "uDB", new String[] {});
	}
}
