package snapGame;

import java.util.List;
import java.util.Queue;

import playingCards.Card;

public class Player {
	
	private Queue<Card> hand;
	private SnapGame game;

	public Player(Queue<Card> hand, SnapGame snapGame) {
		this.hand = hand;
		this.game = snapGame;
	}

	public void pickup(Queue<Card> playedCards) {
		hand.addAll(playedCards);
		
	}

	public Card playCard() {
		Card card = hand.poll();
		if (card == null) {
			game.removePlayer(this);
		}
		return card;
	}

	public int handSize() {
		return hand.size();
	}
	

	
}
