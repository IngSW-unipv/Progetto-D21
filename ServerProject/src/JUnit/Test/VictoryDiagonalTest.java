package JUnit.Test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import model.gameLogic.Grid;
import model.gameLogic.Token;
import model.gameLogic.TokenColor;

/**[ENG]
 *This class tests the victory's  diagonal algorithm, with the manual insertion of tokens.
 * [IT]
 *Questa classe testa l'algoritmo di controllo di vittoria relativo alla diagonale, con l'inserimento manuale dei token.
 *
 * @see Grid
 * @see Token
 * @author Marianna Orsi, Riccardo Pteri
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
 public class VictoryDiagonalTest {

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
	public void testDiagonal1() {
		
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
		
		//grid.displayGrid();
		
		assertEquals(true, grid.checkDiagonali(2,3,TokenColor.YELLOW));
	}
	
	@Test
	public void testDiagonal2() {
		
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
		
		//grid.displayGrid();
		
		assertEquals(false, grid.checkDiagonali(2,0,TokenColor.YELLOW));
	}
	
	@Test
	public void testDiagonal3() {
		
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
		
		//grid.displayGrid();
		
		assertEquals(true, grid.checkDiagonali(2,0,TokenColor.RED));
	}
	
	@Test
	public void testDiagonal4() {
		
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
		
		//grid.displayGrid();
		
		assertEquals(false, grid.checkDiagonali(2,0,TokenColor.RED));
	}
	
	@Test
	public void testDiagonal5() {
		
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
		
		//grid.displayGrid();
		
		assertEquals( false, grid.checkDiagonali(2,0,TokenColor.YELLOW));
	}
	
	@Test
	public void testDiagonal6() {
		
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
		
		//grid.displayGrid();
		
		assertEquals(false, grid.checkDiagonali(1,2,TokenColor.YELLOW));
	}
	
	@Test
	public void testDiagonal7() {
		
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
		
		//grid.displayGrid();
		
		assertEquals( false, grid.checkDiagonali(0,4,TokenColor.RED));
	}
}
