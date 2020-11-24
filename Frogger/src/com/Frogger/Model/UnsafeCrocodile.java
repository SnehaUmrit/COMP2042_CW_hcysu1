package com.Frogger.Model;

import java.util.Random;

import javafx.scene.image.Image;

public class UnsafeCrocodile extends SafeCrocodile{

	private final Random random;
	private final Image[] unsafeCroc;
	private boolean open = false;
	private double chance;
	
	public UnsafeCrocodile(int x, int y, double speed) {
		super(x, y,speed);
		actorSpeed = speed;
		this.unsafeCroc = new Image[] {
				new Image("file:res/Obstacles/croco_open.png",210,90,false,true),
				new Image("file:res/Obstacles/croco_open.png",210,90,false,true),
				new Image("file:res/Obstacles/croco_open.png",210,90,false,true),
		};
		this.random = new Random();
		chance = 1;
	}
	
	public boolean isOpen() {
		return open;
	}
	
	@Override
	public void act() {
		if (ticks == 0) {
			chance = random.nextDouble();
		}
		if (chance < 0.15) {
			animate(unsafeCroc,40);
			open = true;
		} else {
			open = false;
			animate(states,40);
		}
		move(actorSpeed,0);
		if (getX() > 600)
			setX(-300);
		
	}
}
