package Tests;
import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.BeforeClass;
import org.junit.Test;

import MainClasses.Board;
import Pieces.ArchBishop;

public class ArchBishopTest {

	private static Board gameBoard;

	
	@BeforeClass
	public static void setUp() {
		gameBoard = new Board();
		gameBoard.setPiece(new ArchBishop(Color.black,  0, 0), 0, 0);
		gameBoard.setPiece(new ArchBishop(Color.white,  1, 3), 1, 3);
	}
	
	@Test
	public void testKnightMoves() {
		assertTrue(gameBoard.getPiece(0, 0).validMove(1, 2, gameBoard));
		assertFalse(gameBoard.getPiece(0, 0).validMove(1, 3, gameBoard));
		assertTrue(gameBoard.getPiece(1, 3).validMove(2, 5, gameBoard));
		
	}
	
	@Test
	public void testBishopMoves() {
		assertTrue(gameBoard.getPiece(0, 0).validMove(7, 7, gameBoard));
		assertFalse(gameBoard.getPiece(0, 0).validMove(0, 1, gameBoard));
		assertTrue(gameBoard.getPiece(1, 3).validMove(4, 6, gameBoard));
	}
	
}
