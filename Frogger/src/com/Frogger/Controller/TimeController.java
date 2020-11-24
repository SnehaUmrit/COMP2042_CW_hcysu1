package com.Frogger.Controller;

import com.Frogger.View.TimeView;

public class TimeController {
	
	private static TimeView timeView;
	
	public static TimeView getTimeView() {
		timeView = new TimeView(60);
		return timeView;
	}
	
	public static void reset() {
		timeView.getProgressTimeline().playFromStart();
	}
	
	public static double getProgressbarValue() {
		return timeView.getProgressBar().progressProperty().doubleValue();
	}

}
