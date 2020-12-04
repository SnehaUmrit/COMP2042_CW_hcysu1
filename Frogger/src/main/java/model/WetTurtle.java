package model;

import java.util.Random;

import javafx.scene.image.Image;

/**
 * Derived from Turtle class. <p>
 * Allows us to set the images for the wet turtles.
 * A sunk turtle is unsafe for the frog.
 * @author Amended from previous WetTurtle class
 *
 */
public class WetTurtle extends Turtle{

	private final Random sunk;
	private final Image[] wetTurtles;
	private boolean sinking = false;
	
	/**
	 * Determine the ratio at which the turtle changes states in order to show animation of safe and unsafe turtles
	 */
	private double occurrence;
	
	/**
	 * 
	 * @param x Set x position of wet turtle
	 * @param y Set y position of wet turtle
	 * @param speed Set speed at which wet turtle moves along the river
	 */
	public WetTurtle(int x, int y,double speed) {
		
		super(x, y,speed);
		actorSpeed = speed;
		this.wetTurtles = new Image[] {
				new Image("file:src/main/resources/Obstacles/TurtleAnimation2Wet.png", 127,47,false,true),
				new Image("file:src/main/resources/Obstacles/TurtleAnimation3Wet.png",127,47,false,true),
				new Image("file:src/main/resources/Obstacles/TurtleAnimation4Wet.png",127,47,false,true)
			};
		this.sunk = new Random();
		occurrence = 1;
		}
	
	/**
	 * 
	 * @return booleanExpression Returns true if the turtle is sunk/Returns false if the turtle is on the surface
	 */
	public boolean isSunk() {
		return sinking;
	}
	
	/**
	 * Uses checks from AnimatedObject to determine occurrence.
	 * Determine animation of turtle
	 */
	@Override
	public void act() {
		if (checks == 0) {
			occurrence = sunk.nextDouble();
		}
		if (occurrence < 0.15) {
			setAnimation(wetTurtles,40);
			sinking = true;
		} else {
			sinking = false;
			setAnimation(states,40);
		}
		move (actorSpeed,0);
		if (getX() < -75)
			setX(600);
		
	}
	
	
}
