/*
 * Class: Archer - This represents an enemy that can attack the player from a distance as it 
 * moves across the game board. This extends GamePiece, so it is Drawable, allowing it to be 
 * displayed. It is interactive, and returns InteractionResult.HIT when the player is 1 space 
 * away from the archer, whether left or right. Archer also implements Moveable allowing it to 
 * move on the gameboard. It moves up and down the board, similar to bird. It has the same movement 
 * algorithm as bird, where it moves back and forth between the game board boundaries while 
 * avoiding already occupied spaces.
 * Author(s): Stephen Carmon, Joyce Zhou
 * Date: September 25, 2025
 * Collaborators: None
 * Sources:w3schools.com, geeksforgeeks.org
 */

package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Archer extends GamePiece implements Moveable{
	private boolean dirRight;
	
	public Archer(char symbol, String label, int location) {
		super(symbol, label, location);
		dirRight = true;
	}

	public InteractionResult interact(Drawable[] gameboard, int playerLocation) {
		if (getLocation() == playerLocation + 1 || getLocation() == playerLocation - 1) {
			return InteractionResult.HIT;
		}
		else {
			return InteractionResult.NONE;
		}
	}
	
	public void move (Drawable[] gameBoard, int playerLocation) {
		int prev_location = getLocation();
		int current_loc = getLocation();
		
		// Loop to find next Location
		while (gameBoard[current_loc] != null) {
			if (current_loc == gameBoard.length - 1) {
				dirRight = false;
			}
			if (current_loc == 0) {
				dirRight = true;
			}
			
			if (dirRight) {
				current_loc ++;
			}
			else {
				current_loc --;
			}
		}
		setLocation(current_loc);
	
	//Delete the archer from Gameboard
		// Add 1 to the current_loc until There is a null
		
		gameBoard[getLocation()] = this;
		
		if (gameBoard[prev_location] == this) {
			gameBoard[prev_location] = null;
		}
		
		
	}

}