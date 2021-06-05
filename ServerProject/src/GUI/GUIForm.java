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

    public GUIForm(){
        //inizialization of the Jlist and its model
        OnlinePlayersList.setModel(ServerMemory.getServerMemory().getCurrentPlayersList());
        PlayersInQueue.setModel(Queue.getQueue().getQueueLIst());
        //ServerMemory.getServerMemory().addPlayer();

    }

    public void setData(PlayersBean data) {

    }

    public void getData(PlayersBean data) {
    }

    public boolean isModified(PlayersBean data) {

        return false;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
