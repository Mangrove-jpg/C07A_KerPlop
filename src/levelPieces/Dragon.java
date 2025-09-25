package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

import java.util.Random;

public class Dragon extends GamePiece implements Moveable{
	boolean dirRight = true;
	
	private Random numGen;
	
	public Dragon(char symbol, String label, int location) {
		super(symbol, label, location);
		boolean dirRight = true;
	}

	
	public InteractionResult interact(Drawable[] gameboard, int playerLocation) {
		if (getLocation() == playerLocation - 1) {
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
		if (gameBoard[getLocation()] == null) {
			gameBoard[getLocation()] = this;
		}
		
		if (gameBoard[current_loc] == this) {
			gameBoard[current_loc] = null;
		}
		
		
	}

}