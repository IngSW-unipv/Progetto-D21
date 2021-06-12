package gameGui.guiB.gameScreen;

import gameGui.guiB.util.CountDownTask;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;

public class GameInfoPanel extends JPanel {

    private JLabel timerFiel;
    private java.util.Timer turnTimer = new Timer();
    private String duration;
    private JLabel turnOwner;

    public GameInfoPanel(String duration){

            this.setPreferredSize(new Dimension(300,600));
            this.setBackground(Color.GREEN);
            this.setLayout(null);
            this.duration = duration;
            setupTimerField();
            turnOwner = new JLabel("attendi il server sta organizzando la partita");
            this.add(turnOwner);
            turnOwner.setVisible(true);
            turnOwner.setBounds(0,100,300,100);
    }

    public void resetTimer(){
        turnTimer.schedule(new CountDownTask(timerFiel,duration),1000L);
    }

    public void setTurnOwnerME(){
        turnOwner.setText("É il tuo turno!");
    }

    public void setTurnOwnerOPPOSITE(){
        turnOwner.setText("É il turno dell'avversario!");
    }

    private void setupTimerField(){
        timerFiel = new JLabel();
        this.add(timerFiel);
        timerFiel.setVisible(true);
        timerFiel.setBounds(0,0,300,100);
        timerFiel.setHorizontalAlignment(SwingConstants.CENTER);
        timerFiel.setVerticalAlignment(SwingConstants.CENTER);
        timerFiel.setFont(new Font("myfont",Font.PLAIN,80));
        turnTimer.scheduleAtFixedRate(new CountDownTask(timerFiel,duration),0,1000L);
    }

}
