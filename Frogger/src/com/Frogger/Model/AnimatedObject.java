package com.Frogger.Model;

import javafx.scene.image.Image;

public abstract class AnimatedObject extends Actor{
	public final Image[] states;
	public int ticks = 0;
	
	public AnimatedObject(int x, int y, int width, int height, String[] spriteLocators) {
		super(x, y);
		this.states =new Image[spriteLocators.length];
		for(int i =0; i < states.length; i++) {
			states[i] = new Image(spriteLocators[i], width, height, false, true);
		}
	}
	
	public void animate(Image[] states, int speed) {
		ticks++;
		if (ticks/speed > states.length) {
			ticks = -1;
		}
		if (ticks > speed - 1 && ticks % speed == 0) {
			setImage(states[(ticks/speed) - 1]);
		}
		}
	
	

}
