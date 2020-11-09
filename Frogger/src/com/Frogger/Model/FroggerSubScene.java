package com.Frogger.Model;



import com.Frogger.Manager.MyStage;

import javafx.animation.TranslateTransition;
import javafx.scene.Parent;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.util.Duration;

public class FroggerSubScene extends SubScene{

	private  static final String FONT_PATH = "res/Font/Kenney_Future_Narrow.ttf";
	private static final String BACKGROUND_IMAGE = "file:res/Buttons/green_panel.png";
	private boolean isHidden = true;
	
	
	public FroggerSubScene() {
		super(new MyStage(), 450, 230);
		prefWidth(450);
		prefHeight(220);		
		BackgroundImage image = new BackgroundImage(new Image(BACKGROUND_IMAGE,450,230,false,true),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
		
		MyStage root2 = (MyStage)this.getRoot();
		root2.setBackground(new Background(image));
		
		setLayoutX(600);
		setLayoutY(180);

	}
	

	public void moveSubScene() {
		
		TranslateTransition transition = new TranslateTransition();
		transition.setDuration(Duration.seconds(0.3));
		transition.setNode(this);		
		
		
		if(isHidden) {
			transition.setToX(-515);
			isHidden = false;
		} else {
			transition.setToX(0);
			isHidden = true;
		}
		transition.play();
		
	}
	




}
