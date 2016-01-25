package robot.states;

import robot.MyRobotLego;

public final class Escape extends ActiveState {
	public static final int ID = 5;
	
	/* Robot relative speeds */
	public final static int MIN_SPEED = 30;
	public final static int MAX_SPEED = 100;
	
	int[] range = new int[2];																			// Robot's safe distance from the detected object
	int objectDistance;
	
	public Escape(MyRobotLego robot, BackScanner scanner, int[] range) {
		super(robot, scanner, ID);
		this.objectDistance = scanner.scan();
		this.range = range;
		this.weight = 1;
	}
	
	@Override
	public void run() {
		while(objectDistance > range[0] && objectDistance < range[1]) {
			super.run();
			
			action();
			objectDistance = scanner.scan();
			
			delay = MyRobotLego.calculateMovementDelay(robot.getSpeed(), range[1] - objectDistance);
			loopDelay();
		}
		
		robot.Parar(false);
	}

	@Override
	public void action() {						
		int relativeDistance = objectDistance - range[0];
		
		int speed = MAX_SPEED - (relativeDistance * 100 / range[1]);
		
		if(speed < MIN_SPEED) speed += MIN_SPEED - speed;
		
		robot.SetSpeed(speed);
		robot.Reta(range[1] - objectDistance);
		System.out.println("Escape " + "Speed: " + speed + " Distance: " + (range[1] - objectDistance));
	}

}
