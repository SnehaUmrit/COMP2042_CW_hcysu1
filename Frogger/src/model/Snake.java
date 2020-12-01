package model;

import java.util.Random;

public class Snake extends AnimatedObject {
	
	private final Random appearance = new Random();
	private boolean appear = true;

	public Snake(int x, int y, double speed) {
		super(x, y, 90, 25, new String[] {
				"file:res/Obstacles/snake1.png",
				"file:res/Obstacles/snake2.png",
				"file:res/Obstacles/snake3.png"
		});
		
		actorSpeed = speed;
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
