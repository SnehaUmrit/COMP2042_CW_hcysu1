package com.Frogger.Model;

import java.util.Random;

public class Snake extends AnimatedObject {
	
	private final Random appearance = new Random();
	private boolean appear = true;

	public Snake(int x, int y) {
		super(x, y, 112, 44, new String[] {
				"file:res/Obstacles/snake1.png",
				"file:res/Obstacles/snake2.png",
				"file:res/Obstacles/snake3.png"
		});
		
		actorSpeed = -3;
		setImage(states[0]);
		}

	@Override
	public void act() {
		if (appear) {
			animate(states,10);
			move(actorSpeed,0);
		} else {
			double chance = appearance.nextDouble();
			if (chance < 0.002)
				appear = true;
		
		}
		
		if (getX() < -112) {
			setX(600);
			appear = false;
		}
		
	}
	
	
	

}
