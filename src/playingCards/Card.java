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
		// TODO Auto-generated constructor stub
		this.rank = Rank.valueOf(rank.toUpperCase());
		this.suit = Suit.valueOf(suit.toUpperCase());
	}


	/**
	 * Sees if the card passed as a parameter is of the same rank as this card
	 * @param cardB
	 * @return
	 */
	public boolean equalRank(Card cardB) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public String toString() {
		return rank + " " + suit;
	}

}
