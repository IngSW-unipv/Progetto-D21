package core;

import util.PlayerStatus;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import core.gameLogic.model.partita.TokenColor;


public class Player {

    private Socket playerSocket;
    private String nickName;
    private PlayerStatus status;
    private TokenColor color;
    private PrintWriter out;
    private WorkerThread workerThread;

    public Player(){
        //costruttore vuoto per istanziare e basta
    }

    public Player(Socket playerSocket, String nickName,WorkerThread thread) {
        this.playerSocket = playerSocket;
        this.nickName = nickName;
        this.workerThread = thread;
        
        try {
			this.out = new PrintWriter(new OutputStreamWriter(playerSocket.getOutputStream()),true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public Socket getPlayerSocket() {
        return playerSocket;
    }

    public void setPlayerSocket(Socket playerSocket) {
        this.playerSocket = playerSocket;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public PlayerStatus getStatus() {
        return status;
    }

    public void setStatus(PlayerStatus status) {
        this.status = status;
    }

	public TokenColor getColor() {
		return color;
	}

	public void setColor(TokenColor color) {
		this.color = color;
	}
    
    public void sendMessage(String message) {

        System.out.println(message);
    	this.out.println(message);
    	
    }

	public WorkerThread getWorkerThread() {
		return workerThread;
	}
	
	public String toString() {
        return this.nickName+"dbug";
	}

    public void playerBuilder(Player p){

        this.workerThread = p.getWorkerThread();
        this.playerSocket = workerThread.getSocket();
        try {
            this.out = new PrintWriter(new OutputStreamWriter(playerSocket.getOutputStream()),true);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
