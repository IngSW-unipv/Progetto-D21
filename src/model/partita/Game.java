package model.partita;


import java.util.TimerTask;
import java.util.Timer;

public class Game {
	
	private Player player1;
	private Player player2;
	
	private Grid gameGrid;

	//il controller globale passa i giocatori alla partita generata, la partita inizializza la sua grid
	
	public Game(Player player1, Player player2) {
		
		this.player1 = player1;
		this.player2 = player2;
		
		this.gameGrid = new Grid();
	}
	
	public void giveTurn(Player turnEnder) {
		//disabilita l'interfaccia per il giocatore che gli passiamo
	}
	

}
