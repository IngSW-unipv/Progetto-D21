package core;

import menuGUI.windows.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.io.File;

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
        SoundPlayer.playSound(new File("resources/sounds/memories (online-audio-converter.com).wav"),VolumeControl.volume);
    }

    //metodi per la gestione della schermata della partita
    public void addLabel(int x, int y, TokenColor c) {
        gameFrame.addLabel(x,y,c);
    }

    public void victoryScreen(String victory){
        disableGameGui();
        if(victory.equals("victory")){
            VictoryFrame victoryFrame = new VictoryFrame();
            victoryFrame.setVisible(true);
            victoryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gameFrame.dispose();
        }else{
            LoserFrame loserFrame= new LoserFrame();
            loserFrame.setVisible(true);
            loserFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gameFrame.dispose();
        }

    }

    private void startLoginMenu(){
        FirstMenu loginFrame = new FirstMenu();
        currentOpenFrame = loginFrame;
        loginFrame.setVisible(true);
        loginFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void openMenu(){
        closeFrame(currentOpenFrame);
        SecondMenu menu = new SecondMenu();
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
        declineFrame.setVisible(true);
    }

    public void resetTimer(){
        gameFrame.resetTimer();
    }

    public void setMyturn(){
        gameFrame.setMyTurn();
    }

    public void setOpponentTurn(){
        gameFrame.setOppositeTurn();
    }
    
    public void disableColumn(int column) {//disabilita la colonna
        gameFrame.disableColumn(column);
    }


}
