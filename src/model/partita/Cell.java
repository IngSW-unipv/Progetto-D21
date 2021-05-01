package model.partita;

public class Cell {
	
	private Token localToken;
	
	public Cell() {
		
	}
	
	public void addToken(Token t) {
		this.localToken = t;
	}
	
	public TokenColor getTokenColor() {
		
		return this.localToken.getColor();
		
	}

}
