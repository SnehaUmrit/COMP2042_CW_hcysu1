package com.Frogger.View;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class TimeView extends Pane{
	
	private final ProgressBar progressBar;
	private final Timeline progressTimeline;
	
	public TimeView (int completionSeconds) {
		if (completionSeconds < 0) {
			throw new IllegalArgumentException("Positive time is required");			
		}
		progressBar = new ProgressBar();
        progressTimeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(progressBar.progressProperty(), 1)),
                new KeyFrame(Duration.seconds(completionSeconds), e -> {

                }, new KeyValue(progressBar.progressProperty(), 0))
        );
        progressTimeline.playFromStart();

        progressBar.setPrefWidth(250);
        progressBar.setPrefHeight(20);
        progressBar.setLayoutY(771);
        progressBar.setLayoutX(250);
        getChildren().add(progressBar);
        

	}
	
    public ProgressBar getProgressBar() {
        return progressBar;
    }

    public Timeline getProgressTimeline() {
        return progressTimeline;
    }
	
	

}
