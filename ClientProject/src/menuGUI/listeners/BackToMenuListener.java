package menuGUI.listeners;

import core.GUIcontroller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * nn lo usiamo?
 */
public class BackToMenuListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        GUIcontroller.getGuiHandler().closeGameFrame();
        GUIcontroller.getGuiHandler().openMenu();
    }

}
