package hu.bme.mit.dipterv.text.generator

import hu.bme.mit.dipterv.text.minotorDsl.ChangeToRelation
import hu.bme.mit.dipterv.text.minotorDsl.ChangeToMessage

class ChangeToMessages {
	def compile_changeto_required(ChangeToMessage cm)'''
		b = new Automaton("auto3");
		actualState = new State("q" + counter, StateType.NORMAL);
		counter++;
		b.addState(actualState);
		b.setInitial(actualState);
		
		acceptState = new State("q" + counter, StateType.ACCEPT);
		counter++;
		b.addState(acceptState);
		b.addTransition(new Transition("!(" + "changeTo(" + "«cm.context.name»" + "." + "«cm.entity.name»" + "." + "«cm.attribute.name», «cm.changevalue»" + "))", actualState, acceptState));
		
		b.addTransition(new Transition("!(" + "changeTo(" + "«cm.context.name»" + "." + "«cm.entity.name»" + "." + "«cm.attribute.name», «cm.changevalue»" + "))", actualState, actualState));
		newState = new State("q" + counter, StateType.FINAL);
		counter++;
		b.addTransition(new Transition("changeTo(" + "«cm.context.name»" + "." + "«cm.entity.name»" + "." + "«cm.attribute.name», «cm.changevalue»" + ")", actualState, newState));
		b.addState(newState);
		b.setFinale(newState);
	'''
	
	def compile_changetor_required(ChangeToRelation cm)'''
		b = new Automaton("auto3");
		actualState = new State("q" + counter, StateType.NORMAL);
		counter++;
		b.addState(actualState);
		b.setInitial(actualState);
		
		acceptState = new State("q" + counter, StateType.ACCEPT);
		counter++;
		b.addState(acceptState);
		b.addTransition(new Transition("!(" + "changeTo(" + "«cm.context.name»" + "." + "«cm.relation.name»" + "." + "«cm.attribute.name», «cm.changevalue»" + "))", actualState, acceptState));
		
		b.addTransition(new Transition("!(" + "changeTo(" + "«cm.context.name»" + "." + "«cm.relation.name»" + "." + "«cm.attribute.name», «cm.changevalue»" + "))", actualState, actualState));
		newState = new State("q" + counter, StateType.FINAL);
		counter++;
		b.addTransition(new Transition("changeTo(" + "«cm.context.name»" + "." + "«cm.relation.name»" + "." + "«cm.attribute.name», «cm.changevalue»" + ")", actualState, newState));
		b.addState(newState);
		b.setFinale(newState);
	'''
	
	def compile_changeto_fail(ChangeToMessage cm)'''
		b = new Automaton("auto5");
		actualState = new State("q" + counter, StateType.NORMAL);
		counter++;
		b.addState(actualState);
		b.setInitial(actualState);
		
		finalState = new State("q" + counter, StateType.FINAL);
		counter++;
		b.addState(finalState);
		b.setFinale(finalState);
		b.addTransition(new Transition("!(" + "changeTo(" + "«cm.context.name»" + "." + "«cm.entity.name»" + "." + "«cm.attribute.name», «cm.changevalue»" + "))", actualState, finalState));
		
		b.addTransition(new Transition("!(" + "changeTo(" + "«cm.context.name»" + "." + "«cm.entity.name»" + "." + "«cm.attribute.name», «cm.changevalue»" + "))", actualState, actualState));
		newState = new State("q" + counter, StateType.ACCEPT);
		counter++;
		b.addTransition(new Transition("changeTo(" + "«cm.context.name»" + "." + "«cm.entity.name»" + "." + "«cm.attribute.name», «cm.changevalue»" + ")" , actualState, newState));
		b.addState(newState);
	'''
	
	def compile_changetor_fail(ChangeToRelation cm)'''
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
		b.addTransition(new Transition("!(" + "changeTo(" + "«cm.context.name»" + "." + "«cm.relation.name»" + "." + "«cm.attribute.name», «cm.changevalue»" + "))", actualState, finalState));
		
		b.addTransition(new Transition("!(" + "changeTo(" + "«cm.context.name»" + "." + "«cm.relation.name»" + "." + "«cm.attribute.name», «cm.changevalue»" + "))", actualState, actualState));
		newState = new State("q" + counter, StateType.ACCEPT);
		counter++;
		b.addTransition(new Transition("changeTo(" + "«cm.context.name»" + "." + "«cm.relation.name»" + "." + "«cm.attribute.name», «cm.changevalue»" + ")" , actualState, newState));
		b.addState(newState);
	'''
	
	def compile_changeto_msg(ChangeToMessage cm)'''
		b = new Automaton("match1");
		actualState = new State("q" + counter, StateType.NORMAL);
		counter++;
		b.addState(actualState);
		b.setInitial(actualState);
		
		b.addTransition(new Transition("!(" + "changeTo(" + "«cm.context.name»" + "." + "«cm.entity.name»" + "." + "«cm.attribute.name», «cm.changevalue»" + "))", actualState, actualState));
		newState = new State("q" + counter, StateType.FINAL);
		counter++;
		b.addTransition(new Transition("changeTo(" + "«cm.context.name»" + "." + "«cm.entity.name»" + "." + "«cm.attribute.name», «cm.changevalue»" + ")" , actualState, newState));
		b.addState(newState);
		b.setFinale(newState);
	'''
	
	def compile_changetor_msg(ChangeToRelation cm)'''
		b = new Automaton("match1");
		actualState = new State("q" + counter, StateType.NORMAL);
		counter++;
		b.addState(actualState);
		b.setInitial(actualState);
		
		b.addTransition(new Transition("!(" + "changeTo(" + "«cm.context.name»" + "." + "«cm.relation.name»" + "." + "«cm.attribute.name», «cm.changevalue»" + "))", actualState, actualState));
		newState = new State("q" + counter, StateType.FINAL);
		counter++;
		b.addTransition(new Transition("changeTo(" + "«cm.context.name»" + "." + "«cm.relation.name»" + "." + "«cm.attribute.name», «cm.changevalue»" + ")" , actualState, newState));
		b.addState(newState);
		b.setFinale(newState);
	'''
	def compile_changeto_strict_required(ChangeToMessage cm)'''
		b = new Automaton("auto9");
		actualState = new State("q" + counter, StateType.NORMAL);
		counter++;
		b.addState(actualState);
		b.setInitial(actualState);
		
		finalState = new State("q" + counter, StateType.FINAL);
		counter++;
		acceptState = new State("q" + counter, StateType.ACCEPT);
		counter++;
		b.addTransition(new Transition("changeTo(" + "«cm.context.name»" + "." + "«cm.entity.name»" + "." + "«cm.attribute.name», «cm.changevalue»" + ")" , actualState, finalState));
		b.addTransition(new Transition("!(" + "changeTo(" + "«cm.context.name»" + "." + "«cm.entity.name»" + "." + "«cm.attribute.name», «cm.changevalue»" + "))" , actualState, acceptState));
		b.addState(acceptState);
		b.addState(finalState);
		b.setFinale(finalState);
	'''
	
	def compile_changetor_strict_required(ChangeToRelation cm)'''
		b = new Automaton("auto9");
		actualState = new State("q" + counter, StateType.NORMAL);
		counter++;
		b.addState(actualState);
		b.setInitial(actualState);
		
		finalState = new State("q" + counter, StateType.FINAL);
		counter++;
		acceptState = new State("q" + counter, StateType.ACCEPT);
		counter++;
		b.addTransition(new Transition("changeTo(" + "«cm.context.name»" + "." + "«cm.relation.name»" + "." + "«cm.attribute.name», «cm.changevalue»" + ")" , actualState, finalState));
		b.addTransition(new Transition("!(" + "changeTo(" + "«cm.context.name»" + "." + "«cm.relation.name»" + "." + "«cm.attribute.name», «cm.changevalue»" + "))" , actualState, acceptState));
		b.addState(acceptState);
		b.addState(finalState);
		b.setFinale(finalState);
	'''
	
	def compile_changeto_strict_fail(ChangeToMessage cm)'''
		b = new Automaton("auto10");
		actualState = new State("q" + counter, StateType.NORMAL);
		counter++;
		b.addState(actualState);
		b.setInitial(actualState);
		
		finalState = new State("q" + counter, StateType.FINAL);
		counter++;
		acceptState = new State("q" + counter, StateType.ACCEPT);
		counter++;
		b.addTransition(new Transition("!(" + "changeTo(" + "«cm.context.name»" + "." + "«cm.entity.name»" + "." + "«cm.attribute.name», «cm.changevalue»" + "))", actualState, finalState));
		b.addTransition(new Transition("changeTo(" + "«cm.context.name»" + "." + "«cm.entity.name»" + "." + "«cm.attribute.name», «cm.changevalue»" + ")", actualState, acceptState));
		b.addState(finalState);
		b.addState(acceptState);
		b.setFinale(finalState);
	'''
	
	def compile_changetor_strict_fail(ChangeToRelation cm)'''
		b = new Automaton("auto10");
		actualState = new State("q" + counter, StateType.NORMAL);
		counter++;
		b.addState(actualState);
		b.setInitial(actualState);
		
		finalState = new State("q" + counter, StateType.FINAL);
		counter++;
		acceptState = new State("q" + counter, StateType.ACCEPT);
		counter++;
		b.addTransition(new Transition("!(" + "changeTo(" + "«cm.context.name»" + "." + "«cm.relation.name»" + "." + "«cm.attribute.name», «cm.changevalue»" + "))", actualState, finalState));
		b.addTransition(new Transition("changeTo(" + "«cm.context.name»" + "." + "«cm.relation.name»" + "." + "«cm.attribute.name», «cm.changevalue»" + ")", actualState, acceptState));
		b.addState(finalState);
		b.addState(acceptState);
		b.setFinale(finalState);
	'''
	
	def compile_changeto_strict(ChangeToMessage cm)'''
		b = new Automaton("auto12");
		actualState = new State("q" + counter, StateType.NORMAL);
		counter++;
		b.addState(actualState);
		b.setInitial(actualState);
		
		newState = new State("q" + counter, StateType.FINAL);
		counter++;
		b.addTransition(new Transition("changeTo(" + "«cm.context.name»" + "." + "«cm.entity.name»" + "." + "«cm.attribute.name», «cm.changevalue»" + ")", actualState, newState));
		b.addState(newState);
		b.setFinale(newState);
	'''
	
	def compile_changetor_strict(ChangeToRelation cm)'''
		b = new Automaton("auto12");
		actualState = new State("q" + counter, StateType.NORMAL);
		counter++;
		b.addState(actualState);
		b.setInitial(actualState);
		
		newState = new State("q" + counter, StateType.FINAL);
		counter++;
		b.addTransition(new Transition("changeTo(" + "«cm.context.name»" + "." + "«cm.relation.name»" + "." + "«cm.attribute.name», «cm.changevalue»" + ")", actualState, newState));
		b.addState(newState);
		b.setFinale(newState);
	'''
}