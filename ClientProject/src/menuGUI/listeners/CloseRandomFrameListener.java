
    package menuGUI.listeners;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import core.NetworkThread;
import menuGUI.windows.RandomFrame;

    public class CloseRandomFrameListener extends WindowAdapter {

        private RandomFrame f;
        public CloseRandomFrameListener(RandomFrame f) {
            this.f=f;
        }
        public void windowClosing(WindowEvent e) {

            NetworkThread.getNetworkThread().sendMessage("exitFromQueue");
            f.setVisible(false);
        }
    }

