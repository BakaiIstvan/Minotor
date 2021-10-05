package hu.bme.mit.dipterv.text.generator

import hu.bme.mit.dipterv.text.minotorDsl.LooseMessage
import hu.bme.mit.dipterv.text.minotorDsl.Message
import hu.bme.mit.dipterv.text.minotorDsl.StrictMessage
import hu.bme.mit.dipterv.text.minotorDsl.PastMessage
import hu.bme.mit.dipterv.text.minotorDsl.FutureMessage
import hu.bme.mit.dipterv.text.minotorDsl.StrictFutureMessage
import hu.bme.mit.dipterv.text.minotorDsl.RequiredLooseMessage
import hu.bme.mit.dipterv.text.minotorDsl.RequiredStrictMessage
import hu.bme.mit.dipterv.text.minotorDsl.RequiredPastMessage
import hu.bme.mit.dipterv.text.minotorDsl.RequiredFutureMessage
import hu.bme.mit.dipterv.text.minotorDsl.RequiredStrictFutureMessage
import hu.bme.mit.dipterv.text.minotorDsl.FailMessage
import hu.bme.mit.dipterv.text.minotorDsl.FailPastMessage
import hu.bme.mit.dipterv.text.minotorDsl.FailStrictMessage

class LabelGenerator {
	def compile_messageLabel(Message m)
	'''«m.generateMessageLabel»'''
	
	def compile_looseMessageHelper(LooseMessage m)
	'''"«m.sender.name»" + "." +	
		"«m.name»" + "("
		«FOR p: m.params»
			«FOR param: 0..<p.params.size»
				+ "«p.params.get(param).name»"
				«IF param != p.params.size - 1»
					+ ", "
				«ENDIF»
			«ENDFOR»
		«ENDFOR»
		«FOR p: m.constantparams»
			«FOR param: 0..<p.values.size»
				+
				«IF p.values.get(param).value.startsWith("\"")»
					«p.values.get(param).value»
				«ELSE»
				"«p.values.get(param).value»"
				«ENDIF»
				«IF param != p.values.size - 1»
					+ ", "
				«ENDIF»
			«ENDFOR»
		«ENDFOR»
		+ ")"
		
		+ "." + "«m.receiver.name»"'''
		
	def dispatch generateMessageLabel(LooseMessage m)
	'''«m.compile_looseMessageHelper»'''
	
	def dispatch generateMessageLabel(StrictMessage m)
	'''«m.message.get(0).compile_looseMessageHelper»'''
	
	def dispatch generateMessageLabel(PastMessage m)
	'''«m.message.get(0).compile_looseMessageHelper»'''
	
	def dispatch generateMessageLabel(FutureMessage m)
	'''«m.message.get(0).compile_looseMessageHelper»'''
	
	def dispatch generateMessageLabel(StrictFutureMessage m)
	'''«m.futureMessage.get(0).message.get(0).compile_looseMessageHelper»'''
	
	def dispatch generateMessageLabel(RequiredLooseMessage m)
	'''«m.message.get(0).compile_looseMessageHelper»'''
	
	def dispatch generateMessageLabel(RequiredStrictMessage m)
	'''«m.strictMessage.get(0).message.get(0).compile_looseMessageHelper»'''
	
	def dispatch generateMessageLabel(RequiredPastMessage m)
	'''«m.pastMessage.get(0).message.get(0).compile_looseMessageHelper»'''
	
	def dispatch generateMessageLabel(RequiredFutureMessage m)
	'''«m.futureMessage.get(0).message.get(0).compile_looseMessageHelper»'''
	
	def dispatch generateMessageLabel(RequiredStrictFutureMessage m)
	'''«m.strictFutureMessage.get(0).futureMessage.get(0).message.get(0).compile_looseMessageHelper»'''
	
	def dispatch generateMessageLabel(FailMessage m)
	'''«m.message.get(0).compile_looseMessageHelper»'''
	
	def dispatch generateMessageLabel(FailStrictMessage m)
	'''«m.strictMessage.get(0).message.get(0).compile_looseMessageHelper»'''
	
	def dispatch generateMessageLabel(FailPastMessage m)
	'''«m.pastMessage.get(0).message.get(0).compile_looseMessageHelper»'''

}