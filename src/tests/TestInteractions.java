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
	
	@Test
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
	
	@Test
	void testPrize() {
		fail("Not implemented");
	}
	
	@Test
	void testLava() {
		fail("Not implemented");
		
	}
	
	@Test
	void testPortal() {
		fail("Not implemented");
	}
	
	@Test
	void testDragon() {
		fail("Not implemented");
	}
	
	@Test
	void testArcher() {
		fail("Not implemented");
	}

}
