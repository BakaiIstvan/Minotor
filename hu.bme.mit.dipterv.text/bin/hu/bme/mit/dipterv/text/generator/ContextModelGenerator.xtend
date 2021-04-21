package hu.bme.mit.dipterv.text.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IGeneratorContext
import org.eclipse.xtext.generator.IFileSystemAccess2
import hu.bme.mit.dipterv.text.minotorDsl.ContextModel
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.generator.AbstractGenerator
import com.google.inject.Inject

class ContextModelGenerator extends AbstractGenerator {

	@Inject extension IQualifiedNameProvider

	def compile(ContextModel m)'''
		public class «m.name.toFirstUpper» {
			«FOR e: m.entities»
				private «e.name.toFirstUpper» «e.name.toFirstLower»;
			«ENDFOR»
			«FOR r: m.relations»
				private «r.name.toFirstUpper» «r.name.toFirstLower»;
			«ENDFOR»
			
			public «m.name.toFirstUpper»() {
				«FOR e: m.entities»
					«e.name.toFirstLower» = new «e.name.toFirstUpper»();
				«ENDFOR»
				«FOR r: m.relations»
					«r.name.toFirstLower» = new «r.name.toFirstUpper»(«r.sender.name.toFirstLower», «r.receiver.name.toFirstLower»);
				«ENDFOR»
			}
			
			public «m.name.toFirstUpper»(EventCreator eventCreator) {
				«FOR e: m.entities»
					«e.name.toFirstLower» = new «e.name.toFirstUpper»(eventCreator);
				«ENDFOR»
				«FOR r: m.relations»
					«r.name.toFirstLower» = new «r.name.toFirstUpper»(«r.sender.name.toFirstLower», «r.receiver.name.toFirstLower», eventCreator);
				«ENDFOR»
			}
			
			«FOR e: m.entities»
				public «e.name.toFirstUpper» get«e.name.toFirstUpper»() {
					return «e.name.toFirstLower»;
				}
			«ENDFOR»
			«FOR r: m.relations»
				public «r.name.toFirstUpper» get«r.name.toFirstUpper»() {
					return «r.name.toFirstLower»;
				}
			«ENDFOR»
		}
	'''
	
	override doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		for (m : resource.allContents.toIterable.filter(ContextModel)) {
			fsa.generateFile(
				m.fullyQualifiedName.toString("/") + ".java", m.compile
			)
		}
	}
}