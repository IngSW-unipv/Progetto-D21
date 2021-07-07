package core;

import java.io.File;
import java.util.ArrayList;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

/**
 * This class makes possible the volume customization during a game
 */
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

	public static synchronized void playSoundLoop(File f,double v) {
		Thread audioThread = new Thread() {

			public void run() {
				try {
					Clip clip = AudioSystem.getClip();
					clip.open(AudioSystem.getAudioInputStream(f));
					suoni.add(clip);
					setVol(v,clip);
					clip.start();
					clip.loop(Clip.LOOP_CONTINUOUSLY);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}; audioThread.start();
	}

	/**
	 * The following methods set the volume following some different parameters
	 *
	 * @param v
	 * @param clip
	 */
	
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

	public static void stopMusic(){
		for(Clip entry:suoni){
			entry.stop();
		}
	}
	
}