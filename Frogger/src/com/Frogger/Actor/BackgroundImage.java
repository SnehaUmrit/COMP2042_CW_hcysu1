package com.Frogger.Actor;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BackgroundImage extends Actor {
	
	public BackgroundImage(String imageLink) {
		setImage(new Image(imageLink, 600, 800, true, true));
	}
	
	public BackgroundImage(String imageLink, int width, int height) {
		setImage(new Image(imageLink, width, height, false, true));
	}

	@Override
	public void act(long now) {}
}
