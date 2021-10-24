package hu.bme.mit.dipterv.text.generator

import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import hu.bme.mit.dipterv.text.minotorDsl.Domain
import hu.bme.mit.dipterv.text.minotorDsl.Message
import hu.bme.mit.dipterv.text.minotorDsl.LooseMessage
import hu.bme.mit.dipterv.text.minotorDsl.StrictMessage
import hu.bme.mit.dipterv.text.minotorDsl.FailMessage
import hu.bme.mit.dipterv.text.minotorDsl.FailPastMessage
import hu.bme.mit.dipterv.text.minotorDsl.FailStrictMessage
import hu.bme.mit.dipterv.text.minotorDsl.RequiredStrictFutureMessage
import hu.bme.mit.dipterv.text.minotorDsl.RequiredPastMessage
import hu.bme.mit.dipterv.text.minotorDsl.RequiredFutureMessage
import hu.bme.mit.dipterv.text.minotorDsl.RequiredStrictMessage
import hu.bme.mit.dipterv.text.minotorDsl.RequiredLooseMessage
import hu.bme.mit.dipterv.text.minotorDsl.StrictFutureMessage
import hu.bme.mit.dipterv.text.minotorDsl.FutureMessage
import hu.bme.mit.dipterv.text.minotorDsl.PastMessage
import hu.bme.mit.dipterv.text.minotorDsl.ScenarioContent
import hu.bme.mit.dipterv.text.minotorDsl.Loop
import hu.bme.mit.dipterv.text.minotorDsl.Alt
import hu.bme.mit.dipterv.text.minotorDsl.Par

class DiagramGenerator extends AbstractGenerator {
	int transitionCounter = -1;
	int altCounter = -1;
	int parCounter = -1;
	int loopCounter = -1;
	
	override doGenerate(Resource input, IFileSystemAccess2 fsa, IGeneratorContext context) {
		for(s : input.allContents.toIterable.filter(Domain)){
			fsa.generateFile("Scenario.minotor", s.compile)
		}
	}
	
	def compile(Domain s)'''
		<?xml version="1.0" encoding="UTF-8"?>
		<minotor:SequenceDiagram xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:minotor="hu.bme.mit.mdsd.xboyz.erdiagram" Name="«s.name»">
		
		«FOR object: s.objects»
		<lifelines Name="«object.name»" Type="«object.object.get(0).name»"/>
		«ENDFOR»

		«FOR constraint: s.constraints»
		<constraints Name="«constraint.name»">
			«FOR message: constraint.messages»
	    	<transitions Name="«new LabelGenerator().compile_message_xml(message)»" source="//@lifelines.«compile_message_source(message, s)»" target="//@lifelines.«compile_message_target(message, s)»"/>
	    	«ENDFOR»
		</constraints>
		«ENDFOR»
		
		«FOR scenarioContent: s.scenarios.get(0).scenariocontents»
		«FOR l : scenarioContent.loop»
		«l.compile_loop»
		«FOR loopMessage : l.messages»
		<transitions «compile_message(loopMessage, s)»  loop="//@loops.«loopCounter»"/>
		«ENDFOR»
		«ENDFOR»

		«FOR par : scenarioContent.par»
		«par.compile_par»
		«FOR parExpression : 0..<par.parexpression.size»
		«FOR parMessage : par.parexpression.get(parExpression).messages»
		<transitions «compile_message(parMessage, s)»  parpartition="//@pars.«parCounter»/@parpartition.«parExpression»"/>
		«ENDFOR»
		«ENDFOR»
		«ENDFOR»

		«FOR alt : scenarioContent.alt»
		«alt.compile_alt»
		«FOR altExpression : 0..<alt.expressions.size»
		«FOR altMessage : alt.expressions.get(altExpression).messages»
		<transitions «compile_message(altMessage, s)»  altpartition="//@alts.«altCounter»/@altpartition.«altExpression»"/>
		«ENDFOR»
		«ENDFOR»
		«ENDFOR»

		«FOR m : scenarioContent.message»
		<transitions «compile_message(m, s)»/>
		«ENDFOR»
		«ENDFOR»

		</minotor:SequenceDiagram>
	'''
	
	def compile_loop(Loop l) {
		loopCounter++
		'''<loops Name="«l.toString()»" Min="«l.min»" Max="«l.max»"/>'''
	}
	
	def compile_par(Par par) {
		parCounter++
		'''<pars Name="«par.toString()»">
	    	«FOR parexpression : par.parexpression»
        	<parpartition Name="«parexpression.name»"/>
        	«ENDFOR»
		</pars>
		'''
	}
	
	def compile_alt(Alt alt) {
		altCounter++
		'''<alts Name="«alt.toString()»">
			«FOR altexpression : alt.expressions»
	    	<altpartition Name="«new MinotorDslGenerator().compile_alt_condition_name(altexpression.altCondition)»"/>
	    	«ENDFOR»
	    </alts>
	    '''
	}
	
	def compile_message(Message m, Domain domain) {
		transitionCounter++
		'''«generateMessage(m, domain)»'''
	}
	
	def dispatch generateMessage(LooseMessage m, Domain domain)
	'''Name="«new LabelGenerator().compile_message_xml(m)»" Type="REGULAR" Label="e: «new LabelGenerator().compile_message_xml(m)»" source="//@lifelines.«compile_message_source(m, domain)»" target="//@lifelines.«compile_message_target(m, domain)»" «IF transitionCounter > 0»before="//@transitions.«transitionCounter - 1»"«ENDIF» «IF transitionCounter < domain.scenarios.get(0).scenariocontents.size() - 1»after="//@transitions.«transitionCounter + 1»"«ENDIF» «IF m.resetclock !== null»reset="«m.resetclock.clock.name»"«ENDIF» «IF m.CConstraint !== null»clockConstraint="«new ClockConstraintGenerator().compile_clockConstraintExpressionXML(m.CConstraint)»"«ENDIF»'''
	
	def dispatch generateMessage(StrictMessage m, Domain domain)
	'''Name="«new LabelGenerator().compile_message_xml(m)»" Type="REGULAR" Label="e: «new LabelGenerator().compile_message_xml(m)»" isStrict="true" source="//@lifelines.«compile_message_source(m, domain)»" target="//@lifelines.«compile_message_target(m, domain)»" «IF transitionCounter > 0»before="//@transitions.«transitionCounter - 1»"«ENDIF» «IF transitionCounter < domain.scenarios.get(0).scenariocontents.size() - 1»after="//@transitions.«transitionCounter + 1»"«ENDIF» «IF m.message.get(0).resetclock !== null»reset="«m.message.get(0).resetclock.clock.name»"«ENDIF» «IF m.message.get(0).CConstraint !== null»clockConstraint="«new ClockConstraintGenerator().compile_clockConstraintExpressionXML(m.message.get(0).CConstraint)»"«ENDIF»'''
	
	def dispatch generateMessage(PastMessage m, Domain domain)
	'''Name="«new LabelGenerator().compile_message_xml(m)»" Type="REGULAR" Label="e: «new LabelGenerator().compile_message_xml(m)»" source="//@lifelines.«compile_message_source(m, domain)»" target="//@lifelines.«compile_message_target(m, domain)»" «IF transitionCounter > 0»before="//@transitions.«transitionCounter - 1»"«ENDIF» «IF transitionCounter < domain.scenarios.get(0).scenariocontents.size() - 1»after="//@transitions.«transitionCounter + 1»"«ENDIF» constraint="//@constraints.«domain.constraints.indexOf(m.c)»" constraintType="PAST" «IF m.constraintexp != null»clockOnConstraint="«new ClockConstraintGenerator().compile_clockConstraintExpressionXML(m.constraintexp)»"«ENDIF» «IF m.resetinconstraint != null»resetOnConstraint="«m.resetinconstraint.clock.name»"«ENDIF» «IF m.message.get(0).resetclock !== null»reset="«m.message.get(0).resetclock.clock.name»"«ENDIF» «IF m.message.get(0).CConstraint !== null»clockConstraint="«new ClockConstraintGenerator().compile_clockConstraintExpressionXML(m.message.get(0).CConstraint)»"«ENDIF»'''
	
	def dispatch generateMessage(FutureMessage m, Domain domain)
	'''Name="«new LabelGenerator().compile_message_xml(m)»" Type="REGULAR" Label="e: «new LabelGenerator().compile_message_xml(m)»" source="//@lifelines.«compile_message_source(m, domain)»" target="//@lifelines.«compile_message_target(m, domain)»" «IF transitionCounter > 0»before="//@transitions.«transitionCounter - 1»"«ENDIF» «IF transitionCounter < domain.scenarios.get(0).scenariocontents.size() - 1»after="//@transitions.«transitionCounter + 1»"«ENDIF» constraint="//@constraints.«domain.constraints.indexOf(m.c)»" constraintType="FUTURE" «IF m.constraintexp != null»clockOnConstraint="«new ClockConstraintGenerator().compile_clockConstraintExpressionXML(m.constraintexp)»"«ENDIF» «IF m.resetinconstraint != null»resetOnConstraint="«m.resetinconstraint.clock.name»"«ENDIF» «IF m.message.get(0).resetclock !== null»reset="«m.message.get(0).resetclock.clock.name»"«ENDIF» «IF m.message.get(0).CConstraint !== null»clockConstraint="«new ClockConstraintGenerator().compile_clockConstraintExpressionXML(m.message.get(0).CConstraint)»"«ENDIF»'''
	
	def dispatch generateMessage(StrictFutureMessage m, Domain domain)
	'''Name="«new LabelGenerator().compile_message_xml(m)»" Type="REGULAR" Label="e: «new LabelGenerator().compile_message_xml(m)»" isStrict="true" source="//@lifelines.«compile_message_source(m, domain)»" target="//@lifelines.«compile_message_target(m, domain)»" «IF transitionCounter > 0»before="//@transitions.«transitionCounter - 1»"«ENDIF» «IF transitionCounter < domain.scenarios.get(0).scenariocontents.size() - 1»after="//@transitions.«transitionCounter + 1»"«ENDIF» constraint="//@constraints.«domain.constraints.indexOf(m.futureMessage.get(0).c)»" constraintType="FUTURE" «IF m.futureMessage.get(0).constraintexp != null»clockOnConstraint="«new ClockConstraintGenerator().compile_clockConstraintExpressionXML(m.futureMessage.get(0).constraintexp)»"«ENDIF» «IF m.futureMessage.get(0).resetinconstraint != null»resetOnConstraint="«m.futureMessage.get(0).resetinconstraint.clock.name»"«ENDIF» «IF m.futureMessage.get(0).message.get(0).resetclock !== null»reset="«m.futureMessage.get(0).message.get(0).resetclock.clock.name»"«ENDIF» «IF m.futureMessage.get(0).message.get(0).CConstraint !== null»clockConstraint="«new ClockConstraintGenerator().compile_clockConstraintExpressionXML(m.futureMessage.get(0).message.get(0).CConstraint)»"«ENDIF»'''
	
	def dispatch generateMessage(RequiredLooseMessage m, Domain domain)
	'''Name="«new LabelGenerator().compile_message_xml(m)»" Type="REQUIRED" Label="r: «new LabelGenerator().compile_message_xml(m)»" source="//@lifelines.«compile_message_source(m, domain)»" target="//@lifelines.«compile_message_target(m, domain)»" «IF transitionCounter > 0»before="//@transitions.«transitionCounter - 1»"«ENDIF» «IF transitionCounter < domain.scenarios.get(0).scenariocontents.size() - 1»after="//@transitions.«transitionCounter + 1»"«ENDIF» «IF m.message.get(0).resetclock !== null»reset="«m.message.get(0).resetclock.clock.name»"«ENDIF» «IF m.message.get(0).CConstraint !== null»clockConstraint="«new ClockConstraintGenerator().compile_clockConstraintExpressionXML(m.message.get(0).CConstraint)»"«ENDIF»'''
	
	def dispatch generateMessage(RequiredStrictMessage m, Domain domain)
	'''Name="«new LabelGenerator().compile_message_xml(m)»" Type="REQUIRED" Label="r: «new LabelGenerator().compile_message_xml(m)»" isStrict="true" source="//@lifelines.«compile_message_source(m, domain)»" target="//@lifelines.«compile_message_target(m, domain)»" «IF transitionCounter > 0»before="//@transitions.«transitionCounter - 1»"«ENDIF» «IF transitionCounter < domain.scenarios.get(0).scenariocontents.size() - 1»after="//@transitions.«transitionCounter + 1»"«ENDIF» «IF m.strictMessage.get(0).message.get(0).resetclock !== null»reset="«m.strictMessage.get(0).message.get(0).resetclock.clock.name»"«ENDIF» «IF m.strictMessage.get(0).message.get(0).CConstraint !== null»clockConstraint="«new ClockConstraintGenerator().compile_clockConstraintExpressionXML(m.strictMessage.get(0).message.get(0).CConstraint)»"«ENDIF»'''
	
	def dispatch generateMessage(RequiredPastMessage m, Domain domain)
	'''Name="«new LabelGenerator().compile_message_xml(m)»" Type="REQUIRED" Label="r: «new LabelGenerator().compile_message_xml(m)»" source="//@lifelines.«compile_message_source(m, domain)»" target="//@lifelines.«compile_message_target(m, domain)»" «IF transitionCounter > 0»before="//@transitions.«transitionCounter - 1»"«ENDIF» «IF transitionCounter < domain.scenarios.get(0).scenariocontents.size() - 1»after="//@transitions.«transitionCounter + 1»"«ENDIF» constraint="//@constraints.«domain.constraints.indexOf(m.pastMessage.get(0).c)»" constraintType="PAST" «IF m.pastMessage.get(0).constraintexp != null»clockOnConstraint="«new ClockConstraintGenerator().compile_clockConstraintExpressionXML(m.pastMessage.get(0).constraintexp)»"«ENDIF» «IF m.pastMessage.get(0).resetinconstraint != null»resetOnConstraint="«m.pastMessage.get(0).resetinconstraint.clock.name»"«ENDIF» «IF m.pastMessage.get(0).message.get(0).resetclock !== null»reset="«m.pastMessage.get(0).message.get(0).resetclock.clock.name»"«ENDIF» «IF m.pastMessage.get(0).message.get(0).CConstraint !== null»clockConstraint="«new ClockConstraintGenerator().compile_clockConstraintExpressionXML(m.pastMessage.get(0).message.get(0).CConstraint)»"«ENDIF»'''
	
	def dispatch generateMessage(RequiredFutureMessage m, Domain domain)
	'''Name="«new LabelGenerator().compile_message_xml(m)»" Type="REQUIRED" Label="r: «new LabelGenerator().compile_message_xml(m)»" source="//@lifelines.«compile_message_source(m, domain)»" target="//@lifelines.«compile_message_target(m, domain)»" «IF transitionCounter > 0»before="//@transitions.«transitionCounter - 1»"«ENDIF» «IF transitionCounter < domain.scenarios.get(0).scenariocontents.size() - 1»after="//@transitions.«transitionCounter + 1»"«ENDIF» constraint="//@constraints.«domain.constraints.indexOf(m.futureMessage.get(0).c)»" constraintType="FUTURE" «IF m.futureMessage.get(0).constraintexp != null»clockOnConstraint="«new ClockConstraintGenerator().compile_clockConstraintExpressionXML(m.futureMessage.get(0).constraintexp)»"«ENDIF» «IF m.futureMessage.get(0).resetinconstraint != null»resetOnConstraint="«m.futureMessage.get(0).resetinconstraint.clock.name»"«ENDIF» «IF m.futureMessage.get(0).message.get(0).resetclock !== null»reset="«m.futureMessage.get(0).message.get(0).resetclock.clock.name»"«ENDIF» «IF m.futureMessage.get(0).message.get(0).CConstraint !== null»clockConstraint="«new ClockConstraintGenerator().compile_clockConstraintExpressionXML(m.futureMessage.get(0).message.get(0).CConstraint)»"«ENDIF»'''
	
	def dispatch generateMessage(RequiredStrictFutureMessage m, Domain domain)
	'''Name="«new LabelGenerator().compile_message_xml(m)»" Type="REQUIRED" Label="r: «new LabelGenerator().compile_message_xml(m)»" isStrict="true" source="//@lifelines.«compile_message_source(m, domain)»" target="//@lifelines.«compile_message_target(m, domain)»" «IF transitionCounter > 0»before="//@transitions.«transitionCounter - 1»"«ENDIF» «IF transitionCounter < domain.scenarios.get(0).scenariocontents.size() - 1»after="//@transitions.«transitionCounter + 1»"«ENDIF» constraint="//@constraints.«domain.constraints.indexOf(m.strictFutureMessage.get(0).futureMessage.get(0).c)»" constraintType="FUTURE" «IF m.strictFutureMessage.get(0).futureMessage.get(0).constraintexp != null»clockOnConstraint="«new ClockConstraintGenerator().compile_clockConstraintExpressionXML(m.strictFutureMessage.get(0).futureMessage.get(0).constraintexp)»"«ENDIF» «IF m.strictFutureMessage.get(0).futureMessage.get(0).resetinconstraint != null»resetOnConstraint="«m.strictFutureMessage.get(0).futureMessage.get(0).resetinconstraint.clock.name»"«ENDIF» «IF m.strictFutureMessage.get(0).futureMessage.get(0).message.get(0).resetclock !== null»reset="«m.strictFutureMessage.get(0).futureMessage.get(0).message.get(0).resetclock.clock.name»"«ENDIF» «IF m.strictFutureMessage.get(0).futureMessage.get(0).message.get(0).CConstraint !== null»clockConstraint="«new ClockConstraintGenerator().compile_clockConstraintExpressionXML(m.strictFutureMessage.get(0).futureMessage.get(0).message.get(0).CConstraint)»"«ENDIF»'''
	
	def dispatch generateMessage(FailMessage m, Domain domain)
	'''Name="«new LabelGenerator().compile_message_xml(m)»" Type="FAIL" Label="f: «new LabelGenerator().compile_message_xml(m)»" source="//@lifelines.«compile_message_source(m, domain)»" target="//@lifelines.«compile_message_target(m, domain)»" «IF transitionCounter > 0»before="//@transitions.«transitionCounter - 1»"«ENDIF» «IF transitionCounter < domain.scenarios.get(0).scenariocontents.size() - 1»after="//@transitions.«transitionCounter + 1»"«ENDIF» «IF m.message.get(0).resetclock !== null»reset="«m.message.get(0).resetclock.clock.name»"«ENDIF» «IF m.message.get(0).CConstraint !== null»clockConstraint="«new ClockConstraintGenerator().compile_clockConstraintExpressionXML(m.message.get(0).CConstraint)»"«ENDIF»'''
	
	def dispatch generateMessage(FailStrictMessage m, Domain domain)
	'''Name="«new LabelGenerator().compile_message_xml(m)»" Type="FAIL" Label="f: «new LabelGenerator().compile_message_xml(m)»" isStrict="true" source="//@lifelines.«compile_message_source(m, domain)»" target="//@lifelines.«compile_message_target(m, domain)»" «IF transitionCounter > 0»before="//@transitions.«transitionCounter - 1»"«ENDIF» «IF transitionCounter < domain.scenarios.get(0).scenariocontents.size() - 1»after="//@transitions.«transitionCounter + 1»"«ENDIF» «IF m.strictMessage.get(0).message.get(0).resetclock !== null»reset="«m.strictMessage.get(0).message.get(0).resetclock.clock.name»"«ENDIF» «IF m.strictMessage.get(0).message.get(0).CConstraint !== null»clockConstraint="«new ClockConstraintGenerator().compile_clockConstraintExpressionXML(m.strictMessage.get(0).message.get(0).CConstraint)»"«ENDIF»'''
	
	def dispatch generateMessage(FailPastMessage m, Domain domain)
	'''Name="«new LabelGenerator().compile_message_xml(m)»" Type="FAIL" Label="f: «new LabelGenerator().compile_message_xml(m)»" source="//@lifelines.«compile_message_source(m, domain)»" target="//@lifelines.«compile_message_target(m, domain)»" «IF transitionCounter > 0»before="//@transitions.«transitionCounter - 1»"«ENDIF» «IF transitionCounter < domain.scenarios.get(0).scenariocontents.size() - 1»after="//@transitions.«transitionCounter + 1»"«ENDIF» constraint="//@constraints.«domain.constraints.indexOf(m.pastMessage.get(0).c)»" constraintType="PAST" «IF m.pastMessage.get(0).constraintexp != null»clockOnConstraint="«new ClockConstraintGenerator().compile_clockConstraintExpressionXML(m.pastMessage.get(0).constraintexp)»"«ENDIF» «IF m.pastMessage.get(0).resetinconstraint != null»resetOnConstraint="«m.pastMessage.get(0).resetinconstraint.clock.name»"«ENDIF» «IF m.pastMessage.get(0).message.get(0).resetclock !== null»reset="«m.pastMessage.get(0).message.get(0).resetclock.clock.name»"«ENDIF» «IF m.pastMessage.get(0).message.get(0).CConstraint !== null»clockConstraint="«new ClockConstraintGenerator().compile_clockConstraintExpressionXML(m.pastMessage.get(0).message.get(0).CConstraint)»"«ENDIF»'''
	
	def compile_message_source(Message m, Domain domain)
	'''«generateMessageSource(m, domain)»'''
	
	def dispatch generateMessageSource(LooseMessage m, Domain domain)
	'''«domain.objects.indexOf(m.sender)»'''
	
	def dispatch generateMessageSource(StrictMessage m, Domain domain)
	'''«domain.objects.indexOf(m.message.get(0).sender)»'''
	
	def dispatch generateMessageSource(PastMessage m, Domain domain)
	'''«domain.objects.indexOf(m.message.get(0).sender)»'''
	
	def dispatch generateMessageSource(FutureMessage m, Domain domain)
	'''«domain.objects.indexOf(m.message.get(0).sender)»'''
	
	def dispatch generateMessageSource(StrictFutureMessage m, Domain domain)
	'''«domain.objects.indexOf(m.futureMessage.get(0).message.get(0).sender)»'''
	
	def dispatch generateMessageSource(RequiredLooseMessage m, Domain domain)
	'''«domain.objects.indexOf(m.message.get(0).sender)»'''
	
	def dispatch generateMessageSource(RequiredStrictMessage m, Domain domain)
	'''«domain.objects.indexOf(m.strictMessage.get(0).message.get(0).sender)»'''
	
	def dispatch generateMessageSource(RequiredPastMessage m, Domain domain)
	'''«domain.objects.indexOf(m.pastMessage.get(0).message.get(0).sender)»'''
	
	def dispatch generateMessageSource(RequiredFutureMessage m, Domain domain)
	'''«domain.objects.indexOf(m.futureMessage.get(0).message.get(0).sender)»'''
	
	def dispatch generateMessageSource(RequiredStrictFutureMessage m, Domain domain)
	'''«domain.objects.indexOf(m.strictFutureMessage.get(0).futureMessage.get(0).message.get(0).sender)»'''
	
	def dispatch generateMessageSource(FailMessage m, Domain domain)
	'''«domain.objects.indexOf(m.message.get(0).sender)»'''
	
	def dispatch generateMessageSource(FailStrictMessage m, Domain domain)
	'''«domain.objects.indexOf(m.strictMessage.get(0).message.get(0).sender)»'''
	
	def dispatch generateMessageSource(FailPastMessage m, Domain domain)
	'''«domain.objects.indexOf(m.pastMessage.get(0).message.get(0).sender)»'''
	
	def compile_message_target(Message m, Domain domain)
	'''«generateMessageTarget(m, domain)»'''
	
	def dispatch generateMessageTarget(LooseMessage m, Domain domain)
	'''«domain.objects.indexOf(m.receiver)»'''
	
	def dispatch generateMessageTarget(StrictMessage m, Domain domain)
	'''«domain.objects.indexOf(m.message.get(0).receiver)»'''
	
	def dispatch generateMessageTarget(PastMessage m, Domain domain)
	'''«domain.objects.indexOf(m.message.get(0).receiver)»'''
	
	def dispatch generateMessageTarget(FutureMessage m, Domain domain)
	'''«domain.objects.indexOf(m.message.get(0).receiver)»'''
	
	def dispatch generateMessageTarget(StrictFutureMessage m, Domain domain)
	'''«domain.objects.indexOf(m.futureMessage.get(0).message.get(0).receiver)»'''
	
	def dispatch generateMessageTarget(RequiredLooseMessage m, Domain domain)
	'''«domain.objects.indexOf(m.message.get(0).receiver)»'''
	
	def dispatch generateMessageTarget(RequiredStrictMessage m, Domain domain)
	'''«domain.objects.indexOf(m.strictMessage.get(0).message.get(0).receiver)»'''
	
	def dispatch generateMessageTarget(RequiredPastMessage m, Domain domain)
	'''«domain.objects.indexOf(m.pastMessage.get(0).message.get(0).receiver)»'''
	
	def dispatch generateMessageTarget(RequiredFutureMessage m, Domain domain)
	'''«domain.objects.indexOf(m.futureMessage.get(0).message.get(0).receiver)»'''
	
	def dispatch generateMessageTarget(RequiredStrictFutureMessage m, Domain domain)
	'''«domain.objects.indexOf(m.strictFutureMessage.get(0).futureMessage.get(0).message.get(0).receiver)»'''
	
	def dispatch generateMessageTarget(FailMessage m, Domain domain)
	'''«domain.objects.indexOf(m.message.get(0).receiver)»'''
	
	def dispatch generateMessageTarget(FailStrictMessage m, Domain domain)
	'''«domain.objects.indexOf(m.strictMessage.get(0).message.get(0).receiver)»'''
	
	def dispatch generateMessageTarget(FailPastMessage m, Domain domain)
	'''«domain.objects.indexOf(m.pastMessage.get(0).message.get(0).receiver)»'''
}