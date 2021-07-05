/*package JUnit;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import core.gameLogic.model.partita.Grid;
import core.gameLogic.model.partita.Token;
import core.gameLogic.model.partita.TokenColor;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VictoryDiagonalTest {

	Grid grid ;
	Token tokY;
	Token tokR;
	
	@BeforeEach
	void setUp() throws Exception {
		grid = new Grid();
		tokY = new Token(TokenColor.YELLOW);
		tokR = new Token(TokenColor.RED);
	}

	@AfterEach
	void tearDown() throws Exception {
		grid = null;
		tokY = null;
		tokR = null;
	}
	
	@Test
	void testDiagonal1() {
		
		grid.getGameGrid()[5][0].addToken(tokY);	
		grid.getGameGrid()[5][0].cellHasToken();
		grid.getGameGrid()[5][1].addToken(tokY);
		grid.getGameGrid()[5][1].cellHasToken();
		grid.getGameGrid()[5][2].addToken(tokR);	
		grid.getGameGrid()[5][2].cellHasToken();
		grid.getGameGrid()[5][3].addToken(tokY);	
		grid.getGameGrid()[5][3].cellHasToken();
		grid.getGameGrid()[4][0].addToken(tokR);	
		grid.getGameGrid()[4][0].cellHasToken();
		grid.getGameGrid()[4][1].addToken(tokY);
		grid.getGameGrid()[4][1].cellHasToken();
		grid.getGameGrid()[4][2].addToken(tokR);	
		grid.getGameGrid()[4][2].cellHasToken();
		grid.getGameGrid()[4][3].addToken(tokR);	
		grid.getGameGrid()[4][3].cellHasToken();
		grid.getGameGrid()[3][0].addToken(tokY);	
		grid.getGameGrid()[3][0].cellHasToken();
		grid.getGameGrid()[3][1].addToken(tokR);
		grid.getGameGrid()[3][1].cellHasToken();
		grid.getGameGrid()[3][2].addToken(tokY);	
		grid.getGameGrid()[3][2].cellHasToken();
		grid.getGameGrid()[3][3].addToken(tokY);	
		grid.getGameGrid()[3][3].cellHasToken();
		grid.getGameGrid()[2][0].addToken(tokR);	
		grid.getGameGrid()[2][0].cellHasToken();
		grid.getGameGrid()[2][1].addToken(tokY);
		grid.getGameGrid()[2][1].cellHasToken();
		grid.getGameGrid()[2][2].addToken(tokY);	
		grid.getGameGrid()[2][2].cellHasToken();
		grid.getGameGrid()[2][3].addToken(tokY);	
		grid.getGameGrid()[2][3].cellHasToken();
		
		grid.displayGrid();
		
		assertEquals(true, grid.checkDiagonali(2,3,TokenColor.YELLOW));
	}
	
	@Test
	void testDiagonal2() {
		
		grid.getGameGrid()[5][0].addToken(tokY);	
		grid.getGameGrid()[5][0].cellHasToken();
		grid.getGameGrid()[5][1].addToken(tokY);
		grid.getGameGrid()[5][1].cellHasToken();
		grid.getGameGrid()[5][2].addToken(tokR);	
		grid.getGameGrid()[5][2].cellHasToken();
		grid.getGameGrid()[5][3].addToken(tokY);	
		grid.getGameGrid()[5][3].cellHasToken();
		grid.getGameGrid()[4][0].addToken(tokR);	
		grid.getGameGrid()[4][0].cellHasToken();
		grid.getGameGrid()[4][1].addToken(tokY);
		grid.getGameGrid()[4][1].cellHasToken();
		grid.getGameGrid()[4][2].addToken(tokR);	
		grid.getGameGrid()[4][2].cellHasToken();
		grid.getGameGrid()[4][3].addToken(tokR);	
		grid.getGameGrid()[4][3].cellHasToken();
		grid.getGameGrid()[3][0].addToken(tokY);	
		grid.getGameGrid()[3][0].cellHasToken();
		grid.getGameGrid()[3][1].addToken(tokR);
		grid.getGameGrid()[3][1].cellHasToken();
		grid.getGameGrid()[3][2].addToken(tokR);	
		grid.getGameGrid()[3][2].cellHasToken();
		grid.getGameGrid()[3][3].addToken(tokY);	
		grid.getGameGrid()[3][3].cellHasToken();
		grid.getGameGrid()[2][0].addToken(tokR);	
		grid.getGameGrid()[2][0].cellHasToken();
		grid.getGameGrid()[2][1].addToken(tokY);
		grid.getGameGrid()[2][1].cellHasToken();
		grid.getGameGrid()[2][2].addToken(tokY);	
		grid.getGameGrid()[2][2].cellHasToken();
		grid.getGameGrid()[2][3].addToken(tokR);	
		grid.getGameGrid()[2][3].cellHasToken();
		
		grid.displayGrid();
		
		assertEquals(false, grid.checkDiagonali(2,0,TokenColor.YELLOW));
	}
	
	@Test
	void testDiagonal3() {
		
		grid.getGameGrid()[5][0].addToken(tokY);	
		grid.getGameGrid()[5][0].cellHasToken();
		grid.getGameGrid()[5][1].addToken(tokY);
		grid.getGameGrid()[5][1].cellHasToken();
		grid.getGameGrid()[5][2].addToken(tokR);	
		grid.getGameGrid()[5][2].cellHasToken();
		grid.getGameGrid()[5][3].addToken(tokR);	
		grid.getGameGrid()[5][3].cellHasToken();
		grid.getGameGrid()[4][0].addToken(tokR);	
		grid.getGameGrid()[4][0].cellHasToken();
		grid.getGameGrid()[4][1].addToken(tokY);
		grid.getGameGrid()[4][1].cellHasToken();
		grid.getGameGrid()[4][2].addToken(tokR);	
		grid.getGameGrid()[4][2].cellHasToken();
		grid.getGameGrid()[4][3].addToken(tokR);	
		grid.getGameGrid()[4][3].cellHasToken();
		grid.getGameGrid()[3][0].addToken(tokY);	
		grid.getGameGrid()[3][0].cellHasToken();
		grid.getGameGrid()[3][1].addToken(tokR);
		grid.getGameGrid()[3][1].cellHasToken();
		grid.getGameGrid()[3][2].addToken(tokR);	
		grid.getGameGrid()[3][2].cellHasToken();
		grid.getGameGrid()[3][3].addToken(tokY);	
		grid.getGameGrid()[3][3].cellHasToken();
		grid.getGameGrid()[2][0].addToken(tokR);	
		grid.getGameGrid()[2][0].cellHasToken();
		grid.getGameGrid()[2][1].addToken(tokY);
		grid.getGameGrid()[2][1].cellHasToken();
		grid.getGameGrid()[2][2].addToken(tokY);	
		grid.getGameGrid()[2][2].cellHasToken();
		grid.getGameGrid()[2][3].addToken(tokR);	
		grid.getGameGrid()[2][3].cellHasToken();
		
		grid.displayGrid();
		
		assertEquals(true, grid.checkDiagonali(2,0,TokenColor.RED));
	}
	
	@Test
	void testDiagonal4() {
		
		grid.getGameGrid()[5][0].addToken(tokY);	
		grid.getGameGrid()[5][0].cellHasToken();
		grid.getGameGrid()[5][1].addToken(tokY);
		grid.getGameGrid()[5][1].cellHasToken();
		grid.getGameGrid()[5][3].addToken(tokR);	
		grid.getGameGrid()[5][3].cellHasToken();
		grid.getGameGrid()[4][0].addToken(tokR);	
		grid.getGameGrid()[4][0].cellHasToken();
		grid.getGameGrid()[4][1].addToken(tokY);
		grid.getGameGrid()[4][1].cellHasToken();
		grid.getGameGrid()[4][3].addToken(tokR);	
		grid.getGameGrid()[4][3].cellHasToken();
		grid.getGameGrid()[3][0].addToken(tokY);	
		grid.getGameGrid()[3][0].cellHasToken();
		grid.getGameGrid()[3][1].addToken(tokR);
		grid.getGameGrid()[3][1].cellHasToken();
		grid.getGameGrid()[3][3].addToken(tokY);	
		grid.getGameGrid()[3][3].cellHasToken();
		grid.getGameGrid()[2][0].addToken(tokR);	
		grid.getGameGrid()[2][0].cellHasToken();
		grid.getGameGrid()[2][1].addToken(tokY);
		grid.getGameGrid()[2][1].cellHasToken();
		grid.getGameGrid()[2][3].addToken(tokR);	
		grid.getGameGrid()[2][3].cellHasToken();
		
		grid.displayGrid();
		
		assertEquals(false, grid.checkDiagonali(2,0,TokenColor.RED));
	}
	
	@Test
	void testDiagonal5() {
		
		grid.getGameGrid()[5][0].addToken(tokY);	
		grid.getGameGrid()[5][0].cellHasToken();
		grid.getGameGrid()[5][1].addToken(tokY);
		grid.getGameGrid()[5][1].cellHasToken();
		grid.getGameGrid()[5][3].addToken(tokR);	
		grid.getGameGrid()[5][3].cellHasToken();
		grid.getGameGrid()[4][0].addToken(tokR);	
		grid.getGameGrid()[4][0].cellHasToken();
		grid.getGameGrid()[4][1].addToken(tokY);
		grid.getGameGrid()[4][1].cellHasToken();
		grid.getGameGrid()[4][3].addToken(tokR);	
		grid.getGameGrid()[4][3].cellHasToken();
		grid.getGameGrid()[3][0].addToken(tokY);	
		grid.getGameGrid()[3][0].cellHasToken();
		grid.getGameGrid()[3][1].addToken(tokR);
		grid.getGameGrid()[3][1].cellHasToken();
		grid.getGameGrid()[3][3].addToken(tokY);	
		grid.getGameGrid()[3][3].cellHasToken();
		grid.getGameGrid()[2][0].addToken(tokY);	
		grid.getGameGrid()[2][0].cellHasToken();
		grid.getGameGrid()[2][1].addToken(tokY);
		grid.getGameGrid()[2][1].cellHasToken();
		grid.getGameGrid()[2][3].addToken(tokR);	
		grid.getGameGrid()[2][3].cellHasToken();
		
		grid.displayGrid();
		
		assertEquals( false, grid.checkDiagonali(2,0,TokenColor.YELLOW));
	}
	
	@Test
	void testDiagonal6() {
		
		grid.getGameGrid()[5][6].addToken(tokY);	
		grid.getGameGrid()[5][6].cellHasToken();
		grid.getGameGrid()[5][5].addToken(tokY);
		grid.getGameGrid()[5][5].cellHasToken();
		grid.getGameGrid()[5][4].addToken(tokR);	
		grid.getGameGrid()[5][4].cellHasToken();
		grid.getGameGrid()[4][0].addToken(tokR);	
		grid.getGameGrid()[4][0].cellHasToken();
		grid.getGameGrid()[4][1].addToken(tokY);
		grid.getGameGrid()[4][1].cellHasToken();
		grid.getGameGrid()[4][3].addToken(tokR);	
		grid.getGameGrid()[4][3].cellHasToken();
		grid.getGameGrid()[3][0].addToken(tokY);	
		grid.getGameGrid()[3][0].cellHasToken();
		grid.getGameGrid()[3][6].addToken(tokR);
		grid.getGameGrid()[3][6].cellHasToken();
		grid.getGameGrid()[3][3].addToken(tokY);	
		grid.getGameGrid()[3][3].cellHasToken();
		grid.getGameGrid()[2][4].addToken(tokY);	
		grid.getGameGrid()[2][4].cellHasToken();
		grid.getGameGrid()[2][1].addToken(tokY);
		grid.getGameGrid()[2][1].cellHasToken();
		grid.getGameGrid()[2][3].addToken(tokR);	
		grid.getGameGrid()[2][3].cellHasToken();
		grid.getGameGrid()[3][2].addToken(tokR);	
		grid.getGameGrid()[3][2].cellHasToken();
		
		grid.displayGrid();
		
		assertEquals(false, grid.checkDiagonali(1,2,TokenColor.YELLOW));
	}
	
	@Test
	void testDiagonal7() {
		
		grid.getGameGrid()[5][6].addToken(tokY);	
		grid.getGameGrid()[5][6].cellHasToken();
		grid.getGameGrid()[5][5].addToken(tokY);
		grid.getGameGrid()[5][5].cellHasToken();
		grid.getGameGrid()[5][4].addToken(tokR);	
		grid.getGameGrid()[5][4].cellHasToken();
		grid.getGameGrid()[4][0].addToken(tokR);	
		grid.getGameGrid()[4][0].cellHasToken();
		grid.getGameGrid()[4][1].addToken(tokY);
		grid.getGameGrid()[4][1].cellHasToken();
		grid.getGameGrid()[4][3].addToken(tokR);	
		grid.getGameGrid()[4][3].cellHasToken();
		grid.getGameGrid()[3][0].addToken(tokY);	
		grid.getGameGrid()[3][0].cellHasToken();
		grid.getGameGrid()[3][6].addToken(tokR);
		grid.getGameGrid()[3][6].cellHasToken();
		grid.getGameGrid()[3][3].addToken(tokY);	
		grid.getGameGrid()[3][3].cellHasToken();
		grid.getGameGrid()[2][4].addToken(tokY);	
		grid.getGameGrid()[2][4].cellHasToken();
		grid.getGameGrid()[2][1].addToken(tokY);
		grid.getGameGrid()[2][1].cellHasToken();
		grid.getGameGrid()[2][3].addToken(tokR);	
		grid.getGameGrid()[2][3].cellHasToken();
		grid.getGameGrid()[3][2].addToken(tokR);	
		grid.getGameGrid()[3][2].cellHasToken();
		
		grid.displayGrid();
		
		assertEquals( false, grid.checkDiagonali(0,4,TokenColor.RED));
	}
}*/
