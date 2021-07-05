package menuGUI.listeners;

import core.GUIcontroller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackToMenuLIstener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        GUIcontroller.getGuiHandler().closeGameFrame();
        GUIcontroller.getGuiHandler().openMenu();
    }

}
