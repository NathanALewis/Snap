package snapGame;

import java.util.InputMismatchException;
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
		
		System.out.println("Welcome to Snap! Please enter a number of player between 2 and 13 (inclusive) to play!");

		while (!gameStarted) {//Wait until valid input is entered 
			
			try { 
				int numberOfPlayers = stdIn.nextInt();
				game = new SnapGame(numberOfPlayers);
				gameStarted = true;
			} catch (IllegalArgumentException e) {//Integer not within range
				System.out.println(e.getMessage());
			} catch (InputMismatchException e) {//Not an integer
				System.out.println("Input must be an integer between 2 and 13 (inclusive)");
				stdIn.nextLine();
			}
		}
		
		//Game successfully created
		while (game.playOneRound()) {
			System.out.println(game.getStatus());
		}
		
		System.out.println(game.getWinner());
		
	}
	
	public static void main(String args[]) {
		new SnapTUI();
	}

}
