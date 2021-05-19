package model.partita.util;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class SoundPlayer {
	
	public static synchronized void playSound(File f,double v) {
		
		Thread audioThread = new Thread() {
			
			public void run() {
				try {
					Clip clip = AudioSystem.getClip();
					clip.open(AudioSystem.getAudioInputStream(f));
					setVol(v,clip);
					clip.start();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}		
		}; audioThread.start();	
	}
	
	private static void setVol(double v,Clip clip) {
		FloatControl gain = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
		float db = (float) (Math.log(v)/Math.log(10)*20);
		gain.setValue(db);
	}
	
}