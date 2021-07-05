package core.queue;

import GUI.GUIForm;
import GUI.uitl.LinkedHashMapListModel;
import core.GameThread;
import core.Player;
import util.PlayerStatus;

import java.util.Map;

/**This class memorizes the players that put themselves in the waiting queue for
 * a game and the parameters associated with the game type preferences.
 * It is a Singleton class and as backbone data structure utilizes a LinkedHashmapListModel
 *
 * Questa classe si occupa di memorizzare i giocatori in coda e i parametri di
 * ricerca della partita, inoltre accoppia i giocatori con prametri di ricerca
 * corrispondendi.
 * Realizzata come singleton e come struttura dati di base utilizza LinkedHashmapListmodel
 *
 * @author Flavio Bobba
 * @see LinkedHashMapListModel
 */

public class Queue {

    private static Queue myQueue = null;

    private LinkedHashMapListModel<Player,GameParameters> queue;

    /**
     * Private constructor due to singleton
     * Binds the class with the gui using the setter method of GUIForm
     *
     * @see GUIForm
     */
    private Queue(){
        queue = new LinkedHashMapListModel<Player, GameParameters>();
        GUIForm.getGuiForm().bindQueueList(queue);
    }

    /**
     * This method is used when an instance of the Queue is needed.
     * When the Queue has not been initialized a new instance is created
     * and returned, in a different case the existing instance is returned
     *
     * @return Queue
     */
    public static Queue getQueue(){
        if(myQueue==null)
            myQueue = new Queue();
        return myQueue;
    }

    /**
     * This method adds the given player to the queue with the corresponding GameParameters
     * once the player is in the queue the queue is iterated too check if a player with matching
     * GameParameters ins already in the queue. If that is the case a new GameThread is initialized
     * with the two matching players.
     *
     * @see GameThread
     * @see GameParameters
     *
     * @param player1
     * @param gameParameters
     */
    public synchronized void addPlayerToQueue(Player player1,GameParameters gameParameters){
        queue.put(player1, gameParameters);
        for(Map.Entry<Player,GameParameters> entry : queue.entrySet()){

                if(gameParameters.compareParameters(entry.getValue())&&(player1!= entry.getKey()) &&
                        entry.getKey().getStatus() == PlayerStatus.IN_QUEUE){
            	Player player2 = entry.getKey();
            	
                player2.sendMessage("gamefound,"+player1.getNickName());
                player1.sendMessage("gamefound,"+player2.getNickName());
                
                GameThread newGame = new GameThread(player1, player2, gameParameters);
                player1.setAssignedGame(newGame);
                player2.setAssignedGame(newGame);
                return;
            }
        }
    }

    /**
     * Method that removes a given player from the Queue
     *
     * @param p
     */
    public synchronized void removePlayer(Player p){
        queue.remove(p);
    }

}
