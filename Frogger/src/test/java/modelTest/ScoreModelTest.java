package modelTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javafx.embed.swing.JFXPanel;
import model.End;
import model.ScoreModel;

class ScoreModelTest {
	
	String invalidScorePath = "src/test/resources/InvalidScoreTest.csv";
	/**
	 * Before we can create JavaFX project, we have to get the application running.
	 * This can be done by initialising the JFXPanel before running the test methods.
	 * This is done using @BeforeEach annotation
	 * 
	 */
	 @BeforeEach
	    void createPanel() {
	        JFXPanel panel = new JFXPanel();
	    }

	@Test
	void InvalidScoreTest() {
		assertThrows(NumberFormatException.class, () -> {
			ScoreModel.read(invalidScorePath);
		});
	}

}
