package hu.bme.mit.dipterv.text.generator

import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import org.eclipse.emf.ecore.resource.Resource

class IClockGenerator extends AbstractGenerator {
	override doGenerate(Resource input, IFileSystemAccess2 fsa, IGeneratorContext context) {
		fsa.generateFile("IClock.java",
			'''
				package generated;
			
				public interface IClock {
					public long getClock(String clock);
					public void resetClock(String clock);
				}
			''')
			
			fsa.generateFile("Clock.java",
				'''
				package generated;
				
				import java.util.HashMap;
				import java.util.Map;
				
				import org.apache.commons.lang3.time.StopWatch;
				
				public class Clock implements IClock {
					private Map<String, StopWatch> stopwatches;
				
					public Clock() {
						stopwatches = new HashMap<>();
					}
					
					@Override
					public long getClock(String clock) {
						if (stopwatches.containsKey(clock)) {
							return stopwatches.get(clock).getTime();
						}
						
						return -1;
					}
				
					@Override
					public void resetClock(String clock) {
						if (stopwatches.containsKey(clock)) {
							stopwatches.get(clock).reset();
						} else {
							StopWatch watch = new StopWatch();
							watch.start();
							stopwatches.put(clock, watch);
						}
					}
				
				}
				''')
	}
}