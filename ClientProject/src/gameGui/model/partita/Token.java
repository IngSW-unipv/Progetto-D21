package model.partita;

import gameGui.guiB.util.TokenColor;

public class Token {
	
	private TokenColor color;
	
	public Token(TokenColor t) {
		this.color = t;
	}
	
	public TokenColor getColor() {
		return this.color;
	}
	
}
