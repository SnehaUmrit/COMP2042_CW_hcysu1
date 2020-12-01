package model;

/**
 * Class derived from Intersecting Object
 * Also acts as a base class for several other classes
 * @author hcysu1
 *
 */
public abstract class Actor extends IntersectingObject{
	
	public double actorSpeed;
	
	/**
	 * 
	 * @param x Determines the x position of the actor
	 * @param y Determines the y position of the actor
	 */
	public Actor(int x, int y) {
		super(x,y);
	}
	

	/**
	 * 
	 * @param x_movement Set the value for the x movement of the frog
	 * @param y_movement Set the value for the y movement of the frog
	 */
	public void move(double x_movement, double y_movement) {
		setX(getX() + x_movement);
		setY(getY() + y_movement);
	}

	public abstract void act();

}
