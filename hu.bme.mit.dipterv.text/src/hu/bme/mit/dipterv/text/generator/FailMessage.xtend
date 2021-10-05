package hu.bme.mit.dipterv.text.generator

import hu.bme.mit.dipterv.text.minotorDsl.FailStrictMessage
import hu.bme.mit.dipterv.text.minotorDsl.FailPastMessage

class FailMessage {
	
	def compile_fail(hu.bme.mit.dipterv.text.minotorDsl.FailMessage m)'''
		b = new Automaton("auto4");
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
		
		finalState = new State("q" + counter, StateType.FINAL);
		counter++;
		
		b.addTransition(new BasicTransition(actualState
										  , finalState
										  , null
										  , "!(" + «new LabelGenerator().compile_messageLabel(m)» + ")"
										  , null
										  , null));
		
		acceptState = new State("q" + counter, StateType.ACCEPT);
		counter++;
		
		b.addTransition(new BasicTransition(actualState
										  , acceptState
										  , null
										  , «new LabelGenerator().compile_messageLabel(m)»
										  , null
										  , null));
		
		b.addState(acceptState);
		b.addState(finalState);
		b.setFinale(finalState);
	'''
	
	def compile_strict_fail(FailStrictMessage m)'''
		b = new Automaton("auto5");
		actualState = new State("q" + counter, StateType.NORMAL);
		counter++;
		b.addState(actualState);
		b.setInitial(actualState);
		
		finalState = new State("q" + counter, StateType.FINAL);
		counter++;
		
		b.addTransition(new BasicTransition(actualState
										  , finalState
										  , null
										  , "!(" + «new LabelGenerator().compile_messageLabel(m)» + ")"
										  , null
										  , null));
		
		acceptState = new State("q" + counter, StateType.ACCEPT);
		counter++;
		
		b.addTransition(new BasicTransition(actualState
										  , acceptState
										  , null
										  , «new LabelGenerator().compile_messageLabel(m)»
										  , null
										  , null));
		
		b.addState(acceptState);
		b.addState(finalState);
		b.setFinale(finalState);
	'''
	
	def compile_fail_past(FailPastMessage m)'''
		b = new Automaton("auto10");
		actualState = new State("q" + counter, StateType.NORMAL);
		counter++;
		b.addState(actualState);
		b.setInitial(actualState);
		
		b.addTransition(new BasicTransition(actualState
										  , actualState
										  , null
										  , "!(" + «new LabelGenerator().compile_messageLabel(m)» + ")"
										  , new Constraint(new ArrayList<String>() {
										  	{
										  	«FOR cm : m.pastMessage.get(0).c.messages»add(«new LabelGenerator().compile_messageLabel(m)»);«ENDFOR»
										  	}}, null)
									  	  , null
										  , null));
		
		finalState = new State("q" + counter, StateType.FINAL);
		counter++;
		
		b.addTransition(new BasicTransition(actualState
										  , finalState
										  , null
										  , "!(" + «new LabelGenerator().compile_messageLabel(m)» + ")"
										  , null
										  , null));
		
		acceptState = new State("q" + counter, StateType.ACCEPT);
		counter++;
		
		b.addTransition(new BasicTransition(actualState
										  , acceptState
										  , null
										  , «new LabelGenerator().compile_messageLabel(m)»
										  , null
										  , null));
		
		b.addState(acceptState);
		b.addState(finalState);
		b.setFinale(finalState);
	'''
}