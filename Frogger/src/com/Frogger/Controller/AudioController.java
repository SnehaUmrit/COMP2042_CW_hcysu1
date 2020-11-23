package com.Frogger.Controller;

import java.io.File;

import javafx.scene.media.Media;

import javafx.scene.media.MediaPlayer;

public class AudioController {

	
	private static final MediaPlayer MENU_AUDIO = new MediaPlayer(new Media(new File("res/Music/Frogger Main Song Theme (loop).mp3").toURI().toString()));
	private static final MediaPlayer GAME_AUDIO = new MediaPlayer(new Media(new File("res/Music/Frogger Main Song Theme (loop).mp3").toURI().toString()));
	
	public static void playMenuAudio() {
		GAME_AUDIO.stop();
		MENU_AUDIO.setCycleCount(MediaPlayer.INDEFINITE);
		MENU_AUDIO.play();
		
		
	}

	public static void playGameAudio() {
		MENU_AUDIO.stop();
		GAME_AUDIO.setCycleCount(MediaPlayer.INDEFINITE);
		GAME_AUDIO.play();
		
	}

	
}
