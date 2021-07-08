package core;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.JPanel;

import menuGUI.windows.ErrorFrame;

import static tester.ClientMainProva1.clientLogger;

/**
 * This class is the Thread that actually receives messages (String) from the server.
 */

public class NetworkThread extends Thread {

    private Socket socket;
    private static int port=25565;
    private PrintWriter socketOutput = null;
    private BufferedReader socketInput = null;
    private static NetworkThread myThread=null;
    private GUIcontroller guiHandler;
    private String nickName;
    private String opponent;
    private String inviteParameters;
    private ErrorFrame errorFrame;

    private NetworkThread(int port) {
        this.opponent="";
        this.port = port;
    }
    
    public static NetworkThread getNetworkThread() {
    	if(myThread==null)
    		myThread = new NetworkThread(port);
    	return myThread;
    }

    /**
     * This Override establish a simple connection client-server and, possibly, returns an ErrorFrame if
     * some Exceptions occurs
     */
    @Override
    public void run() {
        try {
            this.socket = new Socket("188.216.113.154", port);
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

    /**
     * This method parses a message received from the server. Every String is unique and makes possible every
     * action in this program
     * @param message
     */
    
    public void parseString(String message){
        String[] parts = message.split(",");
        System.out.println(message);

        switch (parts[0]){
        	case "abi":
        	    System.out.println("abilitato");
                guiHandler.enableGameGui();
                guiHandler.setMyturn();
                guiHandler.resetTimer();
        		break;
        	case "NOTabi":
        	    System.out.println("disabilitato");
        	    guiHandler.disableGameGui();
                guiHandler.setOpponentTurn();
                guiHandler.resetTimer();

        		break;
        	case "NOTabiCOLONNA":
                  guiHandler.disableColumn(Integer.parseInt(parts[1]));
                  break;
        	case "addToken": //addToken,x,y
                if (parts[3].compareTo("r")==0)
                    guiHandler.addLabel(Integer.parseInt(parts[1]),Integer.parseInt(parts[2]),TokenColor.RED);
                if (parts[3].compareTo("y")==0)
                    guiHandler.addLabel(Integer.parseInt(parts[1]),Integer.parseInt(parts[2]),TokenColor.YELLOW);
        		break;
        	case "begin":
        		guiHandler.startGameIO(parts[1]);
                if(guiHandler.getSecondMenu().getRanf()!=null){
                    guiHandler.getSecondMenu().getRanf().setVisible(false);
                }
        		break;
        	case "victory":
        		guiHandler.victoryScreen(parts[0]);
        		break;
        	case "defeat":
        		guiHandler.victoryScreen(parts[0]);
        		break;
            case "pareggio":
                ErrorFrame errorFrame = new ErrorFrame("pareggio");
                break;
            case "invitoRicevuto" :
                guiHandler.displayInvite(parts[1]);
                this.inviteParameters = parts[2];
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
            case "oppL":
                errorFrame = new ErrorFrame("Opponent left the game");
                GUIcontroller.getGuiHandler().closeGameFrame();
                GUIcontroller.getGuiHandler().openMenu();
                break;
            case "playerNotFound":
                errorFrame = new ErrorFrame("Player not found");
                break;
            case "playerIsNotOnline":
                errorFrame = new ErrorFrame("Player is not online "+parts[1]);
                break;
            case "nickAlreadyPresent":
                errorFrame = new ErrorFrame("Nickname già in uso");
                break;
            default:
                errorFrame = new ErrorFrame("invalid message received "+message);
        }
    }

    /**
     * This method is the actual one that sends messages (String) to the server, it is necessary for the communication
     * between the client and its server
     * @param message
     */

	public void sendMessage(String message) {

        System.out.println(message);
        socketOutput.println(message);
    }
    /**
     * The following methods are some simple but necessary getters and setters
     *
     */

    public void setGuiHandler(GUIcontroller thread){
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

    public String getInviteParameters(){
        return inviteParameters;
    }
}