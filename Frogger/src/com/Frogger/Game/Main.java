package com.Frogger.Game;





import com.Frogger.Controller.MenuController;

import javafx.application.Application;

import javafx.stage.Stage;
 
 
public class Main extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		//MenuController controller = new MenuController();
		//primaryStage = controller.getMainStage();
		//primaryStage.show();
		MenuController.setMainStage(primaryStage);
		MenuController.intialiseStage();
		
		
	}
	


	
}


/*
 * 	@Override
	public void start(Stage primaryStage) throws Exception {
	  ViewManager manager = new ViewManager();
	  primaryStage = manager.getMainStage();
	  primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
 
 */
