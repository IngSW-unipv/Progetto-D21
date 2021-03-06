package menuGUI.windows;

import core.CountDownTask;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;

/**
 * This class manages the JPanel that hosts the Timer and some messages
 */
public class GameInfoPanel extends JPanel {

    private JLabel timerFiel;
    private java.util.Timer turnTimer;
    private String duration;
    private JLabel turnOwner;
    private VolumePanel volumePanel;
    private boolean isMyTurn = true;
    private CountDownTask countDownTask;

    /**
     *
     * @param duration
     */

    public GameInfoPanel(String duration){
            turnTimer = new Timer();
            setPreferredSize(new Dimension(300,600));
            setBackground(Color.WHITE);
            setLayout(null);
            this.duration = duration;
            setupTimerField();
            turnOwner = new JLabel("attendi il server sta organizzando la partita");
            turnOwner.setFont(new Font("ITC Avant Garde Gothic",Font.BOLD,12));
            this.add(turnOwner);
            turnOwner.setVisible(true);
            turnOwner.setBounds(0,100,300,100);

            volumePanel = new VolumePanel();
            volumePanel.setBounds(0, 200, 300, 200);
            volumePanel.setLayout(null);
            this.add(volumePanel);

    }

    /**
     * Resets the timer whenever the turn is changed. This method is called in GameFrame where it is actually used
     */
    public void resetTimer(){
        turnTimer.cancel();
        turnTimer = new Timer();
        turnTimer.scheduleAtFixedRate(countDownTask=new CountDownTask(timerFiel,duration,isMyTurn),0,1000L);
    }

    /**
     * The following methods set the turn for the players displaying some text
     */
    public void setTurnOwnerME(){
        turnOwner.setText("È il tuo turno!");
        turnOwner.setFont(new Font("ITC Avant Garde Gothic",Font.BOLD,20));
        turnOwner.setHorizontalAlignment(SwingConstants.CENTER);
        turnOwner.setVerticalAlignment(SwingConstants.CENTER);
        isMyTurn=true;
    }

    public void setTurnOwnerOPPOSITE(){
        turnOwner.setText("È il turno dell'avversario!");
        turnOwner.setFont(new Font("ITC Avant Garde Gothic",Font.BOLD,20));
        turnOwner.setHorizontalAlignment(SwingConstants.CENTER);
        turnOwner.setVerticalAlignment(SwingConstants.CENTER);
        isMyTurn=false;
    }

    /**
     * This method sets up the field that hosts the Timer (positioning, font, rate)
     */

    private void setupTimerField(){
        timerFiel = new JLabel();
        this.add(timerFiel);
        timerFiel.setVisible(true);
        timerFiel.setBounds(0,0,300,100);
        timerFiel.setHorizontalAlignment(SwingConstants.CENTER);
        timerFiel.setVerticalAlignment(SwingConstants.CENTER);
        timerFiel.setFont(new Font("ITC Avant Garde Gothic",Font.PLAIN,80));
        turnTimer.scheduleAtFixedRate(countDownTask=new CountDownTask(timerFiel,duration,isMyTurn),0,1000L);
    }
}
