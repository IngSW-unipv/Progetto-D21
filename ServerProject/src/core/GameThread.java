package core;

import core.gameLogic.model.partita.Game;
import core.gameLogic.model.partita.TokenColor;
import core.gameLogic.model.partita.util.GridStatus;
import core.queue.GameParameters;
import core.queue.Queue;
import util.PlayerStatus;

import java.nio.channels.NetworkChannel;
import java.util.concurrent.TimeUnit;

public class GameThread extends Thread{
	
	private Player player1;
	private Player player2;
	private GameParameters parameters;
	private Game localGame;
	private int x;
	private Player nextPlayer;
	private Player oTherPlayer;

    public GameThread(Player player1, Player player2,GameParameters parameters) {
    	
    	this.player1=player1;
    	this.player2=player2;
    	this.parameters=parameters;
		this.oTherPlayer =null;
    	gameSetup();
    	
    }
    
    private void gameSetup() {

		Queue.getQueue().removePlayer(player1);
		Queue.getQueue().removePlayer(player2);

    	player1.setStatus(PlayerStatus.IN_GAME);
		player2.setStatus(PlayerStatus.IN_GAME);
    	localGame = new Game(player1, player2);
    	nextPlayer = player1;
    	player1.sendMessage("begin,"+parameters.getTimestring());
    	player2.sendMessage("begin,"+parameters.getTimestring());
    	nextPlayer.sendMessage("abi");
    	player2.sendMessage("NOTabi");
    	
    }

	@Override
	public void run() {
		
		localGame.turn(x);
		
		if(localGame.getGameGrid().isFlagColonnaDaDisabilitare()) {
            oTherPlayer.sendMessage("NOTabiCOLONNA,"+localGame.getGameGrid().getColonnaDaDisabilitare());
            nextPlayer.sendMessage("NOTabiCOLONNA,"+localGame.getGameGrid().getColonnaDaDisabilitare());
        }
		
<<<<<<< Updated upstream

=======
		if(localGame.isVictory()){
			nextPlayer.sendMessage("victory");
			oTherPlayer.sendMessage("defeat");
			nextPlayer.getWorkerThread().setAssignedGame(null);
			oTherPlayer.getWorkerThread().setAssignedGame(null);
		}
>>>>>>> Stashed changes
		alternatePlayer();
		int x = GridStatus.getGameStatus().getLastX();
		int y = GridStatus.getGameStatus().getLastY();
		
		
		System.out.println("addToken,"+x+","+y+","+getColor());
		player1.sendMessage("addToken,"+x+","+y+","+getColor());
		player2.sendMessage("addToken,"+x+","+y+","+getColor());
		
		localGame.getGameGrid().setFlagColonnaDaDisabilitare(false);

		if(localGame.isVictory()){
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				  //TODO Auto-generated catch block
				  e.printStackTrace();
			}
			nextPlayer.sendMessage("victory");
			oTherPlayer.sendMessage("defeat");
			nextPlayer.setStatus(PlayerStatus.ONLINE);
			oTherPlayer.setStatus(PlayerStatus.ONLINE);
			}
		if(localGame.getTurnsElapsed() > 41) {
			try {
				TimeUnit.SECONDS.sleep(1);
				 } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				 e.printStackTrace();
			}
			player1.sendMessage("pareggio,");
			player2.sendMessage("pareggio,");
			player1.setStatus(PlayerStatus.ONLINE);
			player2.setStatus(PlayerStatus.ONLINE);
		}
		
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
    		oTherPlayer = player1;
    		player1.sendMessage("NOTabi");
    		nextPlayer.sendMessage("abi");
    		return;
    	}
    		
    	if(nextPlayer.equals(player2)) {
    		nextPlayer=player1;
    		oTherPlayer = player2;
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

    public Player getOpponent(Player playerFacing){
    	Player opponent = player1;
    	if(playerFacing.getNickName().compareTo(player1.getNickName())==0){
    		opponent = player2;
		}
    	if(playerFacing.getNickName().compareTo(player2.getNickName())==0){
    		opponent = player1;
		}
    	return opponent;
	}
    
}
