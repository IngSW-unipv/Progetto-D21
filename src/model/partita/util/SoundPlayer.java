package model.partita.util;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundPlayer {
	
	static SoundPlayer player = null;
	
	private SoundPlayer() {
		
	}
	
	public static SoundPlayer getSoundPlayer() {
		if (player==null) {
			player = new SoundPlayer();
			return player;
		}else {
			return player;
		}
	}

	public static void RiproduciSuono(File Suono) {
		  try {
			    Clip clip = AudioSystem.getClip();
			    clip.open(AudioSystem.getAudioInputStream(Suono));
			    clip.start();
			  } catch (Exception e) {
			    System.out.println(e);
			  }
			}
	
}
