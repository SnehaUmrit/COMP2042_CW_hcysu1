package com.Frogger.View;

import com.Frogger.Controller.ScoreController;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class ScoreView extends Pane{
	
	public ScoreView() {
        setPrefWidth(350);
        setPrefHeight(50);
        setLayoutY(0);
		
        
        Label currentScoreLabel = new Label("SCORE");
        currentScoreLabel.setLayoutX(0);
        currentScoreLabel.setLayoutY(0);
        currentScoreLabel.setStyle("-fx-text-fill: aliceblue; -fx-font-weight: bold;");
		
        
        Label currentScore = new Label();
        currentScore.textProperty().bind(ScoreController.getBinding());
        currentScore.setLayoutX(0);
        currentScore.setLayoutY(40);
        currentScore.setStyle("-fx-text-fill: crimson; -fx-font-weight: bolder;");
        
        getChildren().addAll(new Label[]{
        		currentScoreLabel,
        		currentScore
        		
        });
        
        
        
        setStyle("-fx-font-size: 30px; -fx-font-family: \"monospaced\";");
	}
	
	

}
