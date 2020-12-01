package view;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 * Uses ProgressBar to visualise the progress as game proceeds
 * Uses Timeline to be able to set the desired amount of time for the game completion
 * Allows implementation of game progress bar to make game more interesting 
 * Allows player to gain more points if the game is completed quick enough
 * @author hcysu1
 *
 */
public class TimeView extends Pane{
	
	private final ProgressBar progressBar;
	private final Timeline progressTimeline;
	
	/**
	 * Constructor to set width,height and layout of progress bar
	 * @param completionSeconds Time in Seconds to complete a game
	 */
	public TimeView (int completionSeconds) {

		progressBar = new ProgressBar();
        progressTimeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(progressBar.progressProperty(), 1)),
                new KeyFrame(Duration.seconds(completionSeconds), 
                new KeyValue(progressBar.progressProperty(), 0))
        );
        progressTimeline.playFromStart();

        progressBar.setPrefWidth(250);
        progressBar.setPrefHeight(20);
        progressBar.setLayoutY(771);
        progressBar.setLayoutX(250);
        getChildren().add(progressBar);

        setStyle("-fx-control-inner-background: black;"+     		
        		"-fx-box-border: none;"+
        		 "-fx-accent: green;");
	}
	
	/**
	 * Allows us to determine progress bar value
	 * @return progressBar
	 */
    public ProgressBar getProgressBar() {
        return progressBar;
    }

    /**
     * Allows us to reset progress bar when required
     * @return progressTimeline
     */
    public Timeline getProgressTimeline() {
        return progressTimeline;
    }
	
   
	

}
