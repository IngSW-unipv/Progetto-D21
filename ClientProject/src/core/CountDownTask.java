package core;

import core.NetworkThread;

import javax.swing.*;
import java.util.TimerTask;

/**
 * Class that customize the game Timer. Overrides the run() method as TimerTask implements Runnable
 */
public class CountDownTask extends TimerTask {

    private JLabel labelToUpdate;
    private int gameDuration;
    private int currentTime;
    private int seconds;
    private int minutes;
    private Boolean isMyTurn;

    public CountDownTask(JLabel labelToUpdate,String duration,Boolean turn){
        this.labelToUpdate=labelToUpdate;
        this.isMyTurn=turn;
        gameDuration = Integer.parseInt(duration)*60;
        labelToUpdate.setText("0"+duration+":"+"00");
        currentTime = gameDuration;
        minutes = currentTime/60;
        seconds = currentTime-minutes*60;
    }

    /**
     * The run method actually sets up the timer with the parameters we chose if the timer isn't out. If the timer is out
     * it sends a message to the server
     */
    @Override
    public void run() {
        if(currentTime!=0){
            minutes = currentTime/60;
            seconds = currentTime-minutes*60;
            currentTime-=1;
            labelToUpdate.setText(timeText());
        }else {
            if (isMyTurn) {
                NetworkThread.getNetworkThread().sendMessage("turnTimeOut");
            }
            this.cancel();
        }

    }

    /**
     * It displays the String of the timer
     * @return
     */

    private String timeText(){
        String timeText="";
        if(minutes<10){
            if(seconds<10)
                return timeText = "0"+minutes+":"+"0"+seconds;
            return timeText = "0"+minutes+":"+seconds;
        }
        return timeText = minutes+":"+seconds;
    }

}
