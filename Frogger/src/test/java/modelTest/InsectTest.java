package modelTest;

import javafx.embed.swing.JFXPanel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import model.Insect;

class InsectTest {

	Insect insect;
	
	 @BeforeEach
	    void createPanel() {
	        JFXPanel panel = new JFXPanel();
	    }
	 
	
	@Test
	void isIntersectingTest() {
		insect = new Insect(0,0);
		assertFalse(insect.isIntersecting());
		insect.intersect();
		assertTrue(insect.isIntersecting());
		
	}

}
