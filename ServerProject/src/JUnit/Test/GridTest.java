package JUnit.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import core.gameLogic.model.partita.Grid;
import core.gameLogic.model.partita.TokenColor;

/**[ENG]
 *This class tests the functioning of the game grid.
 * [IT]
 *Questa classe testa il funzionamento della griglia di gioco.
 * @see Grid
 * @author Marianna Orsi, Riccardo Petri
 */
public class GridTest {

	Grid grid;
	
	@Before
	 public void setUp() throws Exception {
		grid = new Grid();
	}

	@After
	public void tearDown() throws Exception {
		grid = null;
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
	
}
