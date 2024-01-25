//Juna Kim
//Tic Tac Toe (learning computer)
//April 3, 2023

package files;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PlayTicTacToe_LearningComputer {

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
		String player1;
		int turn = 0;
		int index;
		String comb;
		boolean errorFlag;
		boolean gameOver = false;
		System.out.print("Please Enter Player 1's Name: ");
		player1 = keyboard.readLine();
		System.out.println(player1 + " you are X's");
		// System.out.print("Please Enter Player 2's Name: ");
		// player2 = keyboard.readLine();
		System.out.println("The computer is O's");
		System.out.println("Press ENTER to continue");
		keyboard.readLine();
		System.out.println();
		System.out.println();
		game.drawBoard();
		System.out.println();
		System.out.println();
		while (gameOver == false) {
			errorFlag = false;
			if (turn % 2 == 0) {

				do {

					index = game.attackOrDefend();

					errorFlag = game.play("O", index);
					System.out.println(index);
					if (errorFlag == false) {
						index = game.attackOrDefend();
					}
				} while (errorFlag == false);// makes sure player enters a square not yet used
				System.out.println();
				System.out.println();
				game.drawBoard();
				System.out.println();
				System.out.println();
				if (game.checkWin("O")) {
					System.out.println("COMPUTER WINS!!");
					gameOver = true;
					//comb = game.winComb("O");
				}

				// if it is player 1's turn

			} else {// computers turn
				do {
					System.out.print(player1 + " enter your choice (1-9): ");
					index = Integer.parseInt(keyboard.readLine());// Assumes a valid number is entered
					errorFlag = game.play("X", index);
					// System.out.print(game.getXIndex(index));
					if (errorFlag == false)
						System.out.println("That square is already taken or invalid.  Try again");

				} while (errorFlag == false);// makes sure player enters a square not yet used
				System.out.println();
				System.out.println();
				game.drawBoard();
				System.out.println();
				System.out.println();
				if (game.checkWin("X")) {
					System.out.println(player1 + ", YOU WIN!!");
					gameOver = true;
					 //comb = game.winComb("X");
				}

			}
			turn++;
			if (turn == 9 && gameOver == false) {
				gameOver = true;
				System.out.println("DRAW");
			}
		} // end while

	} // end main

} // end class
