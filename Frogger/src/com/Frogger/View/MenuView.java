package com.Frogger.View;

import com.Frogger.Controller.AudioController;
import com.Frogger.Model.BackgroundImage;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class MenuView extends GridPane {

	


	/**
	 * 
	 */
	public MenuView() {		
		//AudioController.playMenuAudio();
		createMenuBackground();
		createLogo();
		
		
	}
	
	
	public void createMenuBackground() {
		BackgroundImage menuBackground = new BackgroundImage("file:res/Background/menubg6.png");
		add(menuBackground,1,1,1,1);
	}
	
	
	public void createLogo() {
		ImageView logo = new ImageView("file:res/Logo/logo_design.png");
		//logo.setLayoutX(6);
		//logo.setLayoutY(-5);
		//logo.setFitHeight(600);
		//logo.setFitWidth(600);
		add(logo,2,2,1,1);
		
		
		
		
		
		
	}


	
	
}
