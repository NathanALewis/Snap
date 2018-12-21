package snapGame;

import java.util.Scanner;


/**
 * Basic text user interface for the snap game
 * @author Nathan32
 *
 */
public class SnapTUI {

	private SnapGame game;
	private Scanner stdIn;

	public SnapTUI() {

		// Creates a Scanner object for obtaining user input
		stdIn = new Scanner(System.in);
		boolean gameStarted = false;

		while (!gameStarted) {
			int numberOfPlayers = stdIn.nextInt();
			try { 
				game = new SnapGame(numberOfPlayers);
				gameStarted = true;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
		
		//Game successfully created
		while (game.playOneRound()) {
			System.out.println(game.getStatus());
		}
		
		
	}

}
