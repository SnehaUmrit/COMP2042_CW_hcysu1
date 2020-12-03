package view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import controller.ScoreController;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * New class that extends Pane. <p>
 * Set the font, layout, and effect of score label found at top of each level indicating the level the player is on.
 * Set the font path for the score label
 * @author hcysu1
 *
 */
public class ScoreView extends Pane{
	
	/**
	 * Font file obtained from https://kenney.nl/assets/ui-pack
	 */
	private final String FONT_PATH = "res/Font/Kenney Pixel.ttf";	
	private DropShadow drop;
	
	/**
	 * Constructor to set layout and style of text
	 * Call method setScoreFont and setShadow
	 * Creates binding on the text property of the label to the score so that the label always displays the score 
	 */
	public ScoreView() {
        Label currentScore = new Label();
        currentScore.textProperty().bind(ScoreController.getBinding());
        currentScore.setLayoutX(317);
        currentScore.setLayoutY(2.5);
        setScoreFont(currentScore);
        currentScore.setStyle("-fx-text-fill: YELLOW;");
        setShadow(currentScore);
        getChildren().addAll(currentScore);
 
	}
		
	/**
	 * Uses try/catch to set label font
	 * If the font file is not found then,
	 * the font is set to an available font
	 * @param label 
	 */
	private void setScoreFont(Label label) {
		try {
			label.setFont(Font.loadFont(new FileInputStream(FONT_PATH),45));
		} catch(FileNotFoundException e) {
			label.setFont(Font.font("Verdana",40));
		}
	}
	
	/**
	 * Set shadow on label
	 * Set colour and radius of shadow
	 * @param label
	 */
	private void setShadow(Label label) {
		drop = new DropShadow();
		drop.setRadius(20);
		drop.setColor(Color.DEEPPINK);
		label.setEffect(drop);
	}
	

}
