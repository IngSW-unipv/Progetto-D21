/*package JUnit;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import core.gameLogic.model.partita.Grid;
import core.gameLogic.model.partita.Token;
import core.gameLogic.model.partita.TokenColor;

class VictoryRowTest {
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
	void testRiga() {
		
		grid.getGameGrid()[5][0].addToken(tokY);	
		grid.getGameGrid()[5][0].cellHasToken();
		grid.getGameGrid()[5][1].addToken(tokY);
		grid.getGameGrid()[5][1].cellHasToken();
		grid.getGameGrid()[5][3].addToken(tokY);	
		grid.getGameGrid()[5][3].cellHasToken();
		grid.getGameGrid()[5][4].addToken(tokY);	
		grid.getGameGrid()[5][4].cellHasToken();
		
		
		grid.displayGrid();
		
		assertEquals( false, grid.checkRiga(5,4,TokenColor.YELLOW ));
		
	}
	@Test
	void testRiga2() {
		
		grid.getGameGrid()[5][0].addToken(tokY);	
		grid.getGameGrid()[5][0].cellHasToken();
		grid.getGameGrid()[5][1].addToken(tokY);
		grid.getGameGrid()[5][1].cellHasToken();
		grid.getGameGrid()[5][2].addToken(tokY);	
		grid.getGameGrid()[5][2].cellHasToken();
		grid.getGameGrid()[5][3].addToken(tokY);	
		grid.getGameGrid()[5][3].cellHasToken();
		
		
		grid.displayGrid();
		
		assertEquals(false, grid.checkRiga(5,3,TokenColor.RED ));
		
	}
	
	@Test
	void testRiga3() {
		
		grid.getGameGrid()[5][0].addToken(tokY);	
		grid.getGameGrid()[5][0].cellHasToken();
		grid.getGameGrid()[5][1].addToken(tokY);
		grid.getGameGrid()[5][1].cellHasToken();
		grid.getGameGrid()[5][2].addToken(tokR);	
		grid.getGameGrid()[5][2].cellHasToken();
		grid.getGameGrid()[5][3].addToken(tokY);	
		grid.getGameGrid()[5][3].cellHasToken();
		
		
		grid.displayGrid();
		
		assertEquals(false, grid.checkRiga(5,3,TokenColor.YELLOW ));
		
	}
	
	@Test
	void testRiga4() {
		
		grid.getGameGrid()[5][0].addToken(tokY);	
		grid.getGameGrid()[5][0].cellHasToken();
		grid.getGameGrid()[5][1].addToken(tokY);
		grid.getGameGrid()[5][1].cellHasToken();
		grid.getGameGrid()[5][2].addToken(tokR);	
		grid.getGameGrid()[5][2].cellHasToken();
		grid.getGameGrid()[5][3].addToken(tokY);	
		grid.getGameGrid()[5][3].cellHasToken();
		grid.getGameGrid()[5][4].addToken(tokY);	
		grid.getGameGrid()[5][4].cellHasToken();
		grid.getGameGrid()[5][5].addToken(tokY);
		grid.getGameGrid()[5][5].cellHasToken();
		grid.getGameGrid()[5][6].addToken(tokY);	
		grid.getGameGrid()[5][6].cellHasToken();
		
		
		grid.displayGrid();
		
		assertEquals(true, grid.checkRiga(5,6,TokenColor.YELLOW ));
		
	}
	
	@Test
	void testRiga5() {
		
		grid.getGameGrid()[5][0].addToken(tokY);	
		grid.getGameGrid()[5][0].cellHasToken();
		grid.getGameGrid()[5][1].addToken(tokY);
		grid.getGameGrid()[5][1].cellHasToken();
		grid.getGameGrid()[5][2].addToken(tokR);	
		grid.getGameGrid()[5][2].cellHasToken();
		grid.getGameGrid()[5][3].addToken(tokY);	
		grid.getGameGrid()[5][3].cellHasToken();
		grid.getGameGrid()[4][0].addToken(tokY);	
		grid.getGameGrid()[4][0].cellHasToken();
		grid.getGameGrid()[4][1].addToken(tokY);
		grid.getGameGrid()[4][1].cellHasToken();
		grid.getGameGrid()[4][2].addToken(tokY);	
		grid.getGameGrid()[4][2].cellHasToken();
		grid.getGameGrid()[4][3].addToken(tokY);	
		grid.getGameGrid()[4][3].cellHasToken();
		
		grid.displayGrid();
		
		assertEquals(true, grid.checkRiga(4,3,TokenColor.YELLOW ));
		
	}
	
		
		
	@Test
	void testRiga6() {
		
		grid.getGameGrid()[5][0].addToken(tokY);	
		grid.getGameGrid()[5][0].cellHasToken();
		grid.getGameGrid()[5][1].addToken(tokY);
		grid.getGameGrid()[5][1].cellHasToken();
		grid.getGameGrid()[5][2].addToken(tokR);	
		grid.getGameGrid()[5][2].cellHasToken();
		grid.getGameGrid()[5][3].addToken(tokY);	
		grid.getGameGrid()[5][3].cellHasToken();
		grid.getGameGrid()[4][0].addToken(tokY);	
		grid.getGameGrid()[4][0].cellHasToken();
		grid.getGameGrid()[4][1].addToken(tokY);
		grid.getGameGrid()[4][1].cellHasToken();
		grid.getGameGrid()[4][2].addToken(tokY);	
		grid.getGameGrid()[4][2].cellHasToken();
		grid.getGameGrid()[4][3].addToken(tokY);	
		grid.getGameGrid()[4][3].cellHasToken();
		
		grid.displayGrid();
		
		assertEquals(false, grid.checkRiga(4,3,TokenColor.RED ));
		
	}
	
	@Test
	void testRiga7() {
		
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
		grid.getGameGrid()[4][1].addToken(tokR);
		grid.getGameGrid()[4][1].cellHasToken();
		grid.getGameGrid()[4][2].addToken(tokY);	
		grid.getGameGrid()[4][2].cellHasToken();
		grid.getGameGrid()[4][3].addToken(tokY);	
		grid.getGameGrid()[4][3].cellHasToken();
		grid.getGameGrid()[3][0].addToken(tokY);	
		grid.getGameGrid()[3][0].cellHasToken();
		grid.getGameGrid()[3][1].addToken(tokY);
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
		
		assertEquals(false, grid.checkRiga(2,1,TokenColor.YELLOW));
		
	}
	
	@Test
	void testRiga8() {
		
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
		grid.getGameGrid()[4][2].addToken(tokY);	
		grid.getGameGrid()[4][2].cellHasToken();
		grid.getGameGrid()[4][3].addToken(tokY);	
		grid.getGameGrid()[4][3].cellHasToken();
		grid.getGameGrid()[3][0].addToken(tokY);	
		grid.getGameGrid()[3][0].cellHasToken();
		grid.getGameGrid()[3][1].addToken(tokY);
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
		grid.getGameGrid()[2][3].addToken(tokR);	
		grid.getGameGrid()[2][3].cellHasToken();
		
		grid.displayGrid();
		
		assertEquals(false, grid.checkRiga(2,3,TokenColor.RED));
		
	}
		
	

}*/
