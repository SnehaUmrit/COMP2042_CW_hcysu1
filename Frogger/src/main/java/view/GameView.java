package view;



import controller.*;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import model.BackgroundImage;

/**
 * New class that extends Pane and uses constructor to set the game views. <p>
 * Allows us to set the background of the game.
 * Allows us to add to the game the various other views using the controller classes
 * @author hcysu1
 *
 */
public class GameView  extends Pane{
	
	static DropShadow drop;
	
	
	public GameView() {
		BackgroundImage gameBackground = new BackgroundImage("file:src/main/resources/Background/backdroptry16.png");
		getChildren().add(gameBackground);	
	
		getChildren().add(LevelController.getLevelView());
		getChildren().add(TimeController.getTimeView());
		getChildren().add(ScoreController.getScoreView());
		getChildren().add(LivesController.getLivesView());
		
		getChildren().addAll(LevelController.getStartingLevel());
		
		getChildren().addAll(EndController.getEnds());
		
		
		
		}
	
	
	public static void initialiseButtonListeners(Button button) {
		drop = new DropShadow();
		button.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(event.getButton().equals(MouseButton.PRIMARY)) {
					button.setLayoutY(2);
					MenuController.getMenu();
				}
			}			
		});
	
		
		button.setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(event.getButton().equals(MouseButton.PRIMARY)) {
					button.setLayoutY(0);
				}
			}			
		});
		
		button.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				drop = new DropShadow();
				drop.setColor(Color.WHITE);
				drop.setRadius(5);
				button.setEffect(drop);
				
			}			
		});
		
		
		button.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				drop = new DropShadow();
				drop.setColor(Color.BLACK);
				drop.setRadius(10);
				button.setEffect(drop);
				
			}			
		});
		
	}
	
	public static void setHomeButton(Button button, ImageView view) {	
		button.setGraphic(view);
		button.setBackground(null);
		button.setTranslateX(553);
		button.setTranslateY(0);
		button.setMaxWidth(23);
		button.setMaxHeight(23);
	}
		
	

}