package menuGUI.mainmenu.control;

import core.NetworkThread;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonAndTextAreaListener implements ActionListener {

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
                   NetworkThread.getNetworkThread().setNickName(nickField.getText());
                   NetworkThread.getNetworkThread().sendMessage(command+","+nickField.getText());
                   break;
               }
               System.out.println("immettere un nickname composto da almeno un carattere");
               break;
        }

    }
}
