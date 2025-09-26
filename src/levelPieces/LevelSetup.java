/*
 * Class: LevelSetup - It manages level configuration and is responsible for creating and 
 * organizing all game content for each level. It is the bridge between the GameEngine and 
 * the individual game pieces as it constructs complete level layouts and categorizes pieces 
 * into a game board array that determines what appears at each position, a list of moving 
 * pieces that require position updates each turn, and a list of interactive pieces that can 
 * affect the player with interactions. When the GameEngine requests for a specific level using 
 * createLevel(), this class initializes all the necessary game pieces and places them on the 
 * board, adds them to the correct behavior lists (drawable, moveable, interactable), and sets 
 * the player's starting position for that level.
 * Author(s): Stephen Carmon, Joyce Zhou
 * Date: September 25, 2025
 * Collaborators: None
 * Sources:w3schools.com, geeksforgeeks.org
 */

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
		Tree thirdTree = new Tree('T', "Tree", 11);
		Bird bird = new Bird('B', "Bird", 6);
		Dragon dragon = new Dragon('D', "Dragon", 8);
		Lava lava = new Lava ('L', "Lava", 9);
		Portal portal = new Portal('O', "Portal", 15);
		
		gameboard = new Drawable[21];
		movingPieces = new ArrayList<Moveable>();
		interactingPieces = new ArrayList<GamePiece>();
		
		
		//Set All Drawables
		gameboard[firstTree.getLocation()] = firstTree;
		gameboard[secondTree.getLocation()] = secondTree;
		gameboard[thirdTree.getLocation()] = thirdTree;
		gameboard[bird.getLocation()] = bird;
		gameboard[dragon.getLocation()] = dragon;
		gameboard[lava.getLocation()] = lava;
		gameboard[portal.getLocation()] = portal;
		
		//Set all Moveables
		movingPieces.add(bird);
		movingPieces.add(dragon);
		
		//Set all interactables
		interactingPieces.add(dragon);
		interactingPieces.add(lava);
		interactingPieces.add(portal);
	}
			
	//Set up data structures for level 2
	public void level2() {
		playerStartLocation = 12;
		
		gameboard = new Drawable[21];
		movingPieces = new ArrayList<Moveable>();
		interactingPieces = new ArrayList<GamePiece>();
		
		
		Tree tree = new Tree('T', "Tree", 2);
		Tree treetree = new Tree('T', "Tree", 16);
		Tree treetreetree = new Tree('T', "Tree", 10);
		Prize prize1 = new Prize('$', "Prize", 5);
		Prize prize2 = new Prize('$', "Prize", 19);
		Archer archer = new Archer('A', "Archer", 0);
		
		// Set Drawables
		gameboard[tree.getLocation()] = tree;
		gameboard[treetree.getLocation()] = treetree;
		gameboard[treetreetree.getLocation()] = treetreetree;
		gameboard[prize1.getLocation()] = prize1;
		gameboard[prize2.getLocation()] = prize2;
		gameboard[archer.getLocation()] = archer;
		
		// Set Moveables
		movingPieces.add(archer);
		
		// Set interactables
		interactingPieces.add(prize1);
		interactingPieces.add(prize2);
		interactingPieces.add(archer);
				
	}
	
	
}
