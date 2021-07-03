package menuGUI.listeners;

import core.NetworkThread;
import menuGUI.windows.ErrorFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonAndTextAreaListener implements ActionListener {

    //TODO controllare dove si usa

    JButton butt;
    JTextField nickField;

    public ButtonAndTextAreaListener(JButton butt,JTextField nickField){
        this.butt=butt;
        this.nickField=nickField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = butt.getActionCommand();

        switch (command){
            case "newNick":
               if(!nickField.getText().equals("")){
                   try {
                       NetworkThread.getNetworkThread().setNickName(nickField.getText());
                       NetworkThread.getNetworkThread().sendMessage(command+","+nickField.getText());
                       break;
                   } catch (Exception exception) {
                       ErrorFrame errorFrame = new ErrorFrame("You are not connected to the server");
                   }
               }
               ErrorFrame noNickError = new ErrorFrame("insert a nickname");
               break;
        }

    }
}
