package hu.bme.mit.dipterv.text.generator

import hu.bme.mit.dipterv.text.minotorDsl.MatchMessage

class MatchMessages {
	def compile_match_required(MatchMessage ma)'''
		b = new Automaton("auto3");
		actualState = new State("q" + counter, StateType.NORMAL);
		counter++;
		b.addState(actualState);
		b.setInitial(actualState);
		
		acceptState = new State("q" + counter, StateType.ACCEPT);
		counter++;
		b.addState(acceptState);
		b.addTransition(new Transition("!(" + "match(" + "«ma.context.name»" + ", " + "«ma.content.name»" + "))", actualState, acceptState));
		
		b.addTransition(new Transition("!(" + "match(" + "«ma.context.name»" + ", " + "«ma.content.name»" + "))", actualState, actualState));
		newState = new State("q" + counter, StateType.FINAL);
		counter++;
		b.addTransition(new Transition("match(" + "«ma.context.name»" + ", " + "«ma.content.name»" + ")", actualState, newState));
		b.addState(newState);
		b.setFinale(newState);
	'''
	
	def compile_match_fail(MatchMessage ma)'''
		b = new Automaton("auto5");
		actualState = new State("q" + counter, StateType.NORMAL);
		counter++;
		b.addState(actualState);
		b.setInitial(actualState);
		b.setFinale(actualState);
		
		finalState = new State("q" + counter, StateType.FINAL);
		counter++;
		b.addState(finalState);
		b.setFinale(finalState);
		b.addTransition(new Transition("!(" + "match(" + "«ma.context.name»" + ", " + "«ma.content.name»" + "))", actualState, finalState));
											
		b.addTransition(new Transition("!(" + "match(" + "«ma.context.name»" + ", " + "«ma.content.name»" + "))", actualState, actualState));
		newState = new State("q" + counter, StateType.ACCEPT);
		counter++;
		b.addTransition(new Transition("match(" + "«ma.context.name»" + ", " + "«ma.content.name»" + ")" , actualState, newState));
		b.addState(newState);
	'''
	
	def compile_match_msg(MatchMessage ma)'''
		b = new Automaton("match1");
		actualState = new State("q" + counter, StateType.NORMAL);
		counter++;
		b.addState(actualState);
		b.setInitial(actualState);
											
		b.addTransition(new Transition("!(" + "match(" + "«ma.context.name»" + ", " + "«ma.content.name»" + "))", actualState, actualState));
		newState = new State("q" + counter, StateType.FINAL);
		counter++;
		b.addTransition(new Transition("match(" + "«ma.context.name»" + ", " + "«ma.content.name»" + ")" , actualState, newState));
		b.addState(newState);
		b.setFinale(newState);
	'''
	
	def compile_match_strict_required(MatchMessage ma)'''
		b = new Automaton("auto9");
		actualState = new State("q" + counter, StateType.NORMAL);
		counter++;
		b.addState(actualState);
		b.setInitial(actualState);
											
		finalState = new State("q" + counter, StateType.FINAL);
		counter++;
		acceptState = new State("q" + counter, StateType.ACCEPT);
		counter++;
		b.addTransition(new Transition("match(" + "«ma.context.name»" + ", " + "«ma.content.name»" + ")" , actualState, finalState));
		b.addTransition(new Transition("!(" + "match(" + "«ma.context.name»" + ", " + "«ma.content.name»" + "))" , actualState, acceptState));
		b.addState(acceptState);
		b.addState(finalState);
		b.setFinale(finalState);
	'''
	
	def compile_match_strict_fail(MatchMessage ma)'''
		b = new Automaton("auto10");
		actualState = new State("q" + counter, StateType.NORMAL);
		counter++;
		b.addState(actualState);
		b.setInitial(actualState);
											
		finalState = new State("q" + counter, StateType.FINAL);
		counter++;
		acceptState = new State("q" + counter, StateType.ACCEPT);
		counter++;
		b.addTransition(new Transition("!(" + "match(" + "«ma.context.name»" + ", " + "«ma.content.name»" + "))", actualState, finalState));
		b.addTransition(new Transition("match(" + "«ma.context.name»" + ", " + "«ma.content.name»" + ")", actualState, acceptState));
		b.addState(finalState);
		b.addState(acceptState);
		b.setFinale(finalState);
	'''
	
	def compile_match_strict(MatchMessage ma)'''
		b = new Automaton("auto12");
		actualState = new State("q" + counter, StateType.NORMAL);
		counter++;
		b.addState(actualState);
		b.setInitial(actualState);
												
		newState = new State("q" + counter, StateType.FINAL);
		counter++;
		b.addTransition(new Transition("match(" + "«ma.context.name»" + ", " + "«ma.content.name»" + ")", actualState, newState));
		b.addState(newState);
		b.setFinale(newState);
	'''
}