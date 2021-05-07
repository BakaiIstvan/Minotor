import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Transition {
    private String id;
    private State sender;
    private State receiver;
    
    private String reset;
    private String clock;
    private int value;
    private boolean smaller;
    
    public Transition() {
            this.id = "t0";
            this.sender = new State();
            this.receiver = new State();
            this.smaller = false;
    }

    public Transition(String id, State sender, State receiver) {
    	if (id.equals("1")) {
    		this.id = "true";
    	} else {
        	this.id = id;
        }
    	
    	if (id.contains(";")) {
    		List<String> list = new ArrayList<String>(Arrays.asList(id.split(";")));
    		this.id = list.get(0);
    		if (list.get(1) != null) {
    			if (list.get(1).contains(" = 0")) {
    				this.reset = list.get(1).substring(1, 2);
    			} else if (list.get(1).contains("<")) {
    				this.value = Integer.parseInt(list.get(1).substring(list.get(1).length() - 2, list.get(1).length())) * 1000000000;
    				this.clock = list.get(1).substring(1, 2);
    				this.smaller = true;
    			}
    		}
    	}
    	
    	/*if (countChar(this.id, '!') % 2 == 0 && this.id.contains("!")) {
    		formatID();
    	}*/
    	
        this.sender = sender;
        this.receiver = receiver;
    }
    
    private int countChar(String someString, char someChar) {
		int count = 0;
		 
		for (int i = 0; i < someString.length(); i++) {
		    if (someString.charAt(i) == someChar) {
		        count++;
		    }
		}
		
		return count;
	}
    
    public boolean hasReset() {
    	return reset != null && !reset.isEmpty();
    }
    
    public String getReset() {
    	return reset;
    }
    
    public boolean hasClock() {
    	return clock != null && !clock.isEmpty();
    }
    
    public String getClock() {
    	return clock;
    }
    
    public boolean clockConditionSatisfied(long time) {
    	if (this.smaller) {
    		return time < value;
    	}
    	
    	return false;
    }
    
    void formatID() {
		this.id = this.id.substring(5, this.id.length() - 1);
	}
    
    public String getMessageType() {
    	String messageType = this.id.substring(2, this.id.length() - 1);
 
    	messageType = messageType.substring(messageType.indexOf(".") + 1);
    	messageType = messageType.substring(0, messageType.indexOf("("));

    	return messageType;
    }
    
    public String[] getParameters() {
    	String messageType = this.id.substring(2, this.id.length() - 1);
    	 
    	messageType = messageType.substring(messageType.indexOf("(") + 1);
    	messageType = messageType.substring(0, messageType.indexOf(")"));

    	if (messageType.equals("")) {
    		return new String[0];
    	}
    	
    	return messageType.split(",");
    }
    
    public String getSenderName() {
    	String sender = this.id;
    	if (this.id.contains("!")) {
    		sender = this.id.substring(2, this.id.length() - 1);
    	}
    	
    	sender = sender.substring(0, sender.indexOf("."));
    	
    	return sender;
    }
    
    public String getReceiverName() {
    	String receiver = this.id;
    	if (this.id.contains("!")) {
    		receiver = this.id.substring(2, this.id.length() - 1);
    	}
    	
    	receiver = receiver.substring(receiver.indexOf(")") + 2);
    	
    	return receiver;
    }


    public String getId() {
        return id;
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

    public void setId(String id) {
        if(id.equals("1")){
        	this.id = "true";
        }else{
        	this.id = id;
        }
    }
    
    public void writeTransition(){
    	System.out.println(this.id + " " + this.sender.getId() + "->" + this.receiver.getId());
    }
}
