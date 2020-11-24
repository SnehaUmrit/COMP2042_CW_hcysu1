package com.Frogger.Controller;

import java.util.Random;

import com.Frogger.Model.End;
import com.Frogger.Model.IntersectingObject;

public class EndController {
	private static final IntersectingObject[] ENDS = new IntersectingObject[] {
		new End(13),
		new End(141),
		new End(141+141-13),
		new End(141+141-13+141-13+1),
		new End(141+141-13+141-13+141-13+3)
	};
	
	private static final Random RANDOM = new Random();
	private static int endsLeft = ENDS.length;
	private static int crocodile = -1;
	private static int crocodileTicks = 0;
	
	public static int getEndsLeft() {
		return endsLeft;
	}
	
	public static IntersectingObject[] getEnds() {
		newLevel();
		return ENDS;
	}
	
	public static boolean levelCompleted() {
		return endsLeft == 0;
	}
	
	public static void newLevel() {
		endsLeft = ENDS.length;
		for (IntersectingObject end : ENDS) {
			((End) end).deactivate();
		}
	}
	
	
	public static void activate(IntersectingObject activatedEnd) {
		for(IntersectingObject end: ENDS) {
			if(activatedEnd == end) {
				((End) end).activate();
				endsLeft--;
			}
		}
	}
	
	public static boolean inactive(IntersectingObject object) {
		return !((End) object).isActive();
	}
	
	public static boolean active(IntersectingObject object) {
		return ((End) object).isActive();	

	}
	
	public static boolean unsafe(IntersectingObject object) {
		return ((End) object).isUnsafe();	

	}
	
	public static void flipCrocodile() {
		if(crocodileTicks == 30) {
			if(crocodile < 0) {
				int position = RANDOM.nextInt(5);
				while (active(ENDS[position])) {
					position = RANDOM.nextInt(5);
				}
				((End) ENDS[position]).makeUnsafe();
				crocodile = position;
			} else {
				((End) ENDS[crocodile]).free();
				crocodile = -1;
			}
			crocodileTicks = 0;
		} else {
			crocodileTicks++;
		}
	}
	
	
}
