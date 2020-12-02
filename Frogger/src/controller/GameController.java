package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.util.Duration;
import model.Actor;
import model.Insect;
import model.IntersectingObject;
import view.GameView;

public class GameController {
	
	public final static double FRAMERATE = 0.01;
	
	private static  GameView gameView;
	private static final Random RANDOM = new Random();

	private static int bonus = 0;
	
	
	static final Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(FRAMERATE), event -> {
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
		
		double chance = RANDOM.nextDouble();
		if (chance < 0.1) {
			if (LevelController.getLevel() == 3 || LevelController.getLevel() == 4 || LevelController.getLevel() == 5) {
				EndController.moveCrocodile();
			}

		} else if (bonus < 2 && chance > 0.5 && chance < 0.5005) {
			chance = RANDOM.nextDouble();
			int componentY = RANDOM.nextInt(10);
			int componentX = RANDOM.nextInt(5);
			int y = (componentY + 3) * 50 +1 ;
			int x = (componentX +100);
			if (LevelController.getLevel() == 1 || LevelController.getLevel() == 2 || LevelController.getLevel() == 3) {
				gameView.getChildren().add(new Insect(x,y));
				bonus++;
			}						
		}
	}));
	
	
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
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
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
