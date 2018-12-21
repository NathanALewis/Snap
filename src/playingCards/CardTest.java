package playingCards;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CardTest {

	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void cardsOfEqualRank() {
		Card cardA = new Card("Clubs", "EIGHT");
		Card cardB = new Card("Hearts", "EIGHT");
		
		assertTrue("Cards should be of equal rank", cardA.equalRank(cardB));
		
	}
	
	@Test 
	public void cardsNotOfEqualRank() {
		Card cardA = new Card("Clubs", "Eight");
		Card cardB = new Card("Hearts", "Nine");
		
		assertFalse("Cards should not be of equal rank", cardA.equalRank(cardB));
	}
	
}
