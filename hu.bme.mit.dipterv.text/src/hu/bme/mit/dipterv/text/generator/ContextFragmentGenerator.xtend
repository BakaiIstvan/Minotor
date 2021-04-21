package hu.bme.mit.dipterv.text.generator

import hu.bme.mit.dipterv.text.minotorDsl.ContextFragment
import com.google.inject.Inject
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext

class ContextFragmentGenerator extends AbstractGenerator {
	
	@Inject extension IQualifiedNameProvider
	
	override doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		for (m : resource.allContents.toIterable.filter(ContextFragment)) {
			fsa.generateFile(
				m.fullyQualifiedName.toString("/") + ".java", m.compile
			)
		}
	}
	
	def compile(ContextFragment m)'''
		public class «m.name.toFirstUpper» {
			public boolean match(
				«FOR e: 0 ..<m.entities.size»
					«m.entities.get(e).name.toFirstUpper» «m.entities.get(e).name.toFirstLower»
					«IF e != m.entities.size - 1 || m.relations.size > 0»
						,
					«ENDIF»
				«ENDFOR»
				«FOR r: 0 ..<m.relations.size»
					«m.relations.get(r).name.toFirstUpper» «m.relations.get(r).name.toFirstLower»
					«IF r != m.relations.size - 1»
						,
					«ENDIF»
				«ENDFOR»
			) {
				if(
					«FOR e: 0 ..<m.entities.size»
						check«m.entities.get(e).name.toFirstUpper»Constraint(
							«FOR entity: m.entities»
								«IF m.entities.get(e).name.toFirstLower == entity.name.toFirstLower»
									«entity.name.toFirstLower»
								«ENDIF»
							«ENDFOR»
						)
						«IF e != m.entities.size - 1 || m.relations.size != 0»
							&&
						«ENDIF»
					«ENDFOR»
					«FOR r: 0 ..<m.relations.size»
						check«m.relations.get(r).name.toFirstUpper»Constraint(
						«FOR relation: m.relations»
							«IF m.relations.get(r).name.toFirstLower == relation.name.toFirstLower»
								«relation.name.toFirstLower»
							«ENDIF»
						«ENDFOR»
					)
						«IF r != m.relations.size - 1»
							&&
						«ENDIF»
					«ENDFOR»
				) {
					return true;
				}
				
				return false;
			}
			
			«FOR e: m.entities»
				public boolean check«e.name.toFirstUpper»Constraint(«e.name.toFirstUpper» «e.name.toFirstLower») {
					if («FOR a: e.attributes»
							«IF a.int»
								«IF a.greater»
									«e.name.toFirstLower».get«a.name.toFirstUpper»() > «a.value.value»
								«ENDIF»
								«IF a.smaller»
								 	 «e.name.toFirstLower».get«a.name.toFirstUpper»() < «a.value.value»
								«ENDIF»
								«IF a.greaterequals»
									 «e.name.toFirstLower».get«a.name.toFirstUpper»()>= «a.value.value»
								«ENDIF»
								«IF a.smallerequals»
									«e.name.toFirstLower».get«a.name.toFirstUpper»() <= «a.value.value»
								«ENDIF»
								«IF a.equals»
									«e.name.toFirstLower».get«a.name.toFirstUpper»().equals(«a.value.value»)
								«ENDIF»
								«IF a.notequals»
									!«e.name.toFirstLower».get«a.name.toFirstUpper»().equals(«a.value.value»)
								«ENDIF»
							«ENDIF»
							«IF a.float»
								«IF a.greater»
									«e.name.toFirstLower».get«a.name.toFirstUpper»() > «a.value.value»
								«ENDIF»
								«IF a.smaller»
								 	 «e.name.toFirstLower».get«a.name.toFirstUpper»() < «a.value.value»
								«ENDIF»
								«IF a.greaterequals»
									 «e.name.toFirstLower».get«a.name.toFirstUpper»()>= «a.value.value»
								«ENDIF»
								«IF a.smallerequals»
									«e.name.toFirstLower».get«a.name.toFirstUpper»() <= «a.value.value»
								«ENDIF»
								«IF a.equals»
									«e.name.toFirstLower».get«a.name.toFirstUpper»().equals(«a.value.value»)
								«ENDIF»
								«IF a.notequals»
									!«e.name.toFirstLower».get«a.name.toFirstUpper»().equals(«a.value.value»)
								«ENDIF»
							«ENDIF»
							«IF a.string»
								«IF a.equals»
									«e.name.toFirstLower».get«a.name.toFirstUpper»().equals("«a.value.value»")
								«ENDIF»
								«IF a.notequals»
									!«e.name.toFirstLower».get«a.name.toFirstUpper»().equals("«a.value.value»")
								«ENDIF»
							«ENDIF»
							«IF a.boolean»
								«IF a.equals»
									«e.name.toFirstLower».get«a.name.toFirstUpper»().equals(«a.value.value»)
								«ENDIF»
								«IF a.notequals»
									!«e.name.toFirstLower».get«a.name.toFirstUpper»().equals(«a.value.value»)
								«ENDIF»
							«ENDIF» &&
						«ENDFOR»
						«e.name.toFirstLower».getExists()) {
						return true;
					}
					
					return false;
				}
			«ENDFOR»
			«FOR r: m.relations»
				public boolean check«r.name.toFirstUpper»Constraint(«r.name.toFirstUpper» «r.name.toFirstLower») {
					if («FOR a: 0..<r.attributes.size»
							«IF r.attributes.get(a).int»
								«IF r.attributes.get(a).greater»
									«r.name.toFirstLower».get«r.attributes.get(a).name.toFirstUpper»() > «r.attributes.get(a).value.value»
								«ENDIF»
								«IF r.attributes.get(a).smaller»
								 	 «r.name.toFirstLower».get«r.attributes.get(a).name.toFirstUpper»() < «r.attributes.get(a).value.value»
								«ENDIF»
								«IF r.attributes.get(a).greaterequals»
									 «r.name.toFirstLower».get«r.attributes.get(a).name.toFirstUpper»()>= «r.attributes.get(a).value.value»
								«ENDIF»
								«IF r.attributes.get(a).smallerequals»
									«r.name.toFirstLower».get«r.attributes.get(a).name.toFirstUpper»() <= «r.attributes.get(a).value.value»
								«ENDIF»
								«IF r.attributes.get(a).equals»
									«r.name.toFirstLower».get«r.attributes.get(a).name.toFirstUpper»().equals(«r.attributes.get(a).value.value»)
								«ENDIF»
								«IF r.attributes.get(a).notequals»
									!«r.name.toFirstLower».get«r.attributes.get(a).name.toFirstUpper»().equals(«r.attributes.get(a).value.value»)
								«ENDIF»
							«ENDIF»
							«IF r.attributes.get(a).float»
								«IF r.attributes.get(a).greater»
									«r.name.toFirstLower».get«r.attributes.get(a).name.toFirstUpper»() > «r.attributes.get(a).value.value»
								«ENDIF»
								«IF r.attributes.get(a).smaller»
								 	 «r.name.toFirstLower».get«r.attributes.get(a).name.toFirstUpper»() < «r.attributes.get(a).value.value»
								«ENDIF»
								«IF r.attributes.get(a).greaterequals»
									 «r.name.toFirstLower».get«r.attributes.get(a).name.toFirstUpper»()>= «r.attributes.get(a).value.value»
								«ENDIF»
								«IF r.attributes.get(a).smallerequals»
									«r.name.toFirstLower».get«r.attributes.get(a).name.toFirstUpper»() <= «r.attributes.get(a).value.value»
								«ENDIF»
								«IF r.attributes.get(a).equals»
									«r.name.toFirstLower».get«r.attributes.get(a).name.toFirstUpper»().equals(«r.attributes.get(a).value.value»)
								«ENDIF»
								«IF r.attributes.get(a).notequals»
									!«r.name.toFirstLower».get«r.attributes.get(a).name.toFirstUpper»().equals(«r.attributes.get(a).value.value»)
								«ENDIF»
							«ENDIF»
							«IF r.attributes.get(a).string»
								«IF r.attributes.get(a).equals»
									«r.name.toFirstLower».get«r.attributes.get(a).name.toFirstUpper»().equals("«r.attributes.get(a).value.value»")
								«ENDIF»
								«IF r.attributes.get(a).notequals»
									!«r.name.toFirstLower».get«r.attributes.get(a).name.toFirstUpper»().equals("«r.attributes.get(a).value.value»")
								«ENDIF»
							«ENDIF»
							«IF r.attributes.get(a).boolean»
								«IF a.equals»
									«r.name.toFirstLower».get«r.attributes.get(a).name.toFirstUpper»().equals(«r.attributes.get(a).value.value»)
								«ENDIF»
								«IF r.attributes.get(a).notequals»
									!«r.name.toFirstLower».get«r.attributes.get(a).name.toFirstUpper»().equals(«r.attributes.get(a).value.value»)
								«ENDIF»
							«ENDIF»
							«IF a != r.attributes.size - 1» && «ENDIF»
						«ENDFOR» ){
						return true;
					}
					
					return false;
				}
			«ENDFOR»
		}
	'''
	
}