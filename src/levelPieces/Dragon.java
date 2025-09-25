package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

import java.util.Random;

public class Dragon extends GamePiece implements Moveable{
	
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
		this.setLocation(randomNumber);

			
	
	//Delete The dragon From Gameboard
		//Where Dragon is going getLocation()
		if (gameBoard[getLocation()] == null) {
			gameBoard[getLocation()] = this;
		}
		
		// Where dragon came from
		if (gameBoard[current_loc] == this) {
			gameBoard[current_loc] = null;
		}
		
		
	}

}