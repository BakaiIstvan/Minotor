package hu.bme.mit.dipterv.text.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import org.eclipse.xtext.generator.AbstractGenerator
import hu.bme.mit.dipterv.text.minotorDsl.Domain

class EventCreatorGenerator extends AbstractGenerator {
	override doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		for (m : resource.allContents.toIterable.filter(Domain)) {
			fsa.generateFile(
				"EventCreator.java", m.compile_eventcreator
			)
		}
	}
	
	def compile_eventcreator(Domain d)'''
		package generated;
	
		public class EventCreator {
			«FOR i: d.includes»
				private «i.context.name.toFirstUpper» «i.context.name.toFirstLower»;
			«ENDFOR»
			«FOR f: d.contextfragments»
				private «f.name.toFirstUpper» «f.name.toFirstLower»;
			«ENDFOR»
			private Monitor monitorInterface;
			
			public EventCreator(
				«FOR i: d.includes»
					«i.context.name.toFirstUpper» «i.context.name.toFirstLower»,
				«ENDFOR»
				«FOR f: d.contextfragments»
					«f.name.toFirstUpper» «f.name.toFirstLower»,
				«ENDFOR»
				Monitor monitorInterface
			) {
				«FOR i: d.includes»
					this.«i.context.name.toFirstLower» = «i.context.name.toFirstLower»;
				«ENDFOR»
				«FOR f: d.contextfragments»
					this.«f.name.toFirstLower» = «f.name.toFirstLower»;
				«ENDFOR»
				this.monitorInterface = monitorInterface;
			}
			
			«FOR i: d.includes»
				public void set«i.context.name.toFirstUpper»(«i.context.name.toFirstUpper» «i.context.name.toFirstLower») {
					this.«i.context.name.toFirstLower» = «i.context.name.toFirstLower»;
				}
			«ENDFOR»
			
			public void appear(String name) {
				«FOR m: d.includes»
					monitorInterface.update("appear(«m.context.name.toFirstUpper»." + name + ")");
					«FOR f: d.contextfragments»
						if («f.name.toFirstLower».match(
							«FOR e: 0..< f.entities.size»
								«m.context.name.toFirstLower».get«f.entities.get(e).name.toFirstUpper»()
								«IF e != f.entities.size - 1 || f.relations.size > 0»
									,
								«ENDIF»
							«ENDFOR»
							«FOR r: 0..< f.relations.size»
								«m.context.name.toFirstLower».get«f.relations.get(r).name.toFirstUpper»()
								«IF r != f.relations.size - 1»
									,
								«ENDIF»
							«ENDFOR»
						)) {
							monitorInterface.update("match(«m.context.name.toFirstUpper», «f.name.toFirstUpper»)");
						}
					«ENDFOR»
				«ENDFOR»
			}
			
			public void disappear(String name) {
				«FOR m: d.includes»
					monitorInterface.update("disappear(«m.context.name.toFirstUpper»." + name + ")"); 
					«FOR f: d.contextfragments»
						if («f.name.toFirstLower».match(
							«FOR e: 0..< f.entities.size»
								«m.context.name.toFirstLower».get«f.entities.get(e).name.toFirstUpper»()
								«IF e != f.entities.size - 1 || f.relations.size > 0»
									,
								«ENDIF»
							«ENDFOR»
							«FOR r: 0..< f.relations.size»
								«m.context.name.toFirstLower».get«f.relations.get(r).name.toFirstUpper»()
								«IF r != f.relations.size - 1»
									,
								«ENDIF»
							«ENDFOR»
						)) {
							monitorInterface.update("match(«m.context.name.toFirstUpper», «f.name.toFirstUpper»)");
						}
					«ENDFOR»
				«ENDFOR»
			}
			
			public void changeTo(String event) {
				«FOR m: d.includes»
					monitorInterface.update("changeTo(«m.context.name.toFirstUpper»." + event + ")"); 
					«FOR f: d.contextfragments»
						if («f.name.toFirstLower».match(
							«FOR e: 0..< f.entities.size»
								«m.context.name.toFirstLower».get«f.entities.get(e).name.toFirstUpper»()
								«IF e != f.entities.size - 1 || f.relations.size > 0»
									,
								«ENDIF»
							«ENDFOR»
							«FOR r: 0..< f.relations.size»
								«m.context.name.toFirstLower».get«f.relations.get(r).name.toFirstUpper»()
								«IF r != f.relations.size - 1»
									,
								«ENDIF»
							«ENDFOR»
						)) {
							monitorInterface.update("match(«m.context.name.toFirstUpper», «f.name.toFirstUpper»)");
						}
					«ENDFOR»
				«ENDFOR»
			}
		}
	'''
}