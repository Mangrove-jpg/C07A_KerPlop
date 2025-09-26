/*
 * Class: Tree - It is a non-interactive and stationary element on the game board. It extends 
 * GamePiece and it is Drawable, which means that it can display itself on the board. It always 
 * returns NONE when interaction is attempted, so they have no effect on the player.
 * Author(s): Stephen Carmon, Joyce Zhou
 * Date: September 25, 2025
 * Collaborators: None
 * Sources:w3schools.com, geeksforgeeks.org
 */


package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Tree extends GamePiece {
	
	public Tree(char symbol, String label, int location) {
		super(symbol, label, location);
	}

	public InteractionResult interact(Drawable[] gameboard, int playerLocation) {
		return InteractionResult.NONE;
	}

}
