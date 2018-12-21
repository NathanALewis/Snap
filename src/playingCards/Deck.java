package playingCards;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

/**
 * Represents a deck of 52 cards
 * @author Nathan32
 *
 */
public class Deck {

	private List<Card> deck;
	private Random generator;
	
	/**
	 * Creates a new deck of 52 cards
	 * 
	 */
	public Deck() {
		deck = new ArrayList<Card>(52);
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				deck.add(new Card(suit, rank));
			}
		}
		generator = new Random();
		//shuffle the deck after creation
		shuffle();
	}

	/**
	 * Randomises the order of cards in the deck
	 */
	private void shuffle() {
		List<Card> oldOrder = deck;
		deck = new ArrayList<Card>(52);
		while (!oldOrder.isEmpty()) {
			deck.add(oldOrder.remove(generator.nextInt(oldOrder.size())));
		}
	}

	/**
	 * Distributes the cards in this deck exactly equally. If any cards are left over, they are not dealt.
	 * @param numberOfPlayers the number of hands to deal out
	 * @return A List of Queues of Cards, representing the hands that have been created
	 * @throws IllegalArgumentException if number of players <1 or >52
	 */
	public List<Queue<Card>> dealExactlyEvenly(int numberOfPlayers) throws IllegalArgumentException {
		if (numberOfPlayers < 1) {
			throw new IllegalArgumentException("numberOfPlayers == " + numberOfPlayers + ", must be >= 1");
		}
		if (numberOfPlayers > 52) {
			throw new IllegalArgumentException("numberOfPlayers == " + numberOfPlayers + ", must be <= 52");
		}
		
		List<Queue<Card>> hands = new ArrayList<Queue<Card>>(numberOfPlayers);
		for (int i = 0; i < numberOfPlayers; i++) {
			Queue<Card> hand = new LinkedList<Card>();
			//Takes out an equal number of cards from the deck which has been shuffled 
			hand.addAll(deck.subList(0, 52 / numberOfPlayers));
			//Removes selected cards from the deck
			deck.removeAll(hand);
			//add selected cards to a hand
			hands.add(hand);
		}
		return hands;
	}
}
