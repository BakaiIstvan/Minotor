package hu.bme.mit.dipterv.text.example;

import generated.IMonitor;

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
		monitor.update("computer", "server", "sendUnsentEmail", new String[] {});
		server.sendUnsentEmail();
		
		monitor.update("computer", "server", "newEmail", new String[] {});
		server.newEmail();
		
		monitor.update("computer", "server", "downloadEmail", new String[] {});
		server.downloadEmail();
	}
}
