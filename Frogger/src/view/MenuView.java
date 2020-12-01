package com.Frogger.View;


import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.Frogger.Controller.HighscoreController;
import com.Frogger.Model.BackgroundImage;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class MenuView extends Pane {

	private final String FONT_PATH = "res/Font/Kenney Pixel.ttf";	
	public MenuView() {		
		LabelView scoreLabel = new LabelView(HighscoreController.getHighScores());
		scoreLabel.setLayoutX(0);
		scoreLabel.setLayoutY(0);	
		setTextFont(scoreLabel);
		scoreLabel.setStyle("-fx-text-fill: WHITE;");
		//getChildren().add(scoreLabel);
	}
	
	
	private void setTextFont(Label label) {
		try {
			label.setFont(Font.loadFont(new FileInputStream(FONT_PATH),45));
		} catch(FileNotFoundException e) {
			label.setFont(Font.font("Verdana",40));
		}
	}

		
		
	}


	
	

