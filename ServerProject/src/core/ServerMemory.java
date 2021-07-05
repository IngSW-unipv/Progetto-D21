package core;

import GUI.GUIForm;
import GUI.uitl.LinkedHashMapListModel;

/**[ENG]
 * This class memorizes the players connected at the moment to the server,
 * it was made using the Singleton pattern because the server will need only
 * one instance of the connected players list.
 * The necessity of using a class and not just a data structure derives from
 * the fact that multiple threads need to access the contents of the memory
 * and because of that the access to the data must be synchronized.
 * The internal data structure is an implementation of the ListModel interface
 * which utilizes an HashMap. We used ListModel in order to connect it with
 * a JList in the GUI.
 *
 * [IT]
 * Questa classe si occupa di memorizzare i giocatori attualmente connessi al
 * server, si tratta di una classe realizzata come singleton poichè il server
 * dovrà contenere un solo elenco di giocatori correnti.
 * La necessità  di utilizzare una classe e non una semplice struttura dati
 * nasce anche dal fatto che thread multipli accedono alla classe e i metodi per
 * ottenere i dati richiesti o fare operazioni su di essi devono essere sincronizzati
 * La struttura dati interna è una implementazione di listmodel con una HashMap
 * in modo da collegarla alla GUI
 *
 * @see GUIForm
 * @see LinkedHashMapListModel
 * @author Flavio Bobba
 */

public class ServerMemory {

    private LinkedHashMapListModel<String,Player> currentPlayersList;
    private static ServerMemory memory = null;

    /**[ENG]
     * Private contructor due to the singleton pattern
     *
     * [IT]
     * Costurtture privato, poichè la classe è singleton
     */
    private ServerMemory(){
        currentPlayersList = new LinkedHashMapListModel<>();
        GUIForm.getGuiForm().bindOnlinePlayers(currentPlayersList);
    }

    /**[ENG]
     * Static method to get the existing instance of ServerMemory,
     * if one wasn't initialised this method will do it.
     *
     * [IT]
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
     * [ENG]
     * Adds a player to the list of the connected ones.
     *
     * [IT]
     * Aggiunge un giocatore alla lista di quelli connessi.
     *
     * @param p
     */
    public synchronized void addPlayer(Player p){
        currentPlayersList.put(p.getNickName(),p);
        System.out.println("Player"+p.getNickName()+"added");
    }

    /**[ENG]
     * Returns a player given the nickname, returns null if the player
     * is absent.
     *
     * [IT]
     * Ritorna il giocatore con il nickname corrispondente, ritorna null
     * se manca il giocatore.
     *
     * @param s
     * @return
     */
    public synchronized Player getPlayer(String s){
        return currentPlayersList.get(s);

    }

    /**[ENG]
     * Removes a player given the nickname.
     *
     * [IT]
     * Rimuove un giocatore dato il suo nickname.
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
