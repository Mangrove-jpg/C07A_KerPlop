package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import levelPieces.*;


// Tests for all interactive game pieces

class TestInteractions {
	
	//@Test
	// Test that Tree never interacts
	void testTree() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Tree tree = new Tree('T', "Tree", 12);
		gameBoard[12] = tree;
		
		assertEquals(InteractionResult.NONE, tree.interact(gameBoard, 12));
		
		// Tree should never interact regardless of position
		for (int i = 0; i < GameEngine.BOARD_SIZE; i++)
			assertEquals(InteractionResult.NONE, tree.interact(gameBoard, i));
	}
	
	//@Test
	void testPrize() {
		// Initialize Prize and Gameboard
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Prize myPrize = new Prize('$', "Prize", 12);
		gameBoard[12] = myPrize;
		
		//Test Interact results in GET_POINT when Player and Prize overlap
		assertEquals(InteractionResult.GET_POINT, myPrize.interact(gameBoard, 12));
		
		//Test Prize Disappears after collecting
		assertNull(gameBoard[12]);
		
		// Prize should never interact if at different position
		for (int i = 0; i < 12; i++)
			assertEquals(InteractionResult.NONE, myPrize.interact(gameBoard, i));
		for (int i = 13; i < GameEngine.BOARD_SIZE; i++)
			assertEquals(InteractionResult.NONE, myPrize.interact(gameBoard, i));
	}
	
	//@Test
	void testLava() {
		// Initialize Lava and Gameboard
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Lava myLava = new Lava('L', "Lava", 12);
		gameBoard[12] = myLava;
				
		//Test Interact results in Kill when Player and Lava overlap
		assertEquals(InteractionResult.KILL, myLava.interact(gameBoard, 12));
				
		// Lava should never interact when player and lava don't overlap
		for (int i = 0; i < 12; i++)
			assertEquals(InteractionResult.NONE, myLava.interact(gameBoard, i));
		for (int i = 13; i < GameEngine.BOARD_SIZE; i++)
			assertEquals(InteractionResult.NONE, myLava.interact(gameBoard, i));
		
	}
	
	//@Test
	void testPortal() {
		// Initialize Portal and Gameboard
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Portal myPortal = new Portal('O', "Portal", 12);
		gameBoard[12] = myPortal;
						
		//Test Interact results in ADVANCE when Player and Portal overlap
		assertEquals(InteractionResult.ADVANCE, myPortal.interact(gameBoard, 12));
						
		// Portal should never interact when player and Portal don't overlap
		for (int i = 0; i < 12; i++)
			assertEquals(InteractionResult.NONE, myPortal.interact(gameBoard, i));
		for (int i = 13; i < GameEngine.BOARD_SIZE; i++)
			assertEquals(InteractionResult.NONE, myPortal.interact(gameBoard, i));
	}
	
	//@Test
	void testDragon() {
		// Initialize Portal and Gameboard
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Dragon myDragon = new Dragon('D', "Dragon", 12);
		gameBoard[12] = myDragon;
								
		//Test Interact results in HIT when Player and Dragon overlap
		assertEquals(InteractionResult.HIT, myDragon.interact(gameBoard, 12));
								
		// Dargon should never interact when player and Dragon don't overlap
		for (int i = 0; i < 12; i++)
			assertEquals(InteractionResult.NONE, myDragon.interact(gameBoard, i));
		for (int i = 13; i < GameEngine.BOARD_SIZE; i++)
			assertEquals(InteractionResult.NONE, myDragon.interact(gameBoard, i));
	}
	
	//@Test
	void testArcher() {
		fail("Not implemented");
	}

}
