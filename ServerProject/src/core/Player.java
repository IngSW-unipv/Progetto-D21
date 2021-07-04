package core;

import util.PlayerStatus;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import core.gameLogic.model.partita.TokenColor;

/**
 * Questa calsse si occupa di memorizzare e restituire dati utili
 * all'elaborazione di quello che accade durante l'elaborazione.
 * Fornisce inoltre un implementazione comoda da utilizzare del metodo
 * sendmessagge che permette, dato il player di indirizzarsi direttamente
 * al client associato
 */
public class Player {

    private Socket playerSocket;
    private String nickName;
    private PlayerStatus status;
    private TokenColor color;
    private PrintWriter out;
    private WorkerThread workerThread;

    public Player(){
        //costruttore vuoto per junit
    }

    /**
     * Costruttore della classe
     *
     * Associa oltre ai parametri passati ad attributi, anche un reader
     * per mandare i messaggi in modo comodo
     *
     * @param playerSocket
     * @param nickName
     * @param thread
     */
    public Player(Socket playerSocket, String nickName,WorkerThread thread) {

        this.playerSocket = playerSocket;
        this.nickName = nickName;
        this.workerThread = thread;
        this.status = PlayerStatus.ONLINE;
        this.out = workerThread.getSocketOutput();

    }

    /**
     * Ritorna il nickname del player
     *
     * @return Nickname
     */
    public String getNickName() {
        return nickName;
    }
    /**
     * Ritorna lo status
     * Lo status serve ad indicare cosa sta facendo il player sul client
     * serve gestire inviti nel caso il giocatore sia già occupato
     *
     * @return status
     */
    public PlayerStatus getStatus() {
        return status;
    }

    /**
     * Cambia lo status del giocatore a necessità
     *
     * @param status
     */
    public void setStatus(PlayerStatus status) {
        this.status = status;
    }

    /**
     * Setta il colore associato al giocatore nella partita
     * serve a tenere conto di chi sta aggiungendo i gettoni
     *
     * @param color
     */
	public void setColor(TokenColor color) {
		this.color = color;
	}

    /**
     * Metodo che scrive sul socket del client associato al player
     * la stringa passata per mandare messaggi ai client a partire dai
     * player associati
     *
     * @param message
     */
    public void sendMessage(String message) {
        System.out.println(message);
    	this.out.println(message);
    }

    /**
     * Ovverride di toString per aggiungere informazioni al player
     * quando stampato
     *
     * @return
     */

    @Override
	public String toString() {
        return this.nickName+" PLAYER: "+status;
	}

    /**
     * Assegna la partita al thread del client
     *
     * @see WorkerThread
     * @param assignedGame
     */
	public void setAssignedGame(GameThread assignedGame){
        workerThread.setAssignedGame(assignedGame);
    }

}
