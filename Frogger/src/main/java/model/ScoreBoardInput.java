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
	
	public ScoreBoardInput(String points) throws ParseException{
        this.score = Integer.parseInt(points);
	}
	
	@Override
	public int compareTo(ScoreBoardInput input) {			
		return Integer.compare(input.score, this.score);
	}
	
	@Override
	public String toString() {
		return '\n' + String.valueOf(this.score);
	}
	
}