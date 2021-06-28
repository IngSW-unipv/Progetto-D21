package JUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import core.Player;
import core.queue.GameParameters;
import core.queue.Queue;

class QueueTest {
	
	Queue q;
	Player p1;
	GameParameters gp ;
	
	@BeforeEach
	void setUp() throws Exception {
		q= Queue.getQueue();
		p1 = new Player();
		gp = new GameParameters();
	}

	@AfterEach
	void tearDown() throws Exception {
		q=null;
		p1=null;
		gp=null;
	}

	@Test
	void test() throws Exception {
		
		q.addPlayerToQueue(p1,gp);
		assertEquals("Failed", true , (q.getQueueLIst()).contains(p1));
		q.removePlayer(p1);
		
	}
	
	@Test
	void test1() throws Exception {
		q.addPlayerToQueue(p1,gp);
		q.removePlayer(p1);
		assertEquals("Failed", false , (q.getQueueLIst()).contains(p1));
		
	}

}
