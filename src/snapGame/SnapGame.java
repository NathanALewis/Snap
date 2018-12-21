package snapGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

import playingCards.Card;
import playingCards.Deck;

public class SnapGame {

	private List<Player> players;
	private PlayedCardStack centreStack;
	private Random generator;
	private List<Player> playersToRemove;
	

	/**
	 * Creates a new game of snap with the given number of players
	 * @param numberOfPlayers number of players in the game
	 * @throws IllegalArgumentException if number of players is <2 or >13
	 */
	public SnapGame(int numberOfPlayers) throws IllegalArgumentException {
		if (numberOfPlayers < 2) {
			throw new IllegalArgumentException("Must have at least 2 players");
		} else if (numberOfPlayers > 13) {
			throw new IllegalArgumentException("No more than 13 players");
		}
		
		//Initialise deck of cards
		Deck deck = new Deck();
		
		//Initialise where cards are played
		centreStack = new PlayedCardStack();
		
		//Initialise players with a hand of cards
		players = new ArrayList<Player>(numberOfPlayers);
		List<Queue<Card>> playerHands = deck.dealExactlyEvenly(numberOfPlayers);
		for (int i = 0; i < playerHands.size(); i++) {
			players.add(new Player(playerHands.get(i), this, i + 1));
		}
		
		//List of players to remove
		
		generator = new Random();
		//Game ready to play
	}
	
	/**
	 * Plays the game one round at a time (i.e. each player plays a card). Returns true if game can continue, false if someone has won
	 * @return false if there is only 1 player remaining, true otherwise 
	 */
	public boolean playOneRound() {
		//players to be removed
		playersToRemove = new ArrayList<Player>();
		
		for (Player player : players) {
			if (centreStack.play(player.playCard())) {//Match has been made
				snap();
			} 
		}
		
		players.removeAll(playersToRemove);
		
		
		//true if only one player remains, game over
		return players.size() != 1;
		
	}


	/**
	 * Chooses a random player to win the stack of cards after a march has been made
	 */
	private void snap() {
		Player snappedPlayer = players.get(generator.nextInt(players.size()));
		snappedPlayer.pickup(centreStack.retrieveCards());
	}

	/**
	 * Removes a player, called by the player observee that has ran out of cards
	 * @param player the player that has run out of cards. 
	 */
	public void removePlayer(Player player) {
		playersToRemove.add(player);
	}

	/**
	 * Returns the status of the game
	 * @return String containing statuses of the players and the centre stack 
	 */
	public String getStatus() {
		String str = ""; 
		str += centreStack.getStatus() + "\n";
		
		for (Player player : players) {
			str += "Player " + player.playerNumber() + " has " + player.handSize() + "\n";
		}
		
		return str; 
	}

	public String getWinner() {
		// TODO Auto-generated method stub
		return "Player " + players.get(0).playerNumber() + " is the winner!";
	}

}
