package util;
			
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

public class Automaton {
    private String id;
    private ArrayList<State> states;
    private ArrayList<Transition> transitions;
    private State initial;
    private State finale;

    public Automaton(String id) {
        this.id = id;
        this.states = new ArrayList<>();
        this.transitions = new ArrayList<>();
    }
    
    public void setFinale(State state){
        this.finale = state;
    }
    
    public State getFinale(){
        return this.finale;
    }
    
    public void setInitial(State state){
    	this.initial = state;
    }
    
    public State getInitial(){
    	return this.initial;
    }	
    
    public ArrayList<State> getStates(){
    	return states;
    }
    
    public ArrayList<Transition> getTransitions(){
    	return transitions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void addState(State newState){
        states.add(newState);
    }
    
    public void rename(){
       int counter = 0;
       int _counter = 0;
       for(State s : this.states) {
       	if(s.getId().equals("qinit") || s.getId().equals("qfinal") || s.getId().equals("qaccepting")){
       		s.setId(s.getId() + _counter);
       		_counter++;
       	}else{
         	s.setId("q" + counter);
         	counter++;
         }
       }  
    }

    public ArrayList<Transition> findSender(State state){
    	ArrayList<Transition> senderTransitions = new ArrayList<Transition>();
    	for (Transition t : this.transitions) {
    		if (t.getSender().getId().equals(state.getId())) {
    			senderTransitions.add(t);
            }
    	}
    	senderTransitions.sort((t1, t2) -> t1.compareTo(t2));
    	return senderTransitions;
    }

    public ArrayList<Transition> findReceiver(State state){
        ArrayList<Transition> receiverTransitions = new ArrayList<Transition>();
        for (Transition t : this.transitions) {
            if (t.getReceiver().getId().equals(state.getId())) {
                receiverTransitions.add(t);
            }
        }
        receiverTransitions.sort((t1, t2) -> t1.compareTo(t2));
        return receiverTransitions;
     }

    public void addTransition(Transition newTransition) {
   		transitions.add(newTransition);
   }

   public void collapse(Automaton automaton){
	   if (this.states.isEmpty() && this.transitions.isEmpty()) {
	        for (State s : automaton.states) {
	            this.addState(s);
	        }
	
	        for (Transition t : automaton.transitions) {
	            this.addTransition(t);
	        }
	
	        this.initial = automaton.initial;
	        this.finale = automaton.finale;
	
	    } else {
	        ArrayList<Transition> receive = findReceiver(this.finale);
	        ArrayList<Transition> send = findSender(this.finale);
	
	        for (State s : automaton.states) {
	            this.addState(s);
	        }
	
	        for (Transition t : automaton.transitions) {
	            this.addTransition(t);
	        }
	
	        for (Transition t : receive) {
	            t.setReceiver(automaton.initial);
	        }
	
	        for (Transition t : send) {
	            t.setSender(automaton.initial);
	        }
	
	        this.states.remove(finale);
	        this.finale = automaton.finale;
	    }
   }
   public void merge(Map<String, Entry<Boolean, Automaton>> automatas){

      State qinit = new State("qinit", StateType.NORMAL);
      State qfinal = new State("qfinal", StateType.FINAL);

      if (this.states.isEmpty() && this.transitions.isEmpty()) {
    	  this.initial = qinit;
		} else {
			this.addTransition(new EpsilonTransition(this.finale, qinit, null, true));
		}

		this.addState(qinit);
		this.addState(qfinal);
		this.finale = qfinal;

		for (Map.Entry<String, Entry<Boolean, Automaton>> a : automatas.entrySet()) {
			for (Transition t : a.getValue().getValue().transitions)
				this.addTransition(t);

			for (State s : a.getValue().getValue().states) {
				this.addState(s);
				if (s.getType().equals(StateType.FINAL)) {
					System.out.println("[Automaton] Setting final transition");
					this.addTransition(new EpsilonTransition(s, qfinal, null, true));
				}
			}
			System.out.println(a.getValue().getKey() ? "[Automaton] epsilon is true" : "[Automaton] epsilon is false");
			this.addTransition(new EpsilonTransition(qinit, a.getValue().getValue().initial, null, a.getValue().getKey()));
		}
   }
}
