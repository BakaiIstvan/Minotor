package hu.bme.mit.dipterv.text.generator

import hu.bme.mit.dipterv.text.minotorDsl.Domain
import hu.bme.mit.dipterv.text.minotorDsl.Type

class UppaalWriter {
	def compile_uppaal_writer(Domain s)'''
		PrintWriter xmlWriter = new PrintWriter("«s.name»" + ".xml", "UTF-8");
		xmlWriter.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		xmlWriter.println("<!DOCTYPE nta PUBLIC '-//Uppaal Team//DTD Flat System 1.1//EN' 'http://www.it.uu.se/research/group/darts/uppaal/flat-1_1.dtd'>");
		xmlWriter.println("<nta>");
		for (Automaton a : specification.automatas) {
			xmlWriter.println("\t<declaration>");
			String previous = "";
			List<String> existingChannels = new ArrayList<String>();
			for (Transition t : a.getTransitions()) {
				List<String> items = Arrays.asList(t.getId().split("\\s*;\\s*"));
				if (Collections.frequency(existingChannels, items.get(0)) == 0) {
					if (t.getId().startsWith("[") || t.getId().startsWith("![")) {
					} else if (!previous.equals(items.get(0).replaceAll("\\(", "_").replaceAll("\\)", "_").replaceAll("\\.", "__").replaceAll("!", "not").replaceAll("&", "_and_").replaceAll("\\s", ""))){
						xmlWriter.println("chan " + items.get(0).replaceAll("\\(", "_").replaceAll("\\)", "_").replaceAll("\\.", "__").replaceAll("!", "not").replaceAll("&", "_and_").replaceAll("\\s", "") + ";");
						previous = items.get(0).replaceAll("\\(", "_").replaceAll("\\)", "_").replaceAll("\\.", "__").replaceAll("!", "not").replaceAll("&", "_and_").replaceAll("\\s", "");
						existingChannels.add(items.get(0));
					}
				}
			}
			
			«FOR param : s.parameters»
				«IF param.value !== null»
					«IF param.type.toString().substring(1, param.type.toString().length - 1) == "integer"»
						xmlWriter.println("int «param.name» = «param.value.value»;");
					«ELSE»
						xmlWriter.println("«param.type.toString()» «param.name» = «param.value.value»;");
					«ENDIF»
				«ELSE»
					xmlWriter.println("«param.type.toString()» «param.name»;");
				«ENDIF»
			«ENDFOR»
			
			«FOR clock : s.clocks»
				xmlWriter.println("clock «clock.name»;");
			«ENDFOR»
			
			xmlWriter.println("\t</declaration>");
			xmlWriter.println("\t<template>");
			xmlWriter.println("\t\t<name>" + a.getId() + "</name>");
			xmlWriter.println("\t\t<declaration>");
			xmlWriter.println("\t\t</declaration>");
			
			int statecounter = 0;
			
			for (State s : a.getStates()) {
				xmlWriter.println("\t\t<location id=\"" + s.getId() + "\" x=\"" + statecounter + "\" y=\"" + statecounter + "\">");
					if (s.getType().equals(StateType.NORMAL)) {
						xmlWriter.println("\t\t\t<name x=\"" + statecounter + "\" y=\"" + (statecounter + 0.5) + "\">" + s.getId() + "</name>");
					} else if (s.getType().equals(StateType.ACCEPT)) {
						xmlWriter.println("\t\t\t<name x=\"" + statecounter + "\" y=\"" + (statecounter + 0.5) + "\">ACCEPT_" + s.getId() + "</name>");
					} else if (s.getType().equals(StateType.FINAL)) {
						xmlWriter.println("\t\t\t<name x=\"" + statecounter + "\" y=\"" + (statecounter + 0.5) + "\">FINAL_" + s.getId() + "</name>");
					}
				xmlWriter.println("\t\t</location>");
				statecounter++;
			}
			
			xmlWriter.println("\t\t<init ref=\"q0\"/>");
			
			for (Transition t : a.getTransitions()) {
				boolean doubletransition = false;
				xmlWriter.println("\t\t<transition>");
				xmlWriter.println("\t\t\t<source ref=\"" + t.getSender().getId() + "\"/>");
				xmlWriter.println("\t\t\t<target ref=\"" + t.getReceiver().getId() + "\"/>");
				if (t.getId().startsWith("[") || t.getId().startsWith("![")) {
					xmlWriter.println("\t\t\t<label kind=\"guard\" x=\"" + t.getSender().getId().substring(1) + ".5\" y=\"" + t.getSender().getId().substring(1) + ".5\">" + t.getId().substring(0, t.getId().indexOf("]")).replaceAll("<", "&lt;").replaceAll(">", "&gt;").replace("[", "") + "</label>");
				} else {
					List<String> items = Arrays.asList(t.getId().split("\\s*;\\s*"));

					if (items.size() >= 1) {
						xmlWriter.println("\t\t\t<label kind=\"synchronisation\" x=\"" + t.getSender().getId().substring(1) + ".5\" y=\"" + t.getSender().getId().substring(1) + ".5\">" + items.get(0).replaceAll("\\(", "_").replaceAll("\\)", "_").replaceAll("\\.", "__").replaceAll("!", "not").replaceAll("&", "_and_").replaceAll("\\s", "") + "?</label>");
					}

					if (items.size() >= 2) {
						if(items.get(1).contains("1,")) {
							List<String> stringList = Arrays.asList(items.get(1).split("\\s*\\|\\|\\s*"));
							doubletransition = true;
							if (!stringList.get(0).startsWith("(")) {
								xmlWriter.println("\t\t\t<label kind=\"guard\" x=\"" + t.getSender().getId().substring(1) + ".5\" y=\"" + t.getSender().getId().substring(1) + ".5\">" + stringList.get(0).replaceAll("&", "&amp;&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\\(", "").replaceAll("\\)", "").replaceAll(",", " and") + "</label>");
							} else {
								xmlWriter.println("\t\t\t<label kind=\"guard\" x=\"" + t.getSender().getId().substring(1) + ".5\" y=\"" + t.getSender().getId().substring(1) + ".5\">" + stringList.get(0).replaceAll("&", "&amp;&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll(",", " and") + "</label>");
							}
						} else {
							if (!items.get(1).startsWith("(")) {
								xmlWriter.println("\t\t\t<label kind=\"guard\" x=\"" + t.getSender().getId().substring(1) + ".5\" y=\"" + t.getSender().getId().substring(1) + ".5\">" + items.get(1).replaceAll("&", "&amp;&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\\(", "").replaceAll("\\)", "").replaceAll(",", " and") + "</label>");
							} else {
								xmlWriter.println("\t\t\t<label kind=\"guard\" x=\"" + t.getSender().getId().substring(1) + ".5\" y=\"" + t.getSender().getId().substring(1) + ".5\">" + items.get(1).replaceAll("&", "&amp;&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll(",", " and") + "</label>");
							}
						}
					}

					if (items.size() >= 3) {
						xmlWriter.println("\t\t\t<label kind=\"assignment\" x=\"" + t.getSender().getId().substring(1) + ".5\" y=\"" + t.getSender().getId().substring(1) + ".5\">" + items.get(2).replaceAll("&", "&amp;") + "</label>");
					}
				}
				xmlWriter.println("\t\t</transition>");
				if (doubletransition) {
					xmlWriter.println("\t\t<transition>");
					xmlWriter.println("\t\t\t<source ref=\"" + t.getSender().getId() + "\"/>");
					xmlWriter.println("\t\t\t<target ref=\"" + t.getReceiver().getId() + "\"/>");
					if (t.getId().startsWith("[") || t.getId().startsWith("![")) {
						xmlWriter.println("\t\t\t<label kind=\"guard\" x=\"" + t.getSender().getId().substring(1) + ".5\" y=\"" + t.getSender().getId().substring(1) + ".5\">" + t.getId().substring(0, t.getId().indexOf("]")).replaceAll("<", "&lt;").replaceAll(">", "&gt;").replace("[", "") + "</label>");
					} else {
						List<String> items = Arrays.asList(t.getId().split("\\s*;\\s*"));

						if (items.size() >= 1) {
							xmlWriter.println("\t\t\t<label kind=\"synchronisation\" x=\"" + t.getSender().getId().substring(1) + ".5\" y=\"" + t.getSender().getId().substring(1) + ".5\">" + items.get(0).replaceAll("\\(", "_").replaceAll("\\)", "_").replaceAll("\\.", "__").replaceAll("!", "not").replaceAll("&", "_and_").replaceAll("\\s", "") + "?</label>");
						}

						if (items.size() >= 2) {
							if(items.get(1).contains("1,")) {
								List<String> stringList = Arrays.asList(items.get(1).split("\\s*\\|\\|\\s*"));
								doubletransition = true;
								if (!stringList.get(1).startsWith("(")) {
									xmlWriter.println("\t\t\t<label kind=\"guard\" x=\"" + t.getSender().getId().substring(1) + ".5\" y=\"" + t.getSender().getId().substring(1) + ".5\">" + stringList.get(1).replaceAll("&", "&amp;&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\\(", "").replaceAll("\\)", "").replaceAll(",", " and") + "</label>");
								} else {
									xmlWriter.println("\t\t\t<label kind=\"guard\" x=\"" + t.getSender().getId().substring(1) + ".5\" y=\"" + t.getSender().getId().substring(1) + ".5\">" + stringList.get(1).replaceAll("&", "&amp;&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll(",", " and") + "</label>");
								}
							} else {
								if (!items.get(1).startsWith("(")) {
									xmlWriter.println("\t\t\t<label kind=\"guard\" x=\"" + t.getSender().getId().substring(1) + ".5\" y=\"" + t.getSender().getId().substring(1) + ".5\">" + items.get(1).replaceAll("&", "&amp;&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\\(", "").replaceAll("\\)", "").replaceAll(",", " and") + "</label>");
								} else {
									xmlWriter.println("\t\t\t<label kind=\"guard\" x=\"" + t.getSender().getId().substring(1) + ".5\" y=\"" + t.getSender().getId().substring(1) + ".5\">" + items.get(1).replaceAll("&", "&amp;&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll(",", " and") + "</label>");
								}
							}
						}

						if (items.size() >= 3) {
							xmlWriter.println("\t\t\t<label kind=\"assignment\" x=\"" + t.getSender().getId().substring(1) + ".5\" y=\"" + t.getSender().getId().substring(1) + ".5\">" + items.get(2).replaceAll("&", "&amp;") + "</label>");
						}
					}
					xmlWriter.println("\t\t</transition>");
				}
			}
			
			xmlWriter.println("\t</template>");
			xmlWriter.println("\t<template>");
			xmlWriter.println("\t\t<name>" + a.getId() + "_environment</name>");
			xmlWriter.println("\t\t<declaration>");
			xmlWriter.println("\t\t</declaration>");
			xmlWriter.println("\t\t<location id=\"q0\" x=\"0\" y=\"0\">");
			xmlWriter.println("\t\t\t<name x=\"1\" y=\"1\">q0</name>");
			xmlWriter.println("\t\t</location>");
			xmlWriter.println("\t\t<init ref=\"q0\"/>");
			
			Set<Transition> unique_transitions = new TreeSet<Transition>(new Comparator<Transition>() {
		        @Override
		        public int compare(Transition t1, Transition t2) {
		        	List<String> items1 = Arrays.asList(t1.getId().split("\\s*;\\s*"));
		        	List<String> items2 = Arrays.asList(t2.getId().split("\\s*;\\s*"));

		            return !(items1.get(0).equals(items2.get(0))) ? 1 : 0;
		        }
		    });
			
			unique_transitions.addAll(a.getTransitions());
			
			for (Transition t : unique_transitions) {
				xmlWriter.println("\t\t<transition>");
				xmlWriter.println("\t\t\t<source ref=\"q0\"/>");
				xmlWriter.println("\t\t\t<target ref=\"q0\"/>");
				if (t.getId().startsWith("[") || t.getId().startsWith("![")) {
					xmlWriter.println("\t\t\t<label kind=\"guard\" x=\"" + t.getSender().getId().substring(1) + ".5\" y=\"" + t.getSender().getId().substring(1) + ".5\">" + t.getId().substring(0, t.getId().indexOf("]")).replaceAll("<", "&lt;").replaceAll(">", "&gt;").replace("[", "") + "</label>");
				} else {
					List<String> items = Arrays.asList(t.getId().split("\\s*;\\s*"));
	
					if (items.size() >= 1) {
						xmlWriter.println("\t\t\t<label kind=\"synchronisation\" x=\"" + t.getSender().getId().substring(1) + ".5\" y=\"" + t.getSender().getId().substring(1) + ".5\">" + items.get(0).replaceAll("\\(", "_").replaceAll("\\)", "_").replaceAll("\\.", "__").replaceAll("!", "not").replaceAll("&", "_and_").replaceAll("\\s", "") + "!</label>");
					}
					
					«FOR param : s.parameters»
						«IF param.type == Type.BOOL»
							if (t.getId().contains("(" + "«param.name»" + ")") && !t.getId().contains("!")) {
								xmlWriter.println("\t\t\t<label kind=\"select\" x=\"" + t.getSender().getId().substring(1) + ".10\" y=\"" + t.getSender().getId().substring(1) + ".10\">b : int[0, 1]</label>");
								xmlWriter.println("\t\t\t<label kind=\"assignment\" x=\"" + t.getSender().getId().substring(1) + ".15\" y=\"" + t.getSender().getId().substring(1) + ".10\">«param.name» = b</label>");
							}
						«ENDIF»
					«ENDFOR»
				}
				xmlWriter.println("\t\t</transition>");
			}
			
			xmlWriter.println("\t</template>");
		}
		
		xmlWriter.println("\t<system>");
		xmlWriter.println("receiver = " + specification.automatas.get(0).getId() + "();");
		xmlWriter.println("sender = " + specification.automatas.get(0).getId() + "_environment();");
		xmlWriter.println("system receiver, sender;");
		xmlWriter.println("\t</system>");
		
		xmlWriter.println("</nta>");
		xmlWriter.close();
	'''
}