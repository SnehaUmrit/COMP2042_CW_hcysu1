package com.Frogger.View;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.Frogger.Controller.LevelController;

import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class LevelView extends Pane{
	private final String FONT_PATH = "res/Font/Kenney Pixel.ttf";	
	private DropShadow drop;
	
	public LevelView() {

		Label currentLevel = new Label();
		currentLevel.textProperty().bind(LevelController.getLevelValue());	
		currentLevel.setLayoutX(135);
		currentLevel.setLayoutY(2.5);
		setLevelFont(currentLevel);
		currentLevel.setStyle("-fx-text-fill: YELLOW;");
		setShadow(currentLevel);
		getChildren().add(currentLevel);

	}
	
	
	private void setLevelFont(Label label) {
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
