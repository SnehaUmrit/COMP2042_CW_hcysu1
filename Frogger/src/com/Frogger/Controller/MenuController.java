package com.Frogger.Controller;

import java.util.ArrayList;
import java.util.List;

import com.Frogger.Model.Animal;
import com.Frogger.Model.BackgroundImage;
import com.Frogger.Model.ScoreBoard;
import com.Frogger.View.ButtonView;
import com.Frogger.View.GameView;
import com.Frogger.View.SubSceneView;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MenuController {
	
	private static Stage mainStage;
	private static Scene gameScene;
	private static Scene mainScene;
	private static AnchorPane mainPane;
	
	private static final int WIDTH = 600;
	private static final int HEIGHT = 800;
	
	private static SubSceneView scoreSubScene;
	private static SubSceneView helpSubScene;
	private static SubSceneView sceneToHide;
	
	private static final int MENU_BUTTONS_STARTX = 260;
	private static final int MENU_BUTTONS_STARTY = 450;
	
	private static DropShadow drop;
	
	static List<ButtonView> menuButtons;
	
	public static void intialiseStage() {
		menuButtons = new ArrayList<>();
		mainPane = new AnchorPane();
		mainScene = new Scene(mainPane,WIDTH,HEIGHT);
		mainStage = new Stage();
		mainStage.setScene(mainScene);

		AudioController.playMenuAudio();
		createBackground();
		createButtons();
		createLogo();
		createSubScenes();
		
		mainStage.setTitle("Frogger Menu");
		mainStage.show();
		
	}
	
	public static void setMainStage(Stage mainStage) {
		MenuController.mainStage = mainStage;
	}
	
	
	/**
	 * Method to for show/hide behaviour of SubScene
	 * @param subScene
	 */
	private static void showSubScene(SubSceneView subScene) {
		if(sceneToHide != null) {
			sceneToHide.moveSubScene();
		}
		subScene.moveSubScene();
		sceneToHide = subScene;
	}

	public static void createSubScenes() {
		scoreSubScene = new SubSceneView();
		mainPane.getChildren().add(scoreSubScene);
		
		helpSubScene = new SubSceneView();
		mainPane.getChildren().add(helpSubScene);
	}


	private static void addMenuButton(ButtonView button) {
		button.setLayoutX(MENU_BUTTONS_STARTX);
		button.setLayoutY(MENU_BUTTONS_STARTY + menuButtons.size()*70);
		menuButtons.add(button);
		mainPane.getChildren().add(button);
	}
	
	
	private static void createButtons() {
		createStartbutton();
		createHelpbutton();
		createScorebutton();
		//createSettingsbutton();
		createQuitbutton();
		

	}
	
	private static void createStartbutton() {
		ButtonView buttonPlay = new ButtonView("PLAY");
		addMenuButton(buttonPlay);
		
		buttonPlay.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				GameView gameView = GameController.getGame();
				gameView.getChildren().add(new Animal());
				
				gameScene = new Scene(gameView,WIDTH,HEIGHT);
				mainStage.setScene(gameScene);

			}
			
		});
	}
	
	
	private static void createHelpbutton() {
		ButtonView buttonHelp = new ButtonView("HELP");
		addMenuButton(buttonHelp);
		
		buttonHelp.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				showSubScene(helpSubScene);
				
			}
			
		});
	}
	
	
	
	private static void createScorebutton() {
		ButtonView buttonScore = new ButtonView("SCORES");
		addMenuButton(buttonScore);
		
		buttonScore.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				showSubScene(scoreSubScene);
				
			}
			
		});
	}
	
	
	/*private void createSettingsbutton() {
	FroggerButton buttonSettings = new FroggerButton("SETTINGS");
	addMenuButton(buttonSettings);
	}*/

	private static void createQuitbutton() {
		ButtonView buttonQuit = new ButtonView("QUIT");
		addMenuButton(buttonQuit);
		
		buttonQuit.setOnAction(new EventHandler<ActionEvent>() {
	
			@Override
			public void handle(ActionEvent event) {
				mainStage.close();				
			}
			
		});
	}
	
	
	private static void createBackground() {
		BackgroundImage menuBackground = new BackgroundImage("file:res/Background/menubg6.png");
		mainPane.getChildren().add(menuBackground);
	}
	
	private static void createLogo() {
		ImageView logo = new ImageView("file:res/Logo/logo_design.png");
		logo.setLayoutX(6);
		logo.setLayoutY(-5);
		logo.setFitHeight(600);
		logo.setFitWidth(600);

		
		logo.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				drop = new DropShadow();
				drop.setColor(Color.DEEPPINK);
				drop.setRadius(20);
				logo.setEffect(drop);
				
			}			
		});
		
		logo.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {

				logo.setEffect(null);

			}			
		});
		
		mainPane.getChildren().add(logo);
		
	}


	public static void gameOver() {
		ScoreBoard.write(ScoreController.getScoresPath());
		//Do to: Show GameOver Text
		mainStage.close();
		intialiseStage();
	}

	
	
	
	

	
	

}
