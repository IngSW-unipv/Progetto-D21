package core;

import java.util.TimerTask;
import javax.swing.JLabel;
import javax.swing.JPanel;

<<<<<<< HEAD:ClientProject/src/core/AnimationTask.java
=======


>>>>>>> e9f3400115813ae34cc1e3e582e08d9f868ee68b:ClientProject/src/gameGui/guiB/util/AnimationTask.java
public class AnimationTask extends TimerTask {
	
	private JLabel imageToMove;
	private int startY;
	private int X;
	private int finishY;
	private JPanel panelToupdate;
	private int size;
	public static double volumeOffset = 0.1; //maggiorazione di suono per alcuni eventi : tok, vittoria....

	public AnimationTask(JLabel l,JPanel p,int iy,int fy,int x) {
		super();
		this.imageToMove=l;
		this.panelToupdate=p;
		this.startY=iy;
		this.X=x;
		this.finishY=fy;
		this.size=100;
	}

	@Override
	public void run() {
		int slidingY = this.startY;
		
		for(int f = finishY+1;slidingY<f;slidingY++) {
			imageToMove.setBounds(X, slidingY, size, size);
			panelToupdate.add(imageToMove);
			panelToupdate.revalidate();
			panelToupdate.repaint();
		}
		//SoundPlayer.playSound((new File("resources/sounds/tok.wav")),0.5);
		SoundPlayer.playSound((new File("resources/sounds/tok.wav")),VolumeControl.volume + volumeOffset);
		
		cancel();
	}
	
	public void muteVolumeOffset() {
        volumeOffset =0;

    }

}
