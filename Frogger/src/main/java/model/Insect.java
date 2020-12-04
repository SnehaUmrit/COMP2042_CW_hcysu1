package model;

import javafx.scene.image.Image;

/**
 * New class derived from IntersectingObject to set an insect as a bonus for the frog. <p>
 * Allows us to set the image for the insect.
 * @author hcysu1
 *
 */
public class Insect extends IntersectingObject{

	private boolean intersects = false;
	private final Image insect = new Image("file:src/main/resources/Sprites/insect.png",20,20,false,true);

	/**
	 * 
	 * @param x Set x position
	 * @param y Set y position
	 */
	public Insect(int x, int y) {
		super(x, y);
		setImage(insect);
	}

	/**
	 * 
	 * @return booleanExpression Returns true if the frog intersects with the bonus
	 */
	public boolean isIntersecting() {
		return intersects;
	}
	
	/**
	 * Once the frog insects the insect, we set the image to null.
	 * We also set intersects to true.
	 */
	public void intersect() {
		setImage(null);
		intersects = true;
		
	}
}
