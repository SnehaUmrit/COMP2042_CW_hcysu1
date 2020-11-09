package com.Frogger.Manager;

import java.util.ArrayList;
import java.util.List;

import com.Frogger.Actor.BackgroundImage;
import com.Frogger.Model.FroggerButton;
import com.Frogger.Model.FroggerSubScene;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ViewManager {
	
	
	//private AnchorPane mainPane;
	private Scene mainScene;
	private Stage mainStage;
	
	private static final int WIDTH = 600 ;
	private static final int HEIGHT = 800 ;
	
	MyStage background;
	DropShadow drop;
	
	private static final int MENU_BUTTONS_STARTX = 260;
	private static final int MENU_BUTTONS_STARTY = 450;
	
	private FroggerSubScene scoreSubScene;
	private FroggerSubScene helpSubScene;
	private FroggerSubScene sceneToHide;
	
	
	List<FroggerButton> menuButtons;

	
	public ViewManager() {
		menuButtons = new ArrayList<>();
		background = new MyStage();
		//mainPane = new AnchorPane();
		mainScene = new Scene(background,WIDTH,HEIGHT);
		mainStage = new Stage();
		mainStage.setScene(mainScene);

		createBackground();
		createButtons();
		createLogo();
		createSubScenes();
		/*FroggerSubScene subScene = new FroggerSubScene();
		subScene.setLayoutX(80);
		subScene.setLayoutY(180);
		background.getChildren().add(subScene);*/
		}
	
	/**
	 * Method to for show/hide behaviour of SubScene
	 * @param subScene
	 */
	private void showSubScene(FroggerSubScene subScene) {
		if(sceneToHide != null) {
			sceneToHide.moveSubScene();
		}
		subScene.moveSubScene();
		sceneToHide = subScene;
	}
	
	public void createSubScenes() {
		scoreSubScene = new FroggerSubScene();
		background.getChildren().add(scoreSubScene);
		
		helpSubScene = new FroggerSubScene();
		background.getChildren().add(helpSubScene);
	}
	
	
	public Stage getMainStage() {
		return mainStage;
		
	}
	
	private void addMenuButton(FroggerButton button) {
		button.setLayoutX(MENU_BUTTONS_STARTX);
		button.setLayoutY(MENU_BUTTONS_STARTY + menuButtons.size()*70);
		menuButtons.add(button);
		background.getChildren().add(button);
	}
	
	
	private void createButtons() {
		createStartbutton();
		createHelpbutton();
		createScorebutton();
		//createSettingsbutton();
		createQuitbutton();
		

	}
	
	private void createStartbutton() {
		FroggerButton buttonPlay = new FroggerButton("PLAY");
		addMenuButton(buttonPlay);
		
		buttonPlay.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				
				GameViewManager gameManager = new GameViewManager();
				gameManager.createNewGame(mainStage);
				
			}
			
		});
	}
	
	private void createHelpbutton() {
		FroggerButton buttonHelp = new FroggerButton("HELP");
		addMenuButton(buttonHelp);
		
		buttonHelp.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				showSubScene(helpSubScene);
				
			}
			
		});
	}
	
	private void createScorebutton() {
		FroggerButton buttonScore = new FroggerButton("SCORES");
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
	
	private void createQuitbutton() {
		FroggerButton buttonQuit = new FroggerButton("QUIT");
		addMenuButton(buttonQuit);
		
		buttonQuit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				mainStage.close();				
			}
			
		});
	}
	
	
	
	
	private void createBackground() {
		BackgroundImage menuBackground = new BackgroundImage("file:res/Background/menubg6.png");
		background.add(menuBackground);
	}
	
	private void createLogo() {
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
		
		background.getChildren().add(logo);
		
	}
	
	
	
	

}
