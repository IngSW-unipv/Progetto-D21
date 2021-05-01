package model.tester;

import model.partita.*;

public class Tester {

	public static void main(String[] args) {
		
		Player p1 = new Player();
		Player p2 = new Player();
		
		Game test1 = new Game(p1,p2);
		test1.turn();
		// TODO Auto-generated method stub

	}

}
