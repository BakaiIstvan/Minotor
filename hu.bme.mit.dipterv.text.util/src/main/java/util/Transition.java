package util;

public class Transition {
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
}
