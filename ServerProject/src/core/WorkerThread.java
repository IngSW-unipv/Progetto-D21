package core;

import java.io.*;
import java.net.Socket;

import core.gameLogic.model.partita.Game;
import core.gameLogic.model.partita.TokenColor;
import core.gameLogic.model.partita.util.GridStatus;
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
    private Player invitedPlayer;
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

                System.out.println("aa");
                System.out.println(this.socketInput.readLine());
                parseString(this.socketInput.readLine());

            }

        } catch (IOException e) {
            e.printStackTrace();
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

    public void parseString(String message){
        String[] parts = message.split(",");
        TokenColor recievedColor=null;

        switch (parts[0]){
            case "newNick":
                this.player = new Player(socket,parts[1],this);
                this.myMemory.addPlayer(player);
                break;
            
            case "addToken":
            	assignedGame.setX(Integer.parseInt(parts[1]));
            	assignedGame.run();
            	break;
            
            case "sendInvite":
            	myMemory.getPlayer(parts[1]).sendMessage("invitoRicevuto"+","+player.getNickName());
            	invitedPlayer = myMemory.getPlayer(parts[1]);
            	this.inviteParameters = new GameParameters();
            	this.inviteParameters.setDuration(parts[2]);
            	
            	break;
            	
            case "inviteAcceptedOrRefused":
            	if(Integer.parseInt(parts[1])==1)
            		System.out.println("messaggio di accettazione ricevuto"+parts[0]);
            		GameThread newGame = new GameThread(player, invitedPlayer, inviteParameters);
            	break;
            
            case "addmeToQueue":
            	this.player.sendMessage("//apri la finestra di attesa");
            	GameParameters tempGameParameters = new GameParameters();
            	tempGameParameters.setDuration(parts[1]);
            	Queue.getQueue().addPlayerToQueue(player,tempGameParameters);
            	System.out.println("player "+player.getNickName()+" addedd to queue on "+ parts[1]);
            	break;
            
        }

    }

	public void setAssignedGame(GameThread assignedGame) {
		this.assignedGame = assignedGame;
	}

    
    
}
