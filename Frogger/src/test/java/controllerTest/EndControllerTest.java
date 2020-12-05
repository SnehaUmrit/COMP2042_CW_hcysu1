package controllerTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.EndController;
import javafx.embed.swing.JFXPanel;
import model.IntersectingObject;
 
class EndControllerTest {

	IntersectingObject[] ends;
	
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
	void EndsTest() {
		ends = EndController.getEnds();
		assertEquals(5,ends.length);
		
	}

	@Test
	void DeactivateEndsTest() {
		ends = EndController.getEnds();
		EndController.newLevel();
		for (IntersectingObject end : ends) {
			assertTrue (EndController.inactive(end));
		}
		
	}
	
}
