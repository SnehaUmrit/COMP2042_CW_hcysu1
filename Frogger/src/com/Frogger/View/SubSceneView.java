package com.Frogger.View;


import javafx.animation.TranslateTransition;

import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class SubSceneView extends SubScene{

	//private  static final String FONT_PATH = "res/Font/Kenney_Future_Narrow.ttf";
	private static final String BACKGROUND_IMAGE = "file:res/Buttons/green_panel.png";
	private boolean isHidden = true;
	
	
	public SubSceneView() {
		super(new AnchorPane(), 460, 245);
		prefWidth(460); 
		prefHeight(250);		

		BackgroundImage image = new BackgroundImage(new Image(BACKGROUND_IMAGE,460,250,false,true),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
		
		AnchorPane root2 = (AnchorPane)this.getRoot();

		root2.setBackground(new Background(image));
		
		setLayoutX(600);
		setLayoutY(190);


	}
	

	public void moveSubScene() {
		
		TranslateTransition transition = new TranslateTransition();
		transition.setDuration(Duration.seconds(0.3));
		transition.setNode(this);		
		
		
		if(isHidden) {
			transition.setToX(-523);
			isHidden = false;
		} else {
			transition.setToX(0);
			isHidden = true;
		}
		transition.play();
		
	}
	
	public AnchorPane getPane() {
		return (AnchorPane) this.getRoot();
	}
	
	




}
