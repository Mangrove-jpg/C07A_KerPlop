package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gameEngine.Drawable;
import gameEngine.Moveable;
import gameEngine.GameEngine;

import levelPieces.*;

class TestMovingPieces {

	//@Test
	void testBirdMovement() {
		
		//Create Game Board
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		
		Bird myBird = new Bird('B', "Bird", 12);
		gameBoard[12] = myBird;
		
		//Test if instance moves when un-obstructed
		myBird.move(gameBoard, 0);
		assertEquals(gameBoard[13], myBird);
		
		//Test if instance jumps over trees
		Tree tree = new Tree('T', "Tree", 14);
		gameBoard[14] = tree;
		
		Tree treetree = new Tree('T', "Tree", 15);
		gameBoard[15] = treetree;
		
		myBird.move(gameBoard, 0);
		assertEquals(gameBoard[16], myBird);
		
		//Test if instance reverses direction at end of board
		for (int i = 0; i < 5; i++) {
			myBird.move(gameBoard, 0);
		}
		
		assertEquals(gameBoard[19], myBird);
		
	}
	
	@Test
	void testArcherMovement() {
		
		//Create Game Board
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		
		Archer myArcher = new Archer('A', "Archer", 12);
		gameBoard[12] = myArcher;
		
		//Test if instance moves when un-obstructed
		myArcher.move(gameBoard, 0);
		assertEquals(gameBoard[13], myArcher);
		
		//Test if instance jumps over trees
		Tree tree = new Tree('T', "Tree", 14);
		gameBoard[14] = tree;
		
		Tree treetree = new Tree('T', "Tree", 15);
		gameBoard[15] = treetree;
		
		myArcher.move(gameBoard, 0);
		assertEquals(gameBoard[16], myArcher);
		
		//Test if instance reverses direction at end of board
		for (int i = 0; i < 5; i++) {
			myArcher.move(gameBoard, 0);
		}
		
		assertEquals(gameBoard[19], myArcher);
		
	}

}
