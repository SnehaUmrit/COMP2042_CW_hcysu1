package model;


import java.util.Arrays;
import java.util.List;

import controller.AudioController;
import controller.EndController;
import controller.LivesController;
import controller.MenuController;
import controller.ScoreController;
import controller.TimeController;
import javafx.animation.PauseTransition;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

/**
 * 
 * Defines the behaviour of the frog which is controlled by the player <p>
 * Extends AnimatedObject. Uses PauseTransition to check when key is released instead of previously used setOnKeyReleased key event that was less efficient
 * @author Amended from given Animal class
 *
 */
public class Animal extends AnimatedObject {
	
	private static final int START_X = 300;
	private static final int START_Y = 719;
	private static final int CONSTANT = 25;
	private static final int WATER_LEVEL = 350;
	private static final int INSECT_BONUS = 100;
	private final PauseTransition pause = new PauseTransition(Duration.millis(120));
	private boolean noMove, carDeath, waterDeath = false;
	private static boolean gameOver;

	/**
	 * 
	 * Uses an array to store the different images of the frog.
	 * Allows us to switch easily between states and is more efficient when it comes to animations such as death animation and water animation.
	 * Also allows us to set the audio depending on the movement of the frog.
	 * @param x Defines x position of frog
	 * @param y Defines y position of frog
	 */
	public Animal(int x, int y) {		
		super(x, y, 38, 38, new String[] {
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
		AudioController.stopMenuAudio();
		setOnKeyPressed(KeyEvent -> {
			if (!noMove) {
				if (KeyEvent.getCode() == KeyCode.W) {
					AudioController.playHopAudio();	
					
					setState(4);
					move(0,-CONSTANT);
					pause.setOnFinished(actionEvent ->{
						ScoreController.changeScore(5.5555555);
						move (0, -CONSTANT);
						setState(0);
					});
				}
				
				if (KeyEvent.getCode() == KeyCode.A) {
					AudioController.playHopAudio();
					setState(5);
					move(-CONSTANT,0);
					pause.setOnFinished(actionEvent -> {
						move(-CONSTANT,0);
						setState(1);
					});
				}
				
				if (KeyEvent.getCode() == KeyCode.S) {
					AudioController.playHopAudio();
					setState(6);
					move(0,CONSTANT);
					pause.setOnFinished(actionEvent -> {
						move(0,CONSTANT);
						setState(2);
					});
				}
				
				if (KeyEvent.getCode() == KeyCode.D) {
					AudioController.playHopAudio();
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

		gameOver = false;
	}
	
	/**
	 * Used to set the image of the frog by choosing from the array
	 * @param state The number in the array of images representing the different sprites of the frog
	 */
	private void setState(int state) {		
		setImage(this.states[state]);
	}


	/**
	 * Method to change points accordingly and reset the progress bar and position of frog.
	 * Uses the changeScore method from ScoreController
	 * @param points The point that is to be deducted or added
	 */
	private void changePoints(int points) {
		pause.setOnFinished(actionEvent -> {
			setX(START_X);
			setY(START_Y);
			carDeath = waterDeath = noMove = false;
			checks = 0;
			setState(0);
			ScoreController.changeScore(points);
			TimeController.reset();		
		});
		pause.play();
	}
	
	/**
	 * Defines various response of the frog based on the distinct actions.
	 * Checks intersections of frog with other actors. 
	 * Checks whether frog has reached the end and call changePoints method when needed.
	 * Reset progress bar and remove frog lives accordingly.
	 */
	@Override
	public void act() {
		if (checks == -1 ) {
			if (LivesController.getFrogLives() > 0 ) {
				if (ScoreController.getScore() >= 50) {
					changePoints(-50);
				} else {
					changePoints(0);
				}
				
			} else if (!gameOver) {
				
				gameOver = true;	
				AudioController.playGameOverAudio();
				MenuController.gameOver();
			}
		}
		
				
		if (getY() > START_Y || getY() < 0)
			setY(START_Y);
		if (getY() < 0 )
			setX(600);
		else if(getX() > 600 )
			setX(0);
		
		
		if (carDeath) {
			
			AudioController.playStreetDeathAudio();
			setAnimation(Arrays.copyOfRange(states,8,12),20);				
		}
			
			
		else if (waterDeath) {
			AudioController.playWaterDeathAudio();
			setAnimation(Arrays.copyOfRange(states, 12, 16),20);
		}
			
		
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
					AudioController.playBonusAudio();
					ScoreController.changeScore(INSECT_BONUS);
				} else if (object instanceof Log)
					move(((Log) (object)).actorSpeed,0);
				
				
				else if (object instanceof WetTurtle) {
					if (((WetTurtle) object).isSunk()) {
						waterDeath = noMove =  true;
						LivesController.removeFrogLife();
					}
				else 
						move(((WetTurtle) (object)).actorSpeed,0);
				
				} else if (object instanceof Turtle)
					move(((Turtle) (object)).actorSpeed,0);
				
				
				else if (object instanceof UnsafeCrocodile) {
					if (((UnsafeCrocodile) object).isOpen()) {
						waterDeath = noMove =  true;
						LivesController.removeFrogLife();
					}
						
					else 
						move(((UnsafeCrocodile) (object)).actorSpeed,0);
					
				} else if (object instanceof SafeCrocodile)
					move(((SafeCrocodile) (object)).actorSpeed,0);
				
	
				else if (object instanceof End) {
					if (EndController.unsafe(object)) {
						noMove = carDeath = true;
						LivesController.removeFrogLife();
					} else if (EndController.inactive(object)) {
						noMove = true;
						AudioController.playEndAudio();
						EndController.activate(object);						
						changePoints(100);
					} 
				}
				

				
			}
		}
		
	
	}
}

		
	
