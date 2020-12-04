package model;

import javafx.scene.image.Image;

/**
 * New class derived from Actor class
 * <p>
 * Allows us to set the animation of the different actors and set their state and speed easily by calling method setAnimation
 * @author hcysu1
 *
 */
public abstract class AnimatedObject extends Actor{
	/**
	 * Array of images representing the states of the actors
	 */
	public final Image[] states;	
	/**
	 * Set to zero when the frog is moving without getting hit or sinking
	 * If a car hits the frog or the frog is sunk, then checks is set to -1
	 * This leads to a deduction in score and also resets the progress bar
	 */
	public int checks = 0;
	
	
	/**
	 * 
	 * @param x Set x position of the actor
	 * @param y Set y position of the actor
	 * @param width Set width of actor
	 * @param height Set height of actor
	 * @param actorPaths Allows us to set the path of the required image of different actors
	 */
	public AnimatedObject(int x, int y, int width, int height, String[] actorPaths) {
		super(x, y);
		this.states = new Image[actorPaths.length];
		for(int i =0; i < states.length; i++) {
			states[i] = new Image(actorPaths[i], width, height, false, true);
		}
	}
	
	
	/**
	 * Allows us to set the different states of each actor as well as change their speed 
	 * @param states The different states of animation of the actors
	 * @param speed The rate at which the different images are cycled
	 */
	public void setAnimation(Image[] states, int speed) {
		checks++;
		if (checks/speed > states.length) {
			checks = -1;
		}
		if (checks > speed - 1 && checks % speed == 0) {
			setImage(states[(checks/speed) - 1]);
		}
	}
	
	

}
