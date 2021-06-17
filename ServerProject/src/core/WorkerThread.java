package core;

import java.io.*;
import java.net.Socket;

import core.gameLogic.model.partita.TokenColor;
import core.queue.GameParameters;
import core.queue.Queue;

import static tester.Tester1.serverLogger;

public class WorkerThread extends Thread{

    private Socket socket;
    private BufferedReader socketInput=null;
    private PrintWriter socketOutput=null;
    private Player player = null;
    private ServerMemory myMemory;
    private GameThread assignedGame;
    private GameParameters inviteParameters;

    public WorkerThread(Socket socket){

        this.socket = socket;
        setupReaders();
        myMemory = ServerMemory.getServerMemory();

    }

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
        }


    }
    // metodo per inzializzare gli input e gli output
    private void setupReaders(){
        try {
            this.socketInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.socketOutput = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //TODO GESTIRE LA MANCANZA DI PRAMETRI NEI COMANDI
    public void parseString(String message){
        String[] parts = message.split(",");
        TokenColor recievedColor=null;
        
        System.out.println(parts[0]+parts[1]);

        switch (parts[0]){
            case "newNick":
                this.player = new Player(socket,parts[1],this);
                this.myMemory.addPlayer(player);
                System.out.println(this.player.toString()+"debugincaseswitch");
                player.sendMessage("openMainMenu");
                break;
            
            case "addTokenInvirtualGrid":
            	assignedGame.setX(Integer.parseInt(parts[1]));
            	assignedGame.run();
            	break;

            case "sendInvite":
            	myMemory.getPlayer(parts[1]).sendMessage("invitoRicevuto"+","+player.getNickName()+","+parts[2]);
            	this.inviteParameters = new GameParameters();
            	this.inviteParameters.setDuration(parts[2]);
            	return;

            case "inviteAcceptedOrRefused":
            	if(Integer.parseInt(parts[1])==1) {
                    System.out.println("messaggio di accettazione ricevuto" + parts[1]);
                    System.out.println(myMemory.getPlayer(parts[2]).toString());
                    GameThread assignedGame = new GameThread(player, myMemory.getPlayer(parts[2]), inviteParameters);
                    myMemory.getPlayer(parts[2]).getWorkerThread().setAssignedGame(assignedGame);
                } else {
            	    player.sendMessage("decline");
                }

            	break;


            case "addmeToQueue": //addmeToQueue,l
            	this.player.sendMessage("//apri la finestra di attesa");
            	GameParameters tempGameParameters = new GameParameters();
            	tempGameParameters.setDuration(parts[1]);
            	Queue.getQueue().addPlayerToQueue(player,tempGameParameters);
            	System.out.println("player "+player.getNickName()+" addedd to queue on "+ parts[1]);
            	break;
            
            default :
            	socketOutput.println("invalid message sent by you");
            	System.out.println("invalid message recieved");
        }

    }

	public void setAssignedGame(GameThread assignedGame) {

        this.assignedGame = assignedGame;

	}

}
