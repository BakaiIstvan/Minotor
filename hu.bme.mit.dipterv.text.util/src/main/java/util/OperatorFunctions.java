package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class OperatorFunctions {
	public ArrayList<Automaton> par(ArrayList<Automaton> automatas) {
        ArrayList<ArrayList<Automaton>> automataList = new ArrayList<>();
        permute(automataList, new ArrayList<>(), automatas);
        return listConverter((automataList));
	}

	private void permute(ArrayList<ArrayList<Automaton>> list, ArrayList<Automaton> resultList, ArrayList<Automaton> automatas) {
	    if (resultList.size() == automatas.size()) {
	        list.add(new ArrayList<>(resultList));
	    } else {
	        for (int i = 0; i < automatas.size(); i++) {
	            if (resultList.contains((automatas.get(i)))) {
	                continue;
	            }
	
	            resultList.add(automatas.get(i));
	            permute(list, resultList, automatas);
	            resultList.remove(resultList.size() - 1);
	        }
	    }
	}

	private ArrayList<Automaton> listConverter(ArrayList<ArrayList<Automaton>> list) {
	    ArrayList<Automaton> result = new ArrayList<>();
	    for (ArrayList<Automaton> alist : list) {
	        Automaton newauto = new Automaton("listConverter");
	        for (Automaton auto : alist) {
	            newauto.collapse(copyAutomaton(auto));
	        }
	        result.add(newauto);
	    }
	    return result;
	}

	public Map<String, Automaton> loopSetup(Automaton loopauto, int min, int max) {
		Map<String, Automaton> result = new HashMap<>();
	    
	    for (int i = min; i <= max; i++) {
	        Automaton newauto = new Automaton("loopauto" + i);
	        for (int j = 0; j < i; j++) {
	            newauto.collapse(copyAutomaton(loopauto));
	        }
	        result.put("loop" + i, newauto);
	    }
	    return result;
	}

	private Automaton copyAutomaton(Automaton referenceAuto) {
        Automaton result = new Automaton("copy automaton");
        int count = 0;
        State previousSender = new State();
        State referencePreviousSender = new State();

        for (Transition t : referenceAuto.getTransitions()) {
        	BasicTransition basict = (BasicTransition)t;
            State sender = new State();
            State receiver = new State();
            Transition transition = new BasicTransition(basict);
            Automaton temp = new Automaton("temp");

            if (t.getSender() == referencePreviousSender) {
                receiver.setId("c" + count);
                count++;
                receiver.setType(t.getReceiver().getType());

                transition.setSender(previousSender);
                transition.setReceiver(receiver);
                temp.addState(previousSender);
                temp.addState(receiver);
                temp.setInitial(previousSender);
                temp.setFinale(receiver);
            } else {
                if (t.getSender() == t.getReceiver()) {
                    sender.setId("c" + count);
                    count++;
                    sender.setType(t.getSender().getType());

                    transition.setSender(sender);
                    transition.setReceiver(sender);

                    temp.addState(sender);
                    temp.setInitial(sender);
                    temp.setFinale(sender);
                } else {
                    sender.setId("c" + count);
                    count++;
                    sender.setType(t.getSender().getType());

                    receiver.setId("c" + count);
                    count++;
                    receiver.setType(t.getReceiver().getType());

                    transition.setSender(sender);
                    transition.setReceiver(receiver);

                    temp.addState(sender);
                    temp.addState(receiver);
                    temp.setInitial(sender);
                    temp.setFinale(receiver);
                }
                previousSender = sender;
                referencePreviousSender = t.getSender();
            }

            temp.addTransition(transition);
            result.collapse(temp);
        }

        return result;
    }
}