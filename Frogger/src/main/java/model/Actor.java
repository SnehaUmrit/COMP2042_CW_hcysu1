package model;

/**
 * Class derived from Intersecting Object and also acts as a base class for several other classes <p>
 * Allows us to use the methods to set the position of the actors and the movement of the frog.
 * Also uses an abstract method act to set the actions of the frog in Animal class
 * @author Amended from given Actor class
 *
 */
public abstract class Actor extends IntersectingObject{
	
	/**
	 * Variable of type double that allows us to set the speed of different actors distinctly
	 */
	public double actorSpeed;
	
	/**
	 * Allows us to set the x and y position of the actor
	 * @param x Determines the x position of the actor
	 * @param y Determines the y position of the actor
	 */
	public Actor(int x, int y) {
		super(x,y);
	}
	

	/**
	 * Allows us to set the movement of the actor
	 * @param x movement Set the value for the x movement of the frog
	 * @param y movement Set the value for the y movement of the frog
	 */
	public void move(double dx, double dy) {
		setX(getX() + dx);
		setY(getY() + dy);
	}

	public abstract void act();

}
