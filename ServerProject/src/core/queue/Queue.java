package core.queue;

import GUI.uitl.LinkedHashMapListModel;
import core.GameThread;
import core.Player;

import java.util.HashMap;
import java.util.Map;

public class Queue {

    private static Queue myQueue = null;

    private LinkedHashMapListModel<Player,GameParameters> queue;

    private Queue(){
    	queue = new LinkedHashMapListModel<Player, GameParameters>();
    }

    public static Queue getQueue(){
        if(myQueue==null)
            myQueue = new Queue();
        return myQueue;
    }

    public synchronized void addPlayerToQueue(Player player1,GameParameters gameParameters){
        queue.put(player1, gameParameters);
        for(Map.Entry<Player,GameParameters> entry : queue.entrySet()){

            if(gameParameters.compareParameters(entry.getValue())&&(player1!= entry.getKey())){
            	
            	Player player2 = entry.getKey();
            	
                player2.sendMessage("gamefound,"+player1.getNickName());
                player1.sendMessage("gamefound,"+player2.getNickName());
                
                GameThread newGame = new GameThread(player1, player2, gameParameters);
                player1.getWorkerThread().setAssignedGame(newGame);
                player2.getWorkerThread().setAssignedGame(newGame);
                //newGame.start();
                
            }
        }
    }

    public synchronized void removePlayer(Player p){

        queue.remove(p);
    }

    public LinkedHashMapListModel<Player,GameParameters> getQueueLIst(){
        return queue;
    }

}
