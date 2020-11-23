package com.Frogger.Model;

import javafx.scene.image.Image;

public class Obstacle extends Actor {
	
	
	

	public Obstacle(int x, int y, String type) {
		super(x, y);
		int height = 35;
		switch (type) {
		case "race car":
			actorSpeed = -3;
			setImage(new Image("file:res/Obstacles/racecarleft.png",67,height,false,true));
			break;
		case "normal car":
			actorSpeed = -1;
			setImage(new Image("file:res/Obstacles/car1Left.png", 67,height,false,true));			
			break;
		case "short white truck":
			actorSpeed = 1;
			setImage(new Image("file:res/Obstacles/whitetruckright.png",180,height,false,true));
			break;

			
		case "long blue truck":
			actorSpeed = 1;
			setImage(new Image("file:res/Obstacles/truck2Right.png",180,height,false,true));
			break;
			
		case "tractor":
			actorSpeed = 2;
			setImage(new Image("file:res/Obstacles/tractorright.png",67,height,false,true));
			break;
			
		
		}
	}

    @Override
    public void act() {
        move(actorSpeed, 0);
        if (getX() > 600 && actorSpeed > 0)
            setX(-200);
        if (getX() < -50 && actorSpeed < 0)
            setX(600);
    }
	

}
