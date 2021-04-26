package model.partita;

public class Grid {
	
	//Matrice di celle della griglia
	private Cell[][] gameGrid;
	private int height = 6;
	private int lenght = 7;
	
	public Grid() {
		
		//inizializzazione matrice
		this.gameGrid = new Cell[height][lenght];
		
	}
	
	//controllo righe
	
	public boolean checkRiga(int x,int y,TokenColor c) {
		int victoryCounter = 0 ;
		
		for(int i=0;i<7;i++) {
			if(gameGrid[i][y].getTokenColor == c) {
				victoryCounter++;
			}
			else {
				victoryCounter = 0;
			}
		}
		if(victoryCounter==4) 
			return true;
		else
			return false;
		
	}

}
