package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.util.Duration;
import model.Actor;
import model.Insect;
import model.IntersectingObject;
import view.GameView;

/**
 * New class that allows us to set the animation of the models. <p>
 * Creates an instance of GameView.
 * Uses Timeline to set animation framerate.
 * Determine the probabilty at which the insect appears and also at which level.
 * Determines the movement of the crocodile at the ends.
 * Used to remove and set the game elements.
 * 
 * @author Amended from given World class
 *
 */
public class GameController {
	
	/**
	 * Instance variable used to set the rate at which the animation will occur.
	 */
	public final static double FRAMERATE = 0.01;
		
	private static final Random ANIMATION = new Random();
	private static  GameView gameView;
	/**
	 * Appearance of insect which serve as bonus points to frog
	 */
	private static int bonus = 0;
	
	/**
	 * When level completed, all the elements of the current level is removed.
	 * The elements of the next game are loaded.
	 * Allows us to set the probability and level at which the insect appears and the crocodile moves 
	 */
	static final Timeline TIMELINE = new Timeline(new KeyFrame(Duration.seconds(FRAMERATE), event -> {
	
		if (EndController.levelCompleted()) {

			EndController.newLevel();
			gameView.getChildren().removeAll(LevelController.getCurrentLevel());
			gameView.getChildren().addAll(LevelController.getNextLevel());		
		}

		
		List<IntersectingObject> objects = getObjects(IntersectingObject.class);
		for (IntersectingObject object : objects) {
			if (object instanceof Actor) {
				((Actor)object).act();
			}
		}
		
		double probability = ANIMATION.nextDouble();
		if (probability < 0.1) {
			if (LevelController.getLevel() == 3 || LevelController.getLevel() == 5 || LevelController.getLevel() == 7 || LevelController.getLevel() == 9 || LevelController.getLevel() == 10) {
				EndController.moveCrocodile();
			}

		} else if (bonus < 2 && probability > 0.5 && probability < 0.5005) {
			probability = ANIMATION.nextDouble();
			int componentY = ANIMATION.nextInt(8);
			int componentX = ANIMATION.nextInt(4);
			int y = (componentY + 3) * 50 +1 ;
			int x = (componentX + 100);
			if (LevelController.getLevel() == 1 || LevelController.getLevel() == 2 || LevelController.getLevel() == 3 || LevelController.getLevel() == 4 || LevelController.getLevel() == 5) {
				gameView.getChildren().add(new Insect(x,y));
				bonus++;
			}						
		}
	}));
	
	/**
	 * getGame uses the static instance of GameView.
	 * Allows us to set the scene in MenuController when start button is pressed
	 * @return gameView
	 */
	public static GameView getGame() {
		
		gameView = new GameView();
		
		gameView.sceneProperty().addListener((observableValue,scene, next ) -> next.setOnKeyPressed(event -> {
			List<IntersectingObject> objects = GameController.getObjects(IntersectingObject.class);
			for(IntersectingObject object:objects) {
				if(object.getOnKeyPressed() != null) {
					object.getOnKeyPressed().handle(event);
				}
			}
		}));		
		TIMELINE.setCycleCount(Animation.INDEFINITE);
		TIMELINE.play();
		return gameView;
	}


	public static List<IntersectingObject> getObjects(Class<IntersectingObject> cls){
		ArrayList<IntersectingObject> objects = new ArrayList<>();
		for (Node n:gameView.getChildren()) {
			if (cls.isInstance(n)) {
				objects.add((IntersectingObject) n);
			}
		}
		return objects;
	}
	
	
}
