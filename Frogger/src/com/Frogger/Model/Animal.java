package com.Frogger.Model;


import java.util.Arrays;
import java.util.List;

import com.Frogger.Controller.AudioController;
import com.Frogger.Controller.EndController;
import com.Frogger.Controller.LivesController;
import com.Frogger.Controller.MenuController;
import com.Frogger.Controller.ScoreController;
import com.Frogger.Controller.TimeController;

import javafx.animation.PauseTransition;

import javafx.scene.input.KeyCode;

import javafx.util.Duration;

public class Animal extends AnimatedObject {
	private static final int CONSTANT = 25;
	private static final int WATER_LEVEL = 400;
	private static final int INSECT_BONUS = 100;
	private final PauseTransition pause = new PauseTransition(Duration.millis(120));
	private boolean noMove, carDeath, waterDeath = false;
	private static boolean finished;

	public Animal() {
		super(300, 700, 50, 50, new String[] {
				"file:res/Sprites/froggerUp.png",       //0
				"file:res/Sprites/froggerLeft.png",     //1
				"file:res/Sprites/froggerDown.png",		//2
				"file:res/Sprites/froggerRight.png",	//3
				"file:res/Sprites/froggerUpJump.png",	//4
				"file:res/Sprites/froggerLeftJump.png",	//5
				"file:res/Sprites/froggerDownJump.png",	//6
				"file:res/Sprites/froggerRightJump.png",//7
				"file:res/Sprites/cardeath1.png",		//8
				"file:res/Sprites/cardeath2.png",		//9
				"file:res/Sprites/cardeath3.png",		//10
				"file:res/Sprites/cardeath4.png",		//11
				"file:res/Sprites/waterdeath1.png",		//12
				"file:res/Sprites/waterdeath2.png",		//13
				"file:res/Sprites/waterdeath3.png",		//14
				"file:res/Sprites/waterdeath4.png"		//15
		});
		
		setState(0);
		AudioController.playGameAudio();
		setOnKeyPressed(KeyEvent -> {
			if (!noMove) {
				if (KeyEvent.getCode() == KeyCode.W) {
					setState(4);
					move(0,-CONSTANT);
					pause.setOnFinished(actionEvent ->{
						move (0, -CONSTANT);
						setState(0);
					});
				}
				
				if (KeyEvent.getCode() == KeyCode.A) {
					setState(5);
					move(-CONSTANT,0);
					pause.setOnFinished(actionEvent -> {
						move(-CONSTANT,0);
						setState(1);
					});
				}
				
				if (KeyEvent.getCode() == KeyCode.S) {
					setState(6);
					move(0,CONSTANT);
					pause.setOnFinished(actionEvent -> {
						move(0,CONSTANT);
						setState(2);
					});
				}
				
				if (KeyEvent.getCode() == KeyCode.D) {
					setState(7);
					move(CONSTANT,0);
					pause.setOnFinished(actionEvent -> {
						move(CONSTANT,0);
						setState(3);
					});
				}
				
				pause.play();
			}
			
		});
		
		finished = false;
		
	}
	
	private void setState(int state) {
		setImage(this.states[state]);
	}


	private void respawn(int points) {
		pause.setOnFinished(actionEvent -> {
			setX(300);
			setY(700);
			carDeath = waterDeath = noMove = false;
			ticks = 0;
			setState(0);
			ScoreController.changeScore(points);
			TimeController.reset();
			
		});
		pause.play();
	}
	
	
	@Override
	public void act() {
		if (ticks == -1 ) {
			if (LivesController.getFrogLives() > 0) {
				respawn(-50);
			} else if (!finished) {
				finished = true;
				MenuController.gameOver();
			}
		}
		
				
		if (getY() > 700 || getY() < 0)
			setY(700);
		if (getY() < 0 )
			setX(600);
		else if(getX() > 600 )
			setX(0);
		
		
		if (carDeath) 
			animate(Arrays.copyOfRange(states,8,12),20);
		else if (waterDeath)
			animate(Arrays.copyOfRange(states, 12, 16),20);
		else if (!noMove) {
			List<IntersectingObject> objects = getIntersectingObjects();
			if (objects.isEmpty() && getY() < WATER_LEVEL) {
				noMove = waterDeath = true;
				LivesController.removeFrogLife();
			}
			
			for (IntersectingObject object : objects) {
				if (object instanceof Obstacle) {
					carDeath = noMove = true;
					LivesController.removeFrogLife();
				} else if (object instanceof Snake) {
					carDeath = noMove = true;
					LivesController.removeFrogLife();
				} else if (object instanceof Insect && !((Insect) object).isIntersecting()) {
					((Insect) object).intersect();
					ScoreController.changeScore(INSECT_BONUS);
				} else if (object instanceof Log)
					move(((Log) (object)).actorSpeed,0);
				
				else if (object instanceof WetTurtle) {
					if (((WetTurtle) object).isSunk())
						waterDeath = noMove =  true;
					else 
						move(((WetTurtle) (object)).actorSpeed,0);
				
				} else if (object instanceof Turtle)
					move(((Turtle) (object)).actorSpeed,0);
				else if (object instanceof End) {
					if (EndController.unsafe(object)) {
						noMove = carDeath = true;
						LivesController.removeFrogLife();
					} else if (EndController.inactive(object)) {
						noMove = true;
						EndController.activate(object);
						respawn(100);
					} 
				}
				
			}
		}
		
	}
	

		
	
}