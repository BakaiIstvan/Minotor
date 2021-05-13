package hu.bme.mit.dipterv.text.example;

public class Main {
	public static void monitorStatus(String status) {
		System.out.println(status);
	}
	
	public static void main(String[] args) {
		Specification specification = new Specification();
		specification.listAutomatas();
		IClock clock = new Clock();
		IMonitor monitor = new Monitor(specification.getAutomata().get(0), clock);
		
		Server server = new Server(monitor);
		Computer computer = new Computer(server, monitor);
	}
}

