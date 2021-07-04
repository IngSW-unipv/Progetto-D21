package core.queue;

import GUI.uitl.LinkedHashMapListModel;
import core.GameThread;
import core.Player;
import core.ServerMemory;
import util.PlayerStatus;

import java.util.HashMap;
import java.util.Map;

/**
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
     * Costruttore privato per il singleton
     *
     */
    private Queue(){
    	queue = new LinkedHashMapListModel<Player, GameParameters>();
    }

    /**
     * Metoto utilizzato quando serve avere un istanza della Queue
     * nel caso non sia mai stata istanziata ne crea e ritorna un istanza
     * altrimenti ritorna quella presente
     *
     * @return
     */
    public static Queue getQueue(){
        if(myQueue==null)
            myQueue = new Queue();
        return myQueue;
    }

    /**
     * Questo metodo aggiunge il player passato alla coda con i rispettivi
     * parametri di partita, una volta che questo è stato aggiunto alla coda
     * questa ultima viene iterata per vedere se è gia presente in coda un
     * giocatore compatibile con quello appena aggiunto.
     * In questo modo appena viene aggiunto un giocatore è possibile che venga
     * trovato un avversario per questo.
     * Quando viene trovata una corrispondenza tra due giocatori viene
     * creata una istanza di GameThread che si occupera di creare e gestire la
     * partita tra i due player.
     *
     * @see GameThread
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

    public synchronized void removePlayer(Player p){
        queue.remove(p);
    }

    public LinkedHashMapListModel<Player,GameParameters> getQueueLIst(){
        return queue;
    }

}
