package robot.states;

import robot.MyRobotLego;

/**
 * A state to be used by the Robot
 * @author affonseca
 *
 */
public abstract class State extends Thread 
{
	protected final MyRobotLego robot;

	/* State related variables, gets and sets */
	public final static int DEFAULT_DELAY = 500;
	
	protected int delay = DEFAULT_DELAY;													// How much time (ms) the state sleeps between each action
	protected boolean active = true;
	protected final int id;
	
	public int getDelay() { return this.delay; }
	public void setDelay(int delay) { this.delay = delay; }
	public boolean isActive() { return this.active; }
	public void deactivate() { this.active = false; }
	
	/* Action to be performed by each state */
	public abstract void action();															// What the state will do
	
	public State(MyRobotLego robot, int id) {
		this.robot = robot;
		this.id = id;
		this.start();
	}
	
	@Override
	public void run() {		
		if(!active) this.interrupt();
	}
	
	protected void loopDelay() {
		try { Thread.sleep(delay); }
		catch (InterruptedException e) { }
	}
	
}