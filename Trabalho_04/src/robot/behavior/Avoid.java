package robot.behavior;
import robot.MyRobotLego;

public class Avoid extends Thread {
	private MyRobotLego robot;
	
	public static boolean ALIVE;
	public static boolean SCANNER;
	public static boolean REACTOR;
	
	public final static int BEHAVIOUR = 2;
	
	private final static int SCANNER_DELAY = 500;
	private final static int PORT = RobotLego.RobotLego.S_2;

	public Avoid(MyRobotLego robot) {
	    this.robot = robot;
	    Avoid.ALIVE = true;
	    Avoid.SCANNER = true;
	    Avoid.REACTOR = true;
	    robot.SetSensorTouch(PORT);
	    this.start();
	}

	public void run() {
		while(ALIVE) {
			if(scan()) react();
			sleepForAWhile(SCANNER_DELAY);
		}
	  
		this.interrupt();
	}
	
	public static void terminate() {
		ALIVE = false;
	}

	/**
	 * Use the touch sensor to check for collision
	 * @return if collision occurred
	 */
	public boolean scan() {
		return robot.Sensor(PORT) == 1 ? true : false;
	}
	
	/**
	 * Makes the robot avoid an obstacle
	 */
	public void react() {
		robot.Parar(true);
		robot.Reta(-20);
		robot.Parar(false);
		robot.CurvarEsquerda(0, 90);
		robot.Parar(false);
  	}

	  
	private void sleepForAWhile(int ms) {	  
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}