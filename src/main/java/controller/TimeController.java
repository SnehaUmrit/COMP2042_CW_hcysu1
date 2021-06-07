package controller;

import view.TimeView;

/**
 * New class that creates an instance of TimeView class.<p>
 * Allows us to implement a method that can reset the progress bar.
 * Allow us to implement a method to obtain the value of the progress bar
 * @author hcysu1
 *
 */
public class TimeController {
	
	private static TimeView timeView;	
	/**
	 * Method to set the completion seconds
	 * @return timeView
	 */
	public static TimeView getTimeView() {
		timeView = new TimeView(40);
		return timeView;
	}
	
	/**
	 * Method that allows us to reset the progress bar when required
	 * Using playFromStart()
	 */
	public static void reset() {
		timeView.getProgressTimeline().playFromStart();
	}
	
	/**
	 * Uses getProgreeBar() method from TimeView class
	 * @return value of progress bar as double data type
	 */
	public static double getProgressbarValue() {
		return timeView.getProgressBar().progressProperty().doubleValue();
	}

}
