package core;

import java.io.File;
import java.util.ArrayList;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class SoundPlayer {
	
	private static ArrayList<Clip> suoni = new ArrayList<Clip>();
	
	public static synchronized void playSound(File f,double v) {
		Thread audioThread = new Thread() {
			
			public void run() {
				try {
					Clip clip = AudioSystem.getClip();
					clip.open(AudioSystem.getAudioInputStream(f));
					suoni.add(clip);
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
	
	public static void setVol(double v,int i) {
		FloatControl gain = (FloatControl)suoni.get(i).getControl(FloatControl.Type.MASTER_GAIN);
		float db = (float) (Math.log(v)/Math.log(10)*20);
		gain.setValue(db);
	}

	public static void setGlobalVol(double v) {
		for(Clip entry:suoni){
			FloatControl gain = (FloatControl)entry.getControl(FloatControl.Type.MASTER_GAIN);
			float db = (float) (Math.log(v)/Math.log(10)*20);
			gain.setValue(db);
		}
	}
	
}