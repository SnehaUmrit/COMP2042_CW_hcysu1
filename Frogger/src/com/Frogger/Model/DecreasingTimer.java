package com.Frogger.Model;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class DecreasingTimer extends Actor{
	
	boolean keyPress;
	Rectangle rectangle;

	@Override
	public void act(long now) {}
	
	
	public DecreasingTimer() {
		getKeyStatus();
	}
	
	
	
	public boolean getKeyStatus() {
		setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.UP || event.getCode() == KeyCode.LEFT || event.getCode() == KeyCode.RIGHT) {
					keyPress = true;
				}
				
			}
			
			
		});
		return keyPress;
	}
	
	

}
