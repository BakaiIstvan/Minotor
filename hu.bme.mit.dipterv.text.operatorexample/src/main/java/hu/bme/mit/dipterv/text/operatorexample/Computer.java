package hu.bme.mit.dipterv.text.operatorexample;

import java.util.concurrent.TimeUnit;

import util.IMonitor;

public class Computer {
	public Server server;
	public IMonitor monitor;

	Computer(Server server, IMonitor monitor, int tries, boolean success) {
		this.server = server;
		this.server.setComputer(this);
		this.monitor = monitor;

        for (int i = 0; i < tries; i++) {
            login();
            server.attemptLogin();
        }

        if (success) {
            server.checkEmail();
            server.newEmail("John", "Next Meeting");
        }
	}

	public void login() {
        monitor.update("computer", "computer", "login", new String[] {});
    }

    public void logoutUser() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        monitor.update("server", "computer", "logoutUser", new String[] {});
    }

    public void lockComputer() {
        monitor.update("server", "computer", "lockComputer", new String[] {});
    }
}
