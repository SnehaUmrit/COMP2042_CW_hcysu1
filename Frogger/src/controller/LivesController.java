package controller;

import view.LivesView;

/**
 * 
 * Creates a static instance of LivesView to generate images representing lives of frog
 * @author hcysu1
 *
 */
public class LivesController {
	
	private static LivesView livesView;
	private static int frogLives;
	
	/**
	 * Set the number of lives for the frog
	 * @param number Represent the number of lives the player will be allocated
	 */
	public static void setFrogLives(int number) {
		frogLives = number;
	}
	
	
	/**
	 * 
	 * @return frogLives The number of lives the player has been allocated
	 */
	public static int getFrogLives() {
		return frogLives;
	}
	

	/**
	 * 
	 * @return livesView The images representing the lives of the frog
	 */
	public static LivesView getLivesView() {		
		setFrogLives(5);
		livesView = new LivesView(frogLives);
		return livesView;
	}
	
	/**
	 * Remove the last image from the array
	 */
	public static void removeFrogLife() {
		livesView.getChildren().remove(LivesView.getFrogHearts()[frogLives - 1]);
		frogLives--;
	}

}
