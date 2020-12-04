package view;

import controller.*;
import javafx.scene.layout.Pane;
import model.BackgroundImage;

/**
 * New class that extends Pane and uses constructor to set the game views. <p>
 * Allows us to set the background of the game.
 * Allows us to add to the game the various other views using the controller classes
 * @author hcysu1
 *
 */
public class GameView  extends Pane{
	

	public GameView() {
		BackgroundImage gameBackground = new BackgroundImage("file:src/main/resources/Background/backdroptry16.png");
		getChildren().add(gameBackground);	
		
		getChildren().add(LevelController.getLevelView());
		getChildren().add(TimeController.getTimeView());
		getChildren().add(ScoreController.getScoreView());
		getChildren().add(LivesController.getLivesView());
		
		getChildren().addAll(LevelController.getStartingLevel());

		getChildren().addAll(EndController.getEnds());
		}
	
	
	

}