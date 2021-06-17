package core;

import core.gameLogic.model.partita.Game;
import core.gameLogic.model.partita.TokenColor;
import core.gameLogic.model.partita.util.GridStatus;
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
    	player1.sendMessage("begin,"+parameters.getTimestring());
    	player2.sendMessage("begin"+parameters.getTimestring());
    	nextPlayer.sendMessage("abi");
    	player2.sendMessage("NOTabi");
    	
    }

	@Override
	public void run() {
		
		localGame.turn(x);
		alternatePlayer();
		int x = GridStatus.getGameStatus().getLastX();
		int y = GridStatus.getGameStatus().getLastY();
		
		
		System.out.println("addToken,"+x+","+y+","+getColor());
		player1.sendMessage("addToken,"+x+","+y+","+getColor());
		player2.sendMessage("addToken,"+x+","+y+","+getColor());
		
		
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
    
    
    private void alternatePlayer() {
    	if(nextPlayer.equals(player1)) {
    		nextPlayer=player2;
    		player1.sendMessage("NOTabi");
    		nextPlayer.sendMessage("abi");
    		return;
    	}
    		
    	if(nextPlayer.equals(player2)) {
    		nextPlayer=player1;
    		player2.sendMessage("NOTabi");
    		nextPlayer.sendMessage("abi");
    		return;
    	}
    	
    }
    
    private String getColor() {
    	
    	String colorString=null;
    	if(GridStatus.getGameStatus().getLastColor()==TokenColor.RED)
    		colorString = "r";
    	if(GridStatus.getGameStatus().getLastColor()==TokenColor.YELLOW)
    		colorString = "y";
    		
    	return colorString;
  
    }
    
}
