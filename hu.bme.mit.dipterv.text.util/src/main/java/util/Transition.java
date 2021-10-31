package util;

import java.util.List;
import java.util.Map;

public abstract class Transition implements Comparable<Transition> {
    protected State sender;
    protected State receiver;
    
    protected String reset;
    
    public Transition(State sender
    				, State receiver
    				, String reset) {

    	this.sender = sender;
    	this.receiver = receiver;
    	this.reset = reset;
    }
    
    public boolean hasReset() {
    	return reset != null && !reset.isEmpty();
    }
    
    public String getReset() {
    	return reset;
    }

    public void setReset(String reset) {
    	this.reset = reset;
    }

    public State getSender() {
        return sender;
    }

    public State getReceiver() {
        return receiver;
    }

    public void setReceiver(State receiver) {
        this.receiver = receiver;
    }

    public void setSender(State sender) {
        this.sender = sender;
    }
    
    public abstract boolean canTrigger(Map<String, Integer> clockValues
    								 , String receivedMessage
    								 , List<String> previousMessages
    								 , boolean parameterValue);
}
