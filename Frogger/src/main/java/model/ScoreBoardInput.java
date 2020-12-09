package model;

import java.text.ParseException;

/**
 * New class that allows us to implement compareTo method. <p>
 * Used in ScoreModel to create an ArrayList.
 * Constructor to set the score.
 * toString method to display the score as a String 
 * @author hcysu1
 *
 */
public class ScoreBoardInput implements Comparable<ScoreBoardInput>{		
	int score;
	
	/**
	 * 
	 * @param points Game Score
	 * @throws ParseException Signals that an error has been reached unexpectedly while parsing.
	 */
	public ScoreBoardInput(String points) throws ParseException{
        this.score = Integer.parseInt(points);
	}
	
	/**
	 * Override compareTo method to compare the scores
	 */
	@Override
	public int compareTo(ScoreBoardInput input) {			
		return Integer.compare(input.score, this.score);
	}
	
	
	@Override
	public String toString() {
		return '\n' + String.valueOf(this.score);
	}
	
}