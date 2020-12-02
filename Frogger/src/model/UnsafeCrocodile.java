package model;

import java.util.Random;

import javafx.scene.image.Image;

/**
 * New class derived from SafeCrocodile. <p>
 * Allows us to set the images of the unsafe crocodile.
 * A crocodile with an open mouth is deemed as unsafe and will cause a loss of life in case the frog hops on it.
 * @author hcysu1
 *
 */
public class UnsafeCrocodile extends SafeCrocodile{

	private final Random openMouth;
	private final Image[] unsafeCrocs;
	private boolean open = false;
	/**
	 * Determines the ratio at which the crocodile changes states in order to show images of safe crocodile and unsafe crocodile.
	 */
	private double occurrence;
	
	/**
	 * 
	 * @param x Set x position
	 * @param y Set y position
	 * @param speed Set speed of crocodile
	 */
	public UnsafeCrocodile(int x, int y, double speed) {
		super(x, y,speed);
		actorSpeed = speed;
		this.unsafeCrocs = new Image[] {
				new Image("file:res/Obstacles/croco_open.png",210,90,false,true),
				new Image("file:res/Obstacles/croco_open.png",210,90,false,true),
				new Image("file:res/Obstacles/croco_open.png",210,90,false,true),
		};
		this.openMouth = new Random();
		occurrence = 1;
	}
	
	/**
	 * 
	 * @return booleanExpression Returns true if the mouth of the crocodile is open/Returns false if the mouth of the crocodile is closed
	 */
	public boolean isOpen() {
		return open;
	}
	
	/**
	 * Uses checks from AnimatedObject to determine occurrence.
	 * Determine animation of crocodile from safe to unsafe and vice-versa.
	 */
	@Override
	public void act() {
		if (checks == 0) {
			occurrence = openMouth.nextDouble();
		}
		if (occurrence < 0.15) {
			setAnimation(unsafeCrocs,40);
			open = true;
		} else {
			open = false;
			setAnimation(states,40);
		}
		move(actorSpeed,0);
		if (getX() > 600)
			setX(-300);
		
	}
}
