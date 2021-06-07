package model;

import javafx.scene.image.Image;

/**
 * Derived from IntersectingObject. Allows us to set the images representing the end.<p>
 * The ends are divided as safe and unsafe. A safe end is one where the frog can go to without any issues.
 * An unsafe end has a crocodile and if the frog hops into an unsafe end, then the player will lose a life.
 * Uses methods that allows us to determine whether an end is already occupied by a frog or whether an end is safe or not.
 * @author Amended from given End class
 *
 */
public class End extends IntersectingObject{
	
	private final Image emptyEnd = new Image("file:src/main/resources/Background/emptyend.png",58,53, false, true);
	private final Image fullEnd = new Image("file:src/main/resources/Background/fullend.png",60,57,false,true);
	private final Image crocodile = new Image("file:src/main/resources/Obstacles/croco_end.png",58,53,false,true);
	private boolean active;
	private boolean unsafe;
	
	/**
	 * Fix y position of ends
	 * Set images as empty ends
	 * Set ends as safe and free
	 * @param x Set x position of end
	 */
	public End(int x) {
		super(x,51);
		setImage(emptyEnd);
		active = unsafe = false;
	}
	
	/**
	 * 
	 * @return booleanExpression Returns true if the end already has a frog/ Returns false if the end is empty
	 *   
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * 
	 * @return booleanExpression Returns true if the end has a crocodile/Returns false if the end is empty
	 */
	public boolean isUnsafe() {
		return unsafe;
	}
	
	/**
	 * Activate the end as a frog reaches it.
	 * Changes the image and set active to true.
	 */
	public void activate() {
		setImage(fullEnd);
		active = true;
	}
	
	/**
	 * Used for creating new levels.
	 * Deactivate the ends.
	 * Change the images to empty ends and set active to false.
	 */
	public void deactivate() {
		setImage(emptyEnd);
		active = false;
	}
	
	/**
	 * Used to add a crocodile at the end.
	 * Changes the images and set unsafe to true.
	 */
	public void addCrocodile() {
		setImage(crocodile);
		unsafe = true;
	}
	
	/**
	 * Used to change the image of the end to an empty end.
	 * Also set unsafe to false.
	 */
	public void setEmpty() {
		setImage(emptyEnd);
		unsafe = false;
	}

}
