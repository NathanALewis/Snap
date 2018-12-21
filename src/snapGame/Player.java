package snapGame;

import java.util.Queue;

import playingCards.Card;

public class Player {
	
	//The stack of cards the player currently has 
	private Queue<Card> hand;
	private SnapGame game;
	private int playerNumber;

	/**
	 * Creates a new player with a starting hand and a reference to the game the player is in
	 * @param hand a queue of cards for the player's hand
	 * @param snapGame game the player is in
	 */
	public Player(Queue<Card> hand, SnapGame snapGame, int playerNumber) {
		this.hand = hand;
		this.game = snapGame;
		this.playerNumber = playerNumber;
	}

	/**
	 * Has the player "pickup" the cards from the middle in order 
	 * @param playedCards a queue of cards which is added to the end of the queue of cards the player currently has 
	 */
	public void pickup(Queue<Card> playedCards) {
		hand.addAll(playedCards);
	}

	/**
	 * Player plays a card. Returns null if the player doesn't have any cards left, 
	 * and if they don't have any cards informs the game that the player is knocked out
	 * @return Card the card the player players, or null if the player possesses no cards 
	 */
	public Card playCard() {
		Card card = hand.poll();
		if (card == null) {
			game.removePlayer(this);
		}
		return card;
	}

	/**
	 * Returns the number of cards the player has remaining
	 * @return number of cards the player has remaining 
	 */
	public int handSize() {
		return hand.size();
	}
	
	public int playerNumber() {
		return playerNumber;
	}

	
}
