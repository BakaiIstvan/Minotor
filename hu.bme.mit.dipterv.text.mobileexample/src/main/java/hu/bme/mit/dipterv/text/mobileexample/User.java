package hu.bme.mit.dipterv.text.mobileexample;

import util.IMonitor;

public class User {
	public IMonitor monitor;
	public Device device;
	
	void init(boolean errorHappened, int timeout) {
		device.openApp(errorHappened, timeout);
	}
	
	void getPhoto() {
		monitor.update("device", "user", "getPhoto", new String[] {});
	}
	
}
