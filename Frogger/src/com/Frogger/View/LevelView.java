package com.Frogger.View;

import com.Frogger.Controller.LevelController;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class LevelView extends Pane{
	
	
	public LevelView() {
		setPrefWidth(200);
		setPrefHeight(40);
		setLayoutX(50);
		setLayoutY(50);
		
		Label currentLevelLabel = new Label("LEVEL:");
		currentLevelLabel.setLayoutX(0);
		currentLevelLabel.setLayoutY(10);

		Label currentLevel = new Label();
		currentLevel.textProperty().bind(LevelController.getLevelValue());	
		currentLevel.setLayoutX(250);
		currentLevel.setLayoutY(25);
		
		getChildren().addAll(new Label[] {
				currentLevelLabel,
				currentLevel
		});
		
		setStyle("-fx-background-color: gold;" +
                "-fx-font-size: 20px;" +
                "-fx-font-family: \"monospaced\";" +
                "-fx-text-fill: black;");
	}
	
	

}
