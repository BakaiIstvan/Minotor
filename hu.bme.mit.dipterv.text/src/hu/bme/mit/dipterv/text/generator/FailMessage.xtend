package hu.bme.mit.dipterv.text.generator

import hu.bme.mit.dipterv.text.minotorDsl.Message

class FailMessage {
	
	def compile_fail_past(Message m)'''
		b = new Automaton("auto4");
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
			+ "." + "«m.receiver.name»" + ") & " + str, actualState, actualState));
		finalState = new State("q" + counter, StateType.FINAL);
		counter++;
		acceptState = new State("q" + counter, StateType.ACCEPT);
		counter++;
		b.addTransition(new Transition("!" + "(" + str + ")", actualState, finalState));
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
		+ "." + "«m.receiver.name»" , actualState, acceptState));
		b.addState(acceptState);
		b.addState(finalState);
		b.setFinale(finalState);
	'''
	
	def compile_fail(Message m)'''
		b = new Automaton("auto5");
		actualState = new State("q" + counter, StateType.NORMAL);
		counter++;
		b.addState(actualState);
		b.setInitial(actualState);
											
		
		finalState = new State("q" + counter, StateType.FINAL);
		counter++;
		b.addState(finalState);
		b.setFinale(finalState);
		
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
					+ "." + "«m.receiver.name»)", actualState, finalState));
		
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
			
		newState = new State("q" + counter, StateType.ACCEPT);
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
	'''
	
	def compile_strict_fail(Message m)'''
		b = new Automaton("auto10");
		actualState = new State("q" + counter, StateType.NORMAL);
		counter++;
		b.addState(actualState);
		b.setInitial(actualState);
											
		finalState = new State("q" + counter, StateType.FINAL);
		counter++;
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
		+ "." + "«m.receiver.name»" + ")", actualState, finalState));
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
		+ "." + "«m.receiver.name»", actualState, acceptState));
		b.addState(finalState);
		b.addState(acceptState);
		b.setFinale(finalState);
	'''
}