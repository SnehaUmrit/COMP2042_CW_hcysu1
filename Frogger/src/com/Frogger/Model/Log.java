package com.Frogger.Model;

import javafx.scene.image.Image;

public class Log extends Actor {

	
	public Log(int x, int y, int width) {
		super(x, y);
		switch(width) {
		case 147:
			setImage(new Image("file:res/Obstacles/log3.png", width,47,false,true));
			this.actorSpeed = 1;
			break;
		case 297:
			setImage(new Image("file:res/Obstacles/logs.png",width,47,false,true));
			this.actorSpeed = -2;
			break;
		}
	}

	@Override
	public void act() {
		move(actorSpeed,0);
		if (getX() > 600 && actorSpeed > 0)
			setX(-180);
		if (getX() < -300 && actorSpeed < 0) 
			setX(700);

	}
	
	
}
