package com.Frogger.Manager;

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
import javafx.stage.Stage;

public class GameViewManager {
	
	private MyStage gamePane;
	private Scene gameScene;
	private Stage gameStage;

	
	private static final int GAME_WIDTH = 600;
	private static final int GAME_HEIGHT = 800;
	
	private Stage menuStage;
	
	Animal animal;
	AnimationTimer timer;
	
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
		createObstacles();
		createFrog();
		gameStage.show();
	}
	
	
	public void createGameBackground() {
		BackgroundImage gameBackground = new BackgroundImage("file:res/Background/gamebackground.png");
		gamePane.add(gameBackground);
	}
	
	public void createFrog() {
		animal = new Animal("file:res/Sprites/froggerUp.png");
		gamePane.add(animal);
		
	}
	
	
	public void createObstacles() {
		gamePane.add(new Log("file:res/Obstacles/log3.png", 150, 0, 166, 0.75));
		gamePane.add(new Log("file:res/Obstacles/log3.png", 150, 220, 166, 0.75));
		gamePane.add(new Log("file:res/Obstacles/log3.png", 150, 440, 166, 0.75));
		//background.add(new Log("file:src/p4_group_8_repo/log3.png", 150, 0, 166, 0.75));
		gamePane.add(new Log("file:res/Obstacles/logs.png", 300, 0, 276, -2));
		gamePane.add(new Log("file:res/Obstacles/logs.png", 300, 400, 276, -2));
		//background.add(new Log("file:src/p4_group_8_repo/logs.png", 300, 800, 276, -2));
		gamePane.add(new Log("file:res/Obstacles/log3.png", 150, 50, 329, 0.75));
		gamePane.add(new Log("file:res/Obstacles/log3.png", 150, 270, 329, 0.75));
		gamePane.add(new Log("file:res/Obstacles/log3.png", 150, 490, 329, 0.75));
		//background.add(new Log("file:src/p4_group_8_repo/log3.png", 150, 570, 329, 0.75));
		gamePane.add(new Turtle(500, 376, -1, 130, 130));
		gamePane.add(new Turtle(300, 376, -1, 130, 130));
		gamePane.add(new WetTurtle(700, 376, -1, 130, 130));
		gamePane.add(new WetTurtle(600, 217, -1, 130, 130));
		gamePane.add(new WetTurtle(400, 217, -1, 130, 130));
		gamePane.add(new WetTurtle(200, 217, -1, 130, 130));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 100, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 0, 100, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 120, -1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 120, -1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 140, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 140, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 160, -1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 300, 160, -1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 180, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 180, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 200, -1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 200, -1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 220, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 220, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 400, 220, 1));
		//End end2 = new End();
		//End end3 = new End();
		//End end4 = new End();
		//End end5 = new End();
		gamePane.add(new End(13,96));
		gamePane.add(new End(141,96));
		gamePane.add(new End(141 + 141-13,96));
		gamePane.add(new End(141 + 141-13+141-13+1,96));
		gamePane.add(new End(141 + 141-13+141-13+141-13+3,96));
		
		gamePane.add(new Obstacle("file:res/Obstacles/truck1"+"Right.png", 0, 649, 1, 120, 120));
		gamePane.add(new Obstacle("file:res/Obstacles/truck1"+"Right.png", 300, 649, 1, 120, 120));
		gamePane.add(new Obstacle("file:res/Obstacles/truck1"+"Right.png", 600, 649, 1, 120, 120));
		//background.add(new Obstacle("file:src/p4_group_8_repo/truck1"+"Right.png", 720, 649, 1, 120, 120));
		gamePane.add(new Obstacle("file:res/Obstacles/car1Left.png", 100, 597, -1, 50, 50));
		gamePane.add(new Obstacle("file:res/Obstacles/car1Left.png", 250, 597, -1, 50, 50));
		gamePane.add(new Obstacle("file:res/Obstacles/car1Left.png", 400, 597, -1, 50, 50));
		gamePane.add(new Obstacle("file:res/Obstacles/car1Left.png", 550, 597, -1, 50, 50));
		gamePane.add(new Obstacle("file:res/Obstacles/truck2Right.png", 0, 540, 1, 200, 200));
		gamePane.add(new Obstacle("file:res/Obstacles/truck2Right.png", 500, 540, 1, 200, 200));
		gamePane.add(new Obstacle("file:res/Obstacles/car1Left.png", 500, 490, -5, 50, 50));
		gamePane.add(new Digit(0, 30, 360, 25));
		//background.add(obstacle);
		//background.add(obstacle1);
		//background.add(obstacle2);
		
		
		
		
		
		
		
		
		
		
		
		
		gamePane.start();
		start();
	}
	
	
	public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
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
    		  gamePane.add(new Digit(k, 30, 360 - shift, 25));
    		  shift+=30;
    		}
    }
}
