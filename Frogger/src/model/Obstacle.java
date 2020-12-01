package model;

import javafx.scene.image.Image;

public class Obstacle extends Actor {
	
	public Obstacle(int x, int y, String type,double speed) {
		super(x, y);		

		switch (type) {
		
		case "race car":
			actorSpeed = speed;
			setImage(new Image("file:res/Obstacles/racecarleft.png",63,63,false,true));
			break;
		
		case "normal car":
			actorSpeed = speed;
			setImage(new Image("file:res/Obstacles/car1Left.png",45,35,false,true));			
			break;
	
		case "short white truck":

			actorSpeed = speed;
			setImage(new Image("file:res/Obstacles/whitetruckright.png",100,60,false,true));
			break;
		
		case "long blue truck":
			actorSpeed = speed;
			setImage(new Image("file:res/Obstacles/truck2Right.png",190,39,false,true));
			break;
			
		case "tractor":
			actorSpeed = speed;
			setImage(new Image("file:res/Obstacles/tractorright.png",70,60,false,true));
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
