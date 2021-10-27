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
	private boolean requirementSatisfied = false;
	private boolean errorDetected = false;

	//TODO: use @BeforeEach, didn't work for some reason last time
	public void resetValues() {
		requirementSatisfied = false;
		errorDetected = false;
		System.out.println("[NetworkMonitorTest] Resetting values");
	}

    @Test
	public void testNetworkRequirementSatisfied() {
    	resetValues();
		Specification specification = new Specification();
		specification.listAutomatas();
		IClock clock = new Clock();
		IMonitor monitor = new Monitor(specification.getAutomata().get(0), clock, this);
		
		for (int i = 0; i < 1; i++) {
        	System.out.println("[Computer] Tries: " + (i + 1));
        	monitor.update("computer", "computer", "login", new String[] {}, false);
        	monitor.update("computer", "server", "attemptLogin", new String[] {}, false);
        }
		
		try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        monitor.update("server", "computer", "logoutUser", new String[] {}, false);
        monitor.update("server", "computer", "lockComputer", new String[] {}, false);
		
		Assertions.assertTrue(monitor.goodStateReached());
		Assertions.assertTrue(monitor.requirementSatisfied());
		Assertions.assertTrue(requirementSatisfied);
		Assertions.assertFalse(errorDetected);
	}
    
    @Test
	public void testNetworkRequirementSatisfiedTwice() {
    	resetValues();
    	System.out.println("Twice ---------------------------------------------------------------------------");
		Specification specification = new Specification();
		specification.listAutomatas();
		IClock clock = new Clock();
		IMonitor monitor = new Monitor(specification.getAutomata().get(0), clock, this);

		for (int i = 0; i < 2; i++) {
        	System.out.println("[Computer] Tries: " + (i + 1));
        	monitor.update("computer", "computer", "login", new String[] {}, false);
        	monitor.update("computer", "server", "attemptLogin", new String[] {}, false);
        }
		
		try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        monitor.update("server", "computer", "logoutUser", new String[] {}, false);
        monitor.update("server", "computer", "lockComputer", new String[] {}, false);
        
		Assertions.assertTrue(monitor.goodStateReached());
		Assertions.assertTrue(monitor.requirementSatisfied());
		Assertions.assertTrue(requirementSatisfied);
		Assertions.assertFalse(errorDetected);
		System.out.println("Twice --------------------------------------------------------------------------- END");
	}
    
    @Test
	public void testNetworkRequirementSatisfiedThreeTimes() {
		resetValues();
    	System.out.println("Three times ---------------------------------------------------------------------------");
		Specification specification = new Specification();
		specification.listAutomatas();
		IClock clock = new Clock();
		IMonitor monitor = new Monitor(specification.getAutomata().get(0), clock, this);

		for (int i = 0; i < 3; i++) {
        	System.out.println("[Computer] Tries: " + (i + 1));
        	monitor.update("computer", "computer", "login", new String[] {}, false);
        	monitor.update("computer", "server", "attemptLogin", new String[] {}, false);
        }
		
		try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        monitor.update("server", "computer", "logoutUser", new String[] {}, false);
        monitor.update("server", "computer", "lockComputer", new String[] {}, false);
        
		Assertions.assertTrue(monitor.goodStateReached());
		Assertions.assertTrue(monitor.requirementSatisfied());
		Assertions.assertTrue(requirementSatisfied);
		Assertions.assertFalse(errorDetected);
		System.out.println("Three times --------------------------------------------------------------------------- END");
	}
    
    @Test
	public void testNetworkRequirementSatisfiedFourTimes() {
    	resetValues();
    	System.out.println("Four times ---------------------------------------------------------------------------");
		Specification specification = new Specification();
		specification.listAutomatas();
		IClock clock = new Clock();
		IMonitor monitor = new Monitor(specification.getAutomata().get(0), clock, this);

		for (int i = 0; i < 4; i++) {
        	System.out.println("[Computer] Tries: " + (i + 1));
        	monitor.update("computer", "computer", "login", new String[] {}, false);
        	monitor.update("computer", "server", "attemptLogin", new String[] {}, false);
        }
		
		try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        monitor.update("server", "computer", "logoutUser", new String[] {}, false);
        monitor.update("server", "computer", "lockComputer", new String[] {}, false);
        
		Assertions.assertFalse(monitor.goodStateReached());
		Assertions.assertFalse(monitor.requirementSatisfied());
		Assertions.assertFalse(requirementSatisfied);
		Assertions.assertTrue(errorDetected);
		System.out.println("Four times --------------------------------------------------------------------------- END");
	}
    
    @Test
	public void testNetworkAltTrueCase() {
    	resetValues();
		Specification specification = new Specification();
		specification.listAutomatas();
		IClock clock = new Clock();
		IMonitor monitor = new Monitor(specification.getAutomata().get(0), clock, this);

		for (int i = 0; i < 2; i++) {
        	System.out.println("[Computer] Tries: " + (i + 1));
        	monitor.update("computer", "computer", "login", new String[] {}, false);
        	monitor.update("computer", "server", "attemptLogin", new String[] {}, false);
        }
		
		try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		monitor.update("computer", "server", "checkEmail", new String[] {}, false);
		monitor.update("computer", "server", "newEmail", new String[] {"receiver", "subject"}, false);
		
		Assertions.assertTrue(monitor.goodStateReached());
		Assertions.assertFalse(monitor.requirementSatisfied());
		Assertions.assertFalse(requirementSatisfied);
		Assertions.assertFalse(errorDetected);
	}

	@Test
	public void testNetworkAltTrueCaseSatisfied() {
		System.out.println("True case satisfied ---------------------------------------------------------------------------");
    	resetValues();
		Specification specification = new Specification();
		specification.listAutomatas();
		IClock clock = new Clock();
		IMonitor monitor = new Monitor(specification.getAutomata().get(0), clock, this);

		for (int i = 0; i < 2; i++) {
        	System.out.println("[Computer] Tries: " + (i + 1));
        	monitor.update("computer", "computer", "login", new String[] {}, true);
        	monitor.update("computer", "server", "attemptLogin", new String[] {}, true);
        }
		
		try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		monitor.update("computer", "server", "checkEmail", new String[] {}, true);
		monitor.update("computer", "server", "newEmail", new String[] {"receiver", "subject"}, true);
		System.out.println("True case satisfied --------------------------------------------------------------------------- END");
		
		Assertions.assertTrue(monitor.goodStateReached());
		Assertions.assertFalse(monitor.requirementSatisfied());
		Assertions.assertFalse(requirementSatisfied);
		Assertions.assertFalse(errorDetected);
	}
    
    @Test
   	public void testNetworkLogoutTooFast() {
    	resetValues();
   		Specification specification = new Specification();
   		specification.listAutomatas();
   		IClock clock = new Clock();
   		IMonitor monitor = new Monitor(specification.getAutomata().get(0), clock, this);
   		
   		for (int i = 0; i < 2; i++) {
        	System.out.println("[Computer] Tries: " + (i + 1));
        	monitor.update("computer", "computer", "login", new String[] {}, false);
        	monitor.update("computer", "server", "attemptLogin", new String[] {}, false);
        }
		
		try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        monitor.update("server", "computer", "logoutUser", new String[] {}, false);
        monitor.update("server", "computer", "lockComputer", new String[] {}, false);
   		
   		Assertions.assertFalse(monitor.goodStateReached());
   		Assertions.assertFalse(monitor.requirementSatisfied());
   		Assertions.assertFalse(requirementSatisfied);
		Assertions.assertTrue(errorDetected);
   	}
    
    @Test
   	public void testNetworkLogoutConstrait() {
    	resetValues();
   		Specification specification = new Specification();
   		specification.listAutomatas();
   		IClock clock = new Clock();
   		IMonitor monitor = new Monitor(specification.getAutomata().get(0), clock, this);
 		
   		for (int i = 0; i < 2; i++) {
        	System.out.println("[Computer] Tries: " + (i + 1));
        	monitor.update("computer", "computer", "login", new String[] {}, false);
        	monitor.update("computer", "server", "logout", new String[] {}, false);
        	monitor.update("computer", "server", "attemptLogin", new String[] {}, false);
        }
		
		try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        monitor.update("server", "computer", "logoutUser", new String[] {}, false);
        monitor.update("server", "computer", "lockComputer", new String[] {}, false);
   		
   		Assertions.assertFalse(monitor.goodStateReached());
   		Assertions.assertFalse(monitor.requirementSatisfied());
   		Assertions.assertFalse(requirementSatisfied);
		Assertions.assertTrue(errorDetected);
   	}

    @Override
	public void receiveMonitorStatus(String message) {
		System.out.println("[NetworkMonitorTest]Received status from monitor: " + message);
	}

    @Override
	public void receiveMonitorError(String actualMessage, String lastAcceptedMessage) {
		System.out.println("[NetworkMonitorTest] Received error report from Monitor for " + actualMessage + " message.");
		System.out.println("Last accepted message was: " + lastAcceptedMessage);
		errorDetected = true;
	}

	@Override
	public void receiveMonitorSuccess() {
		System.out.println("[NetworkMonitorTest] Monitor reported that the requirement was satisfied");
		requirementSatisfied = true;
	}
}
