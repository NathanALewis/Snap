package playingCards;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class DeckTest {

	@Before
	public void setUp() throws Exception {
	}


	
	@Test
	public void dealExactlyEvenly() {
		Deck deck = new Deck();
		int numberOfPlayers = 4;
		List<List<Card>> hands = deck.dealExactlyEvenly(numberOfPlayers);
		for (List<Card> hand : hands) {
			assertEquals("Hand size should equal 13, 52 DIV 4", hand.size(), 13);
		}
		
		
	}
	
	@Test
	public void dealExactlyEvenlyWithDiscards() {
		Deck deck = new Deck();
		int numberOfPlayers = 5;
		List<List<Card>> hands = deck.dealExactlyEvenly(numberOfPlayers);
		for (List<Card> hand : hands) {
			assertEquals("Hand size should equal 10, 52 DIV 5", hand.size(), 10);
		}
		
		
	}


}
