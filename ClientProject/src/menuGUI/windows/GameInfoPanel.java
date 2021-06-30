package menuGUI.windows;

import core.CountDownTask;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;

public class GameInfoPanel extends JPanel {

    private JLabel timerFiel;
    private java.util.Timer turnTimer;
    private String duration;
    private JLabel turnOwner;
    private VolumePanel volumePanel;

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

    public void resetTimer(){
        turnTimer.cancel();
        turnTimer.purge();
        turnTimer = new Timer();
        turnTimer.schedule(new CountDownTask(timerFiel,duration),1000L);
    }

    public void setTurnOwnerME(){
        turnOwner.setText("È il tuo turno!");
        turnOwner.setFont(new Font("ITC Avant Garde Gothic",Font.BOLD,25));
        turnOwner.setHorizontalAlignment(SwingConstants.CENTER);
        turnOwner.setVerticalAlignment(SwingConstants.CENTER);
    }

    public void setTurnOwnerOPPOSITE(){
        turnOwner.setText("È il turno dell'avversario!");
        turnOwner.setFont(new Font("ITC Avant Garde Gothic",Font.BOLD,25));
        turnOwner.setHorizontalAlignment(SwingConstants.CENTER);
        turnOwner.setVerticalAlignment(SwingConstants.CENTER);
    }

    private void setupTimerField(){
        timerFiel = new JLabel();
        this.add(timerFiel);
        timerFiel.setVisible(true);
        timerFiel.setBounds(0,0,300,100);
        timerFiel.setHorizontalAlignment(SwingConstants.CENTER);
        timerFiel.setVerticalAlignment(SwingConstants.CENTER);
        timerFiel.setFont(new Font("ITC Avant Garde Gothic",Font.PLAIN,80));
        turnTimer.scheduleAtFixedRate(new CountDownTask(timerFiel,duration),0,1000L);
    }
}
