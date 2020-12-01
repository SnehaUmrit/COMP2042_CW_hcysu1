package view;

import controller.*;
import javafx.scene.layout.Pane;
import model.Animal;
import model.BackgroundImage;

public class GameView  extends Pane{
	
	public GameView() {
		


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