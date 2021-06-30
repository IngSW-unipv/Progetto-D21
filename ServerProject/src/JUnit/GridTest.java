package JUnit;



import core.gameLogic.model.partita.Grid;
import core.gameLogic.model.partita.TokenColor;

class GridTest {

	Grid grid = new Grid();
	TokenColor temp = TokenColor.YELLOW;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		for(int i=0; i<42;i++) {
			int colonna =(int) (7* Math.random());
			if(grid.getGameGrid()[0][colonna].getToken() != null) {
				i--;
				continue;
				
			}
			grid.tokenPlaced(temp, colonna);
			grid.displayGrid();
			if(grid.isFinalVictory() == true) {
				break;
			}
			invertTokenColor();
			if(i == 42) {
				System.out.println("Pareggio");
				
			}
		}
		
		assertEquals(true, grid.isFinalVictory());
		
	}

	public void invertTokenColor() {
		if(temp == TokenColor.YELLOW) {
			temp = TokenColor.RED;
		}else temp = TokenColor.YELLOW; 
	}
	
	
}
