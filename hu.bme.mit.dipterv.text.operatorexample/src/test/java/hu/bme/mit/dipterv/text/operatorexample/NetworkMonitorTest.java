package hu.bme.mit.dipterv.text.operatorexample;

import util.Clock;
import util.IClock;
import util.IMonitor;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import generated.Specification;
import util.Monitor;
import util.ISystem;

public class NetworkMonitorTest implements ISystem {
	//TODO: tesztekhez trace-ket írni, komplikált implementációt kitörölni.
    @Test
	public void testNetworkRequirementSatisfied() {
		Specification specification = new Specification();
		specification.listAutomatas();
		IClock clock = new Clock();
		IMonitor monitor = new Monitor(specification.getAutomata().get(0), clock, this);
		
		for (int i = 0; i < 1; i++) {
        	System.out.println("[Computer] Tries: " + ++i);
        	monitor.update("computer", "computer", "login", new String[] {});
        	monitor.update("computer", "server", "attemptLogin", new String[] {});
        }
		
		try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        monitor.update("server", "computer", "logoutUser", new String[] {});
        monitor.update("server", "computer", "lockComputer", new String[] {});
		
		Assertions.assertTrue(monitor.goodStateReached());
		Assertions.assertTrue(monitor.requirementSatisfied());
	}
    
    @Test
	public void testNetworkRequirementSatisfiedTwice() {
    	System.out.println("Twice ---------------------------------------------------------------------------");
		Specification specification = new Specification();
		specification.listAutomatas();
		IClock clock = new Clock();
		IMonitor monitor = new Monitor(specification.getAutomata().get(0), clock, this);

		for (int i = 0; i < 2; i++) {
        	System.out.println("[Computer] Tries: " + ++i);
        	monitor.update("computer", "computer", "login", new String[] {});
        	monitor.update("computer", "server", "attemptLogin", new String[] {});
        }
		
		try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        monitor.update("server", "computer", "logoutUser", new String[] {});
        monitor.update("server", "computer", "lockComputer", new String[] {});
        
		Assertions.assertTrue(monitor.goodStateReached());
		Assertions.assertTrue(monitor.requirementSatisfied());
		System.out.println("Twice --------------------------------------------------------------------------- END");
	}
    
    /*@Test
	public void testNetworkRequirementSatisfiedThreeTimes() {
    	System.out.println("Three times ---------------------------------------------------------------------------");
		Specification specification = new Specification();
		specification.listAutomatas();
		IClock clock = new Clock();
		IMonitor monitor = new Monitor(specification.getAutomata().get(0), clock, this);

		for (int i = 0; i < 3; i++) {
        	System.out.println("[Computer] Tries: " + ++i);
        	monitor.update("computer", "computer", "login", new String[] {});
        	monitor.update("computer", "server", "attemptLogin", new String[] {});
        }
		
		try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        monitor.update("server", "computer", "logoutUser", new String[] {});
        monitor.update("server", "computer", "lockComputer", new String[] {});
        
		Assertions.assertTrue(monitor.goodStateReached());
		Assertions.assertTrue(monitor.requirementSatisfied());
		System.out.println("Three times --------------------------------------------------------------------------- END");
	}*/
    
    @Test
	public void testNetworkRequirementSatisfiedFourTimes() {
    	System.out.println("Four times ---------------------------------------------------------------------------");
		Specification specification = new Specification();
		specification.listAutomatas();
		IClock clock = new Clock();
		IMonitor monitor = new Monitor(specification.getAutomata().get(0), clock, this);

		for (int i = 0; i < 4; i++) {
        	System.out.println("[Computer] Tries: " + ++i);
        	monitor.update("computer", "computer", "login", new String[] {});
        	monitor.update("computer", "server", "attemptLogin", new String[] {});
        }
		
		try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        monitor.update("server", "computer", "logoutUser", new String[] {});
        monitor.update("server", "computer", "lockComputer", new String[] {});
        
		Assertions.assertFalse(monitor.goodStateReached());
		Assertions.assertFalse(monitor.requirementSatisfied());
		System.out.println("Four times --------------------------------------------------------------------------- END");
	}
    
    @Test
	public void testNetworkAltTrueCase() {
		Specification specification = new Specification();
		specification.listAutomatas();
		IClock clock = new Clock();
		IMonitor monitor = new Monitor(specification.getAutomata().get(0), clock, this);

		for (int i = 0; i < 2; i++) {
        	System.out.println("[Computer] Tries: " + ++i);
        	monitor.update("computer", "computer", "login", new String[] {});
        	monitor.update("computer", "server", "attemptLogin", new String[] {});
        }
		
		try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		monitor.update("computer", "server", "checkEmail", new String[] {});
		monitor.update("computer", "server", "newEmail", new String[] {"receiver", "subject"});
		
		Assertions.assertFalse(monitor.goodStateReached());
		Assertions.assertFalse(monitor.requirementSatisfied());
	}
    
    @Test
   	public void testNetworkLogoutTooFast() {
   		Specification specification = new Specification();
   		specification.listAutomatas();
   		IClock clock = new Clock();
   		IMonitor monitor = new Monitor(specification.getAutomata().get(0), clock, this);
   		
   		for (int i = 0; i < 2; i++) {
        	System.out.println("[Computer] Tries: " + ++i);
        	monitor.update("computer", "computer", "login", new String[] {});
        	monitor.update("computer", "server", "attemptLogin", new String[] {});
        }
		
		try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        monitor.update("server", "computer", "logoutUser", new String[] {});
        monitor.update("server", "computer", "lockComputer", new String[] {});
   		
   		Assertions.assertFalse(monitor.goodStateReached());
   		Assertions.assertFalse(monitor.requirementSatisfied());
   	}
    
    @Test
   	public void testNetworkLogoutConstrait() {
   		Specification specification = new Specification();
   		specification.listAutomatas();
   		IClock clock = new Clock();
   		IMonitor monitor = new Monitor(specification.getAutomata().get(0), clock, this);
 		
   		for (int i = 0; i < 2; i++) {
        	System.out.println("[Computer] Tries: " + ++i);
        	monitor.update("computer", "computer", "login", new String[] {});
        	monitor.update("computer", "server", "logout", new String[] {});
        	monitor.update("computer", "server", "attemptLogin", new String[] {});
        }
		
		try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        monitor.update("server", "computer", "logoutUser", new String[] {});
        monitor.update("server", "computer", "lockComputer", new String[] {});
   		
   		Assertions.assertFalse(monitor.goodStateReached());
   		Assertions.assertFalse(monitor.requirementSatisfied());
   	}

    @Override
	public void receiveMonitorStatus(String message) {
		System.out.println("[NetworkMonitorTest]Received status from monitor: " + message);
	}

	@Override
	public void receiveMonitorError(String actualMessage, String lastAcceptedMessage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void receiveMonitorSuccess() {
		// TODO Auto-generated method stub
		
	}
}
