package view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import controller.LevelController;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * New class that extends Pane. <p>
 * Used to set the font, layout and shadow effect to the level number during each game.
 * Used in LevelController to update the level as the game level changes.
 * @author hcysu1
 *
 */
public class LevelView extends Pane{

	private final String FONT_PATH = "src/main/resources/Font/Kenney Pixel.ttf";	
	private DropShadow drop;
	
	/**
	 * Set the layout of the label
	 * Calls method from LevelController class to bind the level value
	 */
	public LevelView() {
		Label currentLevel = new Label();
		currentLevel.textProperty().bind(LevelController.getLevelValue());	
		currentLevel.setLayoutX(135);
		currentLevel.setLayoutY(2.5);
		setLevelFont(currentLevel);
		currentLevel.setStyle("-fx-text-fill: YELLOW;");
		setShadow(currentLevel);
		getChildren().add(currentLevel);

	}
	
	
	/**
	 * Set font to label.
	 * Uses try/catch. In case the font file is not found, the font is set to Verdana
	 * @param label 
	 */
	private void setLevelFont(Label label) {
		try {
			label.setFont(Font.loadFont(new FileInputStream(FONT_PATH),45));
		} catch(FileNotFoundException e) {
			label.setFont(Font.font("Verdana",40));
		}
	}
	
	/**
	 * Set shadow effect to label
	 * @param label
	 */
	private void setShadow(Label label) {
		drop = new DropShadow();
		drop.setRadius(20);
		drop.setColor(Color.DEEPPINK);
		label.setEffect(drop);
	}
	
	

}
