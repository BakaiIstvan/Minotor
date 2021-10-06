package hu.bme.mit.dipterv.text.mobileexample;

import util.IMonitor;

public class Device {
	public IMonitor monitor;
	public User user;
	public Database db;
	
	void openApp() {
		monitor.update("user", "device", "openApp", new String[] {});
		accessWebcam();
	}

	void closeApp() {
		monitor.update("user", "device", "closeApp", new String[] {});
	}
	
	void accessWebcam() {
		monitor.update("device", "device", "accessWebcam", new String[] {});
		user.getPhoto();
		db.retrieveMood();
		db.retrieveMusic();
	}
	
	void cameraOffline() {
		monitor.update("user", "device", "cameOffline", new String[] {});
	}
	
	void generatePlaylist() {
		monitor.update("db", "device", "generatePlaylist", new String[] {});
	}
}