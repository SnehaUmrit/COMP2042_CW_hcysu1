package model;

import javafx.scene.image.Image;

public class Log extends Actor {

	
	public Log(int x, int y, int width,double speed) {
		super(x, y);
		
		switch(width) {
		case 150:
			setImage(new Image("file:res/Obstacles/log3.png", width,40,false,true));
			this.actorSpeed = speed;
			break;
		case 300:
			setImage(new Image("file:res/Obstacles/logs.png",width,40,false,true));
			this.actorSpeed = speed;
			break;
		}
	}

	@Override
	public void act() {
		move(actorSpeed,0);
		if (getX() > 600 && actorSpeed > 0)
			setX(-300);
		if (getX() < -300 && actorSpeed < 0) 
			setX(700);

	}
	
	
}
