package com.Frogger.Model;

import javafx.scene.image.Image;

public class Insect extends IntersectingObject{

	private boolean intersects = false;
	private final Image insect = new Image("file:res/Sprites/insect.png",20,20,false,true);
	private final Image bonus = new Image("file:res/Digits/100.png",20,10,true,false);
	
	
	public Insect(int x, int y) {
		super(x, y);
		setImage(insect);
	}

	public boolean isIntersecting() {
		return intersects;
	}
	
	public void intersect() {
		setImage(bonus);
		intersects = true;
		//wait for a few seconds and hide
	}
}
