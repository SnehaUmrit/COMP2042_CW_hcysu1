package com.Frogger.Controller;

import java.text.ParseException;

import com.Frogger.Model.ScoreBoard;
import com.Frogger.View.ScoreView;

import javafx.beans.binding.StringBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;


public class ScoreController {

	private static final String SCORES_PATH = "res/HighScores.csv";
	private static IntegerProperty score = new SimpleIntegerProperty(250);		
	
	public static ScoreView getScoreView() {
		score = new SimpleIntegerProperty(250);
		return new ScoreView();
	}
			
	public static String getScoresPath() {
		return SCORES_PATH;
	}
	
	public static String getMaxScore() {
		return String.valueOf(ScoreBoard.getMaxScore());
	}
	
	public static int getScore() {
		return score.get();
	}
	
	public static StringBinding getBinding() {
		return score.asString();
		
	}
	
	public static void changeScore(int points) {
		int newScore = score.get();
		newScore += (points < 0) ? points : points * (1 + TimeController.getProgressbarValue());
		score.set(newScore);
	}
	
	
	public static String getHighScores() {
		try {
			return ScoreBoard.read(SCORES_PATH);
		} catch (ParseException e) {
            System.out.println("Date in high scores file at path " + SCORES_PATH + " is incorrectly formatted.");
            return null;
		}
	}
	
	
	
	
	
	
	
	
	
	
}
