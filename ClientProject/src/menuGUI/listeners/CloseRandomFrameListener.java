
package menuGUI.listeners;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import core.NetworkThread;
import menuGUI.windows.RandomFrame;

/**
 * This class extends the WindowAdapter superclass (a class for receiving window events)
 */
    public class CloseRandomFrameListener extends WindowAdapter {

        private RandomFrame f;
        public CloseRandomFrameListener(RandomFrame f) {
            this.f=f;
        }

    /**
     * This method sends, with the sendMessage() method of the NetworkThread, a message (String) to the server. It notifies
     *  the exit of a player from the queue (a player is inserted in a queue if they choose the Random option)
     * @param e
     */
    public void windowClosing(WindowEvent e) {

            NetworkThread.getNetworkThread().sendMessage("exitFromQueue");
            f.setVisible(false);
        }
    }

