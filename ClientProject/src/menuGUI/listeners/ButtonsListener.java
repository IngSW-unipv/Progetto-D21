package menuGUI.listeners;

import core.NetworkThread;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonsListener implements ActionListener {

    private JButton butt;
    private  JFrame frame;

    public ButtonsListener(JButton button, JFrame frame){
        this.butt = button;
        this.frame = frame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        switch (butt.getActionCommand()){
            case "accept":
                NetworkThread.getNetworkThread().sendMessage("inviteAcceptedOrRefused,1,"+NetworkThread.getNetworkThread().getOpponent());
                System.out.println("inviteAcceptedOrRefused,1,"+NetworkThread.getNetworkThread().getOpponent());
                frame.dispose();
                break;
            case "decline":
                NetworkThread.getNetworkThread().sendMessage("inviteAcceptedOrRefused,0,"+NetworkThread.getNetworkThread().getNickName());
                frame.dispose();
                break;
        }

    }
}
