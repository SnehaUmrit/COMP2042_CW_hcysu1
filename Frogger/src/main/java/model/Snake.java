package model;

import java.util.Random;

/**
 * New class representing a snake that appears on the median depending on game levels. <p>
 * Allows us to set the images and speed of the snake.
 * Allows us to set the animation of the snake.
 * @author hcysu1
 *
 */
public class Snake extends AnimatedObject {
	
	/**
	 * Determines the ratio at which the snake appears on the median
	 */
	private final Random appearance = new Random();
	private boolean appear = true;

	/**
	 * 
	 * @param x Set the x position 
	 * @param y Set the y position 
	 * @param speed Set the speed at which the snake move across the median
	 */
	public Snake(int x, int y, double speed) {
		super(x, y, 90, 25, new String[] {
				"file:src/main/resources/Obstacles/snake1.png",
				"file:src/main/resources/Obstacles/snake2.png",
				"file:src/main/resources/Obstacles/snake3.png"
		});
		
		actorSpeed = speed;
		setImage(states[0]);
		}

	/**
	 * Uses setAnimation to set states and speed
	 */
	@Override
	public void act() {
		if (appear) {
			setAnimation(states,10);
			move(actorSpeed,0);
		} else {
			double chance = appearance.nextDouble();
			if (chance < 0.003)
				appear = true;		
		}		
		if (getX() < -112) {
			setX(600);
			appear = false;
		}
		
	}
	
	
	

}
