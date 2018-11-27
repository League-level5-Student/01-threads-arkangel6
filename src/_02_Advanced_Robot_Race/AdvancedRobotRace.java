package _02_Advanced_Robot_Race;

import org.jointheleague.graphical.robot.Robot;

public class AdvancedRobotRace {
	// Re-do the robot race recipe from level 3 module 0. 
	// This time, use threads to make all of the robots go at the same time.
	
	public static void main(String[] args) {
		
		Robot[] rArray = new Robot[5];
		for(int i = 0; i < 5; i++) {
			Robot r = new Robot(i*200+200,700);
			r.setSpeed(10);
			rArray[i] = r;
		}
		
		
		Thread r1 = new Thread(()->rArray[0].move(400));
		Thread r2 = new Thread(()->rArray[1].move(400));
		Thread r3 = new Thread(()->rArray[2].move(400));
		Thread r4 = new Thread(()->rArray[3].move(400));
		Thread r5 = new Thread(()->rArray[4].move(400));
		
		r1.start();
		r2.start();
		r3.start();
		r4.start();
		r5.start();
		
	}
}
