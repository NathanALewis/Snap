package snapGame;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Before;
import org.junit.Test;

import playingCards.Card;
import playingCards.Deck;

public class PlayerTest {

	
	@Before
	public void setUp() throws Exception {
		
	}


	
	@Test
	public void pickupCards() {
		Queue<Card> hand = new LinkedList<Card>();
		Card firstCard = new Card("Spades", "Two");
		Card secondCard = new Card("Hearts", "Three");
		hand.add(firstCard); 
		hand.add(secondCard);
		
		Player player = new Player(hand, new SnapGame());
		
		Queue<Card> playedCards = new LinkedList<Card>();
		Card firstPlayedCard = new Card("Diamonds", "Four");
		Card secondPlayedCard = new Card("Spades", "Four");
		
		playedCards.add(firstPlayedCard);
		playedCards.add(secondPlayedCard);
		player.pickup(playedCards);
		
		assertEquals("Player should play first card in hand", firstCard, player.playCard());
		assertEquals("Player should play second card in hand", secondCard, player.playCard());
		assertEquals("Player should play first card played", firstPlayedCard, player.playCard());
		assertEquals("Player should play second card played", secondPlayedCard, player.playCard());
	}
	
	
	@Test
	public void playCardwhenHandIsEmpty() {
		Queue<Card> hand = new LinkedList<Card>();
		Player player = new Player(hand, new SnapGame());
		assertNull("Should return null", player.playCard());
	}
}
