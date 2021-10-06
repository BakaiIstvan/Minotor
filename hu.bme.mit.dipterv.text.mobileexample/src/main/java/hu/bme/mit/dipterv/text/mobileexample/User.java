package hu.bme.mit.dipterv.text.mobileexample;

import util.IMonitor;

public class User {
	public IMonitor monitor;
	public Device device;
	
	void init() {
		device.openApp();
	}
	
	void getPhoto() {
		monitor.update("device", "user", "getPhoto", new String[] {});
	}
	
}
