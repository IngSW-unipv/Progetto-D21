package model.partita;


//inizializzo il game come singletone?

import java.util.TimerTask;

import model.partita.util.SoundPlayer;

import java.io.File;
import java.util.Scanner;

import java.util.Timer;

public class Game {
	
	private Player player1;
	private Player player2;
	private Grid gameGrid;
	private int turnsElapsed;
	private TokenColor startingColor;
	private Timer gameTimer;


	//il controller globale passa i giocatori alla partita generata, la partita inizializza la sua grid
	
	public Game(Player player1, Player player2) {
		
		this.player1 = player1;
		this.player1.setColore(TokenColor.YELLOW);
		this.player2 = player2;
		this.player2.setColore(TokenColor.RED);
		this.gameGrid = new Grid();
		this.turnsElapsed=0;
		this.startingColor = TokenColor.RED;
		this.gameTimer = new Timer();
	}
	
	public void giveTurn(Player turnEnder) {
		//controlla la vittoria
		//disabilita l'interfaccia per il giocatore che gli passiamo
	}
	
	// metodo eseguito all'interno di giveturn
//	private void checkVictory(Player checked) {
//		
//		TokenColor tempColor = checked.getColor();
//		if(/*condizioni di controllo colore gettoni adiacenti*/ ) {
//
//		 //if(/*condizioni di controllo colore gettoni adiacenti*/) {
//			
//		//}
//		
//	}
	//devo impleneteare una logica fittizzia per l'alternarsi dei turni
	public void turn(int x) {
	
		if(turnsElapsed>=41) {
			return;
		}
		
		this.gameGrid.tokenPlaced(this.startingColor, x);
		this.gameGrid.displayGrid();
		
		if(gameGrid.isFinalVictory()) {
			SoundPlayer.playSound(new File("resources/sounds/win.wav"),1);
			return;
		}
		
		if(this.startingColor==TokenColor.RED) {
			this.startingColor=TokenColor.YELLOW;
		}else {
			this.startingColor=TokenColor.RED;
		}
	}
	
	public Timer getGameTimer() {
		return this.gameTimer;
	}
	
}
