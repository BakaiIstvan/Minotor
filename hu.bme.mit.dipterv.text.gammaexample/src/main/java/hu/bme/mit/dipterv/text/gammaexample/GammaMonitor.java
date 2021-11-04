package hu.bme.mit.dipterv.text.gammaexample;

import util.Automaton;
import util.IClock;
import util.IMonitor;
import util.ISystem;
import util.Monitor;
import hu.bme.mit.gamma.tutorial.finish.monitor.IMonitorStatemachine;
import hu.bme.mit.gamma.tutorial.finish.monitor.IMonitorStatemachine.SCILightInputs;;

public class GammaMonitor extends Monitor implements IMonitor, IMonitorStatemachine, SCILightInputs {

	public GammaMonitor(Automaton automaton, IClock clock, ISystem system) {
		super(automaton, clock, system);
		// TODO Auto-generated constructor stub
	}

	@Override
	public SCILightInputs getSCILightInputs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void raiseDisplayRed() {
		update("controller", "light", "displayRed", new String[] {}, true);
	}

	@Override
	public void raiseDisplayGreen() {
		update("controller", "light", "displayGreen", new String[] {}, true);
	}

	@Override
	public void raiseDisplayYellow() {
		update("controller", "light", "displayYellow", new String[] {}, true);
	}

	@Override
	public void raiseDisplayNone() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isActive() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFinal() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void runCycle() {
		// TODO Auto-generated method stub
		
	}

}
