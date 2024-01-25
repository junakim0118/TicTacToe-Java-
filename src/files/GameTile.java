package files;

/**
 * Class for Tic-Tac-Toe tile
 * 
 * @author Put name here
 */

public class GameTile {
	/**
	 * Stores a String representing the owner "X" or "O" of a GameTile
	 */
	protected String owner;

	/**
	 * Constructs a GameTile, sets owner to null by default
	 */
	public GameTile() {
		owner = null;
	}

	/**
	 * This will return who owns this particular GameTile
	 * 
	 * @return String "X" if player 1 owns tile, "Y" if player 2 owns tile, empty
	 *         string if unowned
	 */
	public String getOwner() {
//Enter code for this method here

		String ownerOfTile = " ";
		if (owner=="X") { 
			ownerOfTile="X";
		} else if (owner=="O") { 
			ownerOfTile="O";
		}
		return ownerOfTile;
	}

	/**
	 * This will assign a new owner to the game tile
	 * 
	 * @param player A String indicating which player will own the tile ("X" or "O")
	 */
	public void setOwner(String player) {
		// Enter code for this method here
		if (player.equals("O")) {
			owner = "O";
		} else if (player.equals("X")) {
			owner = "X";
		}

	}

	/**
	 * This will determine whether any player owns a particular tile
	 * 
	 * @return boolean true if a player owns the tile, false otherwise
	 */
	public boolean owned() {
//Enter code for this method here
		boolean tile = false;
		if (owner=="X"|| owner=="O") {
			tile = true;
		} else {
			tile = false;
		}
		return tile;
	}

}
