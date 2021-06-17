package core;

import GUI.uitl.LinkedHashMapListModel;

import java.util.HashMap;

public class ServerMemory {

    private LinkedHashMapListModel<String,Player> currentPlayersList;
    private static ServerMemory memory = null;

    private ServerMemory(){
        currentPlayersList = new LinkedHashMapListModel<>();
    }

    public synchronized static ServerMemory getServerMemory(){
        if(memory==null)
            memory = new ServerMemory();
        return memory;
    }

    public synchronized void addPlayer(Player p){
        currentPlayersList.put(p.getNickName(),p);
        System.out.println("Player"+p.getNickName()+"added");
    }
    
    public Player getPlayer(String s){
        System.out.println(currentPlayersList);
        return currentPlayersList.get(s);

    }

    public LinkedHashMapListModel<String, Player> getCurrentPlayersList() {

        return currentPlayersList;
    }

    public synchronized void removePlayer(String nickToRemove){
        currentPlayersList.remove(nickToRemove);
    }
}
