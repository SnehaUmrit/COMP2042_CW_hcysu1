package com.Frogger.View;

import com.Frogger.Controller.*;
import com.Frogger.Model.BackgroundImage;

import javafx.scene.layout.Pane;

public class GameView  extends Pane{
	
	public GameView() {
		
		BackgroundImage gameBackground = new BackgroundImage("file:res/Background/backdroptry7.png");
		getChildren().add(gameBackground);
		
		getChildren().add(LevelController.getLevelView());
		getChildren().add(TimeController.getTimeView());
		getChildren().add(ScoreController.getScoreView());
		getChildren().add(LivesController.getLivesView());
		
		getChildren().addAll(LevelController.getStartingLevel());
		getChildren().addAll(EndController.getEnds());
		}
	
	
	

}
