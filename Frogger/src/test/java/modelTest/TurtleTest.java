package modelTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javafx.embed.swing.JFXPanel;
import model.Turtle;

class TurtleTest {

	Turtle turtle;
	/**
	 * Before we can create JavaFX platform, we have to get the application running.
	 * This can be done by initialising the JFXPanel before running the test methods.
	 * This is done using @BeforeEach annotation
	 * 
	 */
	 @BeforeEach
	    void createPanel() {
	        JFXPanel panel = new JFXPanel();
	        turtle = new Turtle(0,0,-1);
	    }
	 
	 
	 
	@Test
	void actTest() {		
		turtle.setX(-80);
		turtle.act();
		assertEquals(turtle.getX(),600);
		
	}

}
