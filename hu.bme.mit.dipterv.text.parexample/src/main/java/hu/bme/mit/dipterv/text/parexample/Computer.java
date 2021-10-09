package hu.bme.mit.dipterv.text.parexample;

import util.IMonitor;

public class Computer {
	public Server server;
	public IMonitor monitor;
	
	Computer(Server server, IMonitor monitor) {
		this.server = server;
		this.monitor = monitor;
		monitor.update("computer", "computer", "checkEmail", new String[] {});
		checkEmail();
	}
	
	void checkEmail() {
		server.newEmail();
		monitor.update("computer", "server", "newEmail", new String[] {});
	}
}
