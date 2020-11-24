package com.Frogger.View;

import com.Frogger.Controller.*;
import com.Frogger.Model.BackgroundImage;

import javafx.scene.layout.Pane;

public class GameView  extends Pane{
	
	public GameView() {
		
		int gameLevel = LevelController.getLevel();
		switch (gameLevel) {
		case 0:
			break;
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		}
	/*	if (LevelController.getLevel() == 0) {
			BackgroundImage gameBackground = new BackgroundImage("file:res/Background/backdroptry14.png");
			getChildren().add(gameBackground);			
		}*/
		

		BackgroundImage gameBackground = new BackgroundImage("file:res/Background/backdroptry16.png");
		getChildren().add(gameBackground);	
		
		getChildren().add(LevelController.getLevelView());
		getChildren().add(TimeController.getTimeView());
		getChildren().add(ScoreController.getScoreView());
		getChildren().add(LivesController.getLivesView());
		
		getChildren().addAll(LevelController.getStartingLevel());
		getChildren().addAll(EndController.getEnds());
		}
	
	
	

}
