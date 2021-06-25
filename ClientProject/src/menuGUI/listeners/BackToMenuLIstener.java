package menuGUI.listeners;

import core.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackToMenuLIstener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        GUI.getGuiHandler().closeGameFrame();
        GUI.getGuiHandler().openMenu();
    }
}
