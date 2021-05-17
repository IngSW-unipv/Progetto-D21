package guiB.util;

import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class AnimationTask extends TimerTask {
	
	private JLabel imageToMove;
	private int startY;
	private int X;
	private int finishY;
	private JPanel panelToupdate;
	private int size;

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
		cancel();
	}

}
