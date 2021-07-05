
package core.gameLogic.model.partita;

import java.util.Arrays;

import core.gameLogic.model.partita.util.GridStatus;

/**
 * This class rappresents an array of Cells which constitutes the grid where the token are added
 * it handles the effettive adding of the tokens to the grid with the relative controls
 * it updates the GridStatus instance which gives information to the other classes about the last token added
 *
 * @see GridStatus
 */
public class Grid {

	// Matrice di celle della griglia
	private Cell[][] gameGrid;
	private int height = 6;
	private int lenght = 7;
	private int lastAdded[];
	private GridStatus status;

	private int victoryDiag1;
	private int victoryDiag2;
	private boolean finalVictory;
	
	private int colonnaDaDisabilitare;        
    private boolean flagColonnaDaDisabilitare;

	/**
	 * Constructor, it sets the counters responsible for counting the adjacent tokens
	 * and obtains an istance of the gridstatus
	 */
	public Grid() {
		victoryDiag1 = 0;
		victoryDiag2 = 0;
		finalVictory=false;
		this.status = GridStatus.getGameStatus();
		// inizializzazione matrice
		this.gameGrid = new Cell[height][lenght];
		this.lastAdded = new int[2];
		// riempimento della griglia a celle vuote
		for (int i = 0; i < this.height; i++) {
			for (int j = 0; j < this.lenght; j++)
				gameGrid[i][j] = new Cell();
		}

	}

	/**
	 * controls if there is a column-win around a given token of a given color
	 *
	 * @param x
	 * @param y
	 * @param c
	 * @return
	 */
		public boolean checkColonna(int x, int y, TokenColor c) {
			int victoryCounter = 0;

			for (int i = 0; i < this.height; i++) {
				if (gameGrid[i][y].getHasToken()) {
					if (gameGrid[i][y].getTokenColor() == c) {
						victoryCounter++;
					} else {
						victoryCounter = 0;
					}
				}
			
				if (victoryCounter == 4) {
					System.out.println("vittoria colonna");
					return true;
				}
			} return false;
		}


		// controllo righe

	/**
	 * Checks if around a given token of a given color a row victory is present
	 * @param x
	 * @param y
	 * @param c
	 * @return
	 */
		public boolean checkRiga(int x, int y, TokenColor c) {
			int victoryCounter = 0;

			for (int i = 0; i < this.lenght; i++) {

				if (gameGrid[x][i].getHasToken()) {
					if (gameGrid[x][i].getTokenColor() == c) {
						victoryCounter++;
						//System.out.println(victoryCounter);
					} else {
						victoryCounter = 0;
						System.out.println("spazio");
					}
				}else {
					victoryCounter = 0;
				}
			
				if (victoryCounter == 4) {
					System.out.println("vittoria rigah");
					return true;
				}
			} return false;
		}

	/**
	 * Checks if around a given token of a given color there is a diagonal victory
	 * @param x
	 * @param y
	 * @param c
	 * @return
	 */
	public boolean checkDiagonali(int x, int y, TokenColor c) {
		
		this.checkDiagAltoDx(x, y, c);
		this.checkDiagAltoSx(x, y, c);
		this.checkDiagBassoDx(x, y, c);
		this.checkDiagBassoSx(x, y, c);
		
		if (victoryDiag1 == 5) {
			return true;
		}
		if (victoryDiag2 == 5) {
			return true;
		}
		
		//alla fine li riportiamo a 0
		victoryDiag1 = 0;
		victoryDiag2 = 0;
		
		return false;
	}


	/**
	 * Checks the specified daiagonal for a vicotry around a given token of a given color
 	 * @param x
	 * @param y
	 * @param c
	 */
	public void checkDiagAltoSx(int x, int y, TokenColor c) {//int i = x, j = y; i >= 0 && j <= 6; i--, j++
	//	if (x!=0 && y!=0) {
			for (int i = x , j = y ; i >= 0 && j >=0; i--, j--) {
				//ERRORE SE PROVO COMBINAZIONE 0-0-1
				if ((!gameGrid[i][j].getHasToken()) || (gameGrid[i][j].getTokenColor() != c)) {
	//				System.out.println(gameGrid[i][j].getHasToken());
					break;
				} else if(gameGrid[i][j].getTokenColor() == c) {
		
					victoryDiag1++;
					System.out.println("V1 upcounter"+victoryDiag1);
				}
				if (victoryDiag1 == 5) {
					break;
				}
			}
		
	//	}
	}
	/**
	 * Checks the specified daiagonal for a vicotry around a given token of a given color
	 * @param x
	 * @param y
	 * @param c
	 */
	public void checkDiagBassoDx(int x, int y, TokenColor c) {
	//	if(x!=5 && y!=6) {
			for (int i = x, j = y; i <= 5 && j <= 6; i++, j++) {
				if (!gameGrid[i][j].getHasToken() || (gameGrid[i][j].getTokenColor() != c)) {
					break;
				} else if(gameGrid[i][j].getTokenColor() == c) {
					victoryDiag1++;
					System.out.println("V1 downcounter "+victoryDiag1);
				}
				if (victoryDiag1 == 5) {
					break;
				}
			}
	//	}
		
	}
	/**
	 * Checks the specified daiagonal for a vicotry around a given token of a given color
	 * @param x
	 * @param y
	 * @param c
	 */
	public void checkDiagAltoDx(int x, int y, TokenColor c) {
		if(x!=0 && y!=6)
			System.out.println("aa");
			for (int i = x, j = y; i >= 0 && j <= 6; i--, j++) { //
				System.out.println("bb");
				if (!gameGrid[i][j].getHasToken() || (gameGrid[i][j].getTokenColor() != c)) {
					break;
				} else if(gameGrid[i][j].getTokenColor() == c) {
					System.out.println(gameGrid[i][j].getTokenColor()+ " alto a dx ");
					victoryDiag2++;
					System.out.println("V2 "+victoryDiag2);
				}
				if (victoryDiag2 == 5) {
					break;
				}	
		}
		
	}
	/**
	 * Checks the specified daiagonal for a vicotry around a given token of a given color
	 * @param x
	 * @param y
	 * @param c
	 */
	public void checkDiagBassoSx(int x, int y, TokenColor c) {
		//if(x!= 5 && y!=0) {
			for (int i = x, j = y; i<6 && j >= 0; i++, j--) {
					if (!gameGrid[i][j].getHasToken() || (gameGrid[i][j].getTokenColor() != c)) {
						break;
					} else if(gameGrid[i][j].getTokenColor() == c) {
						System.out.println(gameGrid[i][j].getTokenColor()+ " basso a sx ");
						victoryDiag2++;
						System.out.println("V2 "+victoryDiag2);
					}
					if (victoryDiag2 == 5) {
						break;
					}
				}
		//}
		
	}
		
	// controllo dellgge diagonali

	/**
	 * This method places a token of a given color in a given column, it is responsible of the calculation
	 * of the row in wich the token will end up
	 * @param c
	 * @param y
	 */
	public void tokenPlaced(TokenColor c, int y) {

        int posPlayer = y;
        int i;
        for (i = 5; i >= 0; i--) {
            if (gameGrid[i][posPlayer].getToken() == null) {
                System.out.println("dentro al for" + gameGrid[i][posPlayer]);
                gameGrid[i][posPlayer].addToken(new Token(c));
                gameGrid[i][posPlayer].cellHasToken();
                status.updateGameStatus(posPlayer, i, c);
                    if (this.checkColonna(i, posPlayer, c) || this.checkRiga(i, posPlayer, c) || this.checkDiagonali(i, posPlayer, c)) {
                        System.out.println("VITTORIA " + c);
                        finalVictory=true;
                    }

                    if(i==0) {
                        //DISABILITA LE CELLE COME ABBIAMO DISABILITATO L'INTERFACCIA
                        colonnaDaDisabilitare = y;
                        flagColonnaDaDisabilitare=true;
                    }
                return; // si ferma alla prima cella vuota, esce dall'if appena la condizione è vera

             }
        }
    }

	/**
	 * Displays the grid via text
	 */
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

	/**
	 * returns true if the game was won
	 * @return
	 */
	public boolean isFinalVictory() {
		return finalVictory;
	}
	
	public int getColonnaDaDisabilitare() {
        return colonnaDaDisabilitare; 
    }
	
	public boolean isFlagColonnaDaDisabilitare() {
        return flagColonnaDaDisabilitare;
    }

    public void setFlagColonnaDaDisabilitare(boolean flagColonnaDaDisabilitare) {
        this.flagColonnaDaDisabilitare = flagColonnaDaDisabilitare;
    }

	/**
	 * returns the array of cells used in the game
	 * @return
	 */
	public Cell[][] getGameGrid() {
		return gameGrid;
	}

}

