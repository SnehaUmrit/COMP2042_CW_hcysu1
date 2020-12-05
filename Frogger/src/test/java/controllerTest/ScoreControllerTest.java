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
	 * This is done using @BeforeEach annotation
	 * 
	 */
	 @BeforeEach
	 void createPanel() {
	        JFXPanel panel = new JFXPanel();
	  }
	 
	@Test
	void modifyPointsTest() {
		ScoreController.changeScore(100);
		assertEquals(100,ScoreController.getScore());
		ScoreController.changeScore(-40);
		assertEquals(60,ScoreController.getScore());
	}
	
	
	 

}
