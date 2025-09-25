package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Bird extends GamePiece implements Moveable{
	boolean dirRight = true;
	
	public Bird(char symbol, String label, int location) {
		super(symbol, label, location);
		boolean dirRight = true;
	}

	public InteractionResult interact(Drawable[] gameboard, int playerLocation) {
		return InteractionResult.NONE;
	}
	
	public void move (Drawable[] gameBoard, int playerLocation) {
		int current_loc = getLocation();
		
		if (current_loc == gameBoard.length - 1) {
			dirRight = false;
		}
		if (current_loc == 0) {
			dirRight = true;
		}
		
		if (dirRight) {
			this.setLocation(current_loc + 1);
		}
		else {
			this.setLocation(current_loc - 1);
		}
	
	//Delete The bird From Gameboard
		if (gameBoard[getLocation()] == null) {
			gameBoard[getLocation()] = this;
		}
		
		if (gameBoard[current_loc] == this) {
			gameBoard[current_loc] = null;
		}
		
		
	}

}