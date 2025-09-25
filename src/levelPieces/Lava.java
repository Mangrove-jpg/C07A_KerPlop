package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Lava extends GamePiece {
	
	public Lava(char symbol, String label, int location) {
		super(symbol, label, location);
	}

	public InteractionResult interact(Drawable[] gameboard, int playerLocation) {
		
		if (getLocation() == playerLocation) {
			return InteractionResult.KILL;
		}
		else {
			return InteractionResult.NONE;
		}
		
	}

}