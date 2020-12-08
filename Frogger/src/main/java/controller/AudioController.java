package controller;

import java.io.File;


import javafx.scene.media.Media;

import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

/**
 * 
 * New class that allows us to set different audio at different points in the game.<p>
 * Audio for menu that plays on a loop
 * Audio for sprite movements
 * Audio for water death and street death
 * Audio for game lost and game won
 * @author hcysu1
 *
 */
public class AudioController {

	/**
	 * Set the path of the audio files
	 */
	private static final MediaPlayer MENU_AUDIO = new MediaPlayer(new Media(new File("src/main/resources/Music/NoCopyrightMenuMusic.mp3").toURI().toString()));	
	private static final MediaPlayer HOP_AUDIO = new MediaPlayer(new Media(new File("src/main/resources/Music/sound-frogger-hop.wav").toURI().toString()));
	private static final MediaPlayer STREET_DEATH_AUDIO = new MediaPlayer(new Media(new File("src/main/resources/Music/sound-frogger-squash.wav").toURI().toString()));
	private static final MediaPlayer WATER_DEATH_AUDIO = new MediaPlayer(new Media(new File("src/main/resources/Music/sound-frogger-plunk.wav").toURI().toString()));
	private static final MediaPlayer BONUS_AUDIO = new MediaPlayer(new Media(new File("src/main/resources/Music/bonus.wav").toURI().toString()));
	private static final MediaPlayer END_AUDIO = new MediaPlayer(new Media(new File("src/main/resources/Music/sound-frogger-extra.wav").toURI().toString()));
	private static final MediaPlayer WIN_AUDIO = new MediaPlayer(new Media(new File("src/main/resources/Music/win.wav").toURI().toString()));
	private static final MediaPlayer GAMEOVER_AUDIO = new MediaPlayer(new Media(new File("src/main/resources/Music/gameover.wav").toURI().toString()));
	
	/**
	 * Allows us to play the menu audio continuously by using setCycleCount and setting it to indefinite
	 */
	public static void playMenuAudio() {
		MENU_AUDIO.setCycleCount(MediaPlayer.INDEFINITE);
		MENU_AUDIO.play();		
	}

	
	/**
	 * Before playing the game audio we have to stop the menu audio from playing
	 * We can do so by calling this method
	 */
	public static void stopMenuAudio() {
		MENU_AUDIO.stop();		
	}
	
	/**
	 * This audio is played for each movement of the frog
	 * In order to play it for each W,A,S,D key press, we have to rewind it every time before playing
	 * We do so using seek(Duration.ZERO)
	 */
	public static void playHopAudio() {
		HOP_AUDIO.seek(Duration.ZERO);
		HOP_AUDIO.play();

	}

	/**
	 * This audio should be played every time the frog dies when sunk
	 * We rewind it before playing so that it can be played every time the frog sinks
	 */
	public static void playWaterDeathAudio() {
		WATER_DEATH_AUDIO.seek(Duration.ZERO);
		WATER_DEATH_AUDIO.play();
	}

	/**
	 * This audio should be played every time the frog dies when hit by a vehicle
	 */
	public static void playStreetDeathAudio() {
		STREET_DEATH_AUDIO.seek(Duration.ZERO);
		STREET_DEATH_AUDIO.play();
	}
	
	/**
	 * This audio is played every time the frog gains an insect bonus
	 */
	public static void playBonusAudio() {
		BONUS_AUDIO.seek(Duration.ZERO);
		BONUS_AUDIO.play();
	}
	
	/**
	 * This audio is played every time the frog reaches an end
	 */
	public static void playEndAudio() {
		END_AUDIO.seek(Duration.ZERO);
		END_AUDIO.play();
	}
	
	/**
	 * This audio is played when the player completes all the levels and wins the game
	 */
	public static void playWinAudio() {
		WIN_AUDIO.seek(Duration.ZERO);
		WIN_AUDIO.play();
	}
	
	/**
	 * This audio is played when the player loses the game
	 */
	public static void playGameOverAudio() {
		GAMEOVER_AUDIO.seek(Duration.ZERO);
		GAMEOVER_AUDIO.play();
	}
	
	
}
