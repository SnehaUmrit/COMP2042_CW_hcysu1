package modelTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javafx.embed.swing.JFXPanel;
import model.SafeCrocodile;

class SafeCrocodileTest {

	/**
	 * Before we can create JavaFX platform, we have to get the application running.
	 * This can be done by initialising the JFXPanel before running the test methods.
	 * If we fail to initialise JFXPanel, then our test class would be subject to error since the graphics would not be initialised.
	 */
	JFXPanel panel = new JFXPanel();
	SafeCrocodile crocodile;
	
	/**
	 * Allows us to initialise SafeCrocodile object with its x and y position and speed
	 */
	 @BeforeEach
	    void createBeforeTest() {
	        crocodile = new SafeCrocodile(0,0,0.75);
	    }
	 
	@Test
	void actTest() {
		crocodile.setX(700);
		crocodile.act();
		assertEquals(crocodile.getX(),-300);
	}

}
