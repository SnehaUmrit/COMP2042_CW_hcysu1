package com.Frogger.Model;

import java.util.Random;

import javafx.scene.image.Image;

public class WetTurtle extends Turtle{

	private final Random sunk;
	private final Image[] wetTurtleStates;
	private boolean sinking = false;
	private double chance;
	
	
	public WetTurtle(int x, int y) {
		
		super(x, y);
		this.wetTurtleStates = new Image[] {
				new Image("file:res/Obstacles/TurtleAnimation2Wet.png", 127,47,false,true),
				new Image("file:res/Obstacles/TurtleAnimation3Wet.png",127,47,false,true),
				new Image("file:res/Obstacles/TurtleAnimation4Wet.png",127,47,false,true)
			};
		this.sunk = new Random();
		chance = 1;
		}
	
	public boolean isSunk() {
		return sinking;
	}
	
	@Override
	public void act() {
		if (ticks == 0) {
			chance = sunk.nextDouble();
		}
		if (chance < 0.15) {
			animate(wetTurtleStates,40);
			sinking = true;
		} else {
			sinking = false;
			animate(states,40);
		}
		move (actorSpeed,0);
		if (getX() < -75)
			setX(600);
		
	}
	
	
}
