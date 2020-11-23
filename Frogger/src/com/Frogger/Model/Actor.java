package com.Frogger.Model;


public abstract class Actor extends IntersectingObject{
	
	int actorSpeed;
	
	public Actor(int x, int y) {
		super(x,y);
	}
	
	public void move(int dx, int dy) {
		setX(getX() + dx);
		setY(getY() + dy);
	}
	
	public abstract void act();

  

}
