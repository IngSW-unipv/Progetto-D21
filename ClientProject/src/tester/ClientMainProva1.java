package tester;

import core.GuiThread;
import core.NetworkThread;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Timer;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class ClientMainProva1 {

    private static int port = 25565;
    public static Logger clientLogger = Logger.getLogger("ClientLogger");
    private int buttonsize = 100;
    private static Timer gameTimer;


    public static void main(String[] args) {

        clientLogger.info("Client starting");
        startConnection(port);
        clientLogger.info("Startup Successful");
        startGui();
        clientLogger.info("gui inizializzata");

        BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));
        String msg = null;

        while (true) {
            try {
                msg = tastiera.readLine();
                System.out.println(msg);
                NetworkThread.getNetworkThread().sendMessage(msg);
                System.out.println(msg+"inviato");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


    private static void startConnection(int port){

        NetworkThread networkThread = NetworkThread.getNetworkThread();
        networkThread.start();

    }

    private static void startGui(){
        gameTimer = new Timer();
        GuiThread guiThread = new GuiThread(gameTimer);
        NetworkThread.getNetworkThread().setGuiThread(guiThread);

    }

}
