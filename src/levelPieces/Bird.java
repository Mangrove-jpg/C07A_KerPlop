package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Bird extends GamePiece implements Moveable{
	boolean dirRight;
	
	public Bird(char symbol, String label, int location) {
		super(symbol, label, location);
		dirRight = true;
	}

	public InteractionResult interact(Drawable[] gameboard, int playerLocation) {
		return InteractionResult.NONE;
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
	
	//Delete The bird From Gameboard
		// Add 1 to the current_loc until There is a null
		
		gameBoard[getLocation()] = this;
		
		if (gameBoard[prev_location] == this) {
			gameBoard[prev_location] = null;
		}
		
		
	}

}