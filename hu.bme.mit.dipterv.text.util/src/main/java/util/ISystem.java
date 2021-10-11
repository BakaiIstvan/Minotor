package util;

public interface ISystem {
	public void receiveMonitorStatus(String message);
	public void receiveMonitorError(String actualMessage, String lastAcceptedMessage); //TODO: tesztben ellenőrizni a megfelelő hívását.
	public void receiveMonitorSuccess();
}
