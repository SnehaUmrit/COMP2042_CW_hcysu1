package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;

import controller.ScoreController;
import javafx.scene.control.Label;


/**
 * New class that uses ScoreBoardInput to create an arrayList.<p>
 * Uses method that allows us to read data from the CSV file
 * Uses method that allows us to write data to the CSV file
 * @author hcysu1
 *
 */
public class ScoreModel {
	

	public static ArrayList<ScoreBoardInput> board;
	
	/**
	 * @return score The first element of the arrayList is returned and thus later used for comparison
	 */
	public static int getMaxScore() {
		return board.get(0).score;
	}
	
	/**
	 * 
	 * @param scoresPath The CSV file path from which the scores are read
	 * @return output
	 * @throws ParseException
	 */
	public static String read(String scoresPath) throws ParseException{
		try (BufferedReader reader = new BufferedReader ((new FileReader(scoresPath)))){
			String output = reader.readLine() + '\n';
			board = new ArrayList<>();
			String line;
			while ((line = reader.readLine()) != null) {
				board.add(new ScoreBoardInput(line));				
			}
			Collections.sort(board);
			for (ScoreBoardInput boardInput : board) {
				output += boardInput.toString();
			}
			
			return output;	
		} catch (IOException e) {
			String string = "No Scores Found!!";			
			return string;
		}

	}
	
	
	/**
	 * 
	 * @param scoresPath The permanent file path where the scores are written
	 */
	public static void write (String scoresPath) {
		try {
            FileWriter writer = new FileWriter(scoresPath, true);    
            String line = '\n' + ScoreController.getScoreString();
            writer.write(line);
            writer.flush();
            writer.close();
			 
		} catch (IOException e) {
			 e.printStackTrace();
	         System.out.println("File not found!!");
			
		}
	}
	

}
