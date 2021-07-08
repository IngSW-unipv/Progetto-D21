package JUnit.Test;

import static org.junit.Assert.assertEquals;
import model.ServerMemory;
import model.WorkerThread;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import model.Player;
import model.queue.GameParameters;

import java.net.Socket;

/**[ENG]
 *This class tests the Queue's functions with the instances of the queue ,the player and the game parameters.
 * @see Player
 * @see GameParameters
 * @see WorkerThread
 * @see Socket
 * @author Marianna Orsi, Riccardo Petri
 */
public class ServerMemoryTest {

	Player p1,p2,p3;
	GameParameters gp ;
	WorkerThread wt;
	Socket s;
	
	@Before
	public void setUp() throws Exception {
		wt = new WorkerThread();
		s = new Socket();
		p1 = new Player(s,"nick", wt );
		gp = new GameParameters();

		p2 = new Player(s,"nickTest", wt );
		p3 = new Player(s,"nickTest2", wt );
	}

	@After
	public void tearDown() throws Exception {
		p1=null;
		p2=null;
		p3=null;
		gp=null;
		wt=null;
		s=null;
	}

	@Test
	public void test() throws Exception {

		ServerMemory.getServerMemory().addPlayer(p1);
		assertEquals( p1 , ServerMemory.getServerMemory().getPlayer("nick"));

	}
	
	@Test
	public void test1() throws Exception {

		ServerMemory.getServerMemory().addPlayer(p1);
		ServerMemory.getServerMemory().removePlayer("nick");
		assertEquals( null , ServerMemory.getServerMemory().getPlayer("nick"));
	}

	@Test
	public void test2() throws Exception {

		ServerMemory.getServerMemory().addPlayer(p1);
		ServerMemory.getServerMemory().removePlayer("nick");
		assertEquals( null , ServerMemory.getServerMemory().getPlayer("nick"));
	}

	@Test
	public void test3() throws Exception {

		ServerMemory.getServerMemory().addPlayer(p1);
		ServerMemory.getServerMemory().addPlayer(p2);
		ServerMemory.getServerMemory().addPlayer(p3);
		ServerMemory.getServerMemory().removePlayer("nick");
		assertEquals( null , ServerMemory.getServerMemory().getPlayer("nick"));
		assertEquals( p2 , ServerMemory.getServerMemory().getPlayer("nickTest"));

	}

	@Test
	public void test4() throws Exception {

		ServerMemory.getServerMemory().addPlayer(p1);
		ServerMemory.getServerMemory().addPlayer(p2);
		ServerMemory.getServerMemory().addPlayer(p3);
		ServerMemory.getServerMemory().removePlayer("nickTest");
		assertEquals( p1 , ServerMemory.getServerMemory().getPlayer("nick"));
		assertEquals( null , ServerMemory.getServerMemory().getPlayer("nickTest"));
		assertEquals( p3 , ServerMemory.getServerMemory().getPlayer("nickTest2"));

	}

}
