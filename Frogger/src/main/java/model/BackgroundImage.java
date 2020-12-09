package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Called in MenuController and GameView class to set background image
 * <p>
 * Makes it more efficient to set background image by only keying in the path of the image as a String as the length and width are fixed.
 * It is derived from ImageView instead of Actor as previously done. 
 * @author Amended from given BackgroundImage class
 *
 */
public class BackgroundImage extends ImageView{
	
	/**
	 * Fix width and height for background image
	 * @param imageLink The path of the image
	 */
	public BackgroundImage(String imageLink) {
		setImage(new Image(imageLink, 600, 800, true, true));
	}

}
