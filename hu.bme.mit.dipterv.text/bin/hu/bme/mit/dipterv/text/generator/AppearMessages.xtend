package hu.bme.mit.dipterv.text.generator

import hu.bme.mit.dipterv.text.minotorDsl.AppearMessage

class AppearMessages {
	def compile_appear_required(AppearMessage am)'''
		b = new Automaton("auto3");
		actualState = new State("q" + counter, StateType.NORMAL);
		counter++;
		b.addState(actualState);
		b.setInitial(actualState);
		acceptState = new State("q" + counter, StateType.ACCEPT);
		b.addState(acceptState);
		b.addTransition(new Transition("!(" + "appear(" + "«am.context.name»" + "." + "«am.entity.name»" + "))", actualState, acceptState));
		
		
		b.addTransition(new Transition("!(" + "appear(" + "«am.context.name»" + "." + "«am.entity.name»" + "))", actualState, actualState));
		newState = new State("q" + counter, StateType.FINAL);
		counter++;
		b.addTransition(new Transition("appear(" + "«am.context.name»" + "." + "«am.entity.name»" + ")", actualState, newState));
		b.addState(newState);
		b.setFinale(newState);
	'''
	
	def compile_appear_fail(AppearMessage am)'''
		b = new Automaton("auto5");
		actualState = new State("q" + counter, StateType.NORMAL);
		counter++;
		b.addState(actualState);
		b.setInitial(actualState);
		
		finalState = new State("q" + counter, StateType.FINAL);
		b.addState(finalState);
		b.setFinale(finalState);
		b.addTransition(new Transition("!(" + "appear(" + "«am.context.name»" + "." + "«am.entity.name»" + "))", actualState, finalState));
											
		b.addTransition(new Transition("!(" + "appear(" + "«am.context.name»" + "." + "«am.entity.name»" + "))", actualState, actualState));
		newState = new State("q" + counter, StateType.ACCEPT);
		counter++;
		b.addTransition(new Transition("appear(" + "«am.context.name»" + "." + "«am.entity.name»" + ")" , actualState, newState));
		b.addState(newState);
	'''
	
	def compile_appear_msg(AppearMessage am)'''
		b = new Automaton("match1");
		actualState = new State("q" + counter, StateType.NORMAL);
		counter++;
		b.addState(actualState);
		b.setInitial(actualState);
											
		b.addTransition(new Transition("!(" + "appear(" + "«am.context.name»" + "." + "«am.entity.name»" + "))", actualState, actualState));
		newState = new State("q" + counter, StateType.FINAL);
		counter++;
		b.addTransition(new Transition("appear(" + "«am.context.name»" + "." + "«am.entity.name»" + ")" , actualState, newState));
		b.addState(newState);
		b.setFinale(newState);
	'''
	
	def compile_appear_strict_required(AppearMessage am)'''
		b = new Automaton("auto9");
		actualState = new State("q" + counter, StateType.NORMAL);
		counter++;
		b.addState(actualState);
		b.setInitial(actualState);
											
		finalState = new State("q" + counter, StateType.FINAL);
		counter++;
		acceptState = new State("q" + counter, StateType.ACCEPT);
		counter++;
		b.addTransition(new Transition("appear(" + "«am.context.name»" + "." + "«am.entity.name»" + ")" , actualState, finalState));
		b.addTransition(new Transition("!(" + "appear(" + "«am.context.name»" + "." + "«am.entity.name»" + "))" , actualState, acceptState));
		b.addState(acceptState);
		b.addState(finalState);
		b.setFinale(finalState);
	'''
	
	def compile_appear_strict_fail(AppearMessage am)'''
		b = new Automaton("auto10");
		actualState = new State("q" + counter, StateType.NORMAL);
		counter++;
		b.addState(actualState);
		b.setInitial(actualState);
											
		finalState = new State("q" + counter, StateType.FINAL);
		counter++;
		acceptState = new State("q" + counter, StateType.ACCEPT);
		counter++;
		b.addTransition(new Transition("!(" + "appear(" + "«am.context.name»" + "." + "«am.entity.name»" + "))", actualState, finalState));
		b.addTransition(new Transition("appear(" + "«am.context.name»" + "." + "«am.entity.name»" + ")", actualState, acceptState));
		b.addState(finalState);
		b.addState(acceptState);
		b.setFinale(finalState);
	'''
	
	def compile_appear_strict(AppearMessage am)'''
		b = new Automaton("auto12");
		actualState = new State("q" + counter, StateType.NORMAL);
		counter++;
		b.addState(actualState);
		b.setInitial(actualState);
												
		newState = new State("q" + counter, StateType.FINAL);
		counter++;
		b.addTransition(new Transition("appear" + "(" + "«am.context.name»" + "." + "«am.entity.name»" + ")", actualState, newState));
		b.addState(newState);
		b.setFinale(newState);
	'''
}