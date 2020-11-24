package com.Frogger.Model;

import javafx.scene.image.Image;

public class End extends IntersectingObject{
	private final Image emptyEnd = new Image("file:res/Background/emptyend.png",58,53, false, true);
	private final Image fullEnd = new Image("file:res/Background/fullend.png",60,57,false,true);
	private final Image crocodile = new Image("file:res/Obstacles/croco_end.png",58,53,false,true);
	private boolean active;
	private boolean unsafe;
	
	public End(int x) {
		super(x,51);
		setImage(emptyEnd);
		active = unsafe = false;
	}
	
	
	public boolean isActive() {
		return active;
	}

	public boolean isUnsafe() {
		return unsafe;
	}
	
	public void activate() {
		setImage(fullEnd);
		active = true;
	}
	
	public void deactivate() {
		setImage(emptyEnd);
		active = false;
	}
	
	public void makeUnsafe() {
		setImage(crocodile);

		unsafe = true;
	}
	
	public void free() {
		setImage(emptyEnd);
		unsafe = false;
	}

}
