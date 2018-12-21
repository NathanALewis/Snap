package playingCards;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CardTest {

	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Test
	public void cardsOfEqualRank() {
		Card cardA = new Card("Club", "EIGHT");
		Card cardB = new Card("Heart", "EIGHT");
		
		assertTrue("Cards should be of equal rank", cardA.equalRank(cardB));
		
	}
	
	@Test 
	public void cardsNotOfEqualRank() {
		Card cardA = new Card("Club", "Eight");
		Card cardB = new Card("Heart", "Nine");
		
		assertTrue("Cards should not be of equal rank", cardA.equalRank(cardB));
	}
	
}
