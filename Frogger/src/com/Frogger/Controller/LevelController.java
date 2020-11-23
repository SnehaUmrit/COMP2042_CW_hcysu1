package com.Frogger.Controller;

import com.Frogger.Model.Actor;
import com.Frogger.Model.Level;
import com.Frogger.View.LevelView;

import javafx.beans.binding.StringBinding;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class LevelController {
	
	private static final int MAX_LEVEL = 2;
	private static final SimpleIntegerProperty LEVEL_VALUE = new SimpleIntegerProperty();
	
	public static String getMaxLevel() {
		return Integer.toString(MAX_LEVEL);
	}
	
	
	public static StringBinding getLevelValue() {
		return LEVEL_VALUE.asString();
	}
	
	
    public static LevelView getLevelView() {
        return new LevelView();
    }
	
	public static Actor[] getStartingLevel() {
		LEVEL_VALUE.setValue(1);
		return getCurrentLevel();
	}
	
	public static Actor[] getCurrentLevel() {
		return Level.getGameLevel(LEVEL_VALUE.get());
		
	}
	
	public static Actor[] getNextLevel() {
		LEVEL_VALUE.setValue(LEVEL_VALUE.get() + 1);
		if (LEVEL_VALUE.get() > MAX_LEVEL) {
			MenuController.gameOver();
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("GAME COMPLETE");
			alert.setHeaderText(null);
			alert.setContentText("YAY, YOU WON!!");
			alert.showAndWait();
			
		}
		return getCurrentLevel();
	}
	
	
	public static Actor[] getSpecificLevel(int level) {
		LEVEL_VALUE.setValue(level);
		return getCurrentLevel();
	}
	
}
