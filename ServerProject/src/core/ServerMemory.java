package core;

import GUI.uitl.LinkedHashMapListModel;

/**
 * Questa classe si occupa di memorizzare i giocatori attualmente connessi al
 * server, si tratta di una classe realizzata come singleton poichè il server
 * dovrà contenere un solo elenco di giocatori correnti.
 * La necessità  di utilizzare una classe e non una semplice struttura dati
 * nasce anche dal fatto che thread multipli accedono alla classe e i metodi per
 * ottenere i dati richiesti o fare operazioni su di essi devono essere sincronizzati
 * La struttura dati interna è una implementazione di listmodel con una HashMao
 * in modo da collegarla alla GUI
 *
 * @see LinkedHashMapListModel
 * @author Flavio Bobba
 */

public class ServerMemory {

    private LinkedHashMapListModel<String,Player> currentPlayersList;
    private static ServerMemory memory = null;

    /**
     * Costurtture privato, poichè la clasee è singleton
     */
    private ServerMemory(){
        currentPlayersList = new LinkedHashMapListModel<>();
    }

    /**
     * Metodo statico per ottenere l'istanza di servermemory esistente,
     * nel caso questa manchi ne viene creata una.
     *
     * @return ServerMemory
     */
    public synchronized static ServerMemory getServerMemory(){
        if(memory==null)
            memory = new ServerMemory();
        return memory;
    }

    /**
     * Aggiunge un giocatore alla lista di qelli connessi
     *
     * @param p
     */
    public synchronized void addPlayer(Player p){
        currentPlayersList.put(p.getNickName(),p);
        System.out.println("Player"+p.getNickName()+"added");
    }

    /**
     * Ritorna il giocatore con il nickname corrispondente
     *
     * @param s
     * @return
     */
    public synchronized Player getPlayer(String s){
        return currentPlayersList.get(s);

    }

    /**
     * Ritorna la struttura dati contenente i player. Non incapsula quindi la
     * stessa. Questo metodo però ci serve per legare la GUI alla Lista corretta
     *
     * @see GUI.GUIForm
     * @return
     */
    public LinkedHashMapListModel<String, Player> getCurrentPlayersList() {

        return currentPlayersList;
    }

    /**
     * Rimove un giocatore dato il suo nickname
     *
     * @param nickToRemove
     */

    public synchronized void removePlayer(String nickToRemove){
        currentPlayersList.remove(nickToRemove);
    }

    public void update(){
        memory.update();
    }
}
