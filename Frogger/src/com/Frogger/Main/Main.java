package com.Frogger.Main;

import java.io.File;
import java.util.List;

import com.Frogger.Actor.*;
import com.Frogger.Manager.MyStage;
import com.Frogger.Manager.ViewManager;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
	

	

	@Override
	public void start(Stage primaryStage) throws Exception {
	  ViewManager manager = new ViewManager();
	  primaryStage = manager.getMainStage();
	  primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
