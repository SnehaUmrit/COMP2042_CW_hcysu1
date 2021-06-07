package view;

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

/**
 * New class that extends Label. <p>
 * Used as score and help label in the menu sub scenes.
 * Allows us to set the image and font to the labels.
 * @author hcysu1
 *
 */
public class LabelView extends Label{
	

	private  static final String FONT_PATH = "src/main/resources/Font/Kenney Pixel.ttf";
	private static final String BACKGROUND_IMAGE = "file:src/main/resources/Buttons/green_button13.png";

	/**
	 * Set the width and height 
	 * @param text Takes in the header for the sub scene
	 */
	public LabelView(String text) {
		setPrefWidth(400);
		setPrefHeight(50);
		setText(text);
		setWrapText(true);
		setLabelFont();
		setPadding(new Insets(10, 10, 10, 10));
		setAlignment(Pos.CENTER);
		
		BackgroundImage backgroundImage = new BackgroundImage(new Image(BACKGROUND_IMAGE,400,50, false, true), BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
		setBackground(new Background(backgroundImage));
				
	}
	
	
	/**
	 * Uses try/catch to set text font
	 * If the font file is not found then, the font is set to an available font
	 */
	private void setLabelFont() {
		try {
			setFont(Font.loadFont(new FileInputStream(FONT_PATH), 35));
		} catch (FileNotFoundException e) {
			setFont(Font.font("Verdana", 35));
		}
	}
		
}
	