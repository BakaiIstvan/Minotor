package hu.bme.mit.dipterv.text.example;

public class Server {
	public IMonitor monitor;
	
	public Server(IMonitor monitor) {
		this.monitor = monitor;
	}
	
	public void newEmail() {}
	
	public void sendUnsentEmail() {}
	
	public void downloadEmail() {}
}
