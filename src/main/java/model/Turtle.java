package model;

/**
 * Class representing a safe turtle.<p>
 * Allows us to set the images of the turtle.
 * Allows us to set the animation and speed of the animation.
 * @author Amended from given Turtle class.
 *
 */
public class Turtle extends AnimatedObject{

	/**
	 * 
	 * @param x Set the x position of the turtle
	 * @param y Set the y position of the turtle
	 * @param speed Set the speed at which the turtle moves across the river
	 */
	public Turtle(int x, int y,double speed) {
		super(x, y, 127, 47, new String[] {
				"file:src/main/resources/Obstacles/TurtleAnimation1.png",
				"file:src/main/resources/Obstacles/TurtleAnimation2.png",
				"file:src/main/resources/Obstacles/TurtleAnimation3.png"
		});
		
		actorSpeed = speed;
		setImage(states[2]);
		
	}

	/**
	 * Uses setAnimation to set the animation states and the speed of animation
	 */
	@Override
	public void act() {
		setAnimation(states,50);
		move(actorSpeed,0);
		if (getX() < -75) {
			setX(600);
		}
		
	}


}
