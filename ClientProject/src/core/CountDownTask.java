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

    public CountDownTask(JLabel labelToUpdate,String duration){
        this.labelToUpdate=labelToUpdate;
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
            //calcolo i minuti e i secondi da displayare nel timer
            minutes = currentTime/60;
            seconds = currentTime-minutes*60;
            //decremento il timer
            currentTime-=1;
            //update alla label
            labelToUpdate.setText(timeText());
        }else {
            NetworkThread.getNetworkThread().sendMessage("addTokenInvirtualGrid,turnTimeOut");
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
