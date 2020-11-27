package com.Frogger.Controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import com.Frogger.Model.Animal;
import com.Frogger.Model.BackgroundImage;
import com.Frogger.Model.ScoreBoard;
import com.Frogger.View.ButtonView;
import com.Frogger.View.GameView;
import com.Frogger.View.LabelView;
import com.Frogger.View.MenuView;
import com.Frogger.View.SubSceneView;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
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
	private static MenuView menuView;
	
	private static final int MENU_BUTTONS_STARTX = 160;
	private static final int MENU_BUTTONS_STARTY = 425;
	
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
		createHelpSubScenes();
		createScoreSubScene();
		
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

	public static void createHelpSubScenes() {
		helpSubScene = new SubSceneView();
		mainPane.getChildren().add(helpSubScene);
		LabelView helpLabel = new LabelView("HELP");
		helpLabel.setLayoutX(30);
		helpLabel.setLayoutY(20);
		helpLabel.setStyle("-fx-text-fill: GREEN;");
		helpSubScene.getPane().getChildren().add(helpLabel);
		
		Label help = new Label("- PRESS W,A,S,D KEYS TO MOVE FROGGY\n"
								+ "- AVOID VEHICES AND SNAKES\n"
								+ "- GRAB A FLY TO GET EXTRA POINYS\n"
								+ "- BE QUICK TO GAIN EXTRA TIME BONUS\n"
								+ "- CROCODILES CAN BE SAFE RIDES, BUT \n"
								+ "! ! ! BEWARE WHEN THEY OPEN THEIR MOUTH ! ! !");
		help.setLayoutX(40);
		help.setLayoutY(74);
		setTextFont(help);

		help.setStyle("-fx-text-fill: BLACK;");
		helpSubScene.getPane().getChildren().add(help);
		
		
	}

	
	public static void createScoreSubScene() {
	
		scoreSubScene = new SubSceneView();
		mainPane.getChildren().add(scoreSubScene);
		LabelView scoreLabel = new LabelView("HIGH SCORES");
		scoreLabel.setLayoutX(30);
		scoreLabel.setLayoutY(20);
		scoreLabel.setStyle("-fx-text-fill: GREEN;");
		scoreSubScene.getPane().getChildren().add(scoreLabel);
		
		Label score = new Label(ScoreController.getHighScores());
		score.setLayoutX(20);
		score.setLayoutY(20);		
		score.setStyle("-fx-text-fill: WHITE;");
		
		
		scoreSubScene.getPane().getChildren().add(score);	
		
	}

	private static void addMenuButton(ButtonView button) {
		button.setLayoutX(MENU_BUTTONS_STARTX);
		button.setLayoutY(MENU_BUTTONS_STARTY + menuButtons.size()*65);
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

		BackgroundImage menuBackground = new BackgroundImage("file:res/Background/menu_bg11.png");
		mainPane.getChildren().add(menuBackground);
		
	}
	
	private static void createLogo() {
		ImageView logo = new ImageView("file:res/Logo/classic_logo.png");
		logo.setLayoutX(75);
		logo.setLayoutY(100);
		logo.setFitHeight(100);
		logo.setFitWidth(450);
		
		logo.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				drop = new DropShadow();
				drop.setColor(Color.WHITE);
				drop.setRadius(10);
				logo.setEffect(drop);
				
			}			
		});
		
		logo.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {

				logo.setEffect(null);

			}			
		});
		
		ImageView froggy = new ImageView("file:res/Logo/frog.png");
		froggy.setLayoutX(185);
		froggy.setLayoutY(195);
		froggy.setFitWidth(250);
		froggy.setFitHeight(250);
		
		mainPane.getChildren().add(froggy);
		mainPane.getChildren().add(logo);
		
	}

	
	

	public static void gameOver() {
		ScoreBoard.write(ScoreController.getScoresPath());
		//Do to: Show GameOver Text
		mainStage.close();		
		intialiseStage();
		showSubScene(scoreSubScene);
	}

	
	private static void setTextFont(Label label) {
		try {
			label.setFont(Font.loadFont(new FileInputStream("res/Font/Kenney Pixel.ttf"),30));
		} catch(FileNotFoundException e) {
			label.setFont(Font.font("Verdana",30));
		}
	}
	
	

	
	

}
