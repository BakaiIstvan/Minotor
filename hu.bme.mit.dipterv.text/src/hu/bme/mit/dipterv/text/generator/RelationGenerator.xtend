package hu.bme.mit.dipterv.text.generator

import org.eclipse.xtext.generator.IFileSystemAccess2
import hu.bme.mit.dipterv.text.minotorDsl.Relation
import org.eclipse.xtext.generator.IGeneratorContext
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.naming.IQualifiedNameProvider
import com.google.inject.Inject
import org.eclipse.xtext.generator.AbstractGenerator

class RelationGenerator extends AbstractGenerator {
	
	@Inject extension IQualifiedNameProvider
	
	override doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		for (m : resource.allContents.toIterable.filter(Relation)) {
			fsa.generateFile(
				m.fullyQualifiedName.toString("/") + ".java", m.compile
			)
		}
	}
	
	def compile(Relation r)'''
		public class «r.name.toFirstUpper» {
			private «r.sender.name.toFirstUpper» sender;
			private «r.receiver.name.toFirstUpper» receiver;
			private EventCreator eventCreator;
			«FOR a: r.attributes»
				«IF a.int»
					private int «a.name.toFirstLower»;
				«ENDIF»
				«IF a.float»
					private float «a.name.toFirstLower»;
				«ENDIF»
				«IF a.string»
					private String «a.name.toFirstLower»;
				«ENDIF»
				«IF a.boolean»
					private boolean «a.name.toFirstLower»;
				«ENDIF»
			«ENDFOR»
			
			public «r.name.toFirstUpper»(«r.sender.name.toFirstUpper» sender, «r.receiver.name.toFirstUpper» receiver) {
				this.sender = sender;
				this.receiver = receiver;
				«FOR a: r.attributes»
					«IF a.int»
						«IF a.value === null»
							«a.name.toFirstLower» = 0;
						«ELSE»
							«a.name.toFirstLower» = «a.value.value»;
						«ENDIF»
					«ENDIF»
					«IF a.float»
						«IF a.value === null»
							«a.name.toFirstLower» = 0;
						«ELSE»
							«a.name.toFirstLower» = «a.value.value»;
						«ENDIF»
					«ENDIF»
					«IF a.string»
						«IF a.value === null»
							«a.name.toFirstLower» = "default";
						«ELSE»
							«a.name.toFirstLower» = "«a.value.value»";
						«ENDIF»
					«ENDIF»
					«IF a.boolean»
						«IF a.value === null»
							«a.name.toFirstLower» = false;
						«ELSE»
							«a.name.toFirstLower» = «a.value.value»;
						«ENDIF»
					«ENDIF»
				«ENDFOR»
			}
			
			public «r.name.toFirstUpper»(«r.sender.name.toFirstUpper» sender, «r.receiver.name.toFirstUpper» receiver, EventCreator eventCreator) {
				this.sender = sender;
				this.receiver = receiver;
				this.eventCreator = eventCreator;
				«FOR a: r.attributes»
					«IF a.int»
						«IF a.value === null»
							«a.name.toFirstLower» = 0;
						«ELSE»
							«a.name.toFirstLower» = «a.value.value»;
						«ENDIF»
					«ENDIF»
					«IF a.float»
						«IF a.value === null»
							«a.name.toFirstLower» = 0;
						«ELSE»
							«a.name.toFirstLower» = «a.value.value»;
						«ENDIF»
					«ENDIF»
					«IF a.string»
						«IF a.value === null»
							«a.name.toFirstLower» = "default";
						«ELSE»
							«a.name.toFirstLower» = "«a.value.value»";
						«ENDIF»
					«ENDIF»
					«IF a.boolean»
						«IF a.value === null»
							«a.name.toFirstLower» = false;
						«ELSE»
							«a.name.toFirstLower» = «a.value.value»;
						«ENDIF»
					«ENDIF»
				«ENDFOR»
			}
				
			«FOR a: r.attributes»
				«IF a.int»
					public int get«a.name.toFirstUpper»() { return «a.name.toFirstLower»; }
					
					public void set«a.name.toFirstUpper»(int «a.name.toFirstLower») { 
						this.«a.name.toFirstLower» = «a.name.toFirstLower»;
						eventCreator.changeTo("«r.name.toFirstUpper».«a.name.toFirstLower», " + «a.name.toFirstLower»);
					}
				«ENDIF»
				«IF a.float»
					public float get«a.name.toFirstUpper»() { return «a.name.toFirstLower»; }
											
					public void set«a.name.toFirstUpper»(float «a.name.toFirstLower») { 
						this.«a.name.toFirstLower» = «a.name.toFirstLower»;
						eventCreator.changeTo("«r.name.toFirstUpper».«a.name.toFirstLower», " + «a.name.toFirstLower»);
					}
				«ENDIF»
				«IF a.string»
					public String get«a.name.toFirstUpper»() { return «a.name.toFirstLower»; }
											
					public void set«a.name.toFirstUpper»(String «a.name.toFirstLower») { 
						this.«a.name.toFirstLower» = «a.name.toFirstLower»;
						eventCreator.changeTo("«r.name.toFirstUpper».«a.name.toFirstLower», " + «a.name.toFirstLower»);
					}
				«ENDIF»
				«IF a.boolean»
					public boolean get«a.name.toFirstUpper»() { return «a.name.toFirstLower»; }
											
					public void set«a.name.toFirstUpper»(boolean «a.name.toFirstLower») { 
						this.«a.name.toFirstLower» = «a.name.toFirstLower»;
						eventCreator.changeTo("«r.name.toFirstUpper».«a.name.toFirstLower», " + «a.name.toFirstLower»);
					}
				«ENDIF»
			«ENDFOR»
			
			public «r.sender.name.toFirstUpper» getSender() { return sender; }
			
			public «r.receiver.name.toFirstUpper» getReceiver() { return receiver; }
		}
	'''
	
}