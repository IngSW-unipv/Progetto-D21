package model.partita;

public class Player {
	
	// variabile flag controllata game per indicare di chi è il turno
	private boolean isMyTurn;
	private TokenColor color;
	
	public Player() {
		//costruttore
	}
	
	public TokenColor getColor() {
		return color;
	}
	
	public void setColore(TokenColor c) {
		
		this.color = c;
		
	}
}
