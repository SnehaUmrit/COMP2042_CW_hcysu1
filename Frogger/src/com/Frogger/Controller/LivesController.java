package com.Frogger.Controller;

import com.Frogger.View.LivesView;

public class LivesController {
	
	private static LivesView livesView;
	private static int frogLives;
	
	/**
	 * 
	 * @return 
	 */
	public static int getFrogLives() {
		return frogLives;
	}
	
	public static void setFrogLives(int number) {
		frogLives = number;
	}
	public static LivesView getLivesView() {		
		/*switch (LevelController.getLevel()) {
		case 0:			
			setFrogLives(5);
			break;
		case 1:
			setFrogLives(5);
			break;
		case 2:
			setFrogLives(5);
			break;
		case 3:
			setFrogLives(3);
			break;
		case 4:
			setFrogLives(3);
			break;
		}*/
		frogLives = 5;
		livesView = new LivesView(frogLives);
		return livesView;
	}
	
	public static void removeFrogLife() {
		livesView.getChildren().remove(LivesView.getFrogHearts()[frogLives - 1]);
		frogLives--;
	}

}
