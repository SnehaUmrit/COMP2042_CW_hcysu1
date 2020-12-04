package controllerTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.LivesController;
import javafx.embed.swing.JFXPanel;

class LivesControllerTest {

	
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
