package JUnit.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import core.gameLogic.Grid;
import core.gameLogic.Token;
import core.gameLogic.TokenColor;

/**[ENG]
 *This class tests the victory's column algorithm, with the manual insertion of tokens.
 * [IT]
 *Questa classe testa l'algoritmo di controllo di vittoria relativo alla colonna, con l'inserimento manuale dei token.
 *
 * @see Grid
 * @see Token

 * @author Marianna Orsi, Riccardo Pteri
 */
public class VictoryColumnTest {

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
	public void testColumn1() {
		
		grid.getGameGrid()[5][0].addToken(tokY);	
		grid.getGameGrid()[5][0].cellHasToken();
		grid.getGameGrid()[4][0].addToken(tokY);
		grid.getGameGrid()[4][0].cellHasToken();
		grid.getGameGrid()[3][0].addToken(tokY);	
		grid.getGameGrid()[3][0].cellHasToken();
		grid.getGameGrid()[2][0].addToken(tokY);	
		grid.getGameGrid()[2][0].cellHasToken();
		
		
		//grid.displayGrid();

		assertEquals( true, grid.checkColonna(2,0,TokenColor.YELLOW));
		
	}
	@Test
	public void testColumn2() {
		
		grid.getGameGrid()[5][0].addToken(tokY);	
		grid.getGameGrid()[5][0].cellHasToken();
		grid.getGameGrid()[4][0].addToken(tokY);
		grid.getGameGrid()[4][0].cellHasToken();
		grid.getGameGrid()[3][0].addToken(tokY);	
		grid.getGameGrid()[3][0].cellHasToken();
		grid.getGameGrid()[2][0].addToken(tokY);	
		grid.getGameGrid()[2][0].cellHasToken();
		
		
		//grid.displayGrid();
		
		assertEquals( false, grid.checkColonna(2,0,TokenColor.RED));
		
	}
	@Test
	public void testColumn3() {
		
		grid.getGameGrid()[5][6].addToken(tokY);	
		grid.getGameGrid()[5][6].cellHasToken();
		grid.getGameGrid()[4][6].addToken(tokY);
		grid.getGameGrid()[4][6].cellHasToken();
		grid.getGameGrid()[3][6].addToken(tokY);	
		grid.getGameGrid()[3][6].cellHasToken();
		grid.getGameGrid()[2][6].addToken(tokY);	
		grid.getGameGrid()[2][6].cellHasToken();
		
		
		//grid.displayGrid();
		
		assertEquals( true, grid.checkColonna(2,6,TokenColor.YELLOW));
		
	}
	
	@Test
	public void testColumn4() {
		
		grid.getGameGrid()[5][6].addToken(tokY);	
		grid.getGameGrid()[5][6].cellHasToken();
		grid.getGameGrid()[4][6].addToken(tokY);
		grid.getGameGrid()[4][6].cellHasToken();
		grid.getGameGrid()[3][6].addToken(tokY);	
		grid.getGameGrid()[3][6].cellHasToken();
		grid.getGameGrid()[2][6].addToken(tokY);	
		grid.getGameGrid()[2][6].cellHasToken();
		
		
		//grid.displayGrid();
		
		assertEquals(false, grid.checkColonna(2,6,TokenColor.RED));
		
	}
	
	@Test
	public void testColumn5() {
		
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
		
		
		//grid.displayGrid();
		
		assertEquals(false, grid.checkColonna(2,6,TokenColor.YELLOW));
		
	}
	
	@Test
	public void testColumn6() {
		
		grid.getGameGrid()[5][2].addToken(tokY);	
		grid.getGameGrid()[5][2].cellHasToken();
		grid.getGameGrid()[4][2].addToken(tokY);
		grid.getGameGrid()[4][2].cellHasToken();
		grid.getGameGrid()[3][3].addToken(tokY);	
		grid.getGameGrid()[3][3].cellHasToken();
		grid.getGameGrid()[3][2].addToken(tokY);	
		grid.getGameGrid()[3][2].cellHasToken();
		
		
		//grid.displayGrid();
		
		assertEquals(false, grid.checkColonna(3,2,TokenColor.YELLOW));
		
	}
	
	@Test
	public void testColumn7() {
		
		grid.getGameGrid()[5][2].addToken(tokY);	
		grid.getGameGrid()[5][2].cellHasToken();
		grid.getGameGrid()[4][2].addToken(tokY);
		grid.getGameGrid()[4][2].cellHasToken();
		grid.getGameGrid()[2][2].addToken(tokY);	
		grid.getGameGrid()[2][2].cellHasToken();
		grid.getGameGrid()[3][3].addToken(tokY);	
		grid.getGameGrid()[3][3].cellHasToken();
		
		
		//grid.displayGrid();
		
		assertEquals(false, grid.checkColonna(3,3,TokenColor.YELLOW));
		
	}
	
	@Test
	public void testColumn8() {
		
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
		
		
		//grid.displayGrid();
		
		assertEquals(false, grid.checkColonna(1,2,TokenColor.YELLOW));
		
	}
	
	@Test
	public void testColumn9() {
		
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
		
		//grid.displayGrid();
		
		assertEquals(true, grid.checkColonna(0,2,TokenColor.YELLOW));
		
	}
	
	

}
