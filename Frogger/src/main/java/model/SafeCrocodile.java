package model;

/**
 * New class representing a safe crocodile that can be used as a ride for the frog to cross the river.<p>
 * Allows us to set images of safe crocodiles which are crocodiles with closed mouths.
 * Allows us to set position and speed of crocodile.
 * @author hcysu1
 *
 */
public class SafeCrocodile extends AnimatedObject{

	/**
	 * 
	 * @param x Set x position of crocodile
	 * @param y Set y position of crocodile
	 * @param speed Set speed at which the crocodile moves
	 */
	public SafeCrocodile(int x, int y, double speed) {
		super(x, y, 210, 90, new String[] {
				"file:src/main/resources/Obstacles/croco.png",
				"file:src/main/resources/Obstacles/croco.png",
				"file:src/main/resources/Obstacles/croco.png"
		});
		actorSpeed = speed;
		setImage(states[2]);
		
	}

	/**
	 * Uses setAnimation to set the states and speed of animation
	 */
	@Override
	public void act() {
		setAnimation(states,50);
		move(actorSpeed,0);
		if (getX() > 600) {
			setX(-300);
		}
		
	}
	

}
