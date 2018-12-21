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
	 */
	public List<Queue<Card>> dealExactlyEvenly(int numberOfPlayers) {
		List<Queue<Card>> hands = new ArrayList<Queue<Card>>(numberOfPlayers);
		for (int i = 0; i < numberOfPlayers; i++) {
			Queue<Card> hand = new LinkedList<Card>();
			hand.addAll(deck.subList(0, 52 / numberOfPlayers));
			deck.removeAll(hand);
			hands.add(hand);
		}
		return hands;
	}
}
