package menuGUI.listeners;

import core.NetworkThread;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class implements ActionListener
 */
public class RequestListener implements ActionListener {

    private JButton butt;
    private  JFrame frame;

    public RequestListener(JButton button, JFrame frame){
        this.butt = button;
        this.frame = frame;
    }

    /**
     * This overrided method makes possible the communication between clien server in some specific cases. If the invited
     * player accepted the request from another player then we enter the first case. The switch case receives in input
     * a getActionCommand which is set in the RequestFrame class as the player presses the accept or decline button.
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        switch (butt.getActionCommand()){
            case "accept":
                NetworkThread.getNetworkThread().sendMessage("inviteAcceptedOrRefused,1,"+NetworkThread.getNetworkThread().getOpponent()+","+NetworkThread.getNetworkThread().getInviteParameters());
                System.out.println("inviteAcceptedOrRefused,1,"+NetworkThread.getNetworkThread().getOpponent());
                break;
            case "decline":
                NetworkThread.getNetworkThread().sendMessage("inviteAcceptedOrRefused,0,"+NetworkThread.getNetworkThread().getOpponent());
                frame.dispose();
                break;
        }

    }
}
