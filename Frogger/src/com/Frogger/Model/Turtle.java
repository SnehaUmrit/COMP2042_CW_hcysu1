package com.Frogger.Model;


public class Turtle extends AnimatedObject{

	public Turtle(int x, int y) {
		super(x, y, 127, 47, new String[] {
				"file:res/Obstacles/TurtleAnimation1.png",
				"file:res/Obstacles/TurtleAnimation2.png",
				"file:res/Obstacles/TurtleAnimation3.png"
		});
		
		actorSpeed = -1;
		setImage(states[2]);
		
	}

	@Override
	public void act() {
		animate(states,50);
		move(actorSpeed,0);
		if (getX() < -75) {
			setX(600);
		}
		
	}


}
