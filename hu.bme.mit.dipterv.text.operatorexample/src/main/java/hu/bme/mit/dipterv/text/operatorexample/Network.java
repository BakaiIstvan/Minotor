package hu.bme.mit.dipterv.text.operatorexample;

import util.Clock;
import util.IClock;
import util.IMonitor;
import generated.Specification;
import util.Monitor;
import util.ISystem;

public class Network implements ISystem {
	public Network() {
		Specification specification = new Specification();
		specification.listAutomatas();
		IClock clock = new Clock();
		IMonitor monitor = new Monitor(specification.getAutomata().get(0), clock, this);

		Server server = new Server(monitor, false);
		Computer computer = new Computer(server, monitor, 1, false);
	}

	@Override
	public void receiveMonitorStatus(String message) {
		System.out.println("[Network]Received status from monitor: " + message);
	}
}

