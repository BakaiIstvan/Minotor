package hu.bme.mit.dipterv.text.parexample;

import util.IMonitor;

public class Server {
	private IMonitor monitor;
	
	public Server(IMonitor monitor) {
		this.monitor = monitor;
	}
	
	public void newEmail() {
		monitor.update("computer", "server", "newEmail", new String[] {});
	}
}
