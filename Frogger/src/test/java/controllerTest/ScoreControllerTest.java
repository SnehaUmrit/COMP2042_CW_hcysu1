package controllerTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.ScoreController;
import javafx.embed.swing.JFXPanel;

class ScoreControllerTest {

	/**
	 * Before we can create JavaFX platform, we have to get the application running.
	 * This can be done by initialising the JFXPanel before running the test methods.
	 */
	JFXPanel panel = new JFXPanel();
	 
	

	@Test
	void modifyPointsTest() {
		ScoreController.changeScore(100);
		assertEquals(100,ScoreController.getScore());
		ScoreController.changeScore(-50);
		assertEquals(50,ScoreController.getScore());
		ScoreController.changeScore(-50);
		assertEquals(0,ScoreController.getScore());
	}
	
	
	 

}
