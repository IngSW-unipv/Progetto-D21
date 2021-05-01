package model.partita;

import java.util.Arrays;

public class Grid {

<<<<<<< HEAD
	// Matrice di celle della griglia
	private Cell[][] gameGrid;
	private int height = 6;
	private int lenght = 7;

	public Grid() {

		// inizializzazione matrice
		this.gameGrid = new Cell[height][lenght];
		// riempimento della griglia a celle vuote
		for (int i = 0; i < this.height; i++) {
			for (int j = 0; j < this.lenght; j++)
				gameGrid[i][j] = new Cell();
		}

	}

	// controllo righe
	public boolean checkRiga(int x, int y, TokenColor c) {
		int victoryCounter = 0;

		for (int i = 0; i < this.height; i++) {
			if (gameGrid[i][y].getHasToken()) {
				if (gameGrid[i][y].getTokenColor() == c) {
					victoryCounter++;
				} else {
					victoryCounter = 0;
				}
			}
		}
		if (victoryCounter == 4)
			return true;
		else
			return false;

	}

	// controllo colonne

	public boolean checkColonna(int x, int y, TokenColor c) {
		int victoryCounter = 0;

		for (int i = 0; i < this.lenght; i++) {

			System.out.println(gameGrid[x][i]+ "a");

			
			if (gameGrid[x][i].getHasToken()) {
				if (gameGrid[x][i].getTokenColor() == c) {
					victoryCounter++;
				} else {
					victoryCounter = 0;
				}
			}
		}
		if (victoryCounter == 4)
			return true;
		else
			return false;
	}

	// controllo delle diagonali
	public boolean checkDiagonale(int x, int y, TokenColor c) {
=======
    //Matrice di celle della griglia
    private Cell[][] gameGrid;
    private int height = 6;
    private int lenght = 7;

    public Grid() {

        //inizializzazione matrice
        this.gameGrid = new Cell[height][lenght];
        //riempimento della griglia a celle vuote
        for(int i = 0;i<this.height;i++) {
        	for(int j = 0;j<this.lenght;j++)
        		this.gameGrid[i][j]= new Cell();
        }
       
    }

    //controllo righe
    public boolean checkRiga(int x,int y,TokenColor c) {
        int victoryCounter = 0 ;

        for(int i=0;i<this.height;i++) {
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

        for(int i=0;i<this.lenght;i++) {
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
>>>>>>> d653d40a563d43dcc58df329310db9ec2c3a2d57

		int victoryCounter1 = 0;
		int victoryCounter2 = 0;

		// controllo della diagonale
		if(x==0 || y== 0) {
			for (int i = x - 1, j = y - 1; i <= 0 || j <= 0; i--, j--) {
				if (!gameGrid[i][j].getHasToken()) {
					break;
				} else if(gameGrid[i][j].getTokenColor() == c)
		
	//			if (gameGrid[i][j].getTokenColor() != c) {		Non va bene!!!
	//				break;
	//			} else
					victoryCounter1++;
	
				if (victoryCounter1 == 3) {
	
					return true;
				}
	
			}
			return false;
		}

		for (int i = x + 1, j = y + 1; i >= 5 || j >= 6; i++, j++) {
			if (!gameGrid[i][j].getHasToken()) {
				break;
			} else if(gameGrid[i][j].getTokenColor() == c)
				victoryCounter1++;

			if (victoryCounter1 == 3) {

				return true;
			}

		}

		// check other diag (in basso a dx)
		for (int i = x - 1, j = y + 1; i <= 0 || j <= 0; i--, j++) {
			if (!gameGrid[i][j].getHasToken()) {
				break;
			} else if(gameGrid[i][j].getTokenColor() == c)
				victoryCounter2++;

			if (victoryCounter2 == 3) {
				return true;
			}

		}

		// andiamo in basso a sx
		for (int i = x + 1, j = y - 1; i >= 5 || j >= 6; i++, j--) {
			if (!gameGrid[i][j].getHasToken()) {
				break;
			} else if(gameGrid[i][j].getTokenColor() == c)
				victoryCounter2++;

			if (victoryCounter2 == 3) {
				return true;
			}

		}

		// il giocatore di turno non ha vinto, via al prossimo ciclo
		return false;

	}

	public void tokenPlaced(TokenColor c, int y) {

		int posPlayer = y;

		for (int i = 5; i >= 0; i--) {
			if (gameGrid[i][posPlayer].getToken() == null) {
				gameGrid[i][posPlayer].addToken(new Token(c));
				gameGrid[i][posPlayer].cellHasToken();
				if (this.checkColonna(i, posPlayer, c) || this.checkRiga(i, posPlayer, c)
						|| this.checkDiagonale(i, posPlayer, c))
					System.out.println("VITTORIA " + c);
				return; // si ferma alla prima cella vuota, esce dall'if appena la condizione è vera
			}
		}
	}

	public void displayGrid() {
		// scrivo num colonne perché mi perdo
		System.out.println("   0  1  2  3  4  5  6");
		for (int i = 0; i < this.height; i++) {
			System.out.print(" |");
			for (int j = 0; j < this.lenght; j++) {
				System.out.print(gameGrid[i][j] + " |");
			}
			// vado a capo perché esce bene
			System.out.println();
			System.out.println(" ------------------------");
		}
	}


}
