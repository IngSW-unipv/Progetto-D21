package JUnit.Test;

import model.gameLogic.Token;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import model.gameLogic.Grid;
import model.gameLogic.TokenColor;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.assertEquals;

/**[ENG]
 *This class tests the functioning of the game grid .
 * [IT]
 *Questa classe testa il funzionamento della griglia di gioco.
 * @see Grid
 * @author Marianna Orsi, Riccardo Petri
 */
public class GridTest {

	Grid grid;
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
	public void test() {
		grid.tokenPlaced(TokenColor.YELLOW, 1);
		assertEquals( true, grid.getGameGrid()[5][1].getToken() != null);
	}
	@Test
	public void test1() {
		grid.tokenPlaced(TokenColor.YELLOW, 2);
		grid.tokenPlaced(TokenColor.YELLOW, 2);
		assertEquals( true, grid.getGameGrid()[5][2].getToken() != null);
	}
	@Test
	public void test2() {
		grid.tokenPlaced(TokenColor.YELLOW, 1);
		grid.tokenPlaced(TokenColor.YELLOW, 1);
		grid.tokenPlaced(TokenColor.YELLOW, 1);
		assertEquals( true, grid.getGameGrid()[3][1].getToken() != null);
	}
	@Test
	public void test3() {
		grid.tokenPlaced(TokenColor.YELLOW, 1);
		grid.tokenPlaced(TokenColor.YELLOW, 1);
		grid.tokenPlaced(TokenColor.YELLOW, 1);
		grid.tokenPlaced(TokenColor.YELLOW, 1);

		assertEquals( true, grid.getGameGrid()[2][1].getToken() != null);
	}
	@Test
	public void test4() {
		grid.tokenPlaced(TokenColor.YELLOW, 1);
		grid.tokenPlaced(TokenColor.YELLOW, 1);
		grid.tokenPlaced(TokenColor.YELLOW, 1);
		grid.tokenPlaced(TokenColor.YELLOW, 1);
		grid.tokenPlaced(TokenColor.YELLOW, 1);

		assertEquals( true, grid.getGameGrid()[1][1].getToken() != null);
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

		Assertions.assertEquals( true, grid.checkColonna(2,0,TokenColor.YELLOW));

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

		Assertions.assertEquals( false, grid.checkColonna(2,0,TokenColor.RED));

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

		Assertions.assertEquals( true, grid.checkColonna(2,6,TokenColor.YELLOW));

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

		Assertions.assertEquals(false, grid.checkColonna(2,6,TokenColor.RED));

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

		Assertions.assertEquals(false, grid.checkColonna(2,6,TokenColor.YELLOW));

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

		Assertions.assertEquals(false, grid.checkColonna(3,2,TokenColor.YELLOW));

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

		Assertions.assertEquals(false, grid.checkColonna(3,3,TokenColor.YELLOW));

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

		Assertions.assertEquals(false, grid.checkColonna(1,2,TokenColor.YELLOW));

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

		Assertions.assertEquals(true, grid.checkColonna(0,2,TokenColor.YELLOW));


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

		Assertions.assertEquals(true, grid.checkDiagonali(2,3,TokenColor.YELLOW));
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

		Assertions.assertEquals(false, grid.checkDiagonali(2,0,TokenColor.YELLOW));
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

		Assertions.assertEquals(true, grid.checkDiagonali(2,0,TokenColor.RED));
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

		Assertions.assertEquals(false, grid.checkDiagonali(2,0,TokenColor.RED));
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

		Assertions.assertEquals( false, grid.checkDiagonali(2,0,TokenColor.YELLOW));
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

		Assertions.assertEquals(false, grid.checkDiagonali(1,2,TokenColor.YELLOW));
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

		Assertions.assertEquals( false, grid.checkDiagonali(0,4,TokenColor.RED));
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

		Assertions.assertEquals( false, grid.checkRiga(5,4,TokenColor.YELLOW ));

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

		Assertions.assertEquals(false, grid.checkRiga(5,3,TokenColor.RED ));

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

		Assertions.assertEquals(false, grid.checkRiga(5,3,TokenColor.YELLOW ));

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

		Assertions.assertEquals(true, grid.checkRiga(5,6,TokenColor.YELLOW ));

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

		Assertions.assertEquals(true, grid.checkRiga(4,3,TokenColor.YELLOW ));

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

		Assertions.assertEquals(false, grid.checkRiga(4,3,TokenColor.RED ));

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

		Assertions.assertEquals(false, grid.checkRiga(2,1,TokenColor.YELLOW));

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

		Assertions.assertEquals(false, grid.checkRiga(2,3,TokenColor.RED));

	}



}
