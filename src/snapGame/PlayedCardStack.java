package snapGame;

import java.util.LinkedList;
import java.util.Queue;

import playingCards.Card;

/**
 * Represents the centre stack of cards in a game of Snap
 * @author Nathan32
 *
 */
public class PlayedCardStack {

	private Queue<Card> playedCards;
	private Card lastCardPlayed;
	
	public PlayedCardStack() {
		playedCards = new LinkedList<Card>();
	}
	
	/**
	 * Adds a card to the top of the stack and returns true if the ranks are equal
	 * @param card the card being played
	 * @return true if the card being played has the same rank as the card on the top of the stack, false otherwise
	 */
	public boolean play(Card card) {
		boolean isMatchingPair = false;
		playedCards.add(card);
		if (lastCardPlayed == null) {//first card on stack
			lastCardPlayed = card;
			isMatchingPair =  false;
		} else if (lastCardPlayed.equalRank(card)) {//same rank as top card
			lastCardPlayed = card;
			isMatchingPair =  true;
		} else {//different rank as top card
			lastCardPlayed = card;
			isMatchingPair =  false;
		}
		return isMatchingPair;
	}

	public Queue<Card> retrieveCards() {
		Queue<Card> cards = playedCards;
		playedCards = new LinkedList<Card>();
		return cards;
	}

}
