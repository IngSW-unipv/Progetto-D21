package model;

import java.io.PrintWriter;
import java.net.Socket;

import model.gameLogic.TokenColor;
import model.util.PlayerStatus;

/**This class memorizes and displays useful data necessary to the elaboration.
 * It provides a simple way to send message to the client of a given player
 */
public class Player {

    private Socket playerSocket;
    private String nickName;
    private PlayerStatus status;
    private TokenColor color;
    private PrintWriter out;
    private WorkerThread workerThread;


    /**
     * Class constructor, binds the given data to attributes inside the class
     * and it binds a reader attribute to the reader from the client's WorkerThread
     *
     * @param playerSocket
     * @param nickName
     * @param thread
     */
    public Player(Socket playerSocket, String nickName,WorkerThread thread) {

        this.playerSocket = playerSocket;
        this.nickName = nickName;
        this.workerThread = thread;

        this.out = workerThread.getSocketOutput();

    }

    /**
     * Returns the player's nickname
     *
     * @return Nickname
     */
    public String getNickName() {
        return nickName;
    }
    /**
     * Returns the player's status
     * the status is used to see what a connected client is doing in order to
     * execute the correct operations through status checks.
     * As an example: if a player is in a game at the moment(INGAME status)
     * it can not be invited
     *
     * @see PlayerStatus
     * @return status
     */
    public PlayerStatus getStatus() {
        return status;
    }

    /**
     * Changes the player status according to necessity
     *
     * @see PlayerStatus
     * @param status
     */
    public void setStatus(PlayerStatus status) {
        this.status = status;
    }

    /**
     * Sets the color associated with a player within a game
     * it is useful to keep track of who is adding the tokens
     *
     * @see TokenColor
     * @param color
     */
	public void setColor(TokenColor color) {
		this.color = color;
	}

    /**
     *Method that writes a message on the socketoutput in order to send it to the associated client
     *
     * @param message
     */
    public void sendMessage(String message) {
        System.out.println(message);
    	this.out.println(message);
    }

    /**ToString override to provide more information
     *
     * @return
     */

    @Override
	public String toString() {
        return this.nickName+" PLAYER: "+status;
	}

    /**Binds the GameThread to the player's workerThread allowing the WorkerThread to work directly on the GameThread
     *
     * @see WorkerThread
     * @param assignedGame
     */
	public void setAssignedGame(GameThread assignedGame){
        workerThread.setAssignedGame(assignedGame);
    }

}
