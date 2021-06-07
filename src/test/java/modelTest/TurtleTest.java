package modelTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javafx.embed.swing.JFXPanel;
import model.Turtle;

class TurtleTest {

	/**
	 * Before we can create JavaFX platform, we have to get the application running.
	 * This can be done by initialising the JFXPanel before running the test methods.
	 * If we fail to initialise JFXPanel, then our test class would be subject to error since the graphics would not be initialised.
	 */
	JFXPanel panel = new JFXPanel();
	Turtle turtle;

	/**
	 * Allows us to initialise the Turtle object with its position and speed for testing purposes
	 */
	 @BeforeEach
	    void createBeforeTest() {
	        turtle = new Turtle(0,0,-1);
	    }
	 
	 
	 
	@Test
	void actTest() {		
		turtle.setX(-80);
		turtle.act();
		assertEquals(turtle.getX(),600);
		
	}

}
