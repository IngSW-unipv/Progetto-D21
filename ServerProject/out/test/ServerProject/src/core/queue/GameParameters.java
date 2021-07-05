package core.queue;

import core.queue.util.GameDuration;

import java.time.Duration;

public class GameParameters {

    public GameDuration duration;
    private String longTime = "6";
    private String shortTime = "3";


    public GameParameters(){
        //costruttore vuoto per junit
    }

    public GameParameters(String s){
        setDuration(s);
    }



    public void setDuration(String s){
        if(s.compareTo("s")==0)
            this.duration = GameDuration.SHORT;
        if(s.compareTo("l")==0)
            this.duration = GameDuration.LONG;
    }

    public boolean compareParameters(GameParameters gameParameters){
        if(this.duration==gameParameters.duration)
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "GameParameters{" +
                "duration=" + duration +
                '}';
    }

    public String getTimestring(){
        if(duration == GameDuration.LONG){
            return longTime;
        }
        return shortTime;
    }
}
