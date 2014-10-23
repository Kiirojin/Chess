package Tests;
import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.BeforeClass;
import org.junit.Test;

import MainClasses.Board;
import Pieces.Camel;

public class CamelTest {

	private static Board gameBoard;

	
	@BeforeClass
	public static void setUp() {
		gameBoard = new Board();
		gameBoard.setPiece(new Camel(Color.black,  0, 0), 0, 0);
		gameBoard.setPiece(new Camel(Color.white,  1, 3), 1, 3);
	}
	
	@Test
	public void testKillMove() {
		assertTrue(gameBoard.getPiece(0, 0).validMove(1, 3, gameBoard));
	}
	
	@Test
	public void testInvalidMove() {
		assertFalse(gameBoard.getPiece(1, 3).validMove(3, 1, gameBoard));
	}
	
	public void testAnotherMove() {
		assertTrue(gameBoard.getPiece(1, 3).validMove(4, 4, gameBoard));
	}
	
}
