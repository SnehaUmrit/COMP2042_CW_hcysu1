package model;



import javafx.scene.image.Image;


public class PurpleFrog extends IntersectingObject {

	private boolean intersects = false;
	
	private final Image purpleFrog = new Image("file:src/main/resources/Sprites/purplefrogUp.png",35,35,false,false);
	
	
	public PurpleFrog(int x, int y) {
		super(x, y);
		setImage(purpleFrog);
		
	}

	public boolean isIntersecting() {
		return intersects;
	}
	
	public void intersect() {
		setImage(null);
		intersects = true;
		
	}
	
	
	
}
