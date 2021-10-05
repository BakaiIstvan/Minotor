package hu.bme.mit.dipterv.text.generator

import hu.bme.mit.dipterv.text.minotorDsl.RequiredLooseMessage
import hu.bme.mit.dipterv.text.minotorDsl.RequiredStrictMessage
import hu.bme.mit.dipterv.text.minotorDsl.RequiredPastMessage
import hu.bme.mit.dipterv.text.minotorDsl.RequiredFutureMessage
import hu.bme.mit.dipterv.text.minotorDsl.RequiredStrictFutureMessage

class ClockRequiredMessage {
	def compile_required_clock(RequiredLooseMessage m)'''
		b = new Automaton("auto31");
		actualState = new State("q" + counter, StateType.NORMAL);
		counter++;
		b.addState(actualState);
		b.setInitial(actualState);
		
		acceptState = new State("q" + counter, StateType.ACCEPT);
		counter++;
		b.addState(acceptState);
		
		newState = new State("q" + counter, StateType.FINAL);
		counter++;
		b.addTransition(new BasicTransition(actualState
										  , newState
										  , «IF m.message.get(0).resetclock !== null»"«m.message.get(0).resetclock.clock.name»"«ELSE»null«ENDIF»
										  , «new LabelGenerator().compile_messageLabel(m)»
										  , null
										  , «IF m.message.get(0).CConstraint !== null»new ClockConstraint("«new ClockConstraintGenerator().compile_clockConstraintName(m.message.get(0).CConstraint)»"
										  , «new ClockConstraintGenerator().compile_ClockConstraintExpression(m.message.get(0).CConstraint)»)
										    «ELSE»null«ENDIF»));
										    
		b.addTransition(new BasicTransition(actualState
										  , actualState
										  , null
										  , "!(" + «new LabelGenerator().compile_messageLabel(m)» + ")"
										  , null
										  , «IF m.message.get(0).CConstraint !== null»new ClockConstraint("«new ClockConstraintGenerator().compile_clockConstraintName(m.message.get(0).CConstraint)»"
										  , «new ClockConstraintGenerator().compile_ClockConstraintExpression(m.message.get(0).CConstraint)»)
										  	«ELSE»null«ENDIF»));
										    
		b.addTransition(new BasicTransition(actualState
										  , acceptState
										  , null
										  , «new LabelGenerator().compile_messageLabel(m)»
										  , null
										  , «IF m.message.get(0).CConstraint !== null»new ClockConstraint("«new ClockConstraintGenerator().compile_clockConstraintName(m.message.get(0).CConstraint)»"
										  , «new ClockConstraintGenerator().compile_Pre(m.message.get(0).CConstraint)»)
										    «ELSE»null«ENDIF»));
										    
		b.addTransition(new BasicTransition(actualState
										  , acceptState
										  , null
										  , "!(" + «new LabelGenerator().compile_messageLabel(m)» + ")"
										  , null
										  , «IF m.message.get(0).CConstraint !== null»new ClockConstraint("«new ClockConstraintGenerator().compile_clockConstraintName(m.message.get(0).CConstraint)»"
										  , «new ClockConstraintGenerator().compile_Succ(m.message.get(0).CConstraint)»)
										  	«ELSE»null«ENDIF»));
		
		b.addState(newState);
		b.setFinale(newState);
	'''
	
	def compile_strict_required_clock(RequiredStrictMessage m)'''
		b = new Automaton("auto9");
		actualState = new State("q" + counter, StateType.NORMAL);
		counter++;
		b.addState(actualState);
		b.setInitial(actualState);
		
		acceptState = new State("q" + counter, StateType.ACCEPT);
		counter++;
		b.addState(acceptState);
		
		newState = new State("q" + counter, StateType.FINAL);
		counter++;
		b.addTransition(new BasicTransition(actualState
										  , newState
										  , «IF m.strictMessage.get(0).message.get(0).resetclock !== null»"«m.strictMessage.get(0).message.get(0).resetclock.clock.name»"«ELSE»null«ENDIF»
										  , «new LabelGenerator().compile_messageLabel(m)»
										  , null
										  , «IF m.strictMessage.get(0).message.get(0).CConstraint !== null»new ClockConstraint("«new ClockConstraintGenerator().compile_clockConstraintName(m.strictMessage.get(0).message.get(0).CConstraint)»"
										  , «new ClockConstraintGenerator().compile_ClockConstraintExpression(m.strictMessage.get(0).message.get(0).CConstraint)»)
										    «ELSE»null«ENDIF»));
		
		b.addTransition(new BasicTransition(actualState
										  , acceptState
										  , null
										  , "!(" + «new LabelGenerator().compile_messageLabel(m)» + ")"
										  , null
										  , «IF m.strictMessage.get(0).message.get(0).CConstraint !== null»new ClockConstraint("«new ClockConstraintGenerator().compile_clockConstraintName(m.strictMessage.get(0).message.get(0).CConstraint)»"
										  , «new ClockConstraintGenerator().compile_ClockConstraintExpression(m.strictMessage.get(0).message.get(0).CConstraint)»)
										  	«ELSE»null«ENDIF»));
								    
		b.addTransition(new BasicTransition(actualState
										  , acceptState
										  , null
										  , «new LabelGenerator().compile_messageLabel(m)»
										  , null
										  , «IF m.strictMessage.get(0).message.get(0).CConstraint !== null»new ClockConstraint("«new ClockConstraintGenerator().compile_clockConstraintName(m.strictMessage.get(0).message.get(0).CConstraint)»"
										  , «new ClockConstraintGenerator().compile_Pre(m.strictMessage.get(0).message.get(0).CConstraint)»)
										    «ELSE»null«ENDIF»));
										    
		b.addTransition(new BasicTransition(actualState
										  , acceptState
										  , null
										  , "!(" + «new LabelGenerator().compile_messageLabel(m)» + ")"
										  , null
										  , «IF m.strictMessage.get(0).message.get(0).CConstraint !== null»new ClockConstraint("«new ClockConstraintGenerator().compile_clockConstraintName(m.strictMessage.get(0).message.get(0).CConstraint)»"
										  , «new ClockConstraintGenerator().compile_Succ(m.strictMessage.get(0).message.get(0).CConstraint)»)
										  	«ELSE»null«ENDIF»));
		
		b.addState(newState);
		b.setFinale(newState);
	'''
	
	def compile_required_past_clock(RequiredPastMessage m)'''
		b = new Automaton("auto2");
		actualState = new State("q" + counter, StateType.NORMAL);
		counter++;
		b.addState(actualState);
		b.setInitial(actualState);
		
		acceptState = new State("q" + counter, StateType.ACCEPT);
		counter++;
		b.addState(acceptState);
		
		newState = new State("q" + counter, StateType.FINAL);
		counter++;
		b.addTransition(new BasicTransition(actualState
										  , newState
										  , «IF m.pastMessage.get(0).message.get(0).resetclock !== null»"«m.pastMessage.get(0).message.get(0).resetclock.clock.name»"«ELSE»null«ENDIF»
										  , «new LabelGenerator().compile_messageLabel(m)»
										  , null
										  , «IF m.pastMessage.get(0).message.get(0).CConstraint !== null»new ClockConstraint("«new ClockConstraintGenerator().compile_clockConstraintName(m.pastMessage.get(0).message.get(0).CConstraint)»"
										  , «new ClockConstraintGenerator().compile_ClockConstraintExpression(m.pastMessage.get(0).message.get(0).CConstraint)»)
										    «ELSE»null«ENDIF»));
										    
		b.addTransition(new BasicTransition(actualState
										  , actualState
										  , null
										  , "!(" + «new LabelGenerator().compile_messageLabel(m)» + ")"
										  , new UnwantedConstraint(new ArrayList<String>() {
										  	{
										  	«FOR cm : m.pastMessage.get(0).c.messages»add(«new LabelGenerator().compile_messageLabel(m)»);«ENDFOR»
										  	}}, «IF m.pastMessage.get(0).constraintexp !== null» 
										  		new ClockConstraint("«new ClockConstraintGenerator().compile_clockConstraintName(m.pastMessage.get(0).constraintexp)»"
										  						 , «new ClockConstraintGenerator().compile_ClockConstraintExpression(m.pastMessage.get(0).constraintexp)»)
										  		«ELSE»null«ENDIF»
										  	  , «IF m.pastMessage.get(0).resetinconstraint !== null»"«m.pastMessage.get(0).resetinconstraint.clock.name»"
										  	    «ELSE»null«ENDIF»)
										  , «IF m.pastMessage.get(0).message.get(0).CConstraint !== null»new ClockConstraint("«new ClockConstraintGenerator().compile_clockConstraintName(m.pastMessage.get(0).message.get(0).CConstraint)»"
										  , «new ClockConstraintGenerator().compile_ClockConstraintExpression(m.pastMessage.get(0).message.get(0).CConstraint)»)
										  	«ELSE»null«ENDIF»));
										    
		b.addTransition(new BasicTransition(actualState
										  , acceptState
										  , null
										  , «new LabelGenerator().compile_messageLabel(m)»
										  , null
										  , «IF m.pastMessage.get(0).message.get(0).CConstraint !== null»new ClockConstraint("«new ClockConstraintGenerator().compile_clockConstraintName(m.pastMessage.get(0).message.get(0).CConstraint)»"
										  , «new ClockConstraintGenerator().compile_Pre(m.pastMessage.get(0).message.get(0).CConstraint)»)
										    «ELSE»null«ENDIF»));
										    
		b.addTransition(new BasicTransition(actualState
										  , acceptState
										  , null
										  , null
										  , new WantedConstraint(new ArrayList<String>() {
  										  	{
  										  	«FOR cm : m.pastMessage.get(0).c.messages»add(«new LabelGenerator().compile_messageLabel(m)»);«ENDFOR»
  										  	}}, «IF m.pastMessage.get(0).constraintexp !== null» 
  										  		new ClockConstraint("«new ClockConstraintGenerator().compile_clockConstraintName(m.pastMessage.get(0).constraintexp)»"
  										  						 , «new ClockConstraintGenerator().compile_ClockConstraintExpression(m.pastMessage.get(0).constraintexp)»)
  										  		«ELSE»null«ENDIF»
  										  	  , null)
										  , null);
										  
		b.addTransition(new BasicTransition(actualState
										  , acceptState
										  , null
										  , "!(" + «new LabelGenerator().compile_messageLabel(m)» + ")"
										  , null
										  , «IF m.pastMessage.get(0).message.get(0).CConstraint !== null»new ClockConstraint("«new ClockConstraintGenerator().compile_clockConstraintName(m.pastMessage.get(0).message.get(0).CConstraint)»"
										  , «new ClockConstraintGenerator().compile_Succ(m.pastMessage.get(0).message.get(0).CConstraint)»)
										  	«ELSE»null«ENDIF»));
		
		b.addState(newState);
		b.setFinale(newState);
	'''
	
	def compile_required_future_clock(RequiredFutureMessage m)'''
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
		
		b.addState(acceptState);
		b.addState(acceptState_new);
		b.addState(finalState);
		b.setFinale(finalState);
										  	
		b.addTransition(new BasicTransition(actualState
										  , finalState
										  , «IF m.futureMessage.get(0).message.get(0).resetclock !== null»"«m.futureMessage.get(0).message.get(0).resetclock.clock.name»"«ELSE»null«ENDIF»
										  , «new LabelGenerator().compile_messageLabel(m)»
										  , null
										  , «IF m.futureMessage.get(0).message.get(0).CConstraint !== null»new ClockConstraint("«new ClockConstraintGenerator().compile_clockConstraintName(m.futureMessage.get(0).message.get(0).CConstraint)»"
										  , «new ClockConstraintGenerator().compile_ClockConstraintExpression(m.futureMessage.get(0).message.get(0).CConstraint)»)
										    «ELSE»null«ENDIF»));
										    
		b.addTransition(new BasicTransition(actualState
										  , actualState
										  , null
										  , "!(" + «new LabelGenerator().compile_messageLabel(m)» + ")"
										  , null
										  , «IF m.futureMessage.get(0).message.get(0).CConstraint !== null»new ClockConstraint("«new ClockConstraintGenerator().compile_clockConstraintName(m.futureMessage.get(0).message.get(0).CConstraint)»"
										  , «new ClockConstraintGenerator().compile_ClockConstraintExpression(m.futureMessage.get(0).message.get(0).CConstraint)»)
										  	«ELSE»null«ENDIF»));
										    
		b.addTransition(new BasicTransition(actualState
										  , acceptState
										  , null
										  , «new LabelGenerator().compile_messageLabel(m)»
										  , null
										  , «IF m.futureMessage.get(0).message.get(0).CConstraint !== null»new ClockConstraint("«new ClockConstraintGenerator().compile_clockConstraintName(m.futureMessage.get(0).message.get(0).CConstraint)»"
										  , «new ClockConstraintGenerator().compile_Pre(m.futureMessage.get(0).message.get(0).CConstraint)»)
										    «ELSE»null«ENDIF»));
										    
		b.addTransition(new BasicTransition(actualState
										  , acceptState
										  , null
										  , "!(" + «new LabelGenerator().compile_messageLabel(m)» + ")"
										  , null
										  , «IF m.futureMessage.get(0).message.get(0).CConstraint !== null»new ClockConstraint("«new ClockConstraintGenerator().compile_clockConstraintName(m.futureMessage.get(0).message.get(0).CConstraint)»"
										  , «new ClockConstraintGenerator().compile_Succ(m.futureMessage.get(0).message.get(0).CConstraint)»)
										  	«ELSE»null«ENDIF»));
										  	
		b.addTransition(new BasicTransition(finalState
										  , finalState
										  , null
										  , null
										  , new UnwantedConstraint(new ArrayList<String>() {
										  	{
										  	«FOR cm : m.futureMessage.get(0).c.messages»add(«new LabelGenerator().compile_messageLabel(m)»);«ENDFOR»
										  	}}, «IF m.futureMessage.get(0).constraintexp !== null» 
										  		new ClockConstraint("«new ClockConstraintGenerator().compile_clockConstraintName(m.futureMessage.get(0).constraintexp)»"
										  						 , «new ClockConstraintGenerator().compile_ClockConstraintExpression(m.futureMessage.get(0).constraintexp)» )
										  		«ELSE»null«ENDIF»
										  	  , «IF m.futureMessage.get(0).resetinconstraint !== null»"«m.futureMessage.get(0).resetinconstraint.clock.name»"
										  	    «ELSE»null«ENDIF»)
										  , null));
										  
		b.addTransition(new BasicTransition(finalState
										  , acceptState_new
										  , null
										  , null
										  , new WantedConstraint(new ArrayList<String>() {
  										  	{
  										  	«FOR cm : m.futureMessage.get(0).c.messages»add(«new LabelGenerator().compile_messageLabel(m)»);«ENDFOR»
  										  	}}, «IF m.futureMessage.get(0).constraintexp !== null» 
  										  		new ClockConstraint("«new ClockConstraintGenerator().compile_clockConstraintName(m.futureMessage.get(0).constraintexp)»"
  										  						 , «new ClockConstraintGenerator().compile_ClockConstraintExpression(m.futureMessage.get(0).constraintexp)»)
  										  		«ELSE»null«ENDIF»
  										  	  , null)
										  , null);
	'''
	
	def compile_strict_required_future_clock(RequiredStrictFutureMessage m)'''
		b = new Automaton("auto10");
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
		
		b.addState(acceptState);
		b.addState(acceptState_new);
		b.addState(finalState);
		b.setFinale(finalState);
		
		b.addTransition(new BasicTransition(actualState
										  , finalState
										  , «IF m.strictFutureMessage.get(0).futureMessage.get(0).message.get(0).resetclock !== null»"«m.strictFutureMessage.get(0).futureMessage.get(0).message.get(0).resetclock.clock.name»"«ELSE»null«ENDIF»
										  , «new LabelGenerator().compile_messageLabel(m)»
										  , null
										  , «IF m.strictFutureMessage.get(0).futureMessage.get(0).message.get(0).CConstraint !== null»new ClockConstraint("«new ClockConstraintGenerator().compile_clockConstraintName(m.strictFutureMessage.get(0).futureMessage.get(0).message.get(0).CConstraint)»"
										  , «new ClockConstraintGenerator().compile_ClockConstraintExpression(m.strictFutureMessage.get(0).futureMessage.get(0).message.get(0).CConstraint)»)
										    «ELSE»null«ENDIF»));
		
		b.addTransition(new BasicTransition(actualState
										  , acceptState
										  , null
										  , "!(" + «new LabelGenerator().compile_messageLabel(m)» + ")"
										  , null
										  , «IF m.strictFutureMessage.get(0).futureMessage.get(0).message.get(0).CConstraint !== null»new ClockConstraint("«new ClockConstraintGenerator().compile_clockConstraintName(m.strictFutureMessage.get(0).futureMessage.get(0).message.get(0).CConstraint)»"
										  , «new ClockConstraintGenerator().compile_ClockConstraintExpression(m.strictFutureMessage.get(0).futureMessage.get(0).message.get(0).CConstraint)»)
										  	«ELSE»null«ENDIF»));
										  	
										    
		b.addTransition(new BasicTransition(actualState
										  , acceptState
										  , null
										  , «new LabelGenerator().compile_messageLabel(m)»
										  , null
										  , «IF m.strictFutureMessage.get(0).futureMessage.get(0).message.get(0).CConstraint !== null»new ClockConstraint("«new ClockConstraintGenerator().compile_clockConstraintName(m.strictFutureMessage.get(0).futureMessage.get(0).message.get(0).CConstraint)»"
										  , «new ClockConstraintGenerator().compile_Pre(m.strictFutureMessage.get(0).futureMessage.get(0).message.get(0).CConstraint)»)
										    «ELSE»null«ENDIF»));
										    
		b.addTransition(new BasicTransition(actualState
										  , acceptState
										  , null
										  , "!(" + «new LabelGenerator().compile_messageLabel(m)» + ")"
										  , null
										  , «IF m.strictFutureMessage.get(0).futureMessage.get(0).message.get(0).CConstraint !== null»new ClockConstraint("«new ClockConstraintGenerator().compile_clockConstraintName(m.strictFutureMessage.get(0).futureMessage.get(0).message.get(0).CConstraint)»"
										  , «new ClockConstraintGenerator().compile_Succ(m.strictFutureMessage.get(0).futureMessage.get(0).message.get(0).CConstraint)»)
										  	«ELSE»null«ENDIF»));
										  	
		b.addTransition(new BasicTransition(finalState
										  , finalState
										  , null
										  , null
										  , new UnwantedConstraint(new ArrayList<String>() {
										  	{
										  	«FOR cm : m.strictFutureMessage.get(0).futureMessage.get(0).c.messages»add(«new LabelGenerator().compile_messageLabel(m)»);«ENDFOR»
										  	}}, «IF m.strictFutureMessage.get(0).futureMessage.get(0).constraintexp !== null» 
										  		new ClockConstraint("«new ClockConstraintGenerator().compile_clockConstraintName(m.strictFutureMessage.get(0).futureMessage.get(0).constraintexp)»"
										  						 , «new ClockConstraintGenerator().compile_ClockConstraintExpression(m.strictFutureMessage.get(0).futureMessage.get(0).constraintexp)» )
										  		«ELSE»null«ENDIF»
										  	  , «IF m.strictFutureMessage.get(0).futureMessage.get(0).resetinconstraint !== null»"«m.strictFutureMessage.get(0).futureMessage.get(0).resetinconstraint.clock.name»"
										  	    «ELSE»null«ENDIF»)
										  , null));
										  
		b.addTransition(new BasicTransition(finalState
										  , acceptState_new
										  , null
										  , null
										  , new WantedConstraint(new ArrayList<String>() {
  										  	{
  										  	«FOR cm : m.strictFutureMessage.get(0).futureMessage.get(0).c.messages»add(«new LabelGenerator().compile_messageLabel(m)»);«ENDFOR»
  										  	}}, «IF m.strictFutureMessage.get(0).futureMessage.get(0).constraintexp !== null» 
  										  		new ClockConstraint("«new ClockConstraintGenerator().compile_clockConstraintName(m.strictFutureMessage.get(0).futureMessage.get(0).constraintexp)»"
  										  						 , «new ClockConstraintGenerator().compile_ClockConstraintExpression(m.strictFutureMessage.get(0).futureMessage.get(0).constraintexp)»)
  										  		«ELSE»null«ENDIF»
  										  	  , null)
										  , null);
	'''
}