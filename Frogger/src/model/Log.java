package model;

import javafx.scene.image.Image;


/**
 * Derived from Actor class <p>
 * Allows us to set the images of the log.
 * A log is used by the frog as a safe ride to cross the river.
 * The constructor allows us to set a fixed height for the log.
 * @author Amended from previous Log class
 *
 */
public class Log extends Actor {

	/**
	 * Set images of the logs based on the if condition which checks width
	 * @param x Set x position
	 * @param y Set y position
	 * @param width Set width of log
	 * @param speed Set speed of log
	 */
	public Log(int x, int y, int width,double speed) {
		super(x, y);
		
		if (width == 150) {
			setImage(new Image("file:res/Obstacles/log3.png", width,40,false,true));
			this.actorSpeed = speed;
		}		
		if (width == 300) {
			setImage(new Image("file:res/Obstacles/logs.png",width,40,false,true));
			this.actorSpeed = speed;
		}

	}

	@Override
	public void act() {
		move(actorSpeed,0);
		if (getX() > 600 && actorSpeed > 0)
			setX(-300);
		if (getX() < -300 && actorSpeed < 0) 
			setX(700);

	}
	
	
}
