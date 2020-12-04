package model;

import java.util.ArrayList;
import java.util.List;

import controller.GameController;
import javafx.scene.image.ImageView;

/**
 * Derived from ImageView class and is a base class to Actor and AnimatedObject<p>
 * Uses method getIntersectingObject to check whether the actors are intersecting.
 * This allows us to determine the response of the frog in Animal class
 * @author Amended from previous class Actor
 *
 */
public class IntersectingObject extends ImageView{
	
	/**
	 * 
	 * @param x Set x position 
	 * @param y Set y position
	 */
	IntersectingObject(int x, int y){
		setX(x);
		setY(y);
	}
	
	/**
	 * 
	 * @return intersectingObject List of intersecting objects
	 */
	List<IntersectingObject> getIntersectingObjects(){
		ArrayList<IntersectingObject> objects = new ArrayList();
		for (IntersectingObject object : GameController.getObjects(IntersectingObject.class)) {
			if (object != this && object.intersects(this.getBoundsInLocal())) {
				objects.add(object);
			}
		}
		return objects;
	}

}
