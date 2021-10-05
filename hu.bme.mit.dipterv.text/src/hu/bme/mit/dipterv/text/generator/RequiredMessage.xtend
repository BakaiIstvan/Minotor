package hu.bme.mit.dipterv.text.generator

import hu.bme.mit.dipterv.text.minotorDsl.RequiredLooseMessage
import hu.bme.mit.dipterv.text.minotorDsl.RequiredStrictMessage
import hu.bme.mit.dipterv.text.minotorDsl.RequiredPastMessage
import hu.bme.mit.dipterv.text.minotorDsl.RequiredFutureMessage
import hu.bme.mit.dipterv.text.minotorDsl.RequiredStrictFutureMessage

class RequiredMessage {
	def compile_required_future(RequiredFutureMessage m)'''
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
										  , null
										  , «new LabelGenerator().compile_messageLabel(m)»
										  , null
										  , null));
										  
		b.addTransition(new BasicTransition(actualState
										  , actualState
										  , null
										  , "!(" + «new LabelGenerator().compile_messageLabel(m)» + ")"
										  , null
										  , null));
										    
		b.addTransition(new BasicTransition(actualState
										  , acceptState
										  , null
										  , "!(" + «new LabelGenerator().compile_messageLabel(m)» + ")"
										  , null
										  , null));
										  	
		b.addTransition(new BasicTransition(finalState
										  , finalState
										  , null
										  , null
										  , new UnwantedConstraint(new ArrayList<String>() {
										  	{
										  	«FOR cm : m.futureMessage.get(0).c.messages»add(«new LabelGenerator().compile_messageLabel(m)»);«ENDFOR»
										  	}}, null
										  	  , null)
										  , null));
										  
		b.addTransition(new BasicTransition(finalState
										  , acceptState_new
										  , null
										  , null
										  , new WantedConstraint(new ArrayList<String>() {
  										  	{
  										  	«FOR cm : m.futureMessage.get(0).c.messages»add(«new LabelGenerator().compile_messageLabel(m)»);«ENDFOR»
  										  	}}, null
  										  	  , null)
										  , null));
		
	'''
	
	def compile_required_past(RequiredPastMessage m)'''
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
										  , null
										  , «new LabelGenerator().compile_messageLabel(m)»
										  , null
										  , null));
		
		b.addTransition(new BasicTransition(actualState
										  , actualState
										  , null
										  , "!(" + «new LabelGenerator().compile_messageLabel(m)» + ")"
										  , new UnwantedConstraint(new ArrayList<String>() {
  										  	{
  										  	«FOR cm : m.pastMessage.get(0).c.messages»add(«new LabelGenerator().compile_messageLabel(m)»);«ENDFOR»
  										  	}}, null
  										  	  , null)
										  , null));
										  
		b.addTransition(new BasicTransition(actualState
										  , acceptState
										  , null
										  , "!(" + «new LabelGenerator().compile_messageLabel(m)» + ")"
										  , null
										  , null));
										  
		b.addTransition(new BasicTransition(actualState
										  , acceptState
										  , null
										  , null
										  , new WantedConstraint(new ArrayList<String>() {
  										  	{
  										  	«FOR cm : m.pastMessage.get(0).c.messages»add(«new LabelGenerator().compile_messageLabel(m)»);«ENDFOR»
  										  	}}, null
  										  	  , null)
										  , null));
										
		b.addState(newState);
		b.setFinale(newState);
	'''
	
	def compile_required(RequiredLooseMessage m)'''
		b = new Automaton("auto3");
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
										  , null
										  , «new LabelGenerator().compile_messageLabel(m)»
										  , null
										  , null));
										  
		b.addTransition(new BasicTransition(actualState
										  , actualState
										  , null
										  , "!(" + «new LabelGenerator().compile_messageLabel(m)» + ")"
										  , null
										  , null));
										  
		b.addTransition(new BasicTransition(actualState
										  , acceptState
										  , null
										  , "!(" + «new LabelGenerator().compile_messageLabel(m)» + ")"
										  , null
										  , null));
										
		b.addState(newState);
		b.setFinale(newState);
	'''
	
	def compile_strict_required_future(RequiredStrictFutureMessage m)'''
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
		
		b.addState(acceptState);
		b.addState(acceptState_new);
		b.addState(finalState);
		b.setFinale(finalState);
										  	
		b.addTransition(new BasicTransition(actualState
										  , finalState
										  , null
										  , «new LabelGenerator().compile_messageLabel(m)»
										  , null
										  , null));
										  
		b.addTransition(new BasicTransition(actualState
										  , acceptState
										  , null
										  , "!(" + «new LabelGenerator().compile_messageLabel(m)» + ")"
										  , null
										  , null));
										  	
		b.addTransition(new BasicTransition(finalState
										  , finalState
										  , null
										  , null
										  , new UnwantedConstraint(new ArrayList<String>() {
										  	{
										  	«FOR cm : m.strictFutureMessage.get(0).futureMessage.get(0).c.messages»add(«new LabelGenerator().compile_messageLabel(m)»);«ENDFOR»
										  	}}, null
										  	  , null)
										  , null));
										  
		b.addTransition(new BasicTransition(finalState
										  , acceptState_new
										  , null
										  , null
										  , new WantedConstraint(new ArrayList<String>() {
  										  	{
  										  	«FOR cm : m.strictFutureMessage.get(0).futureMessage.get(0).c.messages»add(«new LabelGenerator().compile_messageLabel(m)»);«ENDFOR»
  										  	}}, null
  										  	  , null)
										  , null));
	'''
	
	def compile_strict_required(RequiredStrictMessage m)'''
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
										  , null
										  , «new LabelGenerator().compile_messageLabel(m)»
										  , null
										  , null));
										  
		b.addTransition(new BasicTransition(actualState
										  , acceptState
										  , null
										  , "!(" + «new LabelGenerator().compile_messageLabel(m)» + ")"
										  , null
										  , null));
										
		b.addState(newState);
		b.setFinale(newState);
	'''
}