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
    private Player invitedPLayer;

    public WorkerThread(Socket socket){

        this.socket = socket;
        setupReaders();
        myMemory = ServerMemory.getServerMemory();
        inviteParameters = new GameParameters();
        invitedPLayer = new Player();

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
        boolean creategame = false;
        
        System.out.println(message);

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
                invitedPLayer.playerBuilder(myMemory.getPlayer(parts[1]));
            	invitedPLayer.sendMessage("invitoRicevuto,"+player.getNickName()+","+parts[2]);
            	this.inviteParameters.setDuration(parts[2]);
            	return;

            case "inviteAcceptedOrRefused":
            	if(Integer.parseInt(parts[1])==1) {
                    creategame = true;
                    System.out.println("INVITO RICEVUTO DA "+parts[2]);
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

        if(creategame){
            //ottengo il player con il quale creare la partita
            System.out.println(myMemory.getPlayer(parts[2]));
            Player player2 = myMemory.getPlayer(parts[2]);
            System.out.println(player2.toString());
            GameThread assignedGame = new GameThread(player, player2, inviteParameters);
            this.setAssignedGame(assignedGame);
            player2.getWorkerThread().setAssignedGame(assignedGame);

        }

    }

	public void setAssignedGame(GameThread assignedGame) {

        this.assignedGame = assignedGame;

	}

	public Socket getSocket(){
        return this.socket;
    }

}
