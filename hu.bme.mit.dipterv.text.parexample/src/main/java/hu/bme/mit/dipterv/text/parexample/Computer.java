package hu.bme.mit.dipterv.text.parexample;

import util.IMonitor;

public class Computer {
	public Server server;
	public IMonitor monitor;
	
	Computer(Server server, IMonitor monitor, boolean branch) {
		this.server = server;
		this.monitor = monitor;
		if (branch) {
			checkEmail();
			server.newEmail();
		} else {
			server.newEmail();
			checkEmail();
		}
	}
	
	void checkEmail() {
		monitor.update("computer", "computer", "checkEmail", new String[] {});
	}
}
