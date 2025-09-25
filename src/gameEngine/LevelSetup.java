package gameEngine;

import java.util.ArrayList;

public class LevelSetup {
	
	private int levelNumber;
	private int playerStartLocation;
	
	private Drawable[] gameboard;
	private ArrayList<Moveable> movingPieces;
	private ArrayList<Moveable> interactingPieces;
	
	//Constructor for LevelSetup
	public LevelSetup() {
	}
	
	//Set Level Number
	public void createLevel(int levelNum){
		if (levelNum == 0) {
			level1();
		}
		else if (levelNum == 1) {
			level2();
		}
	}
	
	//Return array list of moving pieces
	public ArrayList<Moveable> getMovingPieces(){
		return movingPieces;
	}
	
	//Return array list of interactable pieces
	public ArrayList<Moveable> getInteractingPieces(){
		return interactingPieces;
	}
	
	//Returns array of Drawables on board
	public Drawable[] getBoard(){
		return gameboard;
	}
	
	//Set up data structures for level 1
	public void level1() {
			
	}
			
	//Set up data structures for level 2
	public void level2() {
				
	}
	
	
}
