package hu.bme.mit.dipterv.text.parexample;

import generated.Specification;
import util.IMonitor;
import util.IClock;
import util.Monitor;
import util.Clock;
import util.ISystem;

public class Network implements ISystem {
	public Network() {
		Specification specification = new Specification();
		specification.listAutomatas();
		IClock clock = new Clock();
		IMonitor monitor = new Monitor(specification.getAutomata().get(0), clock, this);
		
		Server server = new Server(monitor);
		Computer computer = new Computer(server, monitor, true);
	}

	@Override
	public void receiveMonitorStatus(String message) {
		System.out.println("[Network]Received status from monitor: " + message);
	}
}