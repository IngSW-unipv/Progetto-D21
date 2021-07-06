package core.gameLogic;


//inizializzo il game come singletone?

import core.Player;

import java.util.Timer;

/**
 * This class is responsible for checking for the victory, adding the tokens and controlling the
 * game at a high level in general. It interfaces With the class Grid which represents the game's grid.
 *
 * @see Grid
 */
public class Game {
	
	private Player player1;
	private Player player2;
	private Grid gameGrid;
	private int turnsElapsed;
	private TokenColor startingColor;
	private Timer gameTimer;
	private boolean victory = false;


	//il controller globale passa i giocatori alla partita generata, la partita inizializza la sua grid

	/**
	 * Constructor
	 *
	 * @param player1
	 * @param player2
	 */
	public Game(Player player1, Player player2) {
		
		this.player1 = player1;
		this.player1.setColor(TokenColor.YELLOW);
		this.player2 = player2;
		this.player2.setColor(TokenColor.RED);
		this.gameGrid = new Grid();
		this.turnsElapsed=0;
		this.startingColor = TokenColor.RED;
		this.gameTimer = new Timer();
	}
	

	//devo impleneteare una logica fittizzia per l'alternarsi dei turni
	public void turn(int x) {
	
		turnsElapsed++;
		
		this.gameGrid.tokenPlaced(this.startingColor, x);
		this.gameGrid.displayGrid();
		
		if(gameGrid.isFinalVictory()) {
			//SoundPlayer.setVol(1, 0); //modifica del volume dinamica
			//SoundPlayer.playSound(new File("resources/sounds/win.wav"),1);
			victory = true;
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

	/**
	 * The grid internally checks for a victory and it is passed to the thread through this
	 *
	 * @return
	 */
	public boolean isVictory() {
		return victory;
	}

	/**
	 * returns the grind
	 *
	 * @return
	 */
	public Grid getGameGrid() {
        return gameGrid;
    }

	/**
	 * returns the number of turns elapsed
	 * @return
	 */
	public int getTurnsElapsed() {         return turnsElapsed;     }
	
}


