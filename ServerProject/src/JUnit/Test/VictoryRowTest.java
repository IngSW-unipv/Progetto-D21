package JUnit.Test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



import core.gameLogic.model.partita.Grid;
import core.gameLogic.model.partita.Token;
import core.gameLogic.model.partita.TokenColor;

/**[ENG]
 *This class tests the victory's row algorithm , with the manual insertion of tokens.
 * [IT]
 *Questa classe testa l'algoritmo di controllo di vittoria relativo alla riga, con l'inserimento manuale dei token.
 *
 * @see Grid
 * @see Token
 * @author Marianna Orsi, Riccardo Pteri
 */

public class VictoryRowTest {
	Grid grid ;
	Token tokY;
	Token tokR;

	@Before
	public void setUp() throws Exception {
		grid = new Grid();
		tokY = new Token(TokenColor.YELLOW);
		tokR = new Token(TokenColor.RED);
	}

	@After
	public void tearDown() throws Exception {
		grid = null;
		tokY = null;
		tokR = null;
	}

	@Test
	public void testRiga() {
		
		grid.getGameGrid()[5][0].addToken(tokY);	
		grid.getGameGrid()[5][0].cellHasToken();
		grid.getGameGrid()[5][1].addToken(tokY);
		grid.getGameGrid()[5][1].cellHasToken();
		grid.getGameGrid()[5][3].addToken(tokY);	
		grid.getGameGrid()[5][3].cellHasToken();
		grid.getGameGrid()[5][4].addToken(tokY);	
		grid.getGameGrid()[5][4].cellHasToken();
		
		
		//grid.displayGrid();
		
		assertEquals( false, grid.checkRiga(5,4,TokenColor.YELLOW ));
		
	}
	@Test
	public void testRiga2() {
		
		grid.getGameGrid()[5][0].addToken(tokY);	
		grid.getGameGrid()[5][0].cellHasToken();
		grid.getGameGrid()[5][1].addToken(tokY);
		grid.getGameGrid()[5][1].cellHasToken();
		grid.getGameGrid()[5][2].addToken(tokY);	
		grid.getGameGrid()[5][2].cellHasToken();
		grid.getGameGrid()[5][3].addToken(tokY);	
		grid.getGameGrid()[5][3].cellHasToken();
		
		
		//grid.displayGrid();
		
		assertEquals(false, grid.checkRiga(5,3,TokenColor.RED ));
		
	}
	
	@Test
	public void testRiga3() {
		
		grid.getGameGrid()[5][0].addToken(tokY);	
		grid.getGameGrid()[5][0].cellHasToken();
		grid.getGameGrid()[5][1].addToken(tokY);
		grid.getGameGrid()[5][1].cellHasToken();
		grid.getGameGrid()[5][2].addToken(tokR);	
		grid.getGameGrid()[5][2].cellHasToken();
		grid.getGameGrid()[5][3].addToken(tokY);	
		grid.getGameGrid()[5][3].cellHasToken();
		
		
		//grid.displayGrid();
		
		assertEquals(false, grid.checkRiga(5,3,TokenColor.YELLOW ));
		
	}
	
	@Test
	public void testRiga4() {
		
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
		
		
		//grid.displayGrid();
		
		assertEquals(true, grid.checkRiga(5,6,TokenColor.YELLOW ));
		
	}
	
	@Test
	public void testRiga5() {
		
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
		
		//grid.displayGrid();
		
		assertEquals(true, grid.checkRiga(4,3,TokenColor.YELLOW ));
		
	}
	
		
		
	@Test
	public void testRiga6() {
		
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
		
		//grid.displayGrid();
		
		assertEquals(false, grid.checkRiga(4,3,TokenColor.RED ));
		
	}
	
	@Test
	public void testRiga7() {
		
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
		
		//grid.displayGrid();
		
		assertEquals(false, grid.checkRiga(2,1,TokenColor.YELLOW));
		
	}
	
	@Test
	public void testRiga8() {
		
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
		
		//grid.displayGrid();
		
		assertEquals(false, grid.checkRiga(2,3,TokenColor.RED));
		
	}
		
	

}
