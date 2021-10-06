package hu.bme.mit.dipterv.text.mobileexample;

import generated.Specification;
import util.ISystem;
import util.Clock;
import util.IClock;
import util.IMonitor;
import util.Monitor;

public class Mobile implements ISystem {

	public Mobile() {
		Specification specification = new Specification();
		specification.listAutomatas();
		IClock clock = new Clock();
		IMonitor monitor = new Monitor(specification.getAutomata().get(0), clock, this);
		
		User user = new User();
		Device device = new Device();
		Database db = new Database();
		user.device = device;
		device.user = user;
		device.db = db;
		db.device = device;
		user.monitor = monitor;
		device.monitor = monitor;
		db.monitor = monitor;
		
		user.init(false, 0);
	}
	
	@Override
	public void receiveMonitorStatus(String message) {
		System.out.println("[Mobile] Received status from monitor: " + message);
	}

}
