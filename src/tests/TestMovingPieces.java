/*
 * Class: TestMovingPieces - Tests to make sure that all moving game pieces are moving correctly. It includes
 * testBirdMovement, testArcherMovement, and testDragonMovement. Both the Bird and Archer tests are to see if they 
 * are moving sequentially, if they jump over other game pieces when they are in the way, and if they reverse after
 * hitting the gameboard bounds. The test for Dragon tests its random movement to make sure it visits all valid locations
 * on the gameboard, while never visiting a location that is occupied by another game piece.
 * Author(s): Stephen Carmon, Joyce Zhou
 * Date: September 28, 2025
 * Collaborators: None
 * Sources: stackoverflow
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gameEngine.Drawable;
import gameEngine.Moveable;
import gameEngine.GameEngine;

import levelPieces.*;

class TestMovingPieces {

	@Test
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
	
	@Test
	void testDragonMovement() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		
		// Start with 1, leaves 0 open
		for (int i = 1; i <= 5; i++)
			gameBoard[i] = new Tree('T', "Tree", i);
		// Leaves 6 open
		for (int i = 7; i <= 11; i++)
			gameBoard[i] = new Tree('T', "Tree", i);
		// Leaves 12, 13, and 20 open, assume player in 13
		for (int i = 14; i < 20; i++)
			gameBoard[i] = new Tree('T', "Tree", i);
		
		Dragon myDragon = new Dragon('D', "Dragon", 6);
		gameBoard[6] = myDragon;
		
		int count0 = 0;
		int count6 = 0;
		int count12 = 0;
		int count20 = 0;
		
		for (int i = 0; i < 200; i++) {
			myDragon.move(gameBoard, 13);
			int loc = myDragon.getLocation();
			
			// Ensure no other space is chosen
			if (loc != 0 && loc != 6 && loc != 12 && loc != 13 && loc != 20) {
				fail("Invalid square selected");
			}
			if (loc == 0) count0++;
			if (loc == 6) count6++;
			if (loc == 12) count12++;
			if (loc == 20) count20++;
		}
		
		// Ensure each option is randomly chosen some number of times
		assertTrue(count0 > 1);
		assertTrue(count6 > 1);
		assertTrue(count12 > 1);
		assertTrue(count20 > 1);
		
	}

}
