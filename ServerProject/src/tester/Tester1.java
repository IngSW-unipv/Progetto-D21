package tester;

import view.GUIForm;
import model.ListenerThread;
import model.queue.util.TextAreaLoggerHandler;

import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tester1 {

    public static int port = 25565;
    public static Logger serverLogger = Logger.getLogger("logger_1");
    public static GUIForm guiHandler ;

    public static void main(String[] args) {

        guiHandler = GUIForm.getGuiForm();
        setUpLogger();

        JFrame mainFrame = new JFrame("Server");
        mainFrame.setContentPane(guiHandler.getMainPanel());
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setVisible(true);

        try {

            serverLogger.info("Server starting...");

            ServerSocket serverSocket = new ServerSocket(25565);
            ListenerThread serverListenerThread = new ListenerThread(serverSocket);
            serverListenerThread.start();

            serverLogger.info("listening started on port:"+port);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    // leggo da file la configurazione del logger
    private static void setUpLogger(){

        serverLogger.setLevel(Level.ALL);
        serverLogger.info("loading logger config");
        serverLogger.addHandler(new TextAreaLoggerHandler());

        Properties logConfig = new Properties();

        /*
        try {

            FileInputStream config = new FileInputStream("src/core/config/loggerconfig.txt");
           // logConfig.load(config);
            System.out.println("aa");
            LogManager.getLogManager().readConfiguration(config);

        } catch (IOException e) {
            System.out.println("WARNING: could not open config file CONSOLE OUTPUT ONLY");
        }*/


    }

}
