package util;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class NeverClaimWriter {
	
	public void writeNeverClaim(String name, List<Automaton> automatas) throws FileNotFoundException, UnsupportedEncodingException {
		boolean acceptState = false;
		PrintWriter writer = new PrintWriter(name + ".txt", "UTF-8");
		
		for(Automaton a : automatas){
			writer.println("");
			writer.println("never{ /*" + a.getId()+ "Monitor" + "*/");
			for(State s : a.getStates()){
				if(s == a.getInitial()){
					writer.println("T0_init:");
					writer.println(" if");
					for(Transition t : a.findSender(s)){
						if(t.getReceiver() == a.getInitial()){
							writer.println(" :: (" + t.toString() + ") " + "->" + " goto T0_init");
						}else if(t.getReceiver().getType().equals(StateType.NORMAL)){
							writer.println(" :: (" + t.toString() + ") " + "->" + " goto T0_" + t.getReceiver().getId());
						}else if(t.getReceiver().getType().equals(StateType.ACCEPT_ALL)){
							writer.println(" :: (" + t.toString() + ") " + "->" + " goto accept_all" );
						}else if(t.getReceiver().getType().equals(StateType.FINAL)){
							writer.println(" :: (" + t.toString() + ") " + "->" + " goto T0_" + t.getReceiver().getId());
						}else if(t.getReceiver().getType().equals(StateType.ACCEPT)){
							writer.println(" :: (" + t.toString() + ") " + "->" + " goto accept_" + t.getReceiver().getId());
						}
					}
					writer.println(" fi;");
				}else if(s.getType().equals(StateType.NORMAL)){
					writer.println("T0_" + s.getId() + ":");
					writer.println(" if");
					for(Transition t : a.findSender(s)){
						if(t.getReceiver() == a.getInitial()){
							writer.println(" :: (" + t.toString() + ") " + "->" + " goto T0_init");
						}else if(t.getReceiver().getType().equals(StateType.NORMAL)){
							writer.println(" :: (" + t.toString() + ") " + "->" + " goto T0_" + t.getReceiver().getId());
						}else if(t.getReceiver().getType().equals(StateType.ACCEPT_ALL)){
							writer.println(" :: (" + t.toString() + ") " + "->" + " goto accept_all" );
						}else if(t.getReceiver().getType().equals(StateType.FINAL)){
							writer.println(" :: (" + t.toString() + ") " + "->" + " goto T0_" + t.getReceiver().getId());
						}else if(t.getReceiver().getType().equals(StateType.ACCEPT)){
							writer.println(" :: (" + t.toString() + ") " + "->" + " goto accept_" + t.getReceiver().getId());
						}
					}
					writer.println(" fi;");
				}else if(s.getType().equals(StateType.ACCEPT_ALL) && !acceptState){
					writer.println("accept_all:");
					writer.println("skip");
					acceptState = true;
				}else if(s.getType().equals(StateType.FINAL)){
					writer.println("T0_" + s.getId() + ":");
					writer.println(" if");
					for(Transition t : a.findSender(s)){
						if(t.getReceiver() == a.getInitial()){
							writer.println(" :: (" + t.toString() + ")" + "->" + " goto T0_init");
						}else if(t.getReceiver().getType().equals(StateType.NORMAL)){
							writer.println(" :: (" + t.toString() + ") " + "->" + " goto T0_" + t.getReceiver().getId());
						}else if(t.getReceiver().getType().equals(StateType.ACCEPT_ALL)){
							writer.println(" :: (" + t.toString() + ") " + "->" + " goto accept_all" );
						}else if(t.getReceiver().getType().equals(StateType.FINAL)){
							writer.println(" :: (" + t.toString() + ") " + "->" + " goto T0_" + t.getReceiver().getId());
						}else if(t.getReceiver().getType().equals(StateType.ACCEPT)){
							writer.println(" :: (" + t.toString() + ") " + "->" + " goto accept_" + t.getReceiver().getId());
						}
					}
					writer.println(" fi;");
				}else if(s.getType().equals(StateType.ACCEPT)){
					writer.println("accept_" + s.getId() + ":");
					writer.println(" if");
					for(Transition t : a.findSender(s)){
						if(t.getReceiver() == a.getInitial()){
							writer.println(" :: (" + t.toString() + ")" + "->" + " goto T0_init");
						}else if(t.getReceiver().getType().equals(StateType.NORMAL)){
							writer.println(" :: (" + t.toString() + ") " + "->" + " goto T0_" + t.getReceiver().getId());
						}else if(t.getReceiver().getType().equals(StateType.ACCEPT_ALL)){
							writer.println(" :: (" + t.toString() + ") " + "->" + " goto accept_all" );
						}else if(t.getReceiver().getType().equals(StateType.FINAL)){
							writer.println(" :: (" + t.toString() + ") " + "->" + " goto T0_" + t.getReceiver().getId());
						}else if(t.getReceiver().getType().equals(StateType.ACCEPT)){
							writer.println(" :: (" + t.toString() + ") " + "->" + " goto accept_" + t.getReceiver().getId());
						}
					}
					writer.println(" fi;");
				}
				
			}
			writer.println("}");
		}
		writer.close();
	}
	
}
