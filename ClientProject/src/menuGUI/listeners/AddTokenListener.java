package menuGUI.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import core.GUIcontroller;
import core.NetworkThread;

/**
 * This class overrides the actionPerformed method of the superclass ActionListener.
 */
public class AddTokenListener implements ActionListener {
	
	private JButton butt;
	private NetworkThread networkThread;
	
	public AddTokenListener(JButton b) {
		this.butt=b;
		this.networkThread = NetworkThread.getNetworkThread();
	}

	/**
	 * This method sends a String to the class NetworkThread. The message is clearly interpreted by the NetworkThread
	 * @param arg0
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		//System.out.println("Bottone premuto,successso "+ butt.getActionCommand());
		GUIcontroller.getGuiHandler().disableGameGui();
		networkThread.sendMessage("addTokenInvirtualGrid,"+butt.getActionCommand());
	}
	
}
