package model.partita;

import gameGui.guiB.util.TokenColor;

public class Cell {

	private Token localToken;
	private Boolean hasToken;

	public Cell() {
		hasToken = false;
	}

	public void addToken(Token t) {
		this.localToken = t;
	}

	public void cellHasToken() {
		hasToken = true;
	}

	//verrà richiamato nei controlli del check vittoria
	public Boolean getHasToken() {
		return hasToken;
	}

	public TokenColor getTokenColor() {

		return this.localToken.getColor();

	}

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

	public Token getToken() {
		return this.localToken;
	}

}
