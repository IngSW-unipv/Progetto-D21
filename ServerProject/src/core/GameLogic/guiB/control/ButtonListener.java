package guiB.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import guiB.util.AnimationTask;
import model.partita.Game;
import model.partita.TokenColor;
import model.partita.util.GridStatus;
import model.partita.util.SoundPlayer;

public class ButtonListener implements ActionListener {
	
	private JButton butt;
	private JPanel animPanel;
	private GridStatus status;
	private Game boradToUpdate;
	private int tokenX;
	private int tokenY;
	private Timer gameTimer;
	private Long refreshRate;
	
	public ButtonListener(JButton b,JPanel a,Game g) {
		
		this.butt=b;
		this.animPanel=a;
		this.status = GridStatus.getGameStatus();
		this.boradToUpdate = g;
		this.gameTimer=this.boradToUpdate.getGameTimer();
		this.refreshRate = 1L;
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Bottone premuto,successso "+ butt.getActionCommand());
		
		tokenX = Integer.parseInt(butt.getActionCommand());
		boradToUpdate.turn(tokenX);
		
		tokenY = status.getLastY();
		
		addLabel(tokenX, tokenY, status.getLastColor());
		
		

	}
	
	private void addLabel(int x,int y,TokenColor c) {
		
		JLabel lbl = new JLabel("");
		if(c==TokenColor.RED) {
			lbl.setIcon(new ImageIcon("resources/textures/RedToken2.png"));
		}
		if(c==TokenColor.YELLOW) {
			lbl.setIcon(new ImageIcon("resources/textures/YellowToken2.png"));
		}
		this.gameTimer.schedule(new AnimationTask(lbl, animPanel, 0, 50+tokenY*100, 50+tokenX*100),this.refreshRate );
		System.out.println("aa");
	}

}
