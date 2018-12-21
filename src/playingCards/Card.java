package playingCards;

/**
 * Represents a card from a standard 52-card playing deck
 * @author Nathan Lewis
 *
 */
public class Card {

	private final Rank rank;
	private final Suit suit;
	
	
	/**
	 * Creates a card of the given suit and rank
	 * @param suit Rank of the card as a word. e.g. "Spades", "Hearts"
	 * @param rank Rank of the card, as a word. e.g. "Two", "Seven", "Ace"
	 */
	public Card(String suit, String rank) {
		this.rank = Rank.valueOf(rank.toUpperCase());
		this.suit = Suit.valueOf(suit.toUpperCase());
	}


	/**
	 * Creates a card of the given suit and rank
	 * @param suit Suit of the card
	 * @param rank Rank of the card
	 */
	public Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
	}


	/**
	 * Sees if the card passed as a parameter is of the same rank as this card
	 * @param cardB card to check this card's rank against
	 * @return true if rank is equal, false otherwise 
	 */
	public boolean equalRank(Card cardB) {
		return cardB.rank == this.rank;
	}
	
	/**
	 * Returns the rank followed by the suit of this card 
	 */
	public String toString() {
		return suit + " " + rank;
	}

}
