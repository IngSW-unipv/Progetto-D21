package menuGUI.listeners;

import core.NetworkThread;
import menuGUI.windows.ErrorFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Simple class that overrides the actionPerformed method inherited from the ActionListener interface
 */
public class ButtonAndTextAreaListener implements ActionListener {

    JButton butt;
    JTextField nickField;

    public ButtonAndTextAreaListener(JButton butt,JTextField nickField){
        this.butt=butt;
        this.nickField=nickField;
    }

    /**
     * This method sets the nickName variable of the NetworkThread getting the String inserted in the FirstMenu JTextArea
     *
     * @param e
     */
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
