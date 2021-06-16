package core;

import gameGui.guiB.control.ButtonListener;
import gameGui.guiB.gameScreen.GameFrame;
import gameGui.guiB.gameScreen.GameInfoPanel;
import gameGui.guiB.util.AnimationTask;
import gameGui.guiB.util.TokenColor;
import menuGUI.mainmenu.First_Menu;
import menuGUI.mainmenu.Second_Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.util.Timer;

public class GUI {

    private JFrame frame;
    private static final int buttonsize=100;
    private java.util.Timer myTimer;
    private JPanel animationPanel;
    private JPanel buttonsPanel;
    private static final long refreshRate = 1l;
    private JFrame menuFrame;
    private JFrame currentOpenFrame=null;
    private GameFrame gameFrame;

    public GUI(Timer timer){

        //startGameIO("5");
        myTimer = timer;
        NetworkThread.getNetworkThread().setGuiHandler(this);
        startLoginMenu();
    }



    public void startGameIO(String duration){

        gameFrame = new GameFrame(duration);
        gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameFrame.setVisible(true);

    }

    public void addLabel(int x, int y, TokenColor c) {
        gameFrame.addLabel(x,y,c);
    }

    public JPanel getButtonsPanel() {
        return buttonsPanel;
    }

    private void startLoginMenu(){
        First_Menu loginFrame = new First_Menu();
        currentOpenFrame = loginFrame;
        loginFrame.setVisible(true);
        loginFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public void openMenu(){

        closeFrame(currentOpenFrame);

        Second_Menu menu = new Second_Menu();


    }

    private void closeFrame(JFrame panelToClose){

        WindowEvent closeFrame = new WindowEvent(panelToClose,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeFrame);
    }

}
