package com.Frogger.Manager;

import java.util.List;

import com.Frogger.Actor.Animal;
import com.Frogger.Actor.BackgroundImage;
import com.Frogger.Actor.Digit;
import com.Frogger.Actor.End;

import com.Frogger.Actor.Log;
import com.Frogger.Actor.Obstacle;
import com.Frogger.Actor.Turtle;
import com.Frogger.Actor.WetTurtle;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class GameViewManager {
	
	private MyStage gamePane;
	private Scene gameScene;
	private Stage gameStage;
	private Stage menuStage;
	Animal animal = new Animal("file:res/Sprites/froggerUp.png");
	long now;
	AnimationTimer timer;
	private static final int START_TIME = 60;
	
	
	private static final int GAME_WIDTH = 600;
	private static final int GAME_HEIGHT = 800;
		

	private static final int FROGGER_LIVES = 3;
	
	
	public int gameLives = FROGGER_LIVES;
	private ImageView[] froglives;

	public GameViewManager() {
		initialiseStage();
	}


	private void initialiseStage() {
		gamePane = new MyStage();
		gameScene = new Scene(gamePane,GAME_WIDTH, GAME_HEIGHT);
		gameStage = new Stage();
		gameStage.setScene(gameScene);

	}
	
	public void createNewGame(Stage menuStage) {
		this.menuStage = menuStage;
		this.menuStage.hide();		
		createTimer();
		createGameBackground();
		createFrogLives();
		CreateGameObstacles();
		createFrog();
		gameStage.show();
	}
	
	
	public void createGameBackground() {

		BackgroundImage gameBackground = new BackgroundImage("file:res/Background/backdroptry7.png");
		gamePane.add(gameBackground);
		
		
	}
	
	public void createFrog() {
		
		gamePane.add(animal);

	}
	
	public void CreateGameObstacles() {	
		
		createLogs();
		createTurtles();
		createCars();
		createTrucks();
		createDigits();
		createEnds();

		gamePane.start();
		start();
		
	}
	
	public void createLogs() {
		
		//first row
		gamePane.add(new Log("file:res/Obstacles/log3.png", 150, 0, 130, 0.75));
		gamePane.add(new Log("file:res/Obstacles/log3.png", 150, 220, 130, 0.75));
		gamePane.add(new Log("file:res/Obstacles/log3.png", 150, 440, 130, 0.75));
		gamePane.add(new Log("file:res/Obstacles/log3.png", 150, 880, 130, 0.75));
		
		//second row
		gamePane.add(new Log("file:res/Obstacles/logs.png", 300, 0, 240, -2));
		gamePane.add(new Log("file:res/Obstacles/logs.png", 300, 400, 240, -2));

		
		gamePane.add(new Log("file:res/Obstacles/log3.png", 150, 50, 293, 0.75));
		gamePane.add(new Log("file:res/Obstacles/log3.png", 150, 270, 293, 0.75));
		gamePane.add(new Log("file:res/Obstacles/log3.png", 150, 490, 293, 0.75));

	}
	
	
	public void createTurtles() {
		//first row
		gamePane.add(new Turtle(500, 340, -1, 130, 130));
		gamePane.add(new Turtle(300, 340, -1, 130, 130));
		gamePane.add(new WetTurtle(700, 340, -1, 130, 130));
		
		//second row
		gamePane.add(new WetTurtle(600, 181, -1, 130, 130));
		gamePane.add(new WetTurtle(400, 181, -1, 130, 130));
		gamePane.add(new WetTurtle(200, 181, -1, 130, 130));
	}
	
	public void createEnds() {
		gamePane.add(new End(13,54));
		gamePane.add(new End(141,54));
		gamePane.add(new End(141 + 141-13,54));
		gamePane.add(new End(141 + 141-13+141-13+1,54));
		gamePane.add(new End(141 + 141-13+141-13+141-13+3,54));		
	}
	
	
	public void createCars() {
		/*gamePane.add(new Obstacle("file:res/Obstacles/car1Left.png", 100, 615, -1, 45, 45));
		gamePane.add(new Obstacle("file:res/Obstacles/car1Left.png", 250, 615, -1, 45, 45));
		gamePane.add(new Obstacle("file:res/Obstacles/car1Left.png", 400, 615, -1, 45, 45));
		gamePane.add(new Obstacle("file:res/Obstacles/car1Left.png", 550, 615, -1, 45, 45));
		

		gamePane.add(new Obstacle("file:res/Obstacles/racecarleft.png", 500, 500, -5, 55, 55));*/
		
	}
	
	public void createTrucks() {
/*
		gamePane.add(new Obstacle("file:res/Obstacles/whitetruckright.png", 0, 655, 1, 95, 95));
		gamePane.add(new Obstacle("file:res/Obstacles/whitetruckright.png", 300, 655, 1, 100, 100));
		gamePane.add(new Obstacle("file:res/Obstacles/whitetruckright.png", 600, 655, 1, 100, 100));
		
		
		gamePane.add(new Obstacle("file:res/Obstacles/tractorright.png", 0, 550, 1, 60, 60));
		gamePane.add(new Obstacle("file:res/Obstacles/tractorright.png", 350, 550, 1, 60, 60));
		gamePane.add(new Obstacle("file:res/Obstacles/tractorright.png", 700, 550, 1, 60, 60));
		
		gamePane.add(new Obstacle("file:res/Obstacles/truck2Right.png", 0, 460 , 2 , 190,190));
		gamePane.add(new Obstacle("file:res/Obstacles/truck2Right.png", 500, 460 , 2 , 190,190));*/
	}
	
	
	public void createDigits() {
		gamePane.add(new Digit(0, 30, 500, 5));
	}
	
	
	public void createFrogLives() {
		
		froglives = new ImageView[FROGGER_LIVES];
		
		for (int i = 0 ; i < froglives.length ; i++) {
			froglives[i] = new ImageView("file:res/Sprites/frogger_pixel.png");
			froglives[i].setFitWidth(20);
			froglives[i].setFitHeight(20);
			
			froglives[i].setLayoutX(20 + (i * 30));
			froglives[i].setLayoutY(770);
			gamePane.getChildren().add(froglives[i]);
		}
	}
	
	public void checkFrogLifeStatus() {
		
		
			if(animal.getCarDeath() || animal.getWaterDeath()) {    					    		
				removeFrogLives();	    		
			} 
		
		
	}
		

	public void removeFrogLives() {		
			
		gamePane.getChildren().remove(froglives[gameLives - 1]);		
		//gameLives--;
		
		if(gameLives < 0) {
			gameStage.close();
			timer.stop();
			menuStage.show();
		}
		
	}
	
	
	public void createTimer() {
        timer = new AnimationTimer() {        	
            @Override
            public void handle(long now) {
            	//createFrogLives();
            	checkFrogLifeStatus();
            	           	
            	if (animal.changeScore()) {
            		setNumber(animal.getPoints());
            	}
            	
            	if (animal.getStop()) {
            		System.out.print("STOPP:");
            		gamePane.stopMusic();
            		stop();
            		gamePane.stop();
            		Alert alert = new Alert(AlertType.INFORMATION);
            		alert.setTitle("You Have Won The Game!");
            		alert.setHeaderText("Your High Score: "+animal.getPoints()+"!");
            		alert.setContentText("Highest Possible Score: 800");
            		alert.show();
            	}
            }
        };
       // timer.start();
    }
	
	public void start() {
		gamePane.playMusic();
    	createTimer();
        timer.start();
    }

    public void stop() {
        timer.stop();
    }
    
    public void setNumber(int n) {
    	int shift = 0;
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  gamePane.add(new Digit(k, 30, 500 - shift, 5));
    		  shift+=30;
    		}
    }
    
    
}
