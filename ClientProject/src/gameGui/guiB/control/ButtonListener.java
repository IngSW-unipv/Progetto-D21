package gameGui.guiB.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import core.NetworkThread;
import gameGui.guiB.util.GridStatus;



public class ButtonListener implements ActionListener {
	
	private JButton butt;
	private NetworkThread networkThread;
	
	public ButtonListener(JButton b) {
		
		this.butt=b;
		this.networkThread = NetworkThread.getNetworkThread();
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Bottone premuto,successso "+ butt.getActionCommand());	
		networkThread.sendMessage("addTokenInvirtualGrid,"+butt.getActionCommand());
	}
	
}
