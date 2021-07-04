package GUI;

import com.sun.media.jfxmedia.logging.Logger;
import core.ServerMemory;
import core.queue.Queue;

import javax.swing.*;

import static tester.Tester1.serverLogger;

/**Class generated using inelliJ's windowbuilder
 * it contains the method to bind the data to the GUI.
 * It is a singleton Class
 *
 * @return
 */

public class GUIForm {
    private JList OnlinePlayersList;
    private JScrollPane OnlinePlayersPane;
    private JScrollPane InQueuePane;
    private JScrollPane LoggerPane;
    private JPanel mainPanel;
    private JList PlayersInQueue;
    private JTextArea loggerTextarea;
    private static GUIForm myGuiForm=null;

    /**Getter method for singleton class
     *
     * @return
     */
    public static GUIForm getGuiForm(){

        if(myGuiForm==null)
            myGuiForm = new GUIForm();
        return myGuiForm;

    }

    /**Private constructor for singleton class
     *
     */
    private GUIForm(){
        // OnlinePlayersList.setModel(ServerMemory.getServerMemory().getCurrentPlayersList());
        // PlayersInQueue.setModel(Queue.getQueue().getQueueLIst());
        //ServerMemory.getServerMemory().addPlayer();
        serverLogger.info("gui inizalised");
    }

    /**
     * Returns the mainpanel to which the GUI element's are added
     * @return
     */
    public JPanel getMainPanel() {
        return mainPanel;
    }

    /**
     * Appends the logger output to the textarea's text
     * @param message
     */
    public void appendToLoggerText(String message){
        loggerTextarea.append(message);
    }

    /**
     * Binds the listmodel to the JList
     * @param listModel
     */
    public void bindQueueList(ListModel listModel){
        PlayersInQueue.setModel(listModel);
    }

    /**
     * Binds the listmodel to the JList
     * @param listModel
     */
    public void bindOnlinePlayers(ListModel listModel){
        OnlinePlayersList.setModel(listModel);
    }
}
