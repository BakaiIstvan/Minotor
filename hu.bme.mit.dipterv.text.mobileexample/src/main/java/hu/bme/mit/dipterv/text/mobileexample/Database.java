package hu.bme.mit.dipterv.text.mobileexample;

import util.IMonitor;

public class Database {
	public IMonitor monitor;
	public Device device;
	
	void retrieveMood(boolean errorHappened) {
		something(errorHappened);
		monitor.update("device", "db", "retrieveMood", new String[] {});
	}
	
	void something(boolean errorHappened) {
		if (errorHappened) {
			monitor.update("user", "device", "cameraOffline", new String[] {});
		} else {
			monitor.update("someone", "else", "message", new String[] {});
		}
		
	}
	
	void retrieveMusic() {
		monitor.update("device", "db", "retrieveMusic", new String[] {});
		device.generatePlaylist();
	}
}
