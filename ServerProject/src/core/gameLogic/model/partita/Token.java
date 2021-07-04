package core.gameLogic.model.partita;

/**
 * Simple class describing a token
 * it contains its color and the getter for that
 */

public class Token {
	
	private TokenColor color;

	/**
	 * Constructor
	 * @param t
	 */
	public Token(TokenColor t) {
		this.color = t;
	}

	/**
	 * gettero of the color
	 * @return
	 */
	public TokenColor getColor() {
		return this.color;
	}
	
}
