/*
 * Class: Dragon - It is a moving and dangerous creature that flies on the game board with random 
 * movements. This piece extends GamePiece. It is Drawable, allowing it to be displayed on the board, 
 * and it's also interactive returning InteractionResult.HIT when the player is at the same location 
 * as the dragon. It implements Moveable to allow it to move each turn. Its movement uses a random 
 * movement algorithm. The Random class is called to generate random numbers that teleports the dragon 
 * to random places on the game board, while also making sure it only moves to empty spaces on the board.
 * Author(s): Stephen Carmon, Joyce Zhou
 * Date: September 25, 2025
 * Collaborators: None
 * Sources:w3schools.com, geeksforgeeks.org
 */

package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

import java.util.Random;

public class Dragon extends GamePiece implements Moveable{
	
	// Random number generator to create unpredictable movement
	private Random numGen;
	
	public Dragon(char symbol, String label, int location) {
		super(symbol, label, location);
	}

	
	public InteractionResult interact(Drawable[] gameboard, int playerLocation) {
		if (getLocation() == playerLocation) {
			return InteractionResult.HIT;
		}
		else {
			return InteractionResult.NONE;
		}
	}
	
	public void move (Drawable[] gameBoard, int playerLocation) {
		int current_loc = getLocation();
		numGen = new Random();
		int randomNumber = numGen.nextInt(gameBoard.length - 1);
		
		// While loop for if the randomNumber is already a location with a game piece
		while (gameBoard[randomNumber] != null) {
			randomNumber = numGen.nextInt(gameBoard.length - 1);
		}
		this.setLocation(randomNumber);
		gameBoard[getLocation()] = this;

	
	//Delete the dragon from Gameboard
		// Where dragon came from
		if (gameBoard[current_loc] == this) {
			gameBoard[current_loc] = null;
		}
		
		
	}

}