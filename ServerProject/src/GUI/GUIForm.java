package GUI;

import core.ServerMemory;
import core.queue.Queue;

import javax.swing.*;

public class GUIForm {
    private JList OnlinePlayersList;
    private JScrollPane OnlinePlayersPane;
    private JScrollPane InQueuePane;
    private JScrollPane LoggerPane;
    private JPanel mainPanel;
    private JList PlayersInQueue;
    private JTextArea loggerTextarea;
    private static GUIForm myGuiForm=null;

    public static GUIForm getGuiForm(){

        if(myGuiForm==null)
            myGuiForm = new GUIForm();
        return myGuiForm;

    }

    private GUIForm(){
        //inizialization of the Jlist and its model
        OnlinePlayersList.setModel(ServerMemory.getServerMemory().getCurrentPlayersList());
        PlayersInQueue.setModel(Queue.getQueue().getQueueLIst());
        //ServerMemory.getServerMemory().addPlayer();

    }

    public JPanel getMainPanel() {

        return mainPanel;

    }

    public void appendToLoggerText(String message){

        loggerTextarea.append(message);

    }
}
