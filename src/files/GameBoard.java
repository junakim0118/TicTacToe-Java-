package files;

/**
 * Class for Tic Tac Toe gameboard
 * 
 * @author Put Name Here
 */
public class GameBoard {
	/**
	 * An array of 9 GameTiles representing the TicTacToe gameboard
	 */
	GameTile[] board;

	/**
	 * Constructs an empty gameboard of 9 GameTiles and fills it with unowned tiles
	 */
	public GameBoard() {
		board = new GameTile[9];
		for (int i = 0; i < 9; i++)
			board[i] = new GameTile();
	}

	/**
	 * This will allow a player to claim a GameTile on the TicTacToe board
	 * 
	 * @return A boolean true if the player successfully played on a tile, false if
	 *         that tile is already owned or the index is out of bounds
	 * @param player A String indicating which player is to own the tile ("X" or
	 *               "O")
	 * @param tile   An integer representing the tile the player wishes to claim
	 */
	public boolean play(String player, int tile) {

		boolean allowed[] = new boolean[9];
		// if the spot is taken, not able to play
		if (board[tile - 1].owned()) {
			allowed[tile - 1] = false;
		} else if (board[tile - 1].owned() == false) {
			allowed[tile - 1] = true;
			board[tile - 1].setOwner(player);
		}
		return allowed[tile - 1];
	}

	/**
	 * This will check to see if there are three tiles in a row belonging to a
	 * player
	 * 
	 * @return A boolean true if the player has three tiles in a row, false
	 *         otherwise
	 * @param player A String indicating which player to check for a win ("X" or
	 *               "O")
	 */
	public boolean checkWin(String player) {
		// check for win with boolean
		boolean win = false;

		// check for winning combinations (if one player has all three spots in a
		// winning combination, they win)
		// 0,1,2
		if (board[0].getOwner().equals(player) && board[1].getOwner().equals(player)
				&& board[2].getOwner().equals(player)) {
			win = true;
		}
		// 0,4,8
		if (board[0].getOwner().equals(player) && board[4].getOwner().equals(player)
				&& board[8].getOwner().equals(player)) {
			win = true;
		}
		// 0,3,6
		if (board[0].getOwner().equals(player) && board[3].getOwner().equals(player)
				&& board[6].getOwner().equals(player)) {
			win = true;
		}
		// 1,4,7
		if (board[1].getOwner().equals(player) && board[4].getOwner().equals(player)
				&& board[7].getOwner().equals(player)) {
			win = true;
		}
		// 2,5,8
		if (board[2].getOwner().equals(player) && board[5].getOwner().equals(player)
				&& board[8].getOwner().equals(player)) {
			win = true;
		}
		// 2,4,6
		if (board[2].getOwner().equals(player) && board[4].getOwner().equals(player)
				&& board[6].getOwner().equals(player)) {
			win = true;
		}
		// 3,4,5
		if (board[3].getOwner().equals(player) && board[4].getOwner().equals(player)
				&& board[5].getOwner().equals(player)) {
			win = true;
		}
		// 6,7,8
		if (board[6].getOwner().equals(player) && board[7].getOwner().equals(player)
				&& board[8].getOwner().equals(player)) {
			win = true;
		}
		return win;
	}


	/**
	 * This will decide where should the smart computer move to attack or defend
	 * 
	 * @return Int index - the index to play
	 *
	 */
	public int attackOrDefend() {
		// initialize index with random int
		int index = (int) Math.floor(Math.random() * (9 - 1 + 1) + 1);
		// declare, initialize variables
		boolean attack = false;
		int count = 0;

		// check how many spots are empty
		for (int i = 0; i < 9; i++) {
			if (board[i].owned() == false) {
				count++;
			}
		}
		// first move, always go on the first spot
		if (count == 9) {
			index = 1;
		}

		// second or third moves
		// when x(user player) goes 5
		if (count == 7 && board[0].getOwner() == "O" && board[4].getOwner() == "X" && board[8].owned() == false) {
			index = 9;
		}
		if (count == 5 && board[0].getOwner() == "O" && board[4].getOwner() == "X" && board[8].getOwner() == "O"
				&& board[2].owned() == false) {
			index = 3;
		} else if (count == 5 && board[0].getOwner() == "O" && board[4].getOwner() == "X" && board[8].getOwner() == "O"
				&& board[2].owned() == true && board[6].owned() == false) {
			index = 7;
		}

		// when x goes 2
		if (count == 7 && board[1].getOwner() == "X") {
			index = 7;
		}
		if (count == 5 && board[1].getOwner() == "X" && board[6].getOwner() == "O" && board[3].getOwner() == "X") {
			index = 9;
		}

		// when x goes 4 or 8 or 9
		if ((count == 7 && board[3].getOwner() == "X") || (count == 7 && board[7].getOwner() == "X")
				|| (count == 7 && board[8].getOwner() == "X")) {
			index = 3;
		}
		// when x goes 4
		if (count == 5 && board[3].getOwner() == "X" && board[2].getOwner() == "O" && board[1].getOwner() == "X") {
			index = 9;
		}
		// when x goes 9
		if (count == 5 && board[8].getOwner() == "X" && board[2].getOwner() == "O" && board[1].getOwner() == "X") {
			index = 7;
		}
		// when x goes 6
		if (count == 7 && board[5].getOwner() == "X") {
			index = 7;
		}

		// when x goes 3 or 7
		if ((count == 7 && board[2].getOwner() == "X") || (count == 7 && board[6].getOwner() == "X")) {
			if (board[2].owned() == false) {
				index = 3;
			} else if (board[2].owned() == true && board[6].owned() == false) {
				index = 7;
			} else if (board[2].owned() == true && board[6].owned() == true && board[8].owned() == false) {
				index = 9;
			}
		}
		// get the edges
		if (count < 7 && board[2].owned() == false) {
			index = 3;
		} else if (count < 7 && board[2].owned() == true && board[6].owned() == false) {
			index = 7;
		} else if (count < 7 && board[2].owned() == true && board[6].owned() == true && board[8].owned() == false) {
			index = 9;
		}

		// attack (if computer has an opportunity to win)
		for (int i = 0; i < 7; i += 3) {
			if (board[i].getOwner() == "O" && board[i + 1].getOwner() == "O" && board[i + 2].owned() == false) {
				index = i + 2 + 1;
				attack = true;

			} else if (board[i + 2].getOwner() == "O" && board[i + 1].getOwner() == "O" && board[i].owned() == false) {
				index = i + 1;
				attack = true;

			} else if (board[i].getOwner() == "O" && board[i + 2].getOwner() == "O" && board[i + 1].owned() == false) {
				index = i + 1 + 1;
				attack = true;

			}
		}

		if (board[2].getOwner() == "O" && board[2 + 2].getOwner() == "O" && board[2 + 4].owned() == false) {
			index = 2 + 4 + 1;
			attack = true;

		} else if (board[2 + 4].getOwner() == "O" && board[2 + 2].getOwner() == "O" && board[2].owned() == false) {
			index = 2 + 1;
			attack = true;

		} else if (board[2].getOwner() == "O" && board[2 + 4].getOwner() == "O" && board[2 + 2].owned() == false) {
			index = 2 + 2 + 1;
			attack = true;

		}

		for (int i = 0; i < 3; i += 1) {
			if (board[i].getOwner() == "O" && board[i + 3].getOwner() == "O" && board[i + 6].owned() == false) {
				index = i + 6 + 1;
				attack = true;

			} else if (board[i + 6].getOwner() == "O" && board[i + 3].getOwner() == "O" && board[i].owned() == false) {
				index = i + 1;
				attack = true;

			} else if (board[i].getOwner() == "O" && board[i + 6].getOwner() == "O" && board[i + 3].owned() == false) {
				index = i + 3 + 1;
				attack = true;

			}
		}
		if (board[0].getOwner() == "O" && board[0 + 4].getOwner() == "O" && board[0 + 8].owned() == false) {
			index = 0 + 8 + 1;
			attack = true;

		} else if (board[0 + 8].getOwner() == "O" && board[0 + 4].getOwner() == "O" && board[0].owned() == false) {
			index = 0 + 1;
			attack = true;

		} else if (board[0].getOwner() == "O" && board[0 + 8].getOwner() == "O" && board[0 + 4].owned() == false) {
			index = 0 + 4 + 1;
			attack = true;

		}

		// defend if attack is not possible (fill in the last spot for user player's
		// winning combination to defend)
		if (attack == false) {
			for (int i = 0; i < 7; i += 3) {
				if (board[i].getOwner() == "X" && board[i + 1].getOwner() == "X" && board[i + 2].owned() == false) {
					index = i + 2 + 1;

				} else if (board[i + 2].getOwner() == "X" && board[i + 1].getOwner() == "X"
						&& board[i].owned() == false) {
					index = i + 1;

				} else if (board[i].getOwner() == "X" && board[i + 2].getOwner() == "X"
						&& board[i + 1].owned() == false) {
					index = i + 1 + 1;

				}
			}

			if (board[2].getOwner() == "X" && board[2 + 2].getOwner() == "X" && board[2 + 4].owned() == false) {
				index = 2 + 4 + 1;

			} else if (board[2 + 4].getOwner() == "X" && board[2 + 2].getOwner() == "X" && board[2].owned() == false) {
				index = 2 + 1;

			} else if (board[2].getOwner() == "X" && board[2 + 4].getOwner() == "X" && board[2 + 2].owned() == false) {
				index = 2 + 2 + 1;

			}

			for (int i = 0; i < 3; i += 1) {
				if (board[i].getOwner() == "X" && board[i + 3].getOwner() == "X" && board[i + 6].owned() == false) {
					index = i + 6 + 1;

				} else if (board[i + 6].getOwner() == "X" && board[i + 3].getOwner() == "X"
						&& board[i].owned() == false) {
					index = i + 1;

				} else if (board[i].getOwner() == "X" && board[i + 6].getOwner() == "X"
						&& board[i + 3].owned() == false) {
					index = i + 3 + 1;

				}
			}
			if (board[0].getOwner() == "X" && board[0 + 4].getOwner() == "X" && board[0 + 8].owned() == false) {
				index = 0 + 8 + 1;

			} else if (board[0 + 8].getOwner() == "X" && board[0 + 4].getOwner() == "X" && board[0].owned() == false) {
				index = 0 + 1;

			} else if (board[0].getOwner() == "X" && board[0 + 8].getOwner() == "X" && board[0 + 4].owned() == false) {
				index = 0 + 4 + 1;

			}
		}
		return index;

	}

	/**
	 * This will draw the current gameboard on the screen
	 */
	public void drawBoard() {
		System.out.println(" " + board[0].getOwner() + " | " + board[1].getOwner() + " | " + board[2].getOwner() + " ");
		System.out.println("___________");
		System.out.println(" " + board[3].getOwner() + " | " + board[4].getOwner() + " | " + board[5].getOwner() + " ");
		System.out.println("___________");
		System.out.println(" " + board[6].getOwner() + " | " + board[7].getOwner() + " | " + board[8].getOwner() + " ");
	}
}// end class
