package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Portal extends GamePiece {
	
	public Portal(char symbol, String label, int location) {
		super(symbol, label, location);
	}

	public InteractionResult interact(Drawable[] gameboard, int playerLocation) {
		
		if (getLocation() == playerLocation) {
			return InteractionResult.ADVANCE;
		}
		else {
			return InteractionResult.NONE;
		}
		
	}

}