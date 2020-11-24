package com.Frogger.Model;

public class SafeCrocodile extends AnimatedObject{

	public SafeCrocodile(int x, int y, double speed) {
		super(x, y, 210, 90, new String[] {
				"file:res/Obstacles/croco.png",
				"file:res/Obstacles/croco.png",
				"file:res/Obstacles/croco.png"
		});
		actorSpeed = speed;
		setImage(states[2]);
		
	}

	@Override
	public void act() {
		animate(states,50);
		move(actorSpeed,0);
		if (getX() > 600) {
			setX(-300);
		}
		
	}
	

}
