package controller;

import java.text.ParseException;

import javafx.beans.binding.StringBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import model.ScoreBoard;
import view.ScoreView;
/**
 * 
 * @author hcysu1
 *
 */

public class ScoreController {

	private static final String SCORES_PATH = "res/HighScoreBoard.csv";
	private static IntegerProperty score = new SimpleIntegerProperty(0);
	
	public static ScoreView getScoreView() {
		score = new SimpleIntegerProperty(0);
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
	
	public static String getScoreString() {
		return String.valueOf(score.get());
	}
	
	/**
	 * asString() creates a StringBinding that holds the value of score turned into a String.
	 * If the value of score changes, the value of StringBinding will be updated automatically.
	 * @return score as StringBinding
	 */
	public static StringBinding getBinding() {
		return score.asString();
		
	}
	
	public static void changeScore(double points) {
		int newScore = score.get();
		newScore += (points < 0) ? points : points * (1 + TimeController.getProgressbarValue());
		score.set(newScore);
	}
	
	/**
	 * 
	 * @return 
	 */
	public static String getHighScores() {
		try {		
			return ScoreBoard.read(SCORES_PATH);			
		} catch (ParseException e) {
            //System.out.println("Date in high scores file at path " + SCORES_PATH + " is incorrectly formatted.");
            return null;
		}
	}
	
	
	
	
	
	
	
	
	
	
}
