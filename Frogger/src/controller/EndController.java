package controller;

import java.util.Random;

import model.End;
import model.IntersectingObject;

/**
 * 
 * @author hcysu1
 *
 */
public class EndController {
	private static final Random RANDOM = new Random();
	private static int crocodile = -1;
	private static int crocodileTicks = 0;
	
	/**
	 * Set the x position of the end 
	 * Allows us to create five ends
	 */
	private static final IntersectingObject[] ENDS = new IntersectingObject[] {
		new End(13),
		new End(141),
		new End(141+141-13),
		new End(141+141-13+141-13+1),
		new End(141+141-13+141-13+141-13+3)
	};
	
	private static int endsLeft = ENDS.length;
	
	/**
	 * 
	 * @return endsLeft The number of ends left
	 */
	public static int getEndsLeft() {
		return endsLeft;
	}
	
	/**
	 * 
	 * @return The empty ends for a new level
	 */
	public static IntersectingObject[] getEnds() {
		newLevel();
		return ENDS;
	}
	
	/**
	 * Used to check if a certain level is completed or not
	 * @return true if the all the ends have a frog
	 */
	public static boolean levelCompleted() {
		return endsLeft == 0;
	}
	
	/**
	 * Uses deactivate() method from End class
	 * In order to set the images as empty to prepare for a new level
	 */
	public static void newLevel() {
		endsLeft = ENDS.length;
		for (IntersectingObject end : ENDS) {
			((End) end).deactivate();
		}
	}
	
	/**
	 * If frog reaches an end, then we call the method activate() from End class
	 * @param activatedEnd The number of ends that have a frog
	 * Reduce counter endsLeft
	 */
	public static void activate(IntersectingObject activatedEnd) {
		for(IntersectingObject end: ENDS) {
			if(activatedEnd == end) {
				((End) end).activate();
				endsLeft--;
			}
		}
	}
	
	/**
	 * End that does not have a frog
	 * @param object
	 * @return
	 */
	public static boolean inactive(IntersectingObject object) {
		return !((End) object).isActive();
	}
	
	/**
	 * End that has a frog
	 * @param object
	 * @return
	 */
	public static boolean active(IntersectingObject object) {
		return ((End) object).isActive();	

	}
	
	/**
	 * End that has a crocodile
	 * @param object
	 * @return
	 */
	public static boolean unsafe(IntersectingObject object) {
		return ((End) object).isUnsafe();	

	}
	
	/**
	 * 
	 */
	public static void moveCrocodile() {
		if(crocodileTicks == 30) {
			if(crocodile < 0) {
				int position = RANDOM.nextInt(5);
				while (active(ENDS[position])) {
					position = RANDOM.nextInt(5);
				}
				((End) ENDS[position]).addCrocodile();
				crocodile = position;
			} else {
				((End) ENDS[crocodile]).setEmpty();
				crocodile = -1;
			}
			crocodileTicks = 0;
		} else {
			crocodileTicks++;
		}
	}
	
	
}
