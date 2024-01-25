//Juna Kim
//Tic Tac Toe (player vs player)
//April 3, 2023

package files;

import java.io.*;

public class PlayTicTacToe_PlayerVsPlayer {
	/**
	 * This main program will create a GameBoard object and allow a round of
	 * TicTacToe to be played
	 * 
	 * @author Mr. Aldworth
	 */

	public static void main(String args[]) throws Exception {
		// let user use keyboard
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in), 1);
		GameBoard game = new GameBoard();// makes a blank gameboard
		// declare and initialize variables
		String player1, player2;
		int turn = 0;
		int index;
		boolean errorFlag;
		boolean gameOver = false;
		
		System.out.print("Please Enter Player 1's Name: ");
		player1 = keyboard.readLine();
		System.out.println(player1 + " you are X's");
		System.out.print("Please Enter Player 2's Name: ");
		player2 = keyboard.readLine();
		System.out.println(player2 + " you are O's");
		System.out.println("Press ENTER to continue");
		keyboard.readLine();
		System.out.println();
		System.out.println();
		// draw gameboard
		game.drawBoard();
		System.out.println();
		System.out.println();
		while (gameOver == false) {
			errorFlag = false;
			if (turn % 2 == 0) {// if it is player 1's turn
				do {
					System.out.print(player1 + " enter your choice (1-9): ");
					index = Integer.parseInt(keyboard.readLine());// Assumes a valid number is entered
					// check if you can play on that index and play
					errorFlag = game.play("X", index);
					if (errorFlag == false)
						System.out.println("That square is already taken or invalid.  Try again");
				} while (errorFlag == false);// makes sure player enters a square not yet used
				System.out.println();
				System.out.println();
				// draw updated gameboard
				game.drawBoard();
				System.out.println();
				System.out.println();
				if (game.checkWin("X")) {
					System.out.println(player1 + ", YOU WIN!!");
					// end game when a player wins
					gameOver = true;
				}
			} else {// player 2s turn
				do {
					System.out.print(player2 + " enter your choice (1-9): ");
					index = Integer.parseInt(keyboard.readLine());// Assumes an integer is entered
					// check if you can play on that index and play
					errorFlag = game.play("O", index);
					if (errorFlag == false)
						System.out.println("That square is already taken or invalid.  Try again");
				} while (errorFlag == false);// makes sure player enters a square not yet used
				System.out.println();
				System.out.println();
				// draw updated gameboard
				game.drawBoard();
				System.out.println();
				System.out.println();
				if (game.checkWin("O")) {
					System.out.println(player2 + ", YOU WIN!!");
					// end game when a player wins
					gameOver = true;
				}

			}
			turn++;
			// when all spaces are filled in the gameboard, end the game with a draw
			if (turn == 9 && gameOver == false) {
				gameOver = true;
				System.out.println("DRAW");
			}
		} // end while
	}// end main
}// end class
