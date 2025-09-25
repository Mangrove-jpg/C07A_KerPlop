package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Prize extends GamePiece {
	public Prize(char symbol, String label, int location) {
		super(symbol, label, location);
	}

	public InteractionResult interact(Drawable[] gameboard, int playerLocation) {
		
		if (getLocation() == playerLocation) {
			
			//Delete Prize if Collected
			gameboard[getLocation()] = null;

			return InteractionResult.GET_POINT;
		}
		else {
			return InteractionResult.NONE;
		}
	}

}