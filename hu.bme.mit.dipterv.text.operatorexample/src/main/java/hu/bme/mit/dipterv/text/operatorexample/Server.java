package hu.bme.mit.dipterv.text.operatorexample;

import util.IMonitor;

public class Server {
	private IMonitor monitor;
	private boolean success;
	private Computer computer;

	public Server(IMonitor monitor, boolean success) {
		this.monitor = monitor;
		this.success = success;
	}

	public void setComputer(Computer computer) {
		this.computer = computer;
	}

	public void checkEmail() {
		monitor.update("computer", "server", "checkEmail", new String[] {});
	}

	public void attemptLogin() {
		monitor.update("computer", "server", "attemptLogin", new String[] {});
		if (!success) {
			computer.logoutUser();
			computer.lockComputer();
		}
	}

	public void newEmail(String recipient, String subject) {
		monitor.update("computer", "server", "newEmail", new String[] {"receiver", "subject"});
	}

	public void deleteEmail(String subject) {
		monitor.update("computer", "server", "deleteEmail", new String[] {"subject"});
	}

	public void logout() {
		monitor.update("computer", "server", "logout", new String[] {});
	}
}
