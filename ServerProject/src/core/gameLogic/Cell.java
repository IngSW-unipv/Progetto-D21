package core.gameLogic;

/**
 * this class represents a cell of the grid, it can display if it is occupied or not and by which token it is occupied
 *
 * @see Token
 * @see Grid
 */

public class Cell {

	private Token localToken;
	private Boolean hasToken;

	/**
	 * returns if the cell is occupied
	 */
	public Cell() {
		hasToken = false;
	}

	/**
	 * adds a token to the cell
	 * @param t
	 */
	public void addToken(Token t) {
		this.localToken = t;
	}

	/**
	 * Sets the presence of a token
	 */
	public void cellHasToken() {
		hasToken = true;
	}

	/**
	 * returns if the cell has a token as a boolean
	 * @return
	 */
	public Boolean getHasToken() {
		return hasToken;
	}

	/**
	 * gets the color of the token present in the cell
	 * @return
	 */
	public TokenColor getTokenColor() {

		return this.localToken.getColor();

	}

	/**
	 * translates the tokenColor in to a string value
	 *
	 * @return
	 */
	public String toString() {
		if(this.getHasToken()) {
			if(getTokenColor()==TokenColor.RED)
				return "R";
			else
				return "Y";
		}
		else
			return " ";
	}

	/**
	 * returns the token present in the cell
	 * @return
	 */
	public Token getToken() {
		return this.localToken;
	}

}
