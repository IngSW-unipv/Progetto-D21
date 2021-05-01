package model.partita;

public class Grid {


    //Matrice di celle della griglia
    private Cell[][] gameGrid;
    private int height = 5;
    private int lenght = 6;

    public Grid() {

        //inizializzazione matrice
        this.gameGrid = new Cell[height][lenght];

    }

    //controllo righe
    public boolean checkRiga(int x,int y,TokenColor c) {
        int victoryCounter = 0 ;

        for(int i=0;i<6;i++) {
            if(gameGrid[i][y].getTokenColor() == c) {
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

    // controllo colonne

    public boolean checkColonna(int x,int y,TokenColor c) {
        int victoryCounter = 0 ;

        for(int i=0;i<6;i++) {
            if(gameGrid[x][i].getTokenColor() == c) {
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
    
    //controllo delle diagonali
public boolean checkDiagonale(int x, int y,TokenColor c) {

        int victoryCounter1 = 0;
        int victoryCounter2 = 0;

        // controllo della diagonale
        for(int i=x-1,j=y-1; i<=0 || j<=0; i--,j--) {
            if(gameGrid[i][j].getTokenColor() != c){
                break;
            } else victoryCounter1++;

            if(victoryCounter1 == 3){

                return true;
            }

        }

        for(int i=x+1,j=y+1 ; i>=5 || j>=6 ; i++,j++) {
            if(gameGrid[i][j].getTokenColor() != c){
                break;
            } else victoryCounter1++;

            if(victoryCounter1 == 3){

                return true;
            }

        }


        //check other diag (in basso a dx)
        for(int i=x-1,j=y+1; i<=0 || j<=0; i--,j++) {
            if(gameGrid[i][j].getTokenColor() != c){
                break;
            } else victoryCounter2++;

            if(victoryCounter2 == 3){
                return true;
            }

        }

        //andiamo in basso a sx
        for(int i=x+1,j=y-1 ; i>=5||j>=6 ; i++,j--) {
            if(gameGrid[i][j].getTokenColor() != c){
                break;
            } else victoryCounter2++;

            if(victoryCounter2 == 3){
                return true;
            }

        }

        //il giocatore di turno non ha vinto, via al prossimo ciclo
        return false;

    }

	public void tokenPlaced(TokenColor c, int y){
		
		int posPlayer = y;

		for(int i = 6; i >= 0; i--){
			if(gameGrid[i][posPlayer]== null){
				gameGrid[i][posPlayer].addToken(new Token(c));
				return; //si ferma alla prima cella vuota, esce dall'if appena la condizione è vera
			}
		}
	}


}

