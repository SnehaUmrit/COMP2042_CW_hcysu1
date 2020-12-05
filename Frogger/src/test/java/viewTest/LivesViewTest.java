package viewTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javafx.embed.swing.JFXPanel;
import view.LivesView;

class LivesViewTest {
	
	
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
	void StartingLivesTest() {
		LivesView livesView = new LivesView(5);
		assertEquals(5,LivesView.getFrogHearts().length);
	}

}
