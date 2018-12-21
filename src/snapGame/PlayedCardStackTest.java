package snapGame;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Before;
import org.junit.Test;

import playingCards.Card;

public class PlayedCardStackTest {

	@Before
	public void setUp() throws Exception {
	}
	

	@Test
	public void addCardWithoutPickup() {
		PlayedCardStack playedCards = new PlayedCardStack();
		
		Card firstCard = new Card("Spades", "Two");
		Card secondCard = new Card("Hearts", "Three");
		
		assertFalse("1st card played, play should continue without pickup", playedCards.play(firstCard));
		assertFalse("Cards played have different rank", playedCards.play(secondCard));
		
	}
	
	@Test
	public void addCardWithPickup() {
		PlayedCardStack playedCards = new PlayedCardStack();
		
		Card firstCard = new Card("Spades", "Two");
		Card secondCard = new Card("Hearts", "Two");
		
		assertFalse("1st card played, play should continue without pickup", playedCards.play(firstCard));
		assertTrue("Cards played have same rank", playedCards.play(secondCard));
		
	}
	
	@Test
	public void retrieveCards() {
		PlayedCardStack playedCards = new PlayedCardStack();
		
		Card firstCard = new Card("Diamonds", "Three");
		Card secondCard = new Card("Spades", "Two");
		Card thirdCard = new Card("Hearts", "Two");
		
		playedCards.play(firstCard);
		playedCards.play(secondCard);
		playedCards.play(thirdCard);
		
		Queue<Card> retrievedCards = playedCards.retrieveCards();
		
		assertEquals("Cards not in correct order", retrievedCards.poll(), firstCard);
		assertEquals("Cards not in correct order", retrievedCards.poll(), secondCard);
		assertEquals("Cards not in correct order", retrievedCards.poll(), thirdCard);
		
	}
}
