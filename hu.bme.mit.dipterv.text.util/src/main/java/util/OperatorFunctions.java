package util;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class OperatorFunctions {
	public Map<String, Entry<Boolean, Automaton>> par(ArrayList<Automaton> automatas) {
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

	private Map<String, Entry<Boolean, Automaton>> listConverter(ArrayList<ArrayList<Automaton>> list) {
		Map<String, Entry<Boolean, Automaton>> result = new HashMap<>();
		int counter = 0;
	    for (ArrayList<Automaton> alist : list) {
	        Automaton newauto = new Automaton("listConverter");
	        for (Automaton auto : alist) {
	            newauto.collapse(copyAutomaton(auto));
	        }
	        
	        result.put("listConverter" + counter, new AbstractMap.SimpleEntry<Boolean, Automaton>(true, newauto));
	        counter++;
	    }
	    return result;
	}

	public Map<String, Entry<Boolean, Automaton>> loopSetup(Automaton loopauto, int min, int max) {
		Map<String, Entry<Boolean, Automaton>> result = new HashMap<>();
	    
	    for (int i = min; i <= max; i++) {
	        Automaton newauto = new Automaton("loopauto" + i);
	        for (int j = 0; j < i; j++) {
	            newauto.collapse(copyAutomaton(loopauto));
	        }
	        result.put("loopauto" + i, new AbstractMap.SimpleEntry<Boolean, Automaton>(true, newauto));
	    }
	    return result;
	}

	private Automaton copyAutomaton(Automaton referenceAuto) {
        Automaton result = new Automaton("copy automaton");
        
        for (State referenceState : referenceAuto.getStates()) {
        	result.addState(new State(referenceState.getId(), referenceState.getType()));
        }
        
        result.setInitial(result.getStates().stream().filter(state -> state.getId().equals(referenceAuto.getInitial().getId())).findFirst().orElse(null));
        result.setFinale(result.getStates().stream().filter(state -> state.getId().equals(referenceAuto.getFinale().getId())).findFirst().orElse(null));
        
        for (Transition referenceTransition : referenceAuto.getTransitions()) {
        	BasicTransition bReferenceTransition = (BasicTransition)referenceTransition;
        	BasicTransition bTransition = new BasicTransition(result.getStates().stream().filter(state -> state.getId().equals(bReferenceTransition.getSender().getId())).findFirst().orElse(null)
        													, result.getStates().stream().filter(state -> state.getId().equals(bReferenceTransition.getReceiver().getId())).findFirst().orElse(null)
        													, bReferenceTransition.getReset()
        													, bReferenceTransition.getLabel()
        													, bReferenceTransition.getConstraint()
        													, bReferenceTransition.getClockConstraint());
        	result.addTransition(bTransition);
        }
        
        return result;
    }
}
