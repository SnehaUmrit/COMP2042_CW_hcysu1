package view;


import javafx.animation.TranslateTransition;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.util.Duration;

/**
 * New class that extends SubScene. <p>
 * Used to create sub scene in menu.
 * Set sub scene for help and high score.
 * @author hcysu1
 *
 */
public class SubSceneView extends SubScene{

	private static final String BACKGROUND_IMAGE = "file:src/main/resources/Buttons/green_panel.png";
	private boolean isHidden = true;
	
	/**
	 * Constructor to set width, height and layout of sub scene
	 * Set image using AnchorPane
	 */
	public SubSceneView() {
		super(new AnchorPane(), 460, 245);
		prefWidth(460); 
		prefHeight(250);		

		BackgroundImage image = new BackgroundImage(new Image(BACKGROUND_IMAGE,460,250,false,true),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);		
		AnchorPane root2 = (AnchorPane)this.getRoot();
		root2.setBackground(new Background(image));
		
		setLayoutX(600);
		setLayoutY(190);

	}
	

	/**
	 * Controls movement of sub scene
	 * Uses TranslateTransition for the sub scene transition
	 * Checks if sub scene is hidden for transition to take place
	 */
	public void moveSubScene() {
		
		TranslateTransition transition = new TranslateTransition();
		transition.setDuration(Duration.seconds(0.3));
		transition.setNode(this);		
				
		if(isHidden) {
			transition.setToX(-523);
			isHidden = false;
		} else {
			transition.setToX(0);
			isHidden = true;
		}
		transition.play();
		
	}
	
	
	/**
	 * cast to AnchorPane
	 * @return sub scene as AnchorPane type
	 */
	public AnchorPane getPane() {
		return (AnchorPane) this.getRoot();
	}
	
	




}
