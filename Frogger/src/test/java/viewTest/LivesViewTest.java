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
	 * If we fail to initialise JFXPanel, then our test class would be subject to error since the graphics would not be initialised.
	 */
	JFXPanel panel = new JFXPanel();
	

	@Test
	void StartingLivesTest() {
		LivesView livesView = new LivesView(6);
		assertEquals(6,LivesView.getFrogHearts().length);
	}

}
