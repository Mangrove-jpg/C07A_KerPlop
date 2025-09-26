/*
 * Class: Prize - This represents a reward item that the player needs to collect, and it 
 * provides points toward level completion and disappears after collected. This piece extends
 * GamePiece, making it Drawable, allowing it to be displayed on the board. It is interactive,
 * returning InteractionResult.GET_POINT when the player is at the same location as the prize, 
 * and the prize will also be removed from the board to prevent multiple collections. Prize does
 * not implement Moveable, which makes it stationary.
 * Author(s): Stephen Carmon, Joyce Zhou
 * Date: September 25, 2025
 * Collaborators: None
 * Sources:w3schools.com, geeksforgeeks.org
 */

package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Prize extends GamePiece {
	public Prize(char symbol, String label, int location) {
		super(symbol, label, location);
	}

	public InteractionResult interact(Drawable[] gameboard, int playerLocation) {
		
		if (getLocation() == playerLocation) {
			
			//Delete Prize if collected
			gameboard[getLocation()] = null;

			return InteractionResult.GET_POINT;
		}
		else {
			return InteractionResult.NONE;
		}
	}

}