package core;

import java.io.*;
import java.net.Socket;

import javax.swing.JPanel;

import menuGUI.windows.ErrorFrame;

import static tester.ClientMainProva1.clientLogger;

public class NetworkThread extends Thread {

    private Socket socket;
    private static int port=25565;
    private PrintWriter socketOutput = null;
    private BufferedReader socketInput = null;
    private static NetworkThread myThread=null;
    private JPanel animPanel;
    private GUI guiHandler;
    private String nickName;
    private String opponent;

    private NetworkThread(int port) {
        this.opponent="";
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
            this.socket = new Socket("188.218.173.220", port);
            clientLogger.info("Connection established");
        } catch (IOException e) {
            clientLogger.info("Impossible to establish connection to server");
            ErrorFrame errorFrame = new ErrorFrame("Impossible to establish \n connection to server");
            return;
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
                ErrorFrame errorFrame = new ErrorFrame("Connection dropped");
                break;
            }
        }
    }
    
    public void parseString(String message){
        String[] parts = message.split(",");
        System.out.println(message);

        switch (parts[0]){
        	case "abi":
        	    System.out.println("abilitato");
                guiHandler.enableGameGui();
                GUI.getGuiHandler().resetTimer();
                GUI.getGuiHandler().setMyturn();
        		break;
        	case "NOTabi":
        	    System.out.println("disabilitato");
        	    guiHandler.disableGameGui();
                GUI.getGuiHandler().resetTimer();
                GUI.getGuiHandler().setOpponentTurn();
        		break;
        	case "addToken": //addToken,x,y
                if (parts[3].compareTo("r")==0)
                    guiHandler.addLabel(Integer.parseInt(parts[1]),Integer.parseInt(parts[2]),TokenColor.RED);
                if (parts[3].compareTo("y")==0)
                    guiHandler.addLabel(Integer.parseInt(parts[1]),Integer.parseInt(parts[2]),TokenColor.YELLOW);
        		break;
        	case "begin":
        		guiHandler.startGameIO(parts[1]);
        		break;
        	case "victory":
        		guiHandler.victoryScreen(parts[0]);
        		break;
        	case "defeat":
        		guiHandler.victoryScreen(parts[0]);
        		break;
            case "invitoRicevuto" :
                guiHandler.displayInvite(parts[1]+parts[2]);
                this.opponent=parts[1];
                break;
            case "gamefound" :
                System.out.println("parita trovata");
                break;
            case "openMainMenu":
                guiHandler.openMenu();
                break;
            case "decline":
                guiHandler.displayDeclineFrame();
                break;
                //default con gestione errore messaggio
            default:
                ErrorFrame errorFrame = new ErrorFrame("invalid message recived");
        }
    }

    public void setAnimPanel(JPanel animPanel) {
        this.animPanel = animPanel;
	}

	public void sendMessage(String message) {
        socketOutput.println(message);
    }

    public void setGuiHandler(GUI thread){
        this.guiHandler = thread;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getNickName() {
        return nickName;
    }

    public String getOpponent(){
        return opponent;
    }
}