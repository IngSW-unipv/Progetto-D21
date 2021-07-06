package core;

import core.gameLogic.model.partita.Game;
import core.gameLogic.model.partita.TokenColor;
import core.gameLogic.model.partita.util.GridStatus;
import core.queue.GameParameters;
import core.queue.Queue;
import util.PlayerStatus;

import java.nio.channels.NetworkChannel;
import java.util.concurrent.TimeUnit;

/**
 * This class consists in a thread responsible for handling the events of the game.
 * It creates a Game class instance and makes the players interface with it.
 *
 * @see Game
 */
public class GameThread extends Thread{
	
	private Player player1;
	private Player player2;
	private GameParameters parameters;
	private Game localGame;
	private int x;
	private Player nextPlayer;
	private Player oTherPlayer;

	/**
	 * Constructor that utilizes the given players and the info inside GameParameters to setup a new Game instance
	 *
	 * @see GameParameters
	 * @see Player
	 *
	 * @param player1
	 * @param player2
	 * @param parameters
	 */
    public GameThread(Player player1, Player player2,GameParameters parameters) {
    	
    	this.player1=player1;
    	this.player2=player2;
    	this.parameters=parameters;
		this.oTherPlayer =null;
    	gameSetup();
    	
    }

	/**
	 * this method does the necessary operations to correctly start a new game:
	 * -it removes the players from the queue
	 * -it sets the player's status to IN_GAME
	 * -creates a new Game instance
	 * -tells the clients to start the game IO
	 * -tells the clients whose turn is first
	 */
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

	/**
	 * The run method of this thread is responsible for adding the tokens to the game's virtual grid
	 * and the relative victory checks, it alternates the players in order to handle the turns.
	 * When a token is correctly added to the grid it sends the client a message to make them add the token to their
	 * interactive grids
	 *
	 */
	@Override
	public void run() {
		localGame.turn(x);
		disableFullColumn();
		updateClientsGui();
		checkForVictory();
		checkForDraw();
		localGame.getGameGrid().setFlagColonnaDaDisabilitare(false);
		alternatePlayer();
	}

	/**
	 * sets the added token's x
	 *
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Alternates the player's interface abilitation by sending them a message
	 */
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

	/**
	 * gets the color of the added token
	 * @return
	 */
	private String getColor() {
    	
    	String colorString=null;
    	if(GridStatus.getGameStatus().getLastColor()==TokenColor.RED)
    		colorString = "r";
    	if(GridStatus.getGameStatus().getLastColor()==TokenColor.YELLOW)
    		colorString = "y";
    		
    	return colorString;
  
    }

	/**
	 * Returns the opponent of a given player in the game
	 * @param playerFacing
	 * @return
	 */
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

    private void disableFullColumn(){
		if(localGame.getGameGrid().isFlagColonnaDaDisabilitare()) {
			oTherPlayer.sendMessage("NOTabiCOLONNA,"+localGame.getGameGrid().getColonnaDaDisabilitare());
			nextPlayer.sendMessage("NOTabiCOLONNA,"+localGame.getGameGrid().getColonnaDaDisabilitare());
		}
	}

	private void checkForVictory(){
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
	}

	private void checkForDraw(){
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
	private void updateClientsGui(){
		int x = GridStatus.getGameStatus().getLastX();
		int y = GridStatus.getGameStatus().getLastY();

		System.out.println("addToken,"+x+","+y+","+getColor());
		player1.sendMessage("addToken,"+x+","+y+","+getColor());
		player2.sendMessage("addToken,"+x+","+y+","+getColor());
	}
}
