package core;

import java.io.*;
import java.net.Socket;

import javax.swing.JPanel;

import gameGui.guiB.util.TokenColor;

import static tester.ClientMainProva1.clientLogger;

public class NetworkThread extends Thread {

    private Socket socket;
    private static int port=25565;
    private PrintWriter socketOutput = null;
    private BufferedReader socketInput = null;
    private static NetworkThread myThread=null;
    private JPanel animPanel;
    private GUI guiThread;

    private NetworkThread(int port) {
        this.port = port;
    }
    
    public static NetworkThread getNetworkThread() {
    	if(myThread==null)
    		myThread = new NetworkThread(port);
    	return myThread;
    }

    @Override
    public void run() {

        try {
            this.socket = new Socket("2.36.254.212", port);
            clientLogger.info("Connection established");
        } catch (IOException e) {
            clientLogger.info("Impossible to establish connection to:" + socket.getInetAddress());
        }

        try {
            socketInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            socketOutput = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
        } catch (IOException e) {
            clientLogger.info("I/O Error");
        }


        while (socket.isBound()) {

            try {

                parseString(this.socketInput.readLine());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void parseString(String message){
        String[] parts = message.split(",");

        switch (parts[0]){
        	case "abi":
        	    System.out.println("abilitato");
                guiThread.getButtonsPanel().setVisible(true);
                guiThread.getButtonsPanel().revalidate();
                guiThread.getButtonsPanel().repaint();
        		break;
        	case "NOTabi":
        	    System.out.println("disabilitato");
        	    guiThread.getButtonsPanel().setVisible(false);
                guiThread.getButtonsPanel().revalidate();
                guiThread.getButtonsPanel().repaint();

        		break;
        	case "addToken": //addToken,x,y	

                if (parts[3].compareTo("r")==0)
                    guiThread.addLabel(Integer.parseInt(parts[1]),Integer.parseInt(parts[2]),TokenColor.RED);
                if (parts[3].compareTo("y")==0)
                    guiThread.addLabel(Integer.parseInt(parts[1]),Integer.parseInt(parts[2]),TokenColor.YELLOW);

        		break;
        	case "begin":
        		// apri cose
        	case "victory":
        		// vittoira
        	case "defeat":
        		//sconfitta
            case "invitoRicevuto" :
                //apertura invito con nome il nome dell'invitatne sara in args1
            case "gamefound" :
                System.out.println("parita trovata");
        }
    }
    
    
    
    public void setAnimPanel(JPanel animPanel) {

        this.animPanel = animPanel;
	}

	public void sendMessage(String message) {

        socketOutput.println(message);
    }

    public void setGuiThread(GUI thread){
        this.guiThread = thread;
    }
    
}