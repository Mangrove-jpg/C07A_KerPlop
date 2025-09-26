/*
 * Class: Lava - This is a stationary and deadly element that can instantly kill the player if 
 * the player makes contact with it. It extends GamePiece, so it is Drawable, which allows it to 
 * be displayed on the board. It is interactive and returns InteractionResult.KILL when the player
 * is at the same location as the lava, which results in the player dying and the game ending. 
 * Moveable is not implemented so lava is at a fixed location on the game board.
 * Author(s): Stephen Carmon, Joyce Zhou
 * Date: September 25, 2025
 * Collaborators: None
 * Sources:w3schools.com, geeksforgeeks.org
 */

package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Lava extends GamePiece {
	
	public Lava(char symbol, String label, int location) {
		super(symbol, label, location);
	}

	public InteractionResult interact(Drawable[] gameboard, int playerLocation) {
		
		if (getLocation() == playerLocation) {
			// Lava kills player upon contact
			return InteractionResult.KILL;
		}
		else {
			return InteractionResult.NONE;
		}
		
	}

}