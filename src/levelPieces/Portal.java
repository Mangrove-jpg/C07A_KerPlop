/*
 * Class: Portal - It is a stationary level progression element that allows the player to advance to the 
 * next level of the game. This piece extends GamePiece. So it is Drawable, which allows it to be displayed 
 * on the board. It is interactive and returns InteractionResult.ADVANCE when the player is at the same 
 * location as the portal. This does not implement Moveable which makes its location on the game board fixed.
 * Author(s): Stephen Carmon, Joyce Zhou
 * Date: September 25, 2025
 * Collaborators: None
 * Sources:w3schools.com, geeksforgeeks.org
 */

package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Portal extends GamePiece {
	
	public Portal(char symbol, String label, int location) {
		super(symbol, label, location);
	}

	public InteractionResult interact(Drawable[] gameboard, int playerLocation) {
		
		if (getLocation() == playerLocation) {
			// Advance player to the next level
			return InteractionResult.ADVANCE;
		}
		else {
			return InteractionResult.NONE;
		}
		
	}

}