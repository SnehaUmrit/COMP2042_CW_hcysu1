package com.Frogger.View;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.Frogger.Controller.ScoreController;

import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ScoreView extends Pane{
	
	private final String FONT_PATH = "res/Font/Kenney Pixel.ttf";	
	private DropShadow drop;
	
	public ScoreView() {

        Label currentScore = new Label();
        currentScore.textProperty().bind(ScoreController.getBinding());
        currentScore.setLayoutX(317);
        currentScore.setLayoutY(2.5);
        setScoreFont(currentScore);
        currentScore.setStyle("-fx-text-fill: YELLOW;");
        setShadow(currentScore);
        getChildren().addAll(currentScore);
 
	}
	
	
	private void setScoreFont(Label label) {
		try {
			label.setFont(Font.loadFont(new FileInputStream(FONT_PATH),45));
		} catch(FileNotFoundException e) {
			label.setFont(Font.font("Verdana",40));
		}
	}
	
	private void setShadow(Label label) {
		drop = new DropShadow();
		drop.setRadius(20);
		drop.setColor(Color.DEEPPINK);
		label.setEffect(drop);
	}
	

}
