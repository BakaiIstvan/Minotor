package hu.bme.mit.dipterv.text.gammaexample;

import util.Automaton;
import util.IClock;
import util.IMonitor;
import util.ISystem;
import util.Monitor;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.HashMap;

import hu.bme.mit.gamma.tutorial.extra.Event;
import hu.bme.mit.gamma.tutorial.extra.interfaces.ErrorInterface;
import hu.bme.mit.gamma.tutorial.extra.interfaces.LightCommandsInterface;
import hu.bme.mit.gamma.tutorial.extra.interfaces.ErrorInterface.Provided;
import hu.bme.mit.gamma.tutorial.extra.interfaces.LightCommandsInterface.Required;
import hu.bme.mit.gamma.tutorial.extra.monitor.MonitorInterface;

public class GammaMonitor extends Monitor implements IMonitor, MonitorInterface {
	private Error error;
	private LightInputs lightInputs;
	
	// Indicates which queue is active in a cycle
		private boolean insertQueue = true;
		private boolean processQueue = false;
		// Event queues for the synchronization of statecharts
		private Queue<Event> eventQueue1 = new LinkedList<Event>();
		private Queue<Event> eventQueue2 = new LinkedList<Event>();
	
	public GammaMonitor(Automaton automaton, IClock clock, ISystem system) {
		super(automaton, clock, system);
		
		error = new Error();
		lightInputs = new LightInputs();
	}

	public void changeEventQueues() {
		insertQueue = !insertQueue;
		processQueue = !processQueue;
	}
	
	/** Changes the event queues to which the events are put. Should be used only be a cascade container (composite system) class. */
	public void changeInsertQueue() {
		insertQueue = !insertQueue;
	}
	
	/** Returns whether the eventQueue containing incoming messages is empty. Should be used only be the container (composite system) class. */
	public boolean isEventQueueEmpty() {
		return getInsertQueue().isEmpty();
	}
	
	/** Returns the event queue into which events should be put in the particular cycle. */
	private Queue<Event> getInsertQueue() {
		if (insertQueue) {
			return eventQueue1;
		}
		return eventQueue2;
	}
	
	public void setupMonitor() {
		update("police", "controller", "policeInterruptRaised", Map.of("success", false));
	}
	
	/** Returns the event queue from which events should be inspected in the particular cycle. */
	private Queue<Event> getProcessQueue() {
		if (processQueue) {
			return eventQueue1;
		}
		return eventQueue2;
	}
	
	@Override
	public void runCycle() {
		changeEventQueues();
		runComponent();
	}
	
	public void runComponent() {
		Queue<Event> eventQueue = getProcessQueue();
		while (!eventQueue.isEmpty()) {
				Event event = eventQueue.remove();
				switch (event.getEvent()) {
					case "LightInputs.DisplayNone":
						//update("controller", "light", "displayNone", new HashMap<String, Object>());
					break;
					case "LightInputs.DisplayYellow":
						//update("controller", "light", "displayYellow", new HashMap<String, Object>());
					break;
					case "LightInputs.DisplayRed":
						//update("controller", "light", "displayRed", new HashMap<String, Object>());
					break;
					case "LightInputs.DisplayGreen":
						//update("controller", "light", "displayGreen", new HashMap<String, Object>());
					break;
					default:
						throw new IllegalArgumentException("No such event!");
				}
		}
		notifyListeners();
	}

	@Override
	public Provided getError() {
		return error;
	}

	@Override
	public Required getLightInputs() {
		return lightInputs;
	}

	@Override
	public void reset() {
		// Clearing the in events
		insertQueue = true;
		processQueue = false;
		eventQueue1.clear();
		eventQueue2.clear();
		
		notifyListeners();
	}

	public void notifyListeners() {
		lightInputs.notifyListeners();
		error.notifyListeners();
	}
	
	public class Error implements ErrorInterface.Provided {
		private List<ErrorInterface.Listener.Provided> registeredListeners = new LinkedList<ErrorInterface.Listener.Provided>();

		@Override
		public boolean isRaisedError() {
			return !goodStateReached();
		}
		@Override
		public void registerListener(final ErrorInterface.Listener.Provided listener) {
			registeredListeners.add(listener);
		}
		
		@Override
		public List<ErrorInterface.Listener.Provided> getRegisteredListeners() {
			return registeredListeners;
		}
		
		/** Notifying the registered listeners. */
		public void notifyListeners() {
			if (isRaisedError()) {
				for (ErrorInterface.Listener.Provided listener : registeredListeners) {
					listener.raiseError();
				}
			}
		}

	}
	
	// Inner classes representing Ports
		public class LightInputs implements LightCommandsInterface.Required {
			private List<LightCommandsInterface.Listener.Required> registeredListeners = new LinkedList<LightCommandsInterface.Listener.Required>();

			@Override
			public void raiseDisplayNone() {
				getInsertQueue().add(new Event("LightInputs.DisplayNone"));
				update("controller", "light", "displayNone", new HashMap<String, Object>());
			}
			
			@Override
			public void raiseDisplayYellow() {
				getInsertQueue().add(new Event("LightInputs.DisplayYellow"));
				update("controller", "light", "displayYellow", new HashMap<String, Object>());
			}
			
			@Override
			public void raiseDisplayRed() {
				getInsertQueue().add(new Event("LightInputs.DisplayRed"));
				update("controller", "light", "displayRed", new HashMap<String, Object>());
			}
			
			@Override
			public void raiseDisplayGreen() {
				getInsertQueue().add(new Event("LightInputs.DisplayGreen"));
				update("controller", "light", "displayGreen", new HashMap<String, Object>());
			}

			@Override
			public void registerListener(final LightCommandsInterface.Listener.Required listener) {
				registeredListeners.add(listener);
			}
			
			@Override
			public List<LightCommandsInterface.Listener.Required> getRegisteredListeners() {
				return registeredListeners;
			}
			
			/** Notifying the registered listeners. */
			public void notifyListeners() {
			}

		}
}
