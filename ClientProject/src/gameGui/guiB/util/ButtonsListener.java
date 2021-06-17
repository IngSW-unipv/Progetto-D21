package gameGui.guiB.util;

import core.NetworkThread;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonsListener implements ActionListener {

    private JButton butt;

    public ButtonsListener(JButton button){
        this.butt = button;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        switch (butt.getActionCommand()){
            case "accept":
                NetworkThread.getNetworkThread().sendMessage("inviteAcceptedOrRefused,1");
                break;
            case "decline":
                NetworkThread.getNetworkThread().sendMessage("inviteAcceptedOrRefused,0");
                break;
        }

    }
}
