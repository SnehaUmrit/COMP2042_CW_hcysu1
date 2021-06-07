package model;

import javafx.scene.image.Image;

/**
 * New class that extends IntersectingObject.<p>
 * Added to set the attributes and implements methods for the purple frog.
 * 
 * @author hcysu1
 *
 */
public class PurpleFrog extends IntersectingObject {

	private boolean intersects = false;
	
	private final Image purpleFrog = new Image("file:src/main/resources/Sprites/purplefrogUp.png",35,35,false,false);
	
	/**
	 * Allows us to set image
	 * @param x
	 * @param y
	 */
	public PurpleFrog(int x, int y) {
		super(x, y);
		setImage(purpleFrog);
		
	}

	/**
	 * 
	 * @return booleanExpression Returns true if the player intersects with the purple frog
	 */
	public boolean isIntersecting() {
		return intersects;
	}
	
	
	/**
	 * Once the player intersects with the purple frog, the image is set to null.
	 */
	public void intersect() {
		setImage(null);
		intersects = true;
		
	}
	
	
	
}
