package hu.bme.mit.dipterv.text.mobileexample;

import util.IMonitor;

public class Database {
	public IMonitor monitor;
	public Device device;
	
	void retrieveMood() {
		something();
		monitor.update("device", "db", "retrieveMood", new String[] {});
	}
	
	void something() {
		monitor.update("someone", "else", "message", new String[] {});
	}
	
	void retrieveMusic() {
		monitor.update("device", "db", "retrieveMusic", new String[] {});
		device.generatePlaylist();
	}
}
