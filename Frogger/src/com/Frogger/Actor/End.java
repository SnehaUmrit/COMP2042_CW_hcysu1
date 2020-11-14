package com.Frogger.Actor;

import javafx.scene.image.Image;

public class End extends Actor{
	boolean activated = false;
	@Override
	public void act(long now) {
		// TODO Auto-generated method st
	}
	
	/**
	 * Parameters used to set size of image
	 * @param x  
	 * @param y
	 */
	public End(int x, int y) {
		setX(x);
		setY(y);
		setImage(new Image("file:res/Background/endtry2.png", 60, 60, true, true));
	}
	
	public void setEnd() {
		setImage(new Image("file:res/Background/froendtry2.png", 65, 65, true, true));
		activated = true;
	}
	
	public boolean isActivated() {
		return activated;
	}
	

}
