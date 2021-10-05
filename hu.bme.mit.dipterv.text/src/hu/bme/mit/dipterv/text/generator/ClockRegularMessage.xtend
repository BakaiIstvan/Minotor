package hu.bme.mit.dipterv.text.generator

import hu.bme.mit.dipterv.text.minotorDsl.LooseMessage
import hu.bme.mit.dipterv.text.minotorDsl.StrictMessage
import hu.bme.mit.dipterv.text.minotorDsl.PastMessage
import hu.bme.mit.dipterv.text.minotorDsl.FutureMessage
import hu.bme.mit.dipterv.text.minotorDsl.StrictFutureMessage

class ClockRegularMessage {
	def compile_msg_clock(LooseMessage m)'''
		b = new Automaton("auto30");
		actualState = new State("q" + counter, StateType.NORMAL);
		counter++;
		b.addState(actualState);
		b.setInitial(actualState);
		
		b.addTransition(new BasicTransition(actualState
										  , actualState
										  , null
										  , "!(" + «new LabelGenerator().compile_messageLabel(m)» + ")"
										  , null
										  , «IF m.CConstraint !== null»new ClockConstraint("«new ClockConstraintGenerator().compile_clockConstraintName(m.CConstraint)»"
										  , «new ClockConstraintGenerator().compile_ClockConstraintExpression(m.CConstraint)»)
										  	«ELSE»null«ENDIF»));
		
		newState = new State("q" + counter, StateType.FINAL);
		counter++;
		b.addTransition(new BasicTransition(actualState
										  , newState
										  , «IF m.resetclock !== null»"«m.resetclock.clock.name»"«ELSE»null«ENDIF»
										  , «new LabelGenerator().compile_messageLabel(m)»
										  , null
										  , «IF m.CConstraint !== null»new ClockConstraint("«new ClockConstraintGenerator().compile_clockConstraintName(m.CConstraint)»"
										  , «new ClockConstraintGenerator().compile_ClockConstraintExpression(m.CConstraint)»)
										    «ELSE»null«ENDIF»));
		b.addState(newState);
		b.setFinale(newState);
	'''
	
	def compile_strict_clock(StrictMessage m)'''
		b = new Automaton("auto12");
		actualState = new State("q" + counter, StateType.NORMAL);
		counter++;
		b.addState(actualState);
		b.setInitial(actualState);
												
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
		b.addState(newState);
		b.setFinale(newState);
	'''
	
	def compile_past_clock(PastMessage m)'''
		b = new Automaton("auto7");
		actualState = new State("q" + counter, StateType.NORMAL);
		counter++;
		b.addState(actualState);
		b.setInitial(actualState);
		
		b.addTransition(new BasicTransition(actualState
										  , actualState
										  , null
										  , "!(" + «new LabelGenerator().compile_messageLabel(m)» + ")"
										  , new UnwantedConstraint(new ArrayList<String>() {
										  	{
										  	«FOR cm : m.c.messages»add(«new LabelGenerator().compile_messageLabel(m)»);«ENDFOR»
										  	}}, «IF m.constraintexp !== null» 
										  		new ClockConstraint("«new ClockConstraintGenerator().compile_clockConstraintName(m.constraintexp)»"
										  						 , «new ClockConstraintGenerator().compile_ClockConstraintExpression(m.constraintexp)»)
										  		«ELSE»null«ENDIF»
										  	  , «IF m.resetinconstraint !== null»"«m.resetinconstraint.clock.name»"
										  	    «ELSE»null«ENDIF»)
										  , «IF m.message.get(0).CConstraint !== null»new ClockConstraint("«new ClockConstraintGenerator().compile_clockConstraintName(m.message.get(0).CConstraint)»"
										  , «new ClockConstraintGenerator().compile_ClockConstraintExpression(m.message.get(0).CConstraint)»)
										  	«ELSE»null«ENDIF»));
		
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
		b.addState(newState);
		b.setFinale(newState);
	'''
	def compile_future_clock(FutureMessage m)'''
		b = new Automaton("auto31");
		actualState = new State("q" + counter, StateType.NORMAL);
		counter++;
		b.addState(actualState);
		b.setInitial(actualState);
											
		b.addTransition(new BasicTransition(actualState
										  , actualState
										  , null
										  , "!(" + «new LabelGenerator().compile_messageLabel(m)» + ")"
										  , null
										  , «IF m.message.get(0).CConstraint !== null»new ClockConstraint("«new ClockConstraintGenerator().compile_clockConstraintName(m.message.get(0).CConstraint)»"
										  , «new ClockConstraintGenerator().compile_ClockConstraintExpression(m.message.get(0).CConstraint)»)
										  	«ELSE»null«ENDIF»));
		
		newState = new State("q" + counter, StateType.NORMAL);
		counter++;
		b.addTransition(new BasicTransition(actualState
										  , newState
										  , «IF m.message.get(0).resetclock !== null»"«m.message.get(0).resetclock.clock.name»"«ELSE»null«ENDIF»
										  , «new LabelGenerator().compile_messageLabel(m)»
										  , null
										  , «IF m.message.get(0).CConstraint !== null»new ClockConstraint("«new ClockConstraintGenerator().compile_clockConstraintName(m.message.get(0).CConstraint)»"
										  , «new ClockConstraintGenerator().compile_ClockConstraintExpression(m.message.get(0).CConstraint)»)
										    «ELSE»null«ENDIF»));
		b.addState(newState);
		b.setFinale(newState);
		
		b.addTransition(new BasicTransition(newState
										  , newState
										  , null
										  , null
										  , new UnwantedConstraint(new ArrayList<String>() {
										  	{
										  	«FOR cm : m.c.messages»add(«new LabelGenerator().compile_messageLabel(m)»);«ENDFOR»
										  	}}, «IF m.constraintexp !== null» 
										  		new ClockConstraint("«new ClockConstraintGenerator().compile_clockConstraintName(m.constraintexp)»"
										  						 , «new ClockConstraintGenerator().compile_ClockConstraintExpression(m.constraintexp)» )
										  		«ELSE»null«ENDIF»
										  	  , «IF m.resetinconstraint !== null»"«m.resetinconstraint.clock.name»"
										  	    «ELSE»null«ENDIF»)
										  , null));
	'''
	
	def compile_future_strict_clock(StrictFutureMessage m)'''
		b = new Automaton("auto33");
				actualState = new State("q" + counter, StateType.NORMAL);
				counter++;
				b.addState(actualState);
				b.setInitial(actualState);
				
				newState = new State("q" + counter, StateType.NORMAL);
				counter++;
				b.addTransition(new BasicTransition(actualState
												  , newState
												  , «IF m.futureMessage.get(0).message.get(0).resetclock !== null»"«m.futureMessage.get(0).message.get(0).resetclock.clock.name»"«ELSE»null«ENDIF»
												  , «new LabelGenerator().compile_messageLabel(m)»
												  , null
												  , «IF m.futureMessage.get(0).message.get(0).CConstraint !== null»new ClockConstraint("«new ClockConstraintGenerator().compile_clockConstraintName(m.futureMessage.get(0).message.get(0).CConstraint)»"
												  , «new ClockConstraintGenerator().compile_ClockConstraintExpression(m.futureMessage.get(0).message.get(0).CConstraint)»)
												    «ELSE»null«ENDIF»));
				b.addState(newState);
				b.setFinale(newState);
				
				b.addTransition(new BasicTransition(newState
												  , newState
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
	'''
	
}