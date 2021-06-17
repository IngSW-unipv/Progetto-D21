package core;

import gameGui.guiB.gameScreen.GameFrame;
import gameGui.guiB.util.TokenColor;
import menuGUI.mainmenu.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class GUI {

    private JPanel buttonsPanel;
    private JFrame menuFrame;
    private JFrame currentOpenFrame=null;
    private GameFrame gameFrame;
    private JFrame frameToOpen;
    private static GUI myGuiHandler;

    public static GUI getGuiHandler(){
        if(myGuiHandler==null)
            myGuiHandler = new GUI();
        return myGuiHandler;
    }

    private GUI(){

        //startGameIO("5");
        NetworkThread.getNetworkThread().setGuiHandler(this);
        startLoginMenu();
    }



    public void startGameIO(String duration){

        gameFrame = new GameFrame(duration);
        gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameFrame.setVisible(true);

    }
    //metodi per la gestione della schermata della partita
    public void addLabel(int x, int y, TokenColor c) {

        gameFrame.addLabel(x,y,c);
    }


    public void victoryScreen(String victory){
        disableGameGui();
        if(victory.equals("victory"))
            gameFrame.addToLayeredPane(new VictoryPanel(true),3);
        gameFrame.addToLayeredPane(new VictoryPanel(false),3);
    }

    private void startLoginMenu(){
        First_Menu loginFrame = new First_Menu();
        currentOpenFrame = loginFrame;
        loginFrame.setVisible(true);
        loginFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void openMenu(){

        closeFrame(currentOpenFrame);

        Second_Menu menu = new Second_Menu();


    }

    private void closeFrame(JFrame panelToClose){

        panelToClose.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        WindowEvent closeFrame = new WindowEvent(panelToClose,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeFrame);
    }

    public void closeGameFrame(){
        closeFrame(gameFrame);
    }

    public void disableGameGui(){
        gameFrame.getButtonsPanel().setVisible(false);
        gameFrame.revalidate();
        gameFrame.repaint();
    }

    public void enableGameGui(){
        gameFrame.getButtonsPanel().setVisible(true);
        gameFrame.revalidate();
        gameFrame.repaint();
    }

    public void displayInvite(String playerName){
        RequestFrame requestFrame = new RequestFrame(playerName);
        requestFrame.setVisible(true);
        requestFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public void displayDeclineFrame(){
        DeclineFrame declineFrame = new DeclineFrame();
    }

}
