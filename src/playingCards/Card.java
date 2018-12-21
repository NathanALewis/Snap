package playingCards;

public class Card {

	private Rank rank;
	private Suit suit;
	/**
	 * Creates a card of the given suit and rank
	 * @param string
	 * @param i
	 */
	public Card(String suit, String rank) {
		this.rank = Rank.valueOf(rank.toUpperCase());
		this.suit = Suit.valueOf(suit.toUpperCase());
	}


	public Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
		// TODO Auto-generated constructor stub
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
		return rank + " " + suit;
	}

}
