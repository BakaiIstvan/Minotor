package hu.bme.mit.dipterv.text.generator

import hu.bme.mit.dipterv.text.minotorDsl.Message

class RegularMessage {
	def compile_msg(Message m)'''
			b = new Automaton("auto7");
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
				
				+ "." + "«m.receiver.name»)", actualState, actualState));
			
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
			
			+ "." + "«m.receiver.name»" , actualState, newState));
			b.addState(newState);
			b.setFinale(newState);
	'''
	
	def compile_future(Message m)'''
			b = new Automaton("auto6");
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
				
				+ "." + "«m.receiver.name»)", actualState, actualState));
							
			newState = new State("q" + counter, StateType.NORMAL);
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
			
			+ "." + "«m.receiver.name»" , actualState, newState));
			b.addState(newState);
			b.addTransition(new Transition("!(" + str + ")", newState, actualState));
			finalState = new State("q" + counter, StateType.FINAL);
			counter++;
			b.addTransition(new Transition(str, newState, finalState));
			b.addState(finalState);
			b.setFinale(finalState);
	'''
	
	def compile_past(Message m)'''
		b = new Automaton("auto7");
		actualState = new State("q" + counter, StateType.NORMAL);
		counter++;
		b.addState(actualState);
		b.setInitial(actualState);
												
		b.addTransition(new Transition(str + " & " + "!(" + "«m.sender.name»" + "." +	
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
			
			+ "." + "«m.receiver.name»)", actualState, actualState));
						
		newState = new State("q" + counter, StateType.FINAL);
		counter++;
		b.addTransition(new Transition("«m.sender.name»" + "." +
		"«m.name»" + "("
		«FOR p: m.params»
			«FOR param: 0..<p.params.size»
				+ "«p.params.get(param).name»"
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
	
	def compile_strict_future(Message m)'''
		b = new Automaton("auto11");
		actualState = new State("q" + counter, StateType.NORMAL);
		counter++;
		b.addState(actualState);
		b.setInitial(actualState);
											
		newState = new State("q" + counter, StateType.NORMAL);
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
		b.addTransition(new Transition("!(" + str + ")", newState, actualState));
		finalState = new State("q" + counter, StateType.FINAL);
		b.addTransition(new Transition(str, newState, finalState));
		b.addState(finalState);
		b.setFinale(newState);
	'''
	
	def compile_strict(Message m)'''
		b = new Automaton("auto12");
		actualState = new State("q" + counter, StateType.NORMAL);
		counter++;
		b.addState(actualState);
		b.setInitial(actualState);
												
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
	
}