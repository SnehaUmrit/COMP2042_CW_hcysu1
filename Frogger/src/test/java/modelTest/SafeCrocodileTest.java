package modelTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javafx.embed.swing.JFXPanel;
import model.SafeCrocodile;

class SafeCrocodileTest {

	SafeCrocodile crocodile;
	/**
	 * Before we can create JavaFX platform, we have to get the application running.
	 * This can be done by initialising the JFXPanel before running the test methods.
	 * This is done using @BeforeEach annotation
	 * 
	 */
	 @BeforeEach
	    void createPanel() {
	        JFXPanel panel = new JFXPanel();
	        crocodile = new SafeCrocodile(0,0,0.75);
	    }
	@Test
	void actTest() {
		crocodile.setX(700);
		crocodile.act();
		assertEquals(crocodile.getX(),-300);
	}

}
