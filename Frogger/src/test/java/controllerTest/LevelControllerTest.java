package controllerTest;


import javafx.embed.swing.JFXPanel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.LevelController;

class LevelControllerTest {

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
