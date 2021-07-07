package core;

import java.io.*;
import java.net.Socket;

import core.gameLogic.TokenColor;
import core.queue.GameParameters;
import core.queue.Queue;
import util.PlayerStatus;

import static tester.Tester1.serverLogger;

/**
 * This class is listening on the given socket for incoming messages from
 * the client, to each message corresponds a request that this class fulfills.
 * It does so by parsing the incoming strings
 *
 * @author Flavio Bobba
 */

public class WorkerThread extends Thread{

    private Socket socket;
    private BufferedReader socketInput=null;
    private PrintWriter socketOutput=null;
    private Player player = null;
    private ServerMemory myMemory;
    private GameThread assignedGame;
    private Player opponent;

    /**
     * Class constructor
     *Accepts as parameter the socket of a connected client and binds the servermemory to
     * a local attribute.
     *
     * @see ServerMemory
     * @param socket
     */
    public WorkerThread(Socket socket){

        this.socket = socket;
        setupReaders();
        myMemory = ServerMemory.getServerMemory();

    }

    /**
     * Epmty constructor for JUnit usage
     */
    public WorkerThread(){
    //costruttore vuoto per JUnit.
    }

    /**
     * Thread's run method
     * Is the part of the class that listens for incoming messages
     * once a message arrives the method parseString is called which
     * has the duty to interpret the given message.
     * In the case of a sudden disconnection of the client, the player object
     * bound to the thread is removed form the ServerMemory
     *
     * @see Player
     */
    @Override
    public void run() {

        serverLogger.info("handling of the connection inizialized");

        try {

            while (true) {

                System.out.println("Stringa ricevuta");
                //System.out.println(this.socketInput.readLine());
                parseString(this.socketInput.readLine());

            }

        } catch (IOException e) {
            //quando la lettura fallisce è perche i reader sono chiusi quindi il socket disconnesso
            serverLogger.info("client "+socket.getInetAddress()+" disconnected");
            if(player!=null){
                //se il player è gia stato istanziato lo rimuovo da coda e elenco di giocatori
                ServerMemory.getServerMemory().removePlayer(player.getNickName());
                Queue.getQueue().removePlayer(player);
            }
            if(assignedGame!=null){
                assignedGame.getOpponent(player).sendMessage("oppL");
            }
        }
    }

    /**
     * This method initializes the reader and writer for the socket
     */

    private void setupReaders(){
        try {
            this.socketInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.socketOutput = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo che si occupa di interpretare i messaggi in arrivo dal client.
     * I messaggi sono formattati seguendo un protocollo definito solo per
     * questo scopo.
     *
     *  Casi gestiti:
     *      -newNick: il cilent invia questo messaggio al server insieme ad una
     *          stringa che corrisponde al nickname desiderato dall'utente, viene
     *          istanziato quindi un oggetto player che salva il nickname il socket
     *          e il workerThread associato
     * @param message
     */
    //TODO GESTIRE LA MANCANZA DI PRAMETRI NEI COMANDI
    public void parseString(String message){
        String[] parts = message.split(",");
        TokenColor recievedColor=null;
        boolean creategame = false;
        
        System.out.println(player+" :"+message);

        switch (parts[0]){
            case "newNick":
                this.player = new Player(socket,parts[1],this);
                this.myMemory.addPlayer(player);
                System.out.println(this.player.toString()+"debugincaseswitch");
                player.sendMessage("openMainMenu");
                this.setName(parts[1]);
                break;
            
            case "addTokenInvirtualGrid":
            	assignedGame.setX(Integer.parseInt(parts[1]));
            	assignedGame.run();
            	break;

            case "sendInvite":
                Player tempPlayer = myMemory.getPlayer(parts[1]);

                if (tempPlayer!=null) {
                    if(tempPlayer.getStatus()==PlayerStatus.ONLINE){
                        tempPlayer.sendMessage("invitoRicevuto,"+player.getNickName()+","+parts[2]);
                    } else {
                        player.sendMessage("playerIsNotOnline," + tempPlayer.getStatus());
                    }
                } else {
                    player.sendMessage("playerNotFound");
                }

                break;

            case "inviteAcceptedOrRefused":
            	if(Integer.parseInt(parts[1])==1) {
                    creategame = true;
                    System.out.println("INVITO RICEVUTO DA "+parts[2]);
                } else {

            	    myMemory.getPlayer(parts[2]).sendMessage("decline");
                }

            	break;


            case "addmeToQueue": //addmeToQueue,l
            	GameParameters tempGameParameters = new GameParameters(parts[1]);
            	Queue.getQueue().addPlayerToQueue(player,tempGameParameters);
                player.setStatus(PlayerStatus.IN_QUEUE);
            	System.out.println("player "+player.getNickName()+" addedd to queue on "+ parts[1]);
            	break;
            case "exitFromQueue": //addmeToQueue,l
                Queue.getQueue().removePlayer(player);
                player.setStatus(PlayerStatus.ONLINE);
                break;


            default :
            	socketOutput.println("invalid message sent by you");
            	System.out.println("invalid message recieved");
        }

        if(creategame){

            //ottengo il player con il quale creare la partita
            opponent = myMemory.getPlayer(parts[2]);
            System.out.println(opponent);
            System.out.println(opponent.toString());
            GameThread assignedGame = new GameThread(player, opponent,new GameParameters(parts[3]));
            this.setAssignedGame(assignedGame);
            opponent.setAssignedGame(assignedGame);


        }

    }

    /**
     * Setter per l'attributo assignedgame
     * L'attributo assignedGame consiste in un gameThread
     * serve per accoppiare i giocatori alle rispettive istanze
     * delle partite in corso
     *
     * @see  GameThread
     * @param assignedGame
     */
	public void setAssignedGame(GameThread assignedGame) {
        this.assignedGame = assignedGame;
	}

    /**
     * Getter per il socket del asseghanto al thread
     *
     * @return socket
     */
	public Socket getSocket(){
        return this.socket;
    }

    public PrintWriter getSocketOutput() {
        return socketOutput;
    }
}
