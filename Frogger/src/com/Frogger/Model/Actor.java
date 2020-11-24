package com.Frogger.Model;


public abstract class Actor extends IntersectingObject{
	
	public double actorSpeed;
	
	public Actor(int x, int y) {
		super(x,y);
	}
	
	public void move(double dx, double dy) {
		setX(getX() + dx);
		setY(getY() + dy);
	}
	
	public abstract void act();

}
