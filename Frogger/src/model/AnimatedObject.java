package model;

import javafx.scene.image.Image;

/**
 * Derived from Actor class
 * @author hcysu1
 *
 */
public abstract class AnimatedObject extends Actor{
	public final Image[] states;
	public int ticks = 0;
	
	
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
		this.states =new Image[actorPaths.length];
		for(int i =0; i < states.length; i++) {
			states[i] = new Image(actorPaths[i], width, height, false, true);
		}
	}
	
	
	/**
	 * Allows us to set the different states of each actor as well as change their speed accordingly
	 * @param states The different states of animation of the actors
	 * @param speed The rate at which the different images are cycled
	 */
	public void animate(Image[] states, int speed) {
		ticks++;
		if (ticks/speed > states.length) {
			ticks = -1;
		}
		if (ticks > speed - 1 && ticks % speed == 0) {
			setImage(states[(ticks/speed) - 1]);
		}
	}
	
	

}
