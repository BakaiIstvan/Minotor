package hu.bme.mit.dipterv.text.mobileexample;

import java.util.concurrent.TimeUnit;

import util.IMonitor;

public class Device {
	public IMonitor monitor;
	public User user;
	public Database db;
	
	void openApp(boolean errorHappened, int timeout) {
		monitor.update("user", "device", "openApp", new String[] {});
		accessWebcam(errorHappened, timeout);
	}

	void closeApp() {
		monitor.update("user", "device", "closeApp", new String[] {});
	}
	
	void accessWebcam(boolean errorHappened, int timeout) {
		try {
			TimeUnit.SECONDS.sleep(timeout);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		monitor.update("device", "device", "accessWebcam", new String[] {});
		user.getPhoto();
		db.retrieveMood(errorHappened);
		db.retrieveMusic();
	}
	
	void cameraOffline() {
		monitor.update("user", "device", "cameOffline", new String[] {});
	}
	
	void generatePlaylist() {
		monitor.update("db", "device", "generatePlaylist", new String[] {});
	}
}