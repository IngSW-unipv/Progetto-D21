package model.partita;

public class Player {
	
	// variabile flag controllata game per indicare di chi � il turno
	private boolean isMyTurn;
	private TokenColor color;
	
	public Player() {
		//costruttore
	}
	
	public TokenColor getColor() {
		return color;
	}
}
