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
	int altCounter = 0;
	int parCounter = 0;
	int loopCounter = 0;
	
	override doGenerate(Resource input, IFileSystemAccess2 fsa, IGeneratorContext context) {
		for(s : input.allContents.toIterable.filter(Domain)){
			fsa.generateFile("Scenario.xml", s.compile)
		}
	}
	
	def compile(Domain s)'''
		<?xml version="1.0" encoding="UTF-8"?>
		<minotor:SequenceDiagram xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:minotor="hu.bme.mit.mdsd.xboyz.erdiagram" Name="«s.name»">
		
		«FOR object: s.objects»
		<lifelines Name="«object.name»" Type="«object.object.get(0).name»"/>
		«ENDFOR»
		
		<transitions Name="login" Type="REGULAR" Label="e: login" source="//@lifelines.0" target="//@lifelines.1" after="//@transitions.1" reset="x" clockConstraint="x &lt; 10"/>
		<transitions Name="wReq" Type="REGULAR" Label="e: wReq" source="//@lifelines.0" target="//@lifelines.1" after="//@transitions.2" before="//@transitions.0" constraint="//@constraints.0" constraintType="PAST" clockOnConstraint="x &lt; 5" resetOnConstraint="x"/>
		<transitions Name="uDB" Label="r: UDB" source="//@lifelines.1" target="//@lifelines.2" before="//@transitions.1" constraint="//@constraints.0" constraintType="PAST" resetOnConstraint="x"/>
		<transitions Name="insertATMCard" Type="REGULAR" Label="e: insertATMCard" source="//@lifelines.0" target="//@lifelines.1" after="//@transitions.1"/>
		<transitions Name="getPassword" Label="r: getPassword" altpartition="//@alts.0/@altpartition.0" source="//@lifelines.1" target="//@lifelines.0" after="//@transitions.2" before="//@transitions.0"/>
		<transitions Name="displayInvalidCard" Type="REGULAR" Label="e: displayInvalidCard" altpartition="//@alts.0/@altpartition.1" source="//@lifelines.1" target="//@lifelines.0" after="//@transitions.3" before="//@transitions.1"/>
		<transitions Name="waitForNextPerson" Type="REGULAR" Label="e: waitForNextPerson" loop="//@loops.0" source="//@lifelines.1" target="//@lifelines.1" before="//@transitions.2"/>
		
		«FOR constraint: s.constraints»
		<constraints Name="«constraint.name»">
			«FOR message: constraint.messages»
	    	<transitions Name="«new LabelGenerator().compile_messageLabel(message)»" source="//@lifelines.«compile_message_source(message, s)»" target="//@lifelines.«compile_message_target(message, s)»"/>
	    	«ENDFOR»
		</constraints>
		«ENDFOR»
		
		«FOR scenarioContent: s.scenarios.get(0).scenariocontents»
		«FOR l : scenarioContent.loop»
		<loops Name="«l.toString()»" Min="«l.min»" Max="«l.max»"/>
		«ENDFOR»
		«FOR par : scenarioContent.par»
		<pars Name="«par.toString()»">
	    	«FOR parexpression : par.parexpression»
        	<parpartition Name="«parexpression.toString()»"/>
        	«ENDFOR»
		</pars>
		«ENDFOR»
		«FOR alt : scenarioContent.alt»
		<alts Name="«alt.toString()»">
			«FOR altexpression : alt.expressions»
	    	<altpartition Name="«new MinotorDslGenerator().compile_alt_condition_name(altexpression.altCondition)»"/>
	    	«ENDFOR»
	    </alts>
		«ENDFOR»
		«FOR m : scenarioContent.message»
		«compile_message(m, s)»
		«ENDFOR»
		«ENDFOR»

		</minotor:SequenceDiagram>
	'''
	
	def incrementCounter() {
		transitionCounter++
	}
	
	def compile_message(Message m, Domain domain) {
		incrementCounter()
		generateMessage(m, domain)
	}
	
	def dispatch generateMessage(LooseMessage m, Domain domain)
	'''<transitions Name="«new LabelGenerator().compile_message_xml(m)»" Type="REGULAR" Label="e: «new LabelGenerator().compile_message_xml(m)»" source="//@lifelines.«compile_message_source(m, domain)»" target="//@lifelines.«compile_message_target(m, domain)»" «IF transitionCounter > 0»before="//@transitions.«transitionCounter - 1»"«ENDIF» «IF transitionCounter < domain.scenarios.get(0).scenariocontents.size()»after="//@transitions.«transitionCounter + 1»"«ENDIF» «IF m.resetclock !== null»reset="«m.resetclock.clock.name»"«ENDIF» «IF m.CConstraint !== null»clockConstraint="«new ClockConstraintGenerator().compile_clockConstraintExpressionXML(m.CConstraint)»"«ENDIF»/>'''
	
	def dispatch generateMessage(StrictMessage m, Domain domain)
	'''«m.message.get(0).sender»'''
	
	def dispatch generateMessage(PastMessage m, Domain domain)
	'''«domain.objects.indexOf(m.message.get(0).sender)»'''
	
	def dispatch generateMessage(FutureMessage m, Domain domain)
	'''«domain.objects.indexOf(m.message.get(0).sender)»'''
	
	def dispatch generateMessage(StrictFutureMessage m, Domain domain)
	'''«domain.objects.indexOf(m.futureMessage.get(0).message.get(0).sender)»'''
	
	def dispatch generateMessage(RequiredLooseMessage m, Domain domain)
	'''«domain.objects.indexOf(m.message.get(0).sender)»'''
	
	def dispatch generateMessage(RequiredStrictMessage m, Domain domain)
	'''«domain.objects.indexOf(m.strictMessage.get(0).message.get(0).sender)»'''
	
	def dispatch generateMessage(RequiredPastMessage m, Domain domain)
	'''«domain.objects.indexOf(m.pastMessage.get(0).message.get(0).sender)»'''
	
	def dispatch generateMessage(RequiredFutureMessage m, Domain domain)
	'''«domain.objects.indexOf(m.futureMessage.get(0).message.get(0).sender)»'''
	
	def dispatch generateMessage(RequiredStrictFutureMessage m, Domain domain)
	'''«domain.objects.indexOf(m.strictFutureMessage.get(0).futureMessage.get(0).message.get(0).sender)»'''
	
	def dispatch generateMessage(FailMessage m, Domain domain)
	'''«domain.objects.indexOf(m.message.get(0).sender)»'''
	
	def dispatch generateMessage(FailStrictMessage m, Domain domain)
	'''«domain.objects.indexOf(m.strictMessage.get(0).message.get(0).sender)»'''
	
	def dispatch generateMessage(FailPastMessage m, Domain domain)
	'''«domain.objects.indexOf(m.pastMessage.get(0).message.get(0).sender)»'''
	
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