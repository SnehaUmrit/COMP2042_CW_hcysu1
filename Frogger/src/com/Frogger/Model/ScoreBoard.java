package com.Frogger.Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.*;

import com.Frogger.Controller.ScoreController;

public class ScoreBoard {
	
	public static ArrayList<BoardInput> board;
	
	private static class BoardInput implements Comparable<BoardInput>{
		String name;
		int score;
		Date date;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yy");
		
		public BoardInput(String[] column) throws ParseException{
            if (column[0].length() > 7)
                this.name = column[0].substring(0,7);
            else
                this.name = column[0];
            this.score = Integer.parseInt(column[1]);
            this.date = new SimpleDateFormat("dd-MM-yyyy").parse(column[2]);
			}
		
		@Override
		public int compareTo(BoardInput input) {			
			return Integer.compare(input.score, this.score);
		}
		
		@Override
		public String toString() {
			return '\n' + this.name + '\t' + this.score + '\t' + dateFormat.format(this.date);
			
		}
		
	}
				
	public static int getMaxScore() {
		return board.get(0).score;
	}
		
	public static String read(String scoresPath) throws ParseException{
		try (BufferedReader reader = new BufferedReader ((new FileReader(scoresPath)))){
			String output = reader.readLine().replace(',','\t') + '\n';
			board = new ArrayList<>();
			String line;
			while ((line = reader.readLine()) != null) {
				board.add(new BoardInput(line.split(",")));				
			}
			Collections.sort(board);
			for (BoardInput bi : board) {
				output += bi.toString();
			}
			
			return output;	
		} catch (IOException e) {
			return "Reading failed: " + scoresPath + " not found";
		}

	}
	
	public static void write (String scoresPath) {
		try {
            FileWriter writer = new FileWriter(scoresPath, true);
            String line = '\n' + "Frog" + ',' + ScoreController.getScore() + ',' + java.time.LocalDate.now();           
            writer.write(line);
            writer.flush();
            writer.close();
			 
		} catch (IOException e) {
			 e.printStackTrace();
	         System.out.println("Writing failed: " + scoresPath + " not found");
			
		}
	}
	

}
