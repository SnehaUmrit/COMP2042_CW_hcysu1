package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Called in MenuController class 
 * Allows us to set the background image with a fixed width and height
 * Makes it more efficient to set background image by only keying in the path of the image as a String
 * @author hcysu1
 *
 */
public class BackgroundImage extends ImageView{
	
	public BackgroundImage(String imageLink) {
		setImage(new Image(imageLink, 600, 800, true, true));
	}

}
