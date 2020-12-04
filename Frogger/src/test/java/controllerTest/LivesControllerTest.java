package controllerTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.LivesController;
import javafx.embed.swing.JFXPanel;

class LivesControllerTest {

	
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
	void StartingLivesTest() {
		LivesController.getLivesView();
		assertEquals(5,LivesController.getFrogLives());
	}
	 
	@Test
	void RemoveFrogLivesTest() {
		LivesController.getLivesView();
		LivesController.removeFrogLife();
		assertEquals(4,LivesController.getFrogLives());
		LivesController.removeFrogLife();
		assertEquals(3,LivesController.getFrogLives());
	}

}
