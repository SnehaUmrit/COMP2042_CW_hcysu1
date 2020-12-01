package model;

import java.util.ArrayList;
import java.util.List;

import controller.GameController;
import javafx.scene.image.ImageView;

public class IntersectingObject extends ImageView{
	
	IntersectingObject(int x, int y){
		setX(x);
		setY(y);
	}
	
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
