package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * 
 * 
 * @author hcysu1
 *
 */
public class LivesView extends Pane{

	private static final Image HEART = new Image("file:res/Sprites/heart.png");
	private static ImageView[] frogHearts;
	
	/**
	 * Constructor to create an array to store images of frog lives
	 * Set the layout, width and height of the images
	 * @param initialLives  The number of lives at the start of the game
	 */
	public LivesView(int initialLives) {
		frogHearts = new ImageView[initialLives];
		for (int i=0 ; i < initialLives ; i++) {
			frogHearts[i] = new ImageView(HEART);
			frogHearts[i].setLayoutX(20+(i*30));
			frogHearts[i].setFitWidth(23);
			frogHearts[i].setFitHeight(23);
			frogHearts[i].setLayoutY(771);
			getChildren().add(frogHearts[i]);
		}
	}
	
	/**
	 * 
	 * @return frogHearts The images representing the lives of the frog
	 */
	public static ImageView[] getFrogHearts() {
		return frogHearts;
		
	}
}
