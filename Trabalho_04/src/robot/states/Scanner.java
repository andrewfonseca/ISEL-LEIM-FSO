package robot.states;

import java.util.ArrayList;
import java.util.List;
import robot.MyRobotLego;

public abstract class Scanner extends Thread 
{
	protected final MyRobotLego robot;
	
	/* Scanner related variables, gets and sets */
	public final static int DEFAULT_DELAY = 50;
	
	protected int delay = DEFAULT_DELAY;													// How much time (ms) the scanner sleeps between each scan	
	protected boolean active = true;														// Determines if a scanner is active or not
	protected final int id;																	// Scanner identification
	protected final int port;																// Scanner port
	
	public int getDelay() { return this.delay; }
	public void setDelay(int delay) { this.delay = delay; }
	public boolean isActive() { return this.active; }
	public void deactivate() { this.active = false; }
	public int getPort() { return this.port; }
	
	protected abstract void setPort(int port);
	public abstract int scan();

	/* Who will listen to scanner's events */
	protected List<RobotNervousSystem> listeners = new ArrayList<RobotNervousSystem>();		// Objects listening to scanners events
	protected void addListener(RobotNervousSystem toAdd) { this.listeners.add(toAdd); }		// Add an object that wants to listen to events
	
	/* What each scanner will report */
	protected abstract void objectDetected();												// Event triggered when an object is detected
	
	protected void objectIsGone() {															// Event triggered when an object is no longer detected
		objectDetected = false;
		for(RobotNervousSystem listener : listeners)  {
			listener.ObjectIsGone();	
		}
	}													
	
	/* Scanner's event triggers */
	protected int objectDistance = 0;														// Object's distance reported by scan()
	protected boolean objectDetected = false;
	
	public Scanner(StateMachine machine, int id, int port) {
		this.robot = machine.getRobot();
		this.id = id;
		this.port = port;
		setPort(port);
		this.addListener(machine);
		this.start();
	}
	
	@Override
	public void run() {		
		if(!active) { this.interrupt(); }
		
		objectDistance = scan();
	}
}

interface RobotNervousSystem {																// Interface to be implemented that defines the events generated by a scanner
	void ObjectDetected(ActiveState state);
	void ObjectIsGone();
}