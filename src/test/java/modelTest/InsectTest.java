package modelTest;

import javafx.embed.swing.JFXPanel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import model.Insect;

class InsectTest {

	/**
	 * Before we can create JavaFX platform, we have to get the application running.
	 * This can be done by initialising the JFXPanel before running the test methods.
	 */
	JFXPanel panel = new JFXPanel();
	Insect insect;
	
	
	@Test
	void isIntersectingTest() {
		insect = new Insect(0,0);
		assertFalse(insect.isIntersecting());
		insect.intersect();
		assertTrue(insect.isIntersecting());
		
	}

}
