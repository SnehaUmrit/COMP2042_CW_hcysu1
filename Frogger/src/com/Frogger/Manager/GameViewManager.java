package com.Frogger.Manager;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameViewManager {
	
	private MyStage gamePane;
	private Scene gameScene;
	private Stage gameStage;

	
	private static final int GAME_WIDTH = 600;
	private static final int GAME_HEIGHT = 800;
	
	private Stage menuStage;
	
	
	public GameViewManager() {
		initialiseStage();
	}


	private void initialiseStage() {
		gamePane = new MyStage();
		gameScene = new Scene(gamePane,GAME_WIDTH, GAME_HEIGHT);
		gameStage = new Stage();
		gameStage.setScene(gameScene);

	}
	
	public void createNewGame(Stage menuStage) {
		this.menuStage = menuStage;
		this.menuStage.hide();
		gameStage.show();
	}
	
}
