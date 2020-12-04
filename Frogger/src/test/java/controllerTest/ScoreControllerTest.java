package controllerTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.ScoreController;
import javafx.embed.swing.JFXPanel;

class ScoreControllerTest {

	 @BeforeEach
	 void createPanel() {
	        JFXPanel panel = new JFXPanel();
	  }
	 
	 
	@Test
	void modifyScoreTest() {
		ScoreController.changeScore(10);
		assertEquals(10,ScoreController.getScore());
	}

}
