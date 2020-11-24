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
		MenuController.setMainStage(primaryStage);
		MenuController.intialiseStage();
	
	}
	
}

