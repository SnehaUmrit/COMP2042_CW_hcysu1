package com.Frogger.Model;

import javafx.scene.image.Image;

public class Insect extends IntersectingObject{

	private boolean intersects = false;
	private final Image insect = new Image("file:res/Sprites/insect.png",40,40,false,true);
	private final Image bonus = new Image("file:res/Digits/100.png",40,20,true,false);
	
	
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
	}
}
