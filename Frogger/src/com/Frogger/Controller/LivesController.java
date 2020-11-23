package com.Frogger.Controller;

import com.Frogger.View.LivesView;

public class LivesController {
	
	private static LivesView livesView;
	private static int frogLives;
	
	public static int getFrogLives() {
		return frogLives;
	}
	
	public static LivesView getLivesView() {
		frogLives = 5;
		livesView = new LivesView(frogLives);
		return livesView;
	}
	
	public static void removeFrogLife() {
		livesView.getChildren().remove(LivesView.getFrogHearts()[frogLives - 1]);
		frogLives--;
	}

}
