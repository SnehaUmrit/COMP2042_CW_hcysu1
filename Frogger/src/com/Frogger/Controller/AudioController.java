package com.Frogger.Controller;

import java.io.File;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;

import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class AudioController {

	
	private static final MediaPlayer MENU_AUDIO = new MediaPlayer(new Media(new File("res/Music/NoCopyrightMenuMusic.mp3").toURI().toString()));
	private static final MediaPlayer GAME_AUDIO = new MediaPlayer(new Media(new File("res/Music/Frogger Main Song Theme (loop).mp3").toURI().toString()));
	private static final MediaPlayer HOP_AUDIO = new MediaPlayer(new Media(new File("res/Music/sound-frogger-hop.wav").toURI().toString()));
	private static final MediaPlayer STREET_DEATH_AUDIO = new MediaPlayer(new Media(new File("res/Music/sound-frogger-squash.wav").toURI().toString()));
	private static final MediaPlayer WATER_DEATH_AUDIO = new MediaPlayer(new Media(new File("res/Music/sound-frogger-plunk.wav").toURI().toString()));
	private static final MediaPlayer BONUS_AUDIO = new MediaPlayer(new Media(new File("res/Music/bonus.wav").toURI().toString()));
	private static final MediaPlayer END_AUDIO = new MediaPlayer(new Media(new File("res/Music/sound-frogger-extra.wav").toURI().toString()));
	private static final MediaPlayer WIN_AUDIO = new MediaPlayer(new Media(new File("res/Music/win.wav").toURI().toString()));
	private static final MediaPlayer GAMEOVER_AUDIO = new MediaPlayer(new Media(new File("res/Music/gameover.wav").toURI().toString()));
	
	
	public static void playMenuAudio() {
		GAME_AUDIO.stop();
		MENU_AUDIO.setCycleCount(MediaPlayer.INDEFINITE);
		MENU_AUDIO.play();
		
		
	}

	public static void playGameAudio() {
		MENU_AUDIO.stop();
		//GAME_AUDIO.setCycleCount(MediaPlayer.INDEFINITE);
		//GAME_AUDIO.play();		
	}
	
	
	public static void playHopAudio() {
		HOP_AUDIO.seek(Duration.ZERO);
		HOP_AUDIO.play();

	}

	public static void playWaterDeathAudio() {
		WATER_DEATH_AUDIO.seek(Duration.ZERO);
		WATER_DEATH_AUDIO.play();
	}

	public static void playStreetDeathAudio() {
		STREET_DEATH_AUDIO.seek(Duration.ZERO);
		STREET_DEATH_AUDIO.play();
	}
	
	public static void playBonusAudio() {
		BONUS_AUDIO.seek(Duration.ZERO);
		BONUS_AUDIO.play();
	}
	
	
	public static void playEndAudio() {
		END_AUDIO.seek(Duration.ZERO);
		END_AUDIO.play();
	}
	
	
	public static void playWinAudio() {
		WIN_AUDIO.seek(Duration.ZERO);
		WIN_AUDIO.play();
	}
	
	
	public static void playGameOverAudio() {
		GAMEOVER_AUDIO.seek(Duration.ZERO);
		GAMEOVER_AUDIO.play();
	}
	
}
