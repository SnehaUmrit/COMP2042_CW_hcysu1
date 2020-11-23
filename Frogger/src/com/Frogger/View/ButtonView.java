package com.Frogger.View;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ButtonView extends Button{
	
	private final String FONT_PATH = "res/Font/Kenney_Future_Narrow.ttf";
	private final String BUTTON_PRESSED_STYLE = "-fx-background-color:transparent";
	private final String BUTTON_FREE_STYLE = "-fx-background-color:transparent";
	DropShadow drop;
	/**
	 * Constructor to call methods
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
	 * Method to set font of button
	 * if application cannot load FONT_PATH, then set to default font
	 */
	private void setButtonFont() {
		try {
			setFont(Font.loadFont(new FileInputStream(FONT_PATH),40));
		} catch(FileNotFoundException e) {
			setFont(Font.font("Verdana",40));
		}
	}
	
	private void setButtonPressedStyle() {
		setStyle(BUTTON_PRESSED_STYLE);
		//setPrefHeight(15);
		//setLayoutX(300);
		setLayoutY(getLayoutY()+5);
	}
	
	private void setButtonReleasedStyle() {
		setStyle(BUTTON_FREE_STYLE);
		//setPrefHeight(15);
		//setLayoutX(300);
		setLayoutY(getLayoutY()-5);
	}
	
	
	/**
	 * Method to listen to mouse events
	 * Nothing is done if mouse is right-clicked 
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
