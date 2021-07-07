package model;

import view.GUIForm;
import control.LinkedHashMapListModel;

/**
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
     */
    private ServerMemory(){
        currentPlayersList = new LinkedHashMapListModel<>();
        GUIForm.getGuiForm().bindOnlinePlayers(currentPlayersList);
    }

    /**
     * Static method to get the existing instance of ServerMemory,
     * if one wasn't initialised this method will do it.
     *
     * @return ServerMemory
     */
    public synchronized static ServerMemory getServerMemory(){
        if(memory==null)
            memory = new ServerMemory();
        return memory;
    }

    /**
     * Adds a player to the list of the connected ones.
     *
     * @param p
     */
    public synchronized void addPlayer(Player p){
        currentPlayersList.put(p.getNickName(),p);
        System.out.println("Player"+p.getNickName()+"added");
    }

    /**
     * Returns a player given the nickname, returns null if the player
     * is absent.
     *
     * @param s
     * @return
     */
    public synchronized Player getPlayer(String s){
        return currentPlayersList.get(s);

    }

    /**
     * Removes a player given the nickname.
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
