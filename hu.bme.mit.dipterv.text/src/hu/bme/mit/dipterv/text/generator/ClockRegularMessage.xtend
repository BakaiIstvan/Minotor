package hu.bme.mit.dipterv.text.generator

import hu.bme.mit.dipterv.text.minotorDsl.Message

class ClockRegularMessage {
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
	def compile_msg_clock(Message m)'''
		b = new Automaton("auto30");
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
			
			+ "." + "«m.receiver.name»); "
			
			«IF m.CConstraint !== null»
			+
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
				+ ";"
			«ENDIF»
			
			, actualState, actualState));
		
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
		
		+ "." + "«m.receiver.name»; "
		
		«IF m.CConstraint !== null»
		+
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
			+ ";"
		«ENDIF»

		«IF m.resetclock !== null»
			+ "«m.resetclock.clock.name» = 0"
		«ENDIF»
		
		 , actualState, newState));
		b.addState(newState);
		b.setFinale(newState);
	'''
	
	def compile_strict_clock(Message m)'''
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
		+ "." + "«m.receiver.name»;" +
		
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
	
	def compile_past_clock(Message m)'''
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
			
			+ "." + "«m.receiver.name»); " + 
			
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
		+ "." + "«m.receiver.name»;" + 
		
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
	def compile_future_clock(Message m)'''
		b = new Automaton("auto30");
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
			
			+ "." + "«m.receiver.name»); " + 
			
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
		
		newState = new State("q" + counter, StateType.NORMAL);
		counter++;
		b.addTransition(new Transition(str + " & " + "«m.sender.name»" + "." +
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
		
		«compile_constraint_msg(m)»
		
		b.addTransition(new Transition("!" + str1, newState, actualState));
		
		finalState = new State("q" + counter, StateType.FINAL);
		b.addTransition(newTransition(str, newState, finalState));
		b.addState(finalState);
		b.setFinale(finalState);
	'''
	
	def compile_future_strict_clock(Message m)'''
		b = new Automaton("auto12");
		actualState = new State("q" + counter, StateType.NORMAL);
		counter++;
		b.addState(actualState);
		b.setInitial(actualState);
												
		newState = new State("q" + counter, StateType.FINAL);
		counter++;
		b.addTransition(new Transition(str + " & " + "«m.sender.name»" + "." +
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
		«compile_constraint_msg(m)»
				
		b.addTransition(new Transition("!" + str1, newState, actualState));
		
		finalState = new State("q" + counter, StateType.FINAL);
		b.addTransition(newTransition(str, newState, finalState));
		b.addState(finalState);
		b.setFinale(finalState);
	'''
	
}