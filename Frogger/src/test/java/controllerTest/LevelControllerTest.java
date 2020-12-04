package controllerTest;


import javafx.embed.swing.JFXPanel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.LevelController;

class LevelControllerTest {

	/**
	 * Before we can create JavaFX project, we have to get the application running.
	 * This can be done by initialising the JFXPanel before running the test methods.
	 * This is done using @BeforeEach annotation
	 * 
	 */
	 @BeforeEach
	    void createPanel() {
	        JFXPanel panel = new JFXPanel();
	    }
	
	@Test
	void StartingLevelTest() {
		LevelController.getStartingLevel();
		assertEquals(1,LevelController.getLevel());	
	}
	
	@Test
	void NextLevelTest() {
		LevelController.getStartingLevel();
		LevelController.getNextLevel();
		assertEquals(2,LevelController.getLevel());
		LevelController.getNextLevel();
		assertEquals(3,LevelController.getLevel());
		LevelController.getNextLevel();
		assertEquals(4,LevelController.getLevel());
		LevelController.getNextLevel();
		assertEquals(5,LevelController.getLevel());
	}
	
	
	
	

}
