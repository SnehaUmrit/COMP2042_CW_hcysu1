package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import com.sun.javafx.tk.Toolkit;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Dimension2D;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;

import javafx.scene.effect.DropShadow;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;

import model.BackgroundImage;
import model.ScoreModel;
import view.ButtonView;
import view.GameView;
import view.LabelView;
import view.SubSceneView;

/**
 * New class that allows us to set the elements of frogger menu. <p>
 * Uses a method initialiseStage that is called in the setMainStage method which is eventually called in main class.
 * Allows us to set the actions of the button events.
 * Allows us to set the text of help sub scene.
 * @author hcysu1
 *
 */
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

	
	private static final int MENU_BUTTONS_STARTX = 160;
	private static final int MENU_BUTTONS_STARTY = 425;
	
	private static DropShadow drop;
	
	static List<ButtonView> menuButtons;

	/**
	 * Create main pane, scene and stage
	 * Allows us to set the scene
	 * Allows us to call other methods.
	 * And also allows us to set the menuAudio
	 */
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
	
	/**
	 * Used to set the mainStage.
	 * Method is called in main class
	 * @param mainStage
	 */
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

	/**
	 * Create help sub scene 
	 * Add help LabelView
	 * 
	 */
	public static void createHelpSubScenes() {
		helpSubScene = new SubSceneView();
		mainPane.getChildren().add(helpSubScene);
		LabelView helpLabel = new LabelView("HELP");
		helpLabel.setLayoutX(30);
		helpLabel.setLayoutY(20);
		helpLabel.setStyle("-fx-text-fill: GREEN;");
		helpSubScene.getPane().getChildren().add(helpLabel);
		
		Label help = new Label("-> PRESS W,A,S,D KEYS TO MOVE FROGGY\n"
								+ "-> AVOID VEHICES AND SNAKES\n"
								+ "-> GRAB AN INSECT TO GAIN EXTRA 50 POINTS\n"
								+ "-> BE QUICK TO GAIN EXTRA TIME BONUS\n"
								+ "-> GIVE A RIDE TO THE PURPLE FROG FOR EXTRA 200\n"
								+ "-> CROCODILES CAN BE SAFE RIDES, BUT... \n"
								+ "          ! ! ! BEWARE WHEN THEY OPEN THEIR MOUTH ! ! !");
		help.setLayoutX(40);
		help.setLayoutY(76);
		setTextFont(help,25);


		help.setStyle("-fx-text-fill: BLACK;");
		helpSubScene.getPane().getChildren().add(help);		
	}

	/**
	 * Create score sub scene.
	 * Allows us to set the label style
	 * 
	 */
	public static void createScoreSubScene() {
	
		scoreSubScene = new SubSceneView();
		mainPane.getChildren().add(scoreSubScene);
		LabelView scoreLabel = new LabelView("HIGH SCORES");
		scoreLabel.setLayoutX(30);
		scoreLabel.setLayoutY(20);
		scoreLabel.setStyle("-fx-text-fill: GREEN;");
		scoreSubScene.getPane().getChildren().add(scoreLabel);
		
		Label score = new Label(ScoreController.getHighScores());
		score.setLayoutX(240);
		score.setLayoutY(14);	
		setTextFont(score,40);
		score.setStyle("-fx-text-fill: BLACK;");
		scoreSubScene.getPane().getChildren().add(score);	
		
		Label rank = new Label(" 1st -> \n"
								+ "2nd -> \n"
								+ "3rd -> \n"
								+ "4th -> \n"
								+ "5th -> ");
		rank.setLayoutY(76);
		rank.setLayoutX(150);
		setTextFont(rank,40);
		rank.setStyle("-fx-text-fill: green;");
		scoreSubScene.getPane().getChildren().add(rank);	
		
	}

	/**
	 * Method to add the buttons on mainPane
	 * Allows us to set the layout
	 * @param button
	 */
	private static void addMenuButton(ButtonView button) {
		button.setLayoutX(MENU_BUTTONS_STARTX);
		button.setLayoutY(MENU_BUTTONS_STARTY + menuButtons.size()*65);
		menuButtons.add(button);
		mainPane.getChildren().add(button);
	}
	
	/**
	 * Used to call methods that create buttons
	 */
	private static void createButtons() {
		createStartbutton();
		createHelpbutton();
		createScorebutton();
		createQuitbutton();
	}
	
	/**
	 * Set the actions to be taken when play button is pressed
	 */
	private static void createStartbutton() {
		ButtonView buttonPlay = new ButtonView("PLAY");
		addMenuButton(buttonPlay);
		
		buttonPlay.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				GameView gameView = GameController.getGame();			
				gameScene = new Scene(gameView,WIDTH,HEIGHT);				
				mainStage.setScene(gameScene);


			}
			
		});
	}
	

	/**
	 * Set the actions when help button is pressed
	 */
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
	

	
	/**
	 * Set the actions when score score button is pressed
	 */
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
	

	/**
	 * Close mainStage when button is pressed
	 */
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
	
	/**
	 * Allows us to set the image of the menu background
	 */
	private static void createBackground() {

		BackgroundImage menuBackground = new BackgroundImage("file:src/main/resources/Background/menu_bg11.png");
		mainPane.getChildren().add(menuBackground);
		
	}
	
	/**
	 * Allows us to set the logo on frogger menu
	 */
	private static void createLogo() {
		ImageView logo = new ImageView("file:src/main/resources/Logo/classic_logo.png");
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
		
		ImageView froggy = new ImageView("file:src/main/resources/Logo/frog.png");
		froggy.setLayoutX(185);
		froggy.setLayoutY(195);
		froggy.setFitWidth(250);
		froggy.setFitHeight(250);
		
		mainPane.getChildren().add(froggy);
		mainPane.getChildren().add(logo);
		
	}

	
	/**
	 * Used to determine the set of actions to be taken as the player loses the game.
	 * Shows alert message that displays the score and let player know that the game was lost.
	 */
	public static void gameOver() {
		
		ScoreModel.write(ScoreController.getScoresPath());
		mainStage.close();
		intialiseStage();
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("GAME OVER");
		alert.setHeaderText("YOUR SCORE IS "+ScoreController.getScore()+ "!");
		alert.setContentText("SORRY, YOU LOST, PRESS OK TO SEE SCORE BOARD");
		alert.show();		
		showSubScene(scoreSubScene);
		
	}
	
	/**
	 * Used to determine the set of actions to be taken when the player wins the game.
	 * Shows alert message that displays the score and let player know that the game was won.
	 */
	public static void gameWon() {
		ScoreModel.write(ScoreController.getScoresPath());
		mainStage.close();
		intialiseStage();
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("GAME COMPLETE");
		alert.setHeaderText("YOUR SCORE IS "+ScoreController.getScore()+ " !");
		alert.setContentText("YAY, YOU WON!!, PRESS OK TO SEE SCORE BOARD");
		alert.show();
		showSubScene(scoreSubScene);
	}
	
	/**
	 * Allows us to close the game stage and initialise the menu stage
	 */
	public static void getMenu() {
		mainStage.close();
		intialiseStage();
	}
	
	/**
	 * Used to set the font and font size.
	 * Uses try/catch in case the font file is not found
	 * @param label
	 */
	private static void setTextFont(Label label, int fontsize) {
		try {
			label.setFont(Font.loadFont(new FileInputStream("src/main/resources/Font/Kenney Pixel.ttf"),fontsize));
		} catch(FileNotFoundException e) {
			label.setFont(Font.font("Verdana",fontsize));
		}
	}

}
