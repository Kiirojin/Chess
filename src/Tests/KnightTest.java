package Tests;
import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import MainClasses.Board;
import MainClasses.Player;
import Pieces.Bishop;
import Pieces.Knight;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class KnightTest {

	private static Board gameBoard;
	private static Player playerWhite;
	private static Player playerBlack;
	
	@BeforeClass
	public static void setUp()
	{
		gameBoard = new Board();
		playerWhite = new Player(Color.white, gameBoard);
		playerBlack = new Player(Color.black, gameBoard);
		gameBoard.setPiece(new Knight(Color.white, 1, 7), 1, 7);
		gameBoard.setPiece(new Bishop(Color.white, 2, 7), 2, 7);
		gameBoard.setPiece(new Knight(Color.black, 1, 0), 1, 0);
		gameBoard.setPiece(new Bishop(Color.black, 2, 0), 2, 0);

		assertTrue(playerBlack.move(0, 1, 0, 3)); 
		assertTrue(playerBlack.move(3, 1, 3, 2)); 
		assertFalse(playerBlack.move(1, 7, 2, 8)); 
		assertTrue(playerWhite.move(0, 6, 0, 4));
		assertTrue(playerWhite.move(1, 6, 1, 4));
		assertTrue(gameBoard.isOccupied(1, 4));
		assertTrue(gameBoard.isOccupied(0, 3));
		assertTrue(playerWhite.move(1, 4, 0, 3));
		assertTrue(playerBlack.move(0, 0, 0, 1));
		assertTrue(gameBoard.isOccupied(0, 1));
		assertFalse(gameBoard.isOccupied(0, 0));
		assertTrue(playerBlack.move(0, 1, 0, 3));
		assertFalse(playerWhite.move(0, 3, 0, 4));
		assertTrue(playerBlack.move(0, 3, 5, 3)); 
		assertFalse(playerBlack.move(2, 0, 5, 3)); 
		assertTrue(playerBlack.move(2, 0, 4, 2)); 
		assertTrue(playerBlack.move(4, 2, 3, 3));
		assertTrue(playerBlack.move(3, 3, 2, 2)); 
		assertTrue(playerBlack.move(2, 2, 3, 1)); 
		assertTrue(playerBlack.move(3, 1, 2, 2));
		assertFalse(playerBlack.move(2, 2, 7, 7)); 
		assertTrue(playerBlack.move(2, 2, 6, 6));
		assertFalse(playerBlack.move(0, 3, 2, 2)); 
		assertTrue(playerBlack.move(4, 0, 2, 2)); 
		assertTrue(playerBlack.move(2, 2, 2, 6)); 
		assertFalse(playerBlack.move(2, 6, 4, 6)); 
		assertTrue(playerBlack.move(2, 6, 1, 7)); 
		assertFalse(playerBlack.move(3, 0, 2, 2));
		assertTrue(playerBlack.move(3, 0, 3, 1));
		assertTrue(playerBlack.move(3, 1, 2, 2));
		assertTrue(playerBlack.move(2, 2, 1, 2));
		assertTrue(playerBlack.move(1, 2, 2, 3));
		assertFalse(playerBlack.move(2, 3, 2, 3));
	}
	
	@Test
	public void AtestInvalidMove() {
		assertFalse(playerBlack.move(6, 0, 6, 2));
	}
	
	@Test
	public void BtestValidMoves() {
		assertTrue(playerBlack.move(6, 0, 5, 2)); 
		assertTrue(playerBlack.move(5, 2, 6, 4));
	}
	
	@Test 
	public void CtestKillMove() {
		assertTrue(playerBlack.move(6, 4, 5, 6));
	}
}
