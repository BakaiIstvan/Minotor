package hu.bme.mit.dipterv.text.example;

import util.IMonitor;

public class Computer {
	public Server server;
	public IMonitor monitor;
	
	Computer(Server server, IMonitor monitor, boolean satisfyRequirement) {
		this.server = server;
		this.monitor = monitor;
		monitor.update("computer", "computer", "checkEmail", new String[] {});
		checkEmail(satisfyRequirement);
	}
	
	void checkEmail(boolean satisfyRequirement) {
		monitor.update("computer", "server", "sendUnsentEmail", new String[] {});
		server.sendUnsentEmail();
		
		monitor.update("computer", "server", "newEmail", new String[] {});
		server.newEmail();
		
		if (satisfyRequirement) {
			monitor.update("computer", "server", "downloadEmail", new String[] {});
			server.downloadEmail();
		}
	}
}
