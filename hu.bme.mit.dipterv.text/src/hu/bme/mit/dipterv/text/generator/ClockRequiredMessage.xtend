package hu.bme.mit.dipterv.text.generator

import hu.bme.mit.dipterv.text.minotorDsl.Message

class ClockRequiredMessage {
	def compile_constraint_msg(Message m)'''
		str1 = "" 
		«FOR msg : m.c.messages»
			+ "!(" + "«msg.sender.name»" + "." +
			"«msg.name»" + "("
			«FOR p: msg.params»
				«FOR param: 0..<p.params.size»
					+
					«IF p.params.get(param).value.value.startsWith("\"")»
						«p.params.get(param).value.value»
					«ELSE»
					"«p.params.get(param).value.value»"
					«ENDIF»
					«IF param != p.params.size - 1»
						+ ", "
					«ENDIF»
				«ENDFOR»
			«ENDFOR»
			«FOR p: msg.constantparams»
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
			+ "." + "«msg.receiver.name»)" + " & "
		«ENDFOR»;
		str1= str1.substring(0, str1.length() - 3);
		
		«IF m.constraintexp !== null»
			str1+= "; " +
			«IF m.constraintexp.rclockconstraint === null»
				«IF m.constraintexp.not»
					"!" + 
				«ENDIF»
				«IF m.constraintexp.lclockconstraint.op.greater»
					"«m.constraintexp.lclockconstraint.clock.name» > «m.constraintexp.lclockconstraint.constant»"
				«ENDIF»
				«IF m.constraintexp.lclockconstraint.op.smaller»
				 	 "«m.constraintexp.lclockconstraint.clock.name» < «m.constraintexp.lclockconstraint.constant»"
				«ENDIF»
				«IF m.constraintexp.lclockconstraint.op.greaterequals»
					 "«m.constraintexp.lclockconstraint.clock.name» >= «m.constraintexp.lclockconstraint.constant»"
				«ENDIF»
				«IF m.constraintexp.lclockconstraint.op.smallerequals»
					"«m.constraintexp.lclockconstraint.clock.name» <= «m.constraintexp.lclockconstraint.constant»"
				«ENDIF»
				«IF m.constraintexp.lclockconstraint.op.equals»
					"«m.constraintexp.lclockconstraint.clock.name» == «m.constraintexp.lclockconstraint.constant»"
				«ENDIF»
				«IF m.constraintexp.lclockconstraint.op.notequals»
					"«m.constraintexp.lclockconstraint.clock.name» != «m.constraintexp.lclockconstraint.constant»"
				«ENDIF»
			«ELSE»
				«IF m.constraintexp.lclockconstraint.op.greater»
					"«m.constraintexp.lclockconstraint.clock.name» > «m.constraintexp.lclockconstraint.constant»"
				«ENDIF»
				«IF m.constraintexp.lclockconstraint.op.smaller»
				 	 "«m.constraintexp.lclockconstraint.clock.name» < «m.constraintexp.lclockconstraint.constant»"
				«ENDIF»
				«IF m.constraintexp.lclockconstraint.op.greaterequals»
					 "«m.constraintexp.lclockconstraint.clock.name» >= «m.constraintexp.lclockconstraint.constant»"
				«ENDIF»
				«IF m.constraintexp.lclockconstraint.op.smallerequals»
					"«m.constraintexp.lclockconstraint.clock.name» <= «m.constraintexp.lclockconstraint.constant»"
				«ENDIF»
				«IF m.constraintexp.lclockconstraint.op.equals»
					"«m.constraintexp.lclockconstraint.clock.name» == «m.constraintexp.lclockconstraint.constant»"
				«ENDIF»
				«IF m.constraintexp.lclockconstraint.op.notequals»
					"«m.constraintexp.lclockconstraint.clock.name» != «m.constraintexp.lclockconstraint.constant»"
				«ENDIF»
				
				+ " & " + 
				
				«IF m.constraintexp.rclockconstraint.op.greater»
					"«m.constraintexp.rclockconstraint.clock.name» > «m.constraintexp.rclockconstraint.constant»"
				«ENDIF»
				«IF m.constraintexp.rclockconstraint.op.smaller»
				 	 "«m.constraintexp.rclockconstraint.clock.name» < «m.constraintexp.rclockconstraint.constant»"
				«ENDIF»
				«IF m.constraintexp.rclockconstraint.op.greaterequals»
					 "«m.constraintexp.rclockconstraint.clock.name» >= «m.constraintexp.rclockconstraint.constant»"
				«ENDIF»
				«IF m.constraintexp.rclockconstraint.op.smallerequals»
					"«m.constraintexp.rclockconstraint.clock.name» <= «m.constraintexp.rclockconstraint.constant»"
				«ENDIF»
				«IF m.constraintexp.rclockconstraint.op.equals»
					"«m.constraintexp.rclockconstraint.clock.name» == «m.constraintexp.rclockconstraint.constant»"
				«ENDIF»
				«IF m.constraintexp.rclockconstraint.op.notequals»
					"«m.constraintexp.rclockconstraint.clock.name» != «m.constraintexp.rclockconstraint.constant»"
				«ENDIF»
			«ENDIF»
			;
		«ENDIF»
	'''
	
	def compile_pre(Message m)'''
		pre = 
		«IF m.CConstraint.rclockconstraint !== null»
			«IF m.CConstraint.lclockconstraint.op.greater»
				"«m.CConstraint.lclockconstraint.clock.name» <= «m.CConstraint.lclockconstraint.constant»"
			«ENDIF»
			«IF m.CConstraint.lclockconstraint.op.greaterequals»
				 "«m.CConstraint.lclockconstraint.clock.name» < «m.CConstraint.lclockconstraint.constant»"
			«ENDIF»
			
			«IF m.CConstraint.rclockconstraint.op.greater»
				"«m.CConstraint.rclockconstraint.clock.name» <= «m.CConstraint.rclockconstraint.constant»"
			«ENDIF»
			«IF m.CConstraint.rclockconstraint.op.greaterequals»
				 "«m.CConstraint.rclockconstraint.clock.name» < «m.CConstraint.rclockconstraint.constant»"
			«ENDIF»
		«ELSEIF m.CConstraint.lclockconstraint.op.greater || m.CConstraint.lclockconstraint.op.greaterequals»
			«IF m.CConstraint.lclockconstraint.op.greater»
				"«m.CConstraint.lclockconstraint.clock.name» <= «m.CConstraint.lclockconstraint.constant»"
			«ENDIF»
			«IF m.CConstraint.lclockconstraint.op.greaterequals»
				 "«m.CConstraint.lclockconstraint.clock.name» < «m.CConstraint.lclockconstraint.constant»"
			«ENDIF»
		«ELSE»
			""
		«ENDIF»
		;
	'''
	
	def compile_succ(Message m)'''
		succ =
		«IF m.CConstraint.rclockconstraint !== null»
			«IF m.CConstraint.lclockconstraint.op.smaller»
				"«m.CConstraint.lclockconstraint.clock.name» >= «m.CConstraint.lclockconstraint.constant»"
			«ENDIF»
			«IF m.CConstraint.lclockconstraint.op.smallerequals»
				 "«m.CConstraint.lclockconstraint.clock.name» > «m.CConstraint.lclockconstraint.constant»"
			«ENDIF»
			
			«IF m.CConstraint.rclockconstraint.op.smaller»
				"«m.CConstraint.rclockconstraint.clock.name» >= «m.CConstraint.rclockconstraint.constant»"
			«ENDIF»
			«IF m.CConstraint.rclockconstraint.op.smallerequals»
				 "«m.CConstraint.rclockconstraint.clock.name» > «m.CConstraint.rclockconstraint.constant»"
			«ENDIF»
		«ELSEIF m.CConstraint.lclockconstraint.op.smaller || m.CConstraint.lclockconstraint.op.smallerequals»
			«IF m.CConstraint.lclockconstraint.op.smaller»
				"«m.CConstraint.lclockconstraint.clock.name» >= «m.CConstraint.lclockconstraint.constant»"
			«ENDIF»
			«IF m.CConstraint.lclockconstraint.op.smallerequals»
				 "«m.CConstraint.lclockconstraint.clock.name» > «m.CConstraint.lclockconstraint.constant»"
			«ENDIF»
		«ELSE»
			""
		«ENDIF»
		;
	'''
	
	def compile_required_message(Message m)'''
		"«m.sender.name»" + "." +
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
	'''
	def compile_clock_constraint(Message m)'''
		«IF m.CConstraint.rclockconstraint === null»
			«IF m.CConstraint.not»
				"!" + 
			«ENDIF»
			«IF m.CConstraint.lclockconstraint.op.greater»
				"«m.CConstraint.lclockconstraint.clock.name» > «m.CConstraint.lclockconstraint.constant»"
			«ENDIF»
			«IF m.CConstraint.lclockconstraint.op.smaller»
			 	 "«m.CConstraint.lclockconstraint.clock.name» < «m.CConstraint.lclockconstraint.constant»"
			«ENDIF»
			«IF m.CConstraint.lclockconstraint.op.greaterequals»
				 "«m.CConstraint.lclockconstraint.clock.name» >= «m.CConstraint.lclockconstraint.constant»"
			«ENDIF»
			«IF m.CConstraint.lclockconstraint.op.smallerequals»
				"«m.CConstraint.lclockconstraint.clock.name» <= «m.CConstraint.lclockconstraint.constant»"
			«ENDIF»
			«IF m.CConstraint.lclockconstraint.op.equals»
				"«m.CConstraint.lclockconstraint.clock.name» == «m.CConstraint.lclockconstraint.constant»"
			«ENDIF»
			«IF m.CConstraint.lclockconstraint.op.notequals»
				"«m.CConstraint.lclockconstraint.clock.name» != «m.CConstraint.lclockconstraint.constant»"
			«ENDIF»
		«ELSE»
			«IF m.CConstraint.lclockconstraint.op.greater»
				"«m.CConstraint.lclockconstraint.clock.name» > «m.CConstraint.lclockconstraint.constant»"
			«ENDIF»
			«IF m.CConstraint.lclockconstraint.op.smaller»
			 	 "«m.CConstraint.lclockconstraint.clock.name» < «m.CConstraint.lclockconstraint.constant»"
			«ENDIF»
			«IF m.CConstraint.lclockconstraint.op.greaterequals»
				 "«m.CConstraint.lclockconstraint.clock.name» >= «m.CConstraint.lclockconstraint.constant»"
			«ENDIF»
			«IF m.CConstraint.lclockconstraint.op.smallerequals»
				"«m.CConstraint.lclockconstraint.clock.name» <= «m.CConstraint.lclockconstraint.constant»"
			«ENDIF»
			«IF m.CConstraint.lclockconstraint.op.equals»
				"«m.CConstraint.lclockconstraint.clock.name» == «m.CConstraint.lclockconstraint.constant»"
			«ENDIF»
			«IF m.CConstraint.lclockconstraint.op.notequals»
				"«m.CConstraint.lclockconstraint.clock.name» != «m.CConstraint.lclockconstraint.constant»"
			«ENDIF»
			
			+ " & " + 
			
			«IF m.CConstraint.rclockconstraint.op.greater»
				"«m.CConstraint.rclockconstraint.clock.name» > «m.CConstraint.rclockconstraint.constant»"
			«ENDIF»
			«IF m.CConstraint.rclockconstraint.op.smaller»
			 	 "«m.CConstraint.rclockconstraint.clock.name» < «m.CConstraint.rclockconstraint.constant»"
			«ENDIF»
			«IF m.CConstraint.rclockconstraint.op.greaterequals»
				 "«m.CConstraint.rclockconstraint.clock.name» >= «m.CConstraint.rclockconstraint.constant»"
			«ENDIF»
			«IF m.CConstraint.rclockconstraint.op.smallerequals»
				"«m.CConstraint.rclockconstraint.clock.name» <= «m.CConstraint.rclockconstraint.constant»"
			«ENDIF»
			«IF m.CConstraint.rclockconstraint.op.equals»
				"«m.CConstraint.rclockconstraint.clock.name» == «m.CConstraint.rclockconstraint.constant»"
			«ENDIF»
			«IF m.CConstraint.rclockconstraint.op.notequals»
				"«m.CConstraint.rclockconstraint.clock.name» != «m.CConstraint.rclockconstraint.constant»"
			«ENDIF»
		«ENDIF»
	'''
	def compile_required_clock(Message m)'''
		b = new Automaton("auto31");
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
		
		+ "." + "«m.receiver.name»" + "); " +
		
		«IF m.CConstraint.rclockconstraint === null»
			«IF m.CConstraint.not»
				"!" + 
			«ENDIF»
			«IF m.CConstraint.lclockconstraint.op.greater»
				"«m.CConstraint.lclockconstraint.clock.name» > «m.CConstraint.lclockconstraint.constant»"
			«ENDIF»
			«IF m.CConstraint.lclockconstraint.op.smaller»
			 	 "«m.CConstraint.lclockconstraint.clock.name» < «m.CConstraint.lclockconstraint.constant»"
			«ENDIF»
			«IF m.CConstraint.lclockconstraint.op.greaterequals»
				 "«m.CConstraint.lclockconstraint.clock.name» >= «m.CConstraint.lclockconstraint.constant»"
			«ENDIF»
			«IF m.CConstraint.lclockconstraint.op.smallerequals»
				"«m.CConstraint.lclockconstraint.clock.name» <= «m.CConstraint.lclockconstraint.constant»"
			«ENDIF»
			«IF m.CConstraint.lclockconstraint.op.equals»
				"«m.CConstraint.lclockconstraint.clock.name» == «m.CConstraint.lclockconstraint.constant»"
			«ENDIF»
			«IF m.CConstraint.lclockconstraint.op.notequals»
				"«m.CConstraint.lclockconstraint.clock.name» != «m.CConstraint.lclockconstraint.constant»"
			«ENDIF»
		«ELSE»
			«IF m.CConstraint.lclockconstraint.op.greater»
				"«m.CConstraint.lclockconstraint.clock.name» > «m.CConstraint.lclockconstraint.constant»"
			«ENDIF»
			«IF m.CConstraint.lclockconstraint.op.smaller»
			 	 "«m.CConstraint.lclockconstraint.clock.name» < «m.CConstraint.lclockconstraint.constant»"
			«ENDIF»
			«IF m.CConstraint.lclockconstraint.op.greaterequals»
				 "«m.CConstraint.lclockconstraint.clock.name» >= «m.CConstraint.lclockconstraint.constant»"
			«ENDIF»
			«IF m.CConstraint.lclockconstraint.op.smallerequals»
				"«m.CConstraint.lclockconstraint.clock.name» <= «m.CConstraint.lclockconstraint.constant»"
			«ENDIF»
			«IF m.CConstraint.lclockconstraint.op.equals»
				"«m.CConstraint.lclockconstraint.clock.name» == «m.CConstraint.lclockconstraint.constant»"
			«ENDIF»
			«IF m.CConstraint.lclockconstraint.op.notequals»
				"«m.CConstraint.lclockconstraint.clock.name» != «m.CConstraint.lclockconstraint.constant»"
			«ENDIF»
			
			+ " & " + 
			
			«IF m.CConstraint.rclockconstraint.op.greater»
				"«m.CConstraint.rclockconstraint.clock.name» > «m.CConstraint.rclockconstraint.constant»"
			«ENDIF»
			«IF m.CConstraint.rclockconstraint.op.smaller»
			 	 "«m.CConstraint.rclockconstraint.clock.name» < «m.CConstraint.rclockconstraint.constant»"
			«ENDIF»
			«IF m.CConstraint.rclockconstraint.op.greaterequals»
				 "«m.CConstraint.rclockconstraint.clock.name» >= «m.CConstraint.rclockconstraint.constant»"
			«ENDIF»
			«IF m.CConstraint.rclockconstraint.op.smallerequals»
				"«m.CConstraint.rclockconstraint.clock.name» <= «m.CConstraint.rclockconstraint.constant»"
			«ENDIF»
			«IF m.CConstraint.rclockconstraint.op.equals»
				"«m.CConstraint.rclockconstraint.clock.name» == «m.CConstraint.rclockconstraint.constant»"
			«ENDIF»
			«IF m.CConstraint.rclockconstraint.op.notequals»
				"«m.CConstraint.rclockconstraint.clock.name» != «m.CConstraint.rclockconstraint.constant»"
			«ENDIF»
		«ENDIF»
		
		, actualState, actualState));
		
		acceptState = new State("q" + counter, StateType.ACCEPT);
		counter++;
		
		
		«compile_pre(m)»
		«compile_succ(m)»
		b.addTransition(new Transition((!pre.equals("")? "(" + "«m.sender.name»" + "." +
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
			
			+ "." + "«m.receiver.name» " +
			"; (" + pre + ")" : "") +
			((!pre.equals("") && !succ.equals(""))? " || " : "") + (!pre.equals("") ? ";" : "") + (succ.equals("") ? "" : "(1; " + succ + ")"), actualState, acceptState));
		
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
		+ "." + "«m.receiver.name»; " +
		
		«IF m.CConstraint.rclockconstraint === null»
			«IF m.CConstraint.not»
				"!" + 
			«ENDIF»
			«IF m.CConstraint.lclockconstraint.op.greater»
				"«m.CConstraint.lclockconstraint.clock.name» > «m.CConstraint.lclockconstraint.constant»"
			«ENDIF»
			«IF m.CConstraint.lclockconstraint.op.smaller»
			 	 "«m.CConstraint.lclockconstraint.clock.name» < «m.CConstraint.lclockconstraint.constant»"
			«ENDIF»
			«IF m.CConstraint.lclockconstraint.op.greaterequals»
				 "«m.CConstraint.lclockconstraint.clock.name» >= «m.CConstraint.lclockconstraint.constant»"
			«ENDIF»
			«IF m.CConstraint.lclockconstraint.op.smallerequals»
				"«m.CConstraint.lclockconstraint.clock.name» <= «m.CConstraint.lclockconstraint.constant»"
			«ENDIF»
			«IF m.CConstraint.lclockconstraint.op.equals»
				"«m.CConstraint.lclockconstraint.clock.name» == «m.CConstraint.lclockconstraint.constant»"
			«ENDIF»
			«IF m.CConstraint.lclockconstraint.op.notequals»
				"«m.CConstraint.lclockconstraint.clock.name» != «m.CConstraint.lclockconstraint.constant»"
			«ENDIF»
		«ELSE»
			«IF m.CConstraint.lclockconstraint.op.greater»
				"«m.CConstraint.lclockconstraint.clock.name» > «m.CConstraint.lclockconstraint.constant»"
			«ENDIF»
			«IF m.CConstraint.lclockconstraint.op.smaller»
			 	 "«m.CConstraint.lclockconstraint.clock.name» < «m.CConstraint.lclockconstraint.constant»"
			«ENDIF»
			«IF m.CConstraint.lclockconstraint.op.greaterequals»
				 "«m.CConstraint.lclockconstraint.clock.name» >= «m.CConstraint.lclockconstraint.constant»"
			«ENDIF»
			«IF m.CConstraint.lclockconstraint.op.smallerequals»
				"«m.CConstraint.lclockconstraint.clock.name» <= «m.CConstraint.lclockconstraint.constant»"
			«ENDIF»
			«IF m.CConstraint.lclockconstraint.op.equals»
				"«m.CConstraint.lclockconstraint.clock.name» == «m.CConstraint.lclockconstraint.constant»"
			«ENDIF»
			«IF m.CConstraint.lclockconstraint.op.notequals»
				"«m.CConstraint.lclockconstraint.clock.name» != «m.CConstraint.lclockconstraint.constant»"
			«ENDIF»
			
			+ " & " + 
			
			«IF m.CConstraint.rclockconstraint.op.greater»
				"«m.CConstraint.rclockconstraint.clock.name» > «m.CConstraint.rclockconstraint.constant»"
			«ENDIF»
			«IF m.CConstraint.rclockconstraint.op.smaller»
			 	 "«m.CConstraint.rclockconstraint.clock.name» < «m.CConstraint.rclockconstraint.constant»"
			«ENDIF»
			«IF m.CConstraint.rclockconstraint.op.greaterequals»
				 "«m.CConstraint.rclockconstraint.clock.name» >= «m.CConstraint.rclockconstraint.constant»"
			«ENDIF»
			«IF m.CConstraint.rclockconstraint.op.smallerequals»
				"«m.CConstraint.rclockconstraint.clock.name» <= «m.CConstraint.rclockconstraint.constant»"
			«ENDIF»
			«IF m.CConstraint.rclockconstraint.op.equals»
				"«m.CConstraint.rclockconstraint.clock.name» == «m.CConstraint.rclockconstraint.constant»"
			«ENDIF»
			«IF m.CConstraint.rclockconstraint.op.notequals»
				"«m.CConstraint.rclockconstraint.clock.name» != «m.CConstraint.rclockconstraint.constant»"
			«ENDIF»
		«ENDIF»
		
		«IF m.resetclock !== null»
			+ "; «m.resetclock.clock.name» = 0"
		«ENDIF»
		
		, actualState, newState));
		b.addState(newState);
		b.setFinale(newState);
	'''
	
	def compile_strict_required_clock(Message m)'''
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
		+ "." + "«m.receiver.name»;" + 
		
		«compile_clock_constraint(m)»
		
		«IF m.resetclock !== null»
			+ "; «m.resetclock.clock.name» = 0"
		«ENDIF»
		
		, actualState, finalState));
		«compile_pre(m)»
		«compile_succ(m)»
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
		+ "." + "«m.receiver.name»" + "); " + «compile_clock_constraint(m)»
		+ " || (" + «compile_required_message(m)» +", " + pre + ")) || (1, " + succ + "))"
		
		, actualState, acceptState));
		b.addState(acceptState);
		b.addState(finalState);
		b.setFinale(finalState);
	'''
	
	def compile_required_past_clock(Message m)'''
		«compile_constraint_msg(m)»
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
		+ "." + "«m.receiver.name»); " + «compile_clock_constraint(m)» + " & " + str + ")", actualState, actualState));
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
		+ "." + "«m.receiver.name»; " + 
		
		«compile_clock_constraint(m)»
		
		«IF m.resetclock !== null»
			+ "; «m.resetclock.clock.name» = 0"
		«ENDIF»
		
		, actualState, finalState));
		«compile_pre(m)»
		«compile_succ(m)»
		b.addTransition(new Transition("(!" + "(" + str1 + "); " + «compile_clock_constraint(m)» + ") || " + "(" + "«m.sender.name»" + "." +
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
			+ "." + "«m.receiver.name»; " + pre + ")) || (1, " + succ + "))", actualState, acceptState));
				
		b.addState(acceptState);
		b.addState(finalState);
		b.setFinale(finalState);
	'''
	
	def compile_required_future_clock(Message m)'''
		«compile_constraint_msg(m)»
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
		+ "." + "«m.receiver.name»" + "); " + «compile_clock_constraint(m)», actualState, actualState));
		finalState = new State("q" + counter, StateType.FINAL);
		counter++;
		acceptState = new State("q" + counter, StateType.ACCEPT);
		counter++;
		acceptState_new = new State("q" + counter, StateType.ACCEPT);
		counter++;
		
		«compile_pre(m)»
		«compile_succ(m)»
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
			+ "." + "«m.receiver.name»; (" + pre + ") || (1, " + succ + ")", actualState, acceptState_new));
		
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
		+ "." + "«m.receiver.name»; " + «compile_clock_constraint(m)»
		
		«IF m.resetclock !== null»
			+ "; «m.resetclock.clock.name» = 0"
		«ENDIF»
		
		, actualState, finalState));
		b.addTransition(new Transition(str, finalState, finalState));
		b.addTransition(new Transition("!" + "(" + str1 + ")", finalState, acceptState));
		b.addState(acceptState);
		b.addState(acceptState_new);
		b.addState(finalState);
		b.setFinale(finalState);
	'''
	
	def compile_strict_required_future_clock(Message m)'''
		«compile_constraint_msg(m)»
		b = new Automaton("auto1");
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
		
		«compile_pre(m)»
		«compile_succ(m)»
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
			+ "." + "«m.receiver.name»; (" + pre + ") || (1, " + succ + ") || "
			
			+ "!(" + «compile_required_message(m)» + "); " + «compile_clock_constraint(m)» 
			
			, actualState, acceptState_new));
		
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
		+ "." + "«m.receiver.name»; " + «compile_clock_constraint(m)»
		
		«IF m.resetclock !== null»
			+ "; «m.resetclock.clock.name» = 0"
		«ENDIF»
		
		, actualState, finalState));
		b.addTransition(new Transition(str, finalState, finalState));
		b.addTransition(new Transition("!" + "(" + str1 + ")", finalState, acceptState));
		b.addState(acceptState);
		b.addState(acceptState_new);
		b.addState(finalState);
		b.setFinale(finalState);
	'''
}