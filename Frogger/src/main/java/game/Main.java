package game;

import controller.MenuController;
import javafx.application.Application;

import javafx.stage.Stage;
  
/**
 * Main Class extends Application. <p>
 * Uses MenuController to call method setMainStage which takes primaryStage as parameter.
 * 
 * @author Amended from given Main class
 *
 */
public class Main extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		MenuController.setMainStage(primaryStage);
		MenuController.intialiseStage();
	
	}
	
}

