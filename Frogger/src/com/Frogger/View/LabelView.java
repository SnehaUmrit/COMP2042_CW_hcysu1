package com.Frogger.View;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.text.Font;

public class LabelView extends Label{
	
	private  static final String FONT_PATH = "res/Font/Kenney_Future_Narrow.ttf";
	private static final String BACKGROUND_IMAGE = "file:res/Buttons/green_panel.png";

	
	public LabelView(String text) {
		setPrefWidth(450);
		setPrefHeight(220);
		setText(text);
		setWrapText(true);
		setLabelFont();
		setPadding(new Insets(10, 10, 10, 10));
		setAlignment(Pos.CENTER);
		
		BackgroundImage backgroundImage = new BackgroundImage(new Image(BACKGROUND_IMAGE,450,220, false, true), BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
		setBackground(new Background(backgroundImage));
				
	}
	
	
	
	private void setLabelFont() {
		try {
			setFont(Font.loadFont(new FileInputStream(FONT_PATH), 25));
		} catch (FileNotFoundException e) {
			setFont(Font.font("Verdana", 25));
		}
	}
		
}
	