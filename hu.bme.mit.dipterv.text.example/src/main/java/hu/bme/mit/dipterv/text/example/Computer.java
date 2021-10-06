package hu.bme.mit.dipterv.text.example;

import java.util.concurrent.TimeUnit;

import util.IMonitor;

public class Computer {
	public Server server;
	public IMonitor monitor;
	
	Computer(Server server, IMonitor monitor, boolean satisfyRequirement, boolean error, int timeout) {
		this.server = server;
		this.monitor = monitor;
		monitor.update("computer", "computer", "checkEmail", new String[] {});
		checkEmail(satisfyRequirement, error, timeout);
	}
	
	void checkEmail(boolean satisfyRequirement, boolean error, int timeout) {
		monitor.update("computer", "server", "sendUnsentEmail", new String[] {});
		server.sendUnsentEmail();
		
		if (error) {
			monitor.update("computer", "server", "logout", new String[] {});
			server.logout();
		}
		
		String receiver = "John";
		String subject = "Next meeting";
		
		monitor.update("computer", "server", "newEmail", new String[] {"receiver", "subject"});
		server.newEmail(receiver, subject);
		
		if (satisfyRequirement) {
			try {
				TimeUnit.SECONDS.sleep(timeout);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			monitor.update("computer", "server", "downloadEmail", new String[] {"timeout"});
			server.downloadEmail(timeout);
		}
	}
}
