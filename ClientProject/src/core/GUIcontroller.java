package core;

import menuGUI.windows.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.io.File;

/**
 * This class follows the Singleton pattern, in fact we have a private constructor. It makes sure that we can cerate a single
 * instance of the GUIController. This class kind of follows the Facade pattern: it hides all the logic made up by the
 * NetworkThread. Also, it can be considered a COntroller class because it manages all the JFrames that make the game
 * playable.
 */
public class GUIcontroller {

    private JPanel buttonsPanel;
    private SecondMenu menu;
    private JFrame currentOpenFrame=null;
    private GameFrame gameFrame;
    private JFrame frameToOpen;
    private static GUIcontroller myGuiHandler;

    /**
     *
     * @return
     */
    public static GUIcontroller getGuiHandler(){
        if(myGuiHandler==null)
            myGuiHandler = new GUIcontroller();
        return myGuiHandler;
    }

    /**
     * Constructor
     */
    private GUIcontroller(){
        //startGameIO("5");
        NetworkThread.getNetworkThread().setGuiHandler(this);
        startLoginMenu();
    }

    /**
     * This method starts the game creating an instance of the GameFrame and playing a sound
     * @param duration
     */

    public void startGameIO(String duration){
        closeFrame(currentOpenFrame);
        gameFrame = new GameFrame(duration);
        gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameFrame.setVisible(true);
        SoundPlayer.playSoundLoop(new File("resources/sounds/memories (online-audio-converter.com).wav"),VolumeControl.volume);
        currentOpenFrame = gameFrame;
    }

    /**
     *Adds a label playing the animation to a given x,y couple of a given colour
     *
     * @param x
     * @param y
     * @param c
     */

    public void addLabel(int x, int y, TokenColor c) {
        gameFrame.addLabel(x,y,c);
    }

    /**
     * This method creates an instance of the VictoryFrame in case a victory occurs or a LoserFrame. Stops the background music and
     * disposes the GameFrame previously created
     * @param victory
     */
    public void victoryScreen(String victory){
        disableGameGui();
        SoundPlayer.stopMusic();
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

    /**
     * The following methods manage the instances of the different JFrames
     */

    private void startLoginMenu(){
        FirstMenu loginFrame = new FirstMenu();
        currentOpenFrame = loginFrame;
        loginFrame.setVisible(true);
        loginFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void openMenu(){
        closeFrame(currentOpenFrame);
        menu = new SecondMenu();
        currentOpenFrame = menu;
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


    public SecondMenu getSecondMenu() {
        return menu;
    }
}
