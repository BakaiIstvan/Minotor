package util;

import java.util.Map;

public interface IMonitor {
	public boolean goodStateReached();
	public void update(String sender, String receiver, String messageType, Map<String, Object> parameters);
	public boolean requirementSatisfied();
	public void errorDetected(String sender, String receiver, String messageType, Map<String, Object> parameters);
	public void noMoreMessages();
}
