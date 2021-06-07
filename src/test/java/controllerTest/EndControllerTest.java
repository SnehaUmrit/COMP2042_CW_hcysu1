package controllerTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.EndController;
import javafx.embed.swing.JFXPanel;
import model.IntersectingObject;
 
class EndControllerTest {

	/**
	 * Before we can create JavaFX platform, we have to get the application running.
	 * This can be done by initialising the JFXPanel before running the test methods.
	 */
	JFXPanel panel = new JFXPanel();
	IntersectingObject[] ends;
	
	
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
