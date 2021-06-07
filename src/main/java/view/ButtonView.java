package view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * New class to set the style for the buttons in main menu. <p>
 * Load the font used for the buttons.
 * Background colour of button is set to transparent.
 * @author hcysu1
 *
 */
public class ButtonView extends Button{
	
	
	private final String FONT_PATH = "src/main/resources/Font/Kenney Pixel.ttf";
	private final String BUTTON_PRESSED_STYLE = "-fx-background-color:transparent;";
	private final String BUTTON_FREE_STYLE = "-fx-background-color: transparent;"; 
	DropShadow drop;
	
	
	/**
	 * Set width and height
	 * @param text
	 */
	public ButtonView(String text) {	
		setText(text);
		setTextFill(Color.WHITE);
		setButtonFont();	
		setPrefWidth(290);
		setPrefHeight(40);
		drop = new DropShadow();
		drop.setColor(Color.BLACK);
		drop.setRadius(10);
		setEffect(drop);
		setStyle(BUTTON_FREE_STYLE);
		initialiseButtonListeners();
	}
	
	/**
	 * Uses try/catch to set text font
	 * If the font file is not found then, the font is set to a default font
	 */
	private void setButtonFont() {
		try {
			setFont(Font.loadFont(new FileInputStream(FONT_PATH),60));
		} catch(FileNotFoundException e) {
			setFont(Font.font("Verdana",40));
		}
	}
	
	/**
	 * Set layout for button when pressed
	 * When the button is pressed, it moves downwards slightly
	 */
	private void setButtonPressedStyle() {
		setStyle(BUTTON_PRESSED_STYLE);
		setPrefHeight(100);
		setLayoutY(getLayoutY()+5);
	}
	
	/**
	 * Set layout for button when released
	 * When the button is released, it should move back to its original position
	 */
	private void setButtonReleasedStyle() {
		setStyle(BUTTON_FREE_STYLE);
		setPrefHeight(100);
		setLayoutY(getLayoutY()-5);
	}
	
	
	/**
	 * Listen to mouse events
	 * Nothing is done if mouse is right-clicked 
	 * Add shadow effect when mouse hovers over button
	 */
	private void initialiseButtonListeners() {
		setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(event.getButton().equals(MouseButton.PRIMARY)) {
					setButtonPressedStyle();
				}
			}			
		});
		
		setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(event.getButton().equals(MouseButton.PRIMARY)) {
					setButtonReleasedStyle();
				}
			}			
		});
		
		setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				drop = new DropShadow();
				drop.setColor(Color.WHITE);
				drop.setRadius(10);
				setEffect(drop);
				
			}			
		});
		
		setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				drop = new DropShadow();
				drop.setColor(Color.BLACK);
				drop.setRadius(10);
				setEffect(drop);
				
			}			
		});
				
	}
	
	
	
}
