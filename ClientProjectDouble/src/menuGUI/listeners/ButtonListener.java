package menuGUI.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import core.NetworkThread;

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
