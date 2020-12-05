package controller;

import javafx.beans.binding.StringBinding;
import javafx.beans.property.SimpleIntegerProperty;
import model.Actor;
import model.Level;
import view.LevelView;

/**
 * New class that allows us to maintain the levels.<p>
 * Uses LevelView to implement getLevelView method.
 * @author hcysu1
 *
 */
public class LevelController {
	
	private static final int MAX_LEVEL = 10;
	private static final SimpleIntegerProperty LEVEL_VALUE = new SimpleIntegerProperty();
	
	/**
	 * 
	 * @return The maximum number of levels as a String
	 */
	public static String getMaxLevel() {
		return Integer.toString(MAX_LEVEL);
	}
	
	/**
	 * Used in LevelView to display the level the player is at
	 * @return level
	 */
	public static StringBinding getLevelValue() {
		return LEVEL_VALUE.asString();
	}

    public static LevelView getLevelView() {
        return new LevelView();
    }
	
    /**
     * 
     * @return the elements of array LEVEL1
     */
	public static Actor[] getStartingLevel() {
		LEVEL_VALUE.setValue(1);
		return getCurrentLevel();
	}
	
	public static Actor[] getCurrentLevel() {
		return Level.getGameLevel(LEVEL_VALUE.get());
		
	}
	

	
	/**
	 * If the last level has been reached then the win music is played and the method gameWon is called
	 * @return Elements of the new level
	 */
	public static Actor[] getNextLevel() {
		
		LEVEL_VALUE.setValue(LEVEL_VALUE.get() + 1);
		
		if (LEVEL_VALUE.get() > MAX_LEVEL) {		
			AudioController.playWinAudio();
			MenuController.gameWon();
		}
		return getCurrentLevel();
	}
	
	/**
	 * Used for testing in LevelControllerTest
	 * @return the integer value of the level being played
	 */
	public static int getLevel() {
		return LEVEL_VALUE.getValue().intValue();
	}


}