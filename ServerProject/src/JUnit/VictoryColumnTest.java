package JUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import core.gameLogic.model.partita.Grid;
import core.gameLogic.model.partita.Token;
import core.gameLogic.model.partita.TokenColor;

class VictoryColumnTest {

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
	void testColumn1() {
		
		grid.getGameGrid()[5][0].addToken(tokY);	
		grid.getGameGrid()[5][0].cellHasToken();
		grid.getGameGrid()[4][0].addToken(tokY);
		grid.getGameGrid()[4][0].cellHasToken();
		grid.getGameGrid()[3][0].addToken(tokY);	
		grid.getGameGrid()[3][0].cellHasToken();
		grid.getGameGrid()[2][0].addToken(tokY);	
		grid.getGameGrid()[2][0].cellHasToken();
		
		
		grid.displayGrid();

		assertEquals("Failed", true, grid.checkColonna(2,0,TokenColor.YELLOW));
		
	}
	@Test
	void testColumn2() {
		
		grid.getGameGrid()[5][0].addToken(tokY);	
		grid.getGameGrid()[5][0].cellHasToken();
		grid.getGameGrid()[4][0].addToken(tokY);
		grid.getGameGrid()[4][0].cellHasToken();
		grid.getGameGrid()[3][0].addToken(tokY);	
		grid.getGameGrid()[3][0].cellHasToken();
		grid.getGameGrid()[2][0].addToken(tokY);	
		grid.getGameGrid()[2][0].cellHasToken();
		
		
		grid.displayGrid();
		
		assertEquals("Failed", false, grid.checkColonna(2,0,TokenColor.RED));
		
	}
	@Test
	void testColumn3() {
		
		grid.getGameGrid()[5][6].addToken(tokY);	
		grid.getGameGrid()[5][6].cellHasToken();
		grid.getGameGrid()[4][6].addToken(tokY);
		grid.getGameGrid()[4][6].cellHasToken();
		grid.getGameGrid()[3][6].addToken(tokY);	
		grid.getGameGrid()[3][6].cellHasToken();
		grid.getGameGrid()[2][6].addToken(tokY);	
		grid.getGameGrid()[2][6].cellHasToken();
		
		
		grid.displayGrid();
		
		assertEquals("Failed", true, grid.checkColonna(2,6,TokenColor.YELLOW));
		
	}
	
	@Test
	void testColumn4() {
		
		grid.getGameGrid()[5][6].addToken(tokY);	
		grid.getGameGrid()[5][6].cellHasToken();
		grid.getGameGrid()[4][6].addToken(tokY);
		grid.getGameGrid()[4][6].cellHasToken();
		grid.getGameGrid()[3][6].addToken(tokY);	
		grid.getGameGrid()[3][6].cellHasToken();
		grid.getGameGrid()[2][6].addToken(tokY);	
		grid.getGameGrid()[2][6].cellHasToken();
		
		
		grid.displayGrid();
		
		assertEquals("Failed", false, grid.checkColonna(2,6,TokenColor.RED));
		
	}
	
	@Test
	void testColumn5() {
		
		grid.getGameGrid()[5][6].addToken(tokY);	
		grid.getGameGrid()[5][6].cellHasToken();
		grid.getGameGrid()[4][6].addToken(tokY);
		grid.getGameGrid()[4][6].cellHasToken();
		grid.getGameGrid()[3][6].addToken(tokY);	
		grid.getGameGrid()[3][6].cellHasToken();
		grid.getGameGrid()[1][6].addToken(tokY);	
		grid.getGameGrid()[1][6].cellHasToken();
		grid.getGameGrid()[2][6].addToken(tokR);	
		grid.getGameGrid()[2][6].cellHasToken();
		
		
		grid.displayGrid();
		
		assertEquals("Failed", false, grid.checkColonna(2,6,TokenColor.YELLOW));
		
	}
	
	@Test
	void testColumn6() {
		
		grid.getGameGrid()[5][2].addToken(tokY);	
		grid.getGameGrid()[5][2].cellHasToken();
		grid.getGameGrid()[4][2].addToken(tokY);
		grid.getGameGrid()[4][2].cellHasToken();
		grid.getGameGrid()[3][3].addToken(tokY);	
		grid.getGameGrid()[3][3].cellHasToken();
		grid.getGameGrid()[3][2].addToken(tokY);	
		grid.getGameGrid()[3][2].cellHasToken();
		
		
		grid.displayGrid();
		
		assertEquals("Failed", false, grid.checkColonna(3,2,TokenColor.YELLOW));
		
	}
	
	@Test
	void testColumn7() {
		
		grid.getGameGrid()[5][2].addToken(tokY);	
		grid.getGameGrid()[5][2].cellHasToken();
		grid.getGameGrid()[4][2].addToken(tokY);
		grid.getGameGrid()[4][2].cellHasToken();
		grid.getGameGrid()[2][2].addToken(tokY);	
		grid.getGameGrid()[2][2].cellHasToken();
		grid.getGameGrid()[3][3].addToken(tokY);	
		grid.getGameGrid()[3][3].cellHasToken();
		
		
		grid.displayGrid();
		
		assertEquals("Failed", false, grid.checkColonna(3,3,TokenColor.YELLOW));
		
	}
	
	@Test
	void testColumn8() {
		
		grid.getGameGrid()[5][2].addToken(tokY);	
		grid.getGameGrid()[5][2].cellHasToken();
		grid.getGameGrid()[4][2].addToken(tokY);
		grid.getGameGrid()[4][2].cellHasToken();
		grid.getGameGrid()[2][2].addToken(tokR);	
		grid.getGameGrid()[2][2].cellHasToken();
		grid.getGameGrid()[3][2].addToken(tokY);	
		grid.getGameGrid()[3][2].cellHasToken();
		grid.getGameGrid()[1][2].addToken(tokY);	
		grid.getGameGrid()[1][2].cellHasToken();
		
		
		grid.displayGrid();
		
		assertEquals("Failed", false, grid.checkColonna(1,2,TokenColor.YELLOW));
		
	}
	
	@Test
	void testColumn9() {
		
		grid.getGameGrid()[5][2].addToken(tokY);	
		grid.getGameGrid()[5][2].cellHasToken();
		grid.getGameGrid()[4][2].addToken(tokR);
		grid.getGameGrid()[4][2].cellHasToken();
		grid.getGameGrid()[2][2].addToken(tokY);	
		grid.getGameGrid()[2][2].cellHasToken();
		grid.getGameGrid()[3][2].addToken(tokY);	
		grid.getGameGrid()[3][2].cellHasToken();
		grid.getGameGrid()[1][2].addToken(tokY);	
		grid.getGameGrid()[1][2].cellHasToken();
		grid.getGameGrid()[0][2].addToken(tokY);	
		grid.getGameGrid()[0][2].cellHasToken();
		
		grid.displayGrid();
		
		assertEquals("Failed", true, grid.checkColonna(0,2,TokenColor.YELLOW));
		
	}
	
	

}
