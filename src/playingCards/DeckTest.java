package playingCards;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Queue;

import org.junit.Before;
import org.junit.Test;

public class DeckTest {

	@Before
	public void setUp() throws Exception {
	}


	
	/**
	 * Deal out card evenly when 52 is divisible by the number of players 
	 */
	@Test
	public void dealExactlyEvenly() {
		Deck deck = new Deck();
		int numberOfPlayers = 4;
		List<Queue<Card>> hands = deck.dealExactlyEvenly(numberOfPlayers);
		for (Queue<Card> hand : hands) {
			assertEquals("Hand size should equal 13, 52 DIV 4", 13, hand.size());
		}
		
		
	}
	
	/**
	 * Deal out cards when 53 is not divisible by the number of players 
	 */
	@Test
	public void dealExactlyEvenlyWithDiscards() {
		Deck deck = new Deck();
		int numberOfPlayers = 5;
		List<Queue<Card>> hands = deck.dealExactlyEvenly(numberOfPlayers);
		for (Queue<Card> hand : hands) {
			assertEquals("Hand size should equal 10, 52 DIV 5", 10, hand.size());
		}
		
		
	}


}
