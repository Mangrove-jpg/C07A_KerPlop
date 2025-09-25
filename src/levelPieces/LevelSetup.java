package levelPieces;

import java.util.ArrayList;
import gameEngine.Drawable;
import gameEngine.Moveable;

public class LevelSetup {
	
	private int playerStartLocation;
	
	private Drawable[] gameboard;
	private ArrayList<Moveable> movingPieces;
	private ArrayList<GamePiece> interactingPieces;
	
	//Constructor for LevelSetup
	public LevelSetup() {
	}
	
	//Gets players Start Location
	public int getPlayerStartLoc(){
		return playerStartLocation;
	}
	
	//Set Level Number
	public void createLevel(int levelNum){
		if (levelNum == 1) {
			level1();
		}
		else if (levelNum == 2) {
			level2();
		}
	}
	
	//Return array list of moving pieces
	public ArrayList<Moveable> getMovingPieces(){
		return movingPieces;
	}
	
	//Return array list of interactable pieces
	public ArrayList<GamePiece> getInteractingPieces(){
		return interactingPieces;
	}
	
	//Returns array of Drawables on board
	public Drawable[] getBoard(){
		return gameboard;
	}
	
	//Set up data structures for level 1
	public void level1() {
		playerStartLocation = 3;
		Tree firstTree = new Tree('T', "Tree", 0);
		Tree secondTree = new Tree('T', "Tree", 5);
		Bird bird = new Bird('B', "Bird", 6);
		
		gameboard = new Drawable[10];
		movingPieces = new ArrayList<Moveable>();
		interactingPieces = new ArrayList<GamePiece>();
		
		
		//Set All Drawables
		gameboard[firstTree.getLocation()] = firstTree;
		gameboard[secondTree.getLocation()] = secondTree;
		gameboard[bird.getLocation()] = bird;
		
		//Set all Moveables
		movingPieces.add(bird);
		
		//Set all interactables
	}
			
	//Set up data structures for level 2
	public void level2() {
				
	}
	
	
}
