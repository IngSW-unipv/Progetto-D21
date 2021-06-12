package menuGUI.mainmenu;

import core.GUI;

import javax.swing.*;
import java.util.Timer;

public class maintest {
    public static void main(String[] args) {
        GUI gui = new GUI(new Timer());
        gui.startGameIO("5");

    }
}
