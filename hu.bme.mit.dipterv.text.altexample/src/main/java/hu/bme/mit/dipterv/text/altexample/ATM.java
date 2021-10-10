package hu.bme.mit.dipterv.text.altexample;

import util.IMonitor;

public class ATM {
	public IMonitor monitor;
	public BankDB db;
	public UserInterface ui;
	
	public void logout() {
		monitor.update("ui", "atm", "logout", new String[] {});
	}
	
	public void login(boolean success) {
		monitor.update("ui", "atm", "login", new String[] {"success"});
	}
	
	public void wReq() {
		monitor.update("ui", "atm", "wReq", new String[] {});
		db.uDB();
	}
	
	public void loginUnsuccessful() {
		monitor.update("ui", "atm", "loginUnsuccesful", new String[] {});
		ui.lockMachine();
	}
}
