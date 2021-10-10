package hu.bme.mit.dipterv.text.altexample;

import util.IMonitor;

public class UserInterface {
	public IMonitor monitor;
	public ATM atm;
	
	public void lockMachine() {
		monitor.update("atm", "ui", "lockMachine", new String[] {});
	}
	
	public void start(boolean success) {
		atm.login(success);
		if (success) {
			atm.wReq();
		} else {
			atm.loginUnsuccessful();
		}
		
	}
}
