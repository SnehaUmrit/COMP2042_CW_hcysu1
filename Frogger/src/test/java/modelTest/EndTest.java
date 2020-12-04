package modelTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javafx.embed.swing.JFXPanel;
import model.End;

class EndTest {

	End end;
	
	/**
	 * Before we can create JavaFX project, we have to get the application running.
	 * This can be done by initialising the JFXPanel before running the test methods.
	 * This is done using @BeforeEach annotation
	 * 
	 */
	 @BeforeEach
	    void createPanel() {
	        JFXPanel panel = new JFXPanel();
	        end = new End(0);
	    }
	 	 
	@Test
	void isActivatedTest() {
		assertFalse(end.isActive());
		end.activate();
		assertTrue(end.isActive());
	}
	
	
	@Test
	void isDeactivatedTest() {
		end.activate();
		assertTrue(end.isActive());
		end.deactivate();
		assertFalse(end.isActive());
	}
	
	@Test
	void isUnsafeTest() {
		assertFalse(end.isUnsafe());
		end.addCrocodile();
		assertTrue(end.isUnsafe());
	
	}
	
	@Test
	void isSafeTest() {
		end.addCrocodile();
		assertTrue(end.isUnsafe());
		end.setEmpty();
		assertFalse(end.isUnsafe());
	}

}
