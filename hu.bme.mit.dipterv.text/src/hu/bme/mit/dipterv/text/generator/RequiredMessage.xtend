package hu.bme.mit.dipterv.text.generator

import hu.bme.mit.dipterv.text.minotorDsl.Message

class RequiredMessage {
	def compile_required_future(Message m)'''
		b = new Automaton("auto1");
		actualState = new State("q" + counter, StateType.NORMAL);
		counter++;
		b.addState(actualState);
		b.setInitial(actualState);
											
		b.addTransition(new Transition("!(" + "«m.sender.name»" + "." +
		"«m.name»" + "("
		«FOR p: m.params»
			«FOR param: 0..<p.params.size»
				+ "«p.params.get(param).name»"
				«IF param != p.params.size - 1»
					+ ", "
				«ENDIF»
			«ENDFOR»
		«ENDFOR»
		«FOR p: m.constantparams»
			«FOR param: 0..<p.values.size»
				+
				«IF p.values.get(param).value.startsWith("\"")»
					«p.values.get(param).value»
				«ELSE»
				"«p.values.get(param).value»"
				«ENDIF»
				«IF param != p.values.size - 1»
					+ ", "
				«ENDIF»
			«ENDFOR»
		«ENDFOR»
		+ ")"
		+ "." + "«m.receiver.name»" + ")", actualState, actualState));
		finalState = new State("q" + counter, StateType.FINAL);
		counter++;
		acceptState = new State("q" + counter, StateType.ACCEPT);
		counter++;
		acceptState_new = new State("q" + counter, StateType.ACCEPT);
		counter++;
		
		b.addTransition(new Transition("!(" + "«m.sender.name»" + "." +
			"«m.name»" + "("
			«FOR p: m.params»
				«FOR param: 0..<p.params.size»
					+ "«p.params.get(param).name»"
					«IF param != p.params.size - 1»
						+ ", "
					«ENDIF»
				«ENDFOR»
			«ENDFOR»
			«FOR p: m.constantparams»
				«FOR param: 0..<p.values.size»
					+
					«IF p.values.get(param).value.startsWith("\"")»
						«p.values.get(param).value»
					«ELSE»
					"«p.values.get(param).value»"
					«ENDIF»
					«IF param != p.values.size - 1»
						+ ", "
					«ENDIF»
				«ENDFOR»
			«ENDFOR»
			+ ")"
			+ "." + "«m.receiver.name»" + ")", actualState, acceptState_new));
		
		b.addTransition(new Transition("«m.sender.name»" + "." +
		"«m.name»" + "("
		«FOR p: m.params»
			«FOR param: 0..<p.params.size»
				+ "«p.params.get(param).name»"
				«IF param != p.params.size - 1»
					+ ", "
				«ENDIF»
			«ENDFOR»
		«ENDFOR»
		«FOR p: m.constantparams»
			«FOR param: 0..<p.values.size»
				+
				«IF p.values.get(param).value.startsWith("\"")»
					«p.values.get(param).value»
				«ELSE»
				"«p.values.get(param).value»"
				«ENDIF»
				«IF param != p.values.size - 1»
					+ ", "
				«ENDIF»
			«ENDFOR»
		«ENDFOR»
		+ ")"
		+ "." + "«m.receiver.name»", actualState, finalState));
		b.addTransition(new Transition(str, finalState, finalState));
		b.addTransition(new Transition("!" + "(" + str + ")", finalState, acceptState));
		b.addState(acceptState);
		b.addState(acceptState_new);
		b.addState(finalState);
		b.setFinale(finalState);
		
	'''
	
	def compile_required_past(Message m)'''
		b = new Automaton("auto2");
		actualState = new State("q" + counter, StateType.NORMAL);
		counter++;
		b.addState(actualState);
		b.setInitial(actualState);
		
											
		b.addTransition(new Transition("!(" + "«m.sender.name»" + "." +
		"«m.name»" + "("
		«FOR p: m.params»
			«FOR param: 0..<p.params.size»
				+ "«p.params.get(param).name»"
				«IF param != p.params.size - 1»
					+ ", "
				«ENDIF»
			«ENDFOR»
		«ENDFOR»
		«FOR p: m.constantparams»
			«FOR param: 0..<p.values.size»
				+
				«IF p.values.get(param).value.startsWith("\"")»
					«p.values.get(param).value»
				«ELSE»
				"«p.values.get(param).value»"
				«ENDIF»
				«IF param != p.values.size - 1»
					+ ", "
				«ENDIF»
			«ENDFOR»
		«ENDFOR»
		+ ")"
		+ "." + "«m.receiver.name»" + " & " + str + ")", actualState, actualState));
		acceptState = new State("q" + counter, StateType.ACCEPT);
		counter++;
		finalState = new State("q" + counter, StateType.FINAL);
		counter++;
		b.addTransition(new Transition("«m.sender.name»" + "." +
		"«m.name»" + "("
		«FOR p: m.params»
			«FOR param: 0..<p.params.size»
				+ "«p.params.get(param).name»"
				«IF param != p.params.size - 1»
					+ ", "
				«ENDIF»
			«ENDFOR»
		«ENDFOR»
		«FOR p: m.constantparams»
			«FOR param: 0..<p.values.size»
				+
				«IF p.values.get(param).value.startsWith("\"")»
					«p.values.get(param).value»
				«ELSE»
				"«p.values.get(param).value»"
				«ENDIF»
				«IF param != p.values.size - 1»
					+ ", "
				«ENDIF»
			«ENDFOR»
		«ENDFOR»
		+ ")"
		+ "." + "«m.receiver.name»", actualState, finalState));
		b.addTransition(new Transition("!" + "(" + str + ") || " + "!(" + "«m.sender.name»" + "." +
			"«m.name»" + "("
			«FOR p: m.params»
				«FOR param: 0..<p.params.size»
					+ "«p.params.get(param).name»"
					«IF param != p.params.size - 1»
						+ ", "
					«ENDIF»
				«ENDFOR»
			«ENDFOR»
			«FOR p: m.constantparams»
				«FOR param: 0..<p.values.size»
					+
					«IF p.values.get(param).value.startsWith("\"")»
						«p.values.get(param).value»
					«ELSE»
					"«p.values.get(param).value»"
					«ENDIF»
					«IF param != p.values.size - 1»
						+ ", "
					«ENDIF»
				«ENDFOR»
			«ENDFOR»
			+ ")"
			+ "." + "«m.receiver.name»)", actualState, acceptState));
				
		b.addState(acceptState);
		b.addState(finalState);
		b.setFinale(finalState);
	'''
	
	def compile_required(Message m)'''
		b = new Automaton("auto3");
		actualState = new State("q" + counter, StateType.NORMAL);
		counter++;
		b.addState(actualState);
		b.setInitial(actualState);
		
		b.addTransition(new Transition("!(" + "«m.sender.name»" + "." +
		"«m.name»" + "("
		«FOR p: m.params»
			«FOR param: 0..<p.params.size»
				+ "«p.params.get(param).name»"
				«IF param != p.params.size - 1»
					+ ", "
				«ENDIF»
			«ENDFOR»
		«ENDFOR»
		«FOR p: m.constantparams»
			«FOR param: 0..<p.values.size»
				+
				«IF p.values.get(param).value.startsWith("\"")»
					«p.values.get(param).value»
				«ELSE»
				"«p.values.get(param).value»"
				«ENDIF»
				«IF param != p.values.size - 1»
					+ ", "
				«ENDIF»
			«ENDFOR»
		«ENDFOR»
		+ ")"
		
		+ "." + "«m.receiver.name»" + ")", actualState, actualState));
		
		acceptState = new State("q" + counter, StateType.ACCEPT);
		counter++;
		
		b.addTransition(new Transition("!(" + "«m.sender.name»" + "." +
			"«m.name»" + "("
			«FOR p: m.params»
				«FOR param: 0..<p.params.size»
					+ "«p.params.get(param).name»"
					«IF param != p.params.size - 1»
						+ ", "
					«ENDIF»
				«ENDFOR»
			«ENDFOR»
			«FOR p: m.constantparams»
				«FOR param: 0..<p.values.size»
					+
					«IF p.values.get(param).value.startsWith("\"")»
						«p.values.get(param).value»
					«ELSE»
					"«p.values.get(param).value»"
					«ENDIF»
					«IF param != p.values.size - 1»
						+ ", "
					«ENDIF»
				«ENDFOR»
			«ENDFOR»
			+ ")"
			
			+ "." + "«m.receiver.name»" + ")", actualState, acceptState));
		
		b.addState(acceptState);
		
		newState = new State("q" + counter, StateType.FINAL);
		counter++;
		b.addTransition(new Transition("«m.sender.name»" + "." +
		"«m.name»" + "("
		«FOR p: m.params»
			«FOR param: 0..<p.params.size»
				+ "«p.params.get(param).name»"
				«IF param != p.params.size - 1»
					+ ", "
				«ENDIF»
			«ENDFOR»
		«ENDFOR»
		«FOR p: m.constantparams»
			«FOR param: 0..<p.values.size»
				+
				«IF p.values.get(param).value.startsWith("\"")»
					«p.values.get(param).value»
				«ELSE»
				"«p.values.get(param).value»"
				«ENDIF»
				«IF param != p.values.size - 1»
					+ ", "
				«ENDIF»
			«ENDFOR»
		«ENDFOR»
		+ ")"
		+ "." + "«m.receiver.name»", actualState, newState));
		b.addState(newState);
		b.setFinale(newState);
	'''
	
	def compile_strict_required_future(Message m)'''
		b = new Automaton("auto8");
		actualState = new State("q" + counter, StateType.NORMAL);
		counter++;
		b.addState(actualState);
		b.setInitial(actualState);
											
		finalState = new State("q" + counter, StateType.FINAL);
		counter++;
		acceptState = new State("q" + counter, StateType.ACCEPT);
		counter++;
		acceptState_new = new State("q" + counter, StateType.ACCEPT);
		counter++;
		b.addTransition(new Transition("!(" + "«m.sender.name»" + "." +
		"«m.name»" + "("
		«FOR p: m.params»
			«FOR param: 0..<p.params.size»
				+ "«p.params.get(param).name»"
				«IF param != p.params.size - 1»
					+ ", "
				«ENDIF»
			«ENDFOR»
		«ENDFOR»
		«FOR p: m.constantparams»
			«FOR param: 0..<p.values.size»
				+
				«IF p.values.get(param).value.startsWith("\"")»
					«p.values.get(param).value»
				«ELSE»
				"«p.values.get(param).value»"
				«ENDIF»
				«IF param != p.values.size - 1»
					+ ", "
				«ENDIF»
			«ENDFOR»
		«ENDFOR»
		+ ")"
		
		+ "." + "«m.receiver.name»" + ")", actualState, acceptState_new));
		b.addTransition(new Transition("«m.sender.name»" + "." +
		"«m.name»" + "("
		«FOR p: m.params»
			«FOR param: 0..<p.params.size»
				+ "«p.params.get(param).name»"
				«IF param != p.params.size - 1»
					+ ", "
				«ENDIF»
			«ENDFOR»
		«ENDFOR»
		«FOR p: m.constantparams»
			«FOR param: 0..<p.values.size»
				+
				«IF p.values.get(param).value.startsWith("\"")»
					«p.values.get(param).value»
				«ELSE»
				"«p.values.get(param).value»"
				«ENDIF»
				«IF param != p.values.size - 1»
					+ ", "
				«ENDIF»
			«ENDFOR»
		«ENDFOR»
		+ ")"
		+ "." + "«m.receiver.name»", actualState, finalState));
		b.addTransition(new Transition(str, finalState, finalState));
		b.addTransition(new Transition("!" + "(" + str + ")", finalState, acceptState));
		b.addState(finalState);
		b.addState(acceptState);
		b.addState(acceptState_new);
		b.setFinale(finalState);
	'''
	
	def compile_strict_required(Message m)'''
		b = new Automaton("auto9");
		actualState = new State("q" + counter, StateType.NORMAL);
		counter++;
		b.addState(actualState);
		b.setInitial(actualState);
											
		finalState = new State("q" + counter, StateType.FINAL);
		counter++;
		acceptState = new State("q" + counter, StateType.ACCEPT);
		counter++;
		b.addTransition(new Transition("«m.sender.name»" + "." +
		"«m.name»" + "("
		«FOR p: m.params»
			«FOR param: 0..<p.params.size»
				+ "«p.params.get(param).name»"
				«IF param != p.params.size - 1»
					+ ", "
				«ENDIF»
			«ENDFOR»
		«ENDFOR»
		«FOR p: m.constantparams»
			«FOR param: 0..<p.values.size»
				+
				«IF p.values.get(param).value.startsWith("\"")»
					«p.values.get(param).value»
				«ELSE»
				"«p.values.get(param).value»"
				«ENDIF»
				«IF param != p.values.size - 1»
					+ ", "
				«ENDIF»
			«ENDFOR»
		«ENDFOR»
		+ ")"
		+ "." + "«m.receiver.name»" , actualState, finalState));
		b.addTransition(new Transition("!(" + "«m.sender.name»" + "." +
		"«m.name»" + "("
		«FOR p: m.params»
			«FOR param: 0..<p.params.size»
				+ "«p.params.get(param).name»"
				«IF param != p.params.size - 1»
					+ ", "
				«ENDIF»
			«ENDFOR»
		«ENDFOR»
		«FOR p: m.constantparams»
			«FOR param: 0..<p.values.size»
				+
				«IF p.values.get(param).value.startsWith("\"")»
					«p.values.get(param).value»
				«ELSE»
				"«p.values.get(param).value»"
				«ENDIF»
				«IF param != p.values.size - 1»
					+ ", "
				«ENDIF»
			«ENDFOR»
		«ENDFOR»
		+ ")"
		+ "." + "«m.receiver.name»" + ")", actualState, acceptState));
		b.addState(acceptState);
		b.addState(finalState);
		b.setFinale(finalState);
	'''
}