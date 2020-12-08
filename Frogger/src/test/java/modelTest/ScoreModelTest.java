package modelTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import javafx.embed.swing.JFXPanel;
import model.ScoreModel;

class ScoreModelTest {
	
	/**
	 * Before we can create JavaFX platform, we have to get the application running.
	 * This can be done by initialising the JFXPanel before running the test methods.
	 * If we fail to initialise JFXPanel, then our test class would be subject to error since the graphics would not be initialised.
	 */
	JFXPanel panel = new JFXPanel();
	/**
	 * Setting the path to the file containing invalid scores
	 */
	String invalidScorePath = "src/test/resources/InvalidScoreTest.csv";

	
	@Test
	void InvalidScoreTest() {
		assertThrows(NumberFormatException.class, () -> {
			ScoreModel.read(invalidScorePath);
		});
	}

}
