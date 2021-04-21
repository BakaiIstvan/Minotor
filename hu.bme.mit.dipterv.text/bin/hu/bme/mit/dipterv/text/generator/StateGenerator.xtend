package hu.bme.mit.dipterv.text.generator

import org.eclipse.xtext.generator.IGeneratorContext
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator

class StateGenerator extends AbstractGenerator {
	
	override doGenerate(Resource input, IFileSystemAccess2 fsa, IGeneratorContext context) {
		fsa.generateFile("State.java", 
			'''
				public class State {
				    private String id;
				    private StateType type;
				
				    public State() {
				        this.id = "q0";
				        this.type = StateType.NORMAL;
				    }
				
				    public State(String id, StateType stateType) {
				        this.id = id;
				        this.type = stateType;
				    }
				
				    public String getId() {
				        return id;
				    }
				
				    public StateType getType() {
				        return type;
				    }
				
				    public void setType(StateType type) {
				        this.type = type;
				    }
				
				    public void setId(String id) {
				        this.id = id;
				    }
				    
				    public void writeState(){
				    	System.out.println(this.id + " " + this.type);
				    }
				}
			''')
			
			fsa.generateFile("StateType.java",
			'''
				public enum StateType {
				    NORMAL, ACCEPT, FINAL, ACCEPT_ALL
				}
				
			''')
	}
	
}