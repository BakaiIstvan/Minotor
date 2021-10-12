package util;

public interface ISystem {
	public void receiveMonitorStatus(String message);
	public void receiveMonitorError(String actualMessage, String lastAcceptedMessage);
	public void receiveMonitorSuccess();
}
