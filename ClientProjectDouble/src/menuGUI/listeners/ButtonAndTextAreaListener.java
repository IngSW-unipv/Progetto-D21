package menuGUI.listeners;

import core.NetworkThread;
import menuGUI.windows.ErrorFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class implements ActionListener, its role is to send a message ("newNick") to the server using the class NetworkThread
 * whenever the JButton that makes possible to add a player is pressed
 */
public class ButtonAndTextAreaListener implements ActionListener {

    JButton butt;
    JTextField nickField;

    public ButtonAndTextAreaListener(JButton butt,JTextField nickField){
        this.butt=butt;
        this.nickField=nickField;
    }

    /**
     * Overrided method from superclass which sends the actual String and creates (possibly) an ErrorFrame
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
