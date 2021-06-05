package tester;

import GUI.GUIForm;
import core.ServerListenerThread;

import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.logging.Logger;

public class Tester1 {

    public static int port = 25565;
    public static Logger serverLogger = Logger.getLogger("logger_1");
    public static GUIForm guiHandler;

    public static void main(String[] args) {

        guiHandler = new GUIForm();

        JFrame mainFrame = new JFrame("Server");
        mainFrame.setContentPane(guiHandler.getMainPanel());
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setVisible(true);

        try {

            serverLogger.info("Server starting...");

            ServerSocket serverSocket = new ServerSocket(port);
            ServerListenerThread serverListenerThread = new ServerListenerThread(serverSocket);
            serverListenerThread.start();

            serverLogger.info("listening started on port:"+port);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
