package hu.bme.mit.dipterv.text.operatorexample;

import java.util.concurrent.TimeUnit;

import util.IMonitor;

public class Computer {
	private Server server;
	private IMonitor monitor;
	private int timeout;

	Computer(Server server, IMonitor monitor, int tries, boolean success, int timeout, boolean error) {
		this.server = server;
		this.server.setComputer(this);
		this.monitor = monitor;
		this.timeout = timeout;
		
        for (int i = 0; i < tries; i++) {
        	System.out.println("[Computer] Tries: " + ++i);
            login();
            if (error) {
    			server.logout();
    		} else {
    			server.attemptLogin();
    		}
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
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        monitor.update("server", "computer", "logoutUser", new String[] {});
    }

    public void lockComputer() {
        monitor.update("server", "computer", "lockComputer", new String[] {});
    }
}
