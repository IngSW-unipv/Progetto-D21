package core;

import core.gameLogic.model.partita.Game;
import core.queue.GameParameters;

public class GameThread extends Thread{
	
	private Player player1;
	private Player player2;
	private GameParameters parameters;
	private Game localGame;
	private int x;
	private Player nextPlayer;

    public GameThread(Player player1, Player player2,GameParameters parameters) {
    	
    	this.player1=player1;
    	this.player2=player2;
    	this.parameters=parameters;
    	gameSetup();
    	
    }
    
    private void gameSetup() {
    	localGame = new Game(player1, player2);
    	nextPlayer = player1;
    	nextPlayer.sendMessage("abilita interfaccia");
    	
    }

	@Override
	public void run() {
		
		localGame.turn(x);
		alternatePlayer();
		player1.sendMessage("aggiungi token gui");
		player2.sendMessage("aggiungi token gui");
		
		
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
    
    
    private void alternatePlayer() {
    	if(nextPlayer==player1) {
    		nextPlayer=player2;
    		player1.sendMessage("disabilita interfaccia");
    	}
    		
    	if(nextPlayer==player2) {
    		nextPlayer=player1;
    		player2.sendMessage("disabilita interfaccia");
    	}
    	nextPlayer.sendMessage("abilita interfaccia");
    }
    
}
