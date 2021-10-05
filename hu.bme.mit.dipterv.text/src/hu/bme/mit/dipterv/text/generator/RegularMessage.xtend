package hu.bme.mit.dipterv.text.generator

import hu.bme.mit.dipterv.text.minotorDsl.FutureMessage
import hu.bme.mit.dipterv.text.minotorDsl.StrictFutureMessage

class RegularMessage {	
	def compile_future(FutureMessage m)'''
		b = new Automaton("auto6");
		actualState = new State("q" + counter, StateType.NORMAL);
		counter++;
		b.addState(actualState);
		b.setInitial(actualState);
											
		b.addTransition(new BasicTransition(actualState
										  , actualState
										  , null
										  , "!(" + «new LabelGenerator().compile_messageLabel(m)» + ")"
										  , null
										  , null));
						
		newState = new State("q" + counter, StateType.NORMAL);
		counter++;
		b.addTransition(new BasicTransition(actualState
										  , newState
										  , null
										  , «new LabelGenerator().compile_messageLabel(m)»
										  , null
										  , null));
		b.addState(newState);
		
		b.addTransition(new BasicTransition(newState
										  , actualState
										  , null
										  , null
										  , new WantedConstraint(new ArrayList<String>() {
										  	{
										  	«FOR cm : m.c.messages»add(«new LabelGenerator().compile_messageLabel(m)»);«ENDFOR»
										  	}}, null)
									  	  , null
										  , null));
		
		finalState = new State("q" + counter, StateType.FINAL);
		counter++;
		b.addTransition(new BasicTransition(newState
										  , finalState
										  , null
										  , null
										  , new UnwantedConstraint(new ArrayList<String>() {
										  	{
										  	«FOR cm : m.c.messages»add(«new LabelGenerator().compile_messageLabel(m)»);«ENDFOR»
										  	}}, null)
									  	  , null
										  , null));
		b.addState(finalState);
		b.setFinale(finalState);
	'''
	
	def compile_strict_future(StrictFutureMessage m)'''
		b = new Automaton("auto11");
		actualState = new State("q" + counter, StateType.NORMAL);
		counter++;
		b.addState(actualState);
		b.setInitial(actualState);
						
		newState = new State("q" + counter, StateType.NORMAL);
		counter++;
		b.addTransition(new BasicTransition(actualState
										  , newState
										  , null
										  , «new LabelGenerator().compile_messageLabel(m)»
										  , null
										  , null));
		b.addState(newState);
		
		b.addTransition(new BasicTransition(newState
										  , actualState
										  , null
										  , null
										  , new WantedConstraint(new ArrayList<String>() {
										  	{
										  	«FOR cm : m.futureMessage.get(0).c.messages»add(«new LabelGenerator().compile_messageLabel(m)»);«ENDFOR»
										  	}}, null)
									  	  , null
										  , null));
		
		finalState = new State("q" + counter, StateType.FINAL);
		counter++;
		b.addTransition(new BasicTransition(newState
										  , finalState
										  , null
										  , null
										  , new UnwantedConstraint(new ArrayList<String>() {
										  	{
										  	«FOR cm : m.futureMessage.get(0).c.messages»add(«new LabelGenerator().compile_messageLabel(m)»);«ENDFOR»
										  	}}, null)
									  	  , null
										  , null));
		b.addState(finalState);
		b.setFinale(finalState);
	'''
}