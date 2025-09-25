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
