package Tests;
import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import MainClasses.Board;
import MainClasses.Player;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PawnTest {
	private static Board gameBoard;
	private static Player playerWhite;
	private static Player playerBlack;
	
	@BeforeClass
	public static void setUp()
	{
		gameBoard = new Board();
		playerWhite = new Player(Color.white, gameBoard);
		playerBlack = new Player(Color.black, gameBoard);
		
	}
	@Test 
	public void AtestVerticalMove() {
		gameBoard.printBoard();
		assertTrue(playerBlack.move(0, 1, 0, 3));
		assertTrue(playerBlack.move(3, 1, 3, 2)); 
	}
	
	@Test
	public void BtestCantMoveOffBoard() {
		assertFalse(playerBlack.move(1, 7, 2, 8));
	}
	
	@Test
	public void CtestOtherTeam() {
		assertTrue(playerWhite.move(0, 6, 0, 4));
		assertTrue(playerWhite.move(1, 6, 1, 4));
		assertTrue(gameBoard.isOccupied(1, 4));
	}
	
	@Test
	public void DtestDiagonalMove() {
		assertTrue(gameBoard.isOccupied(0, 3));
		assertTrue(gameBoard.getPiece(1, 4).validMove(0, 3, gameBoard)); 
		assertFalse(gameBoard.getPiece(1, 4).validMove(0, 5, gameBoard));
		assertTrue(playerWhite.move(1, 4, 0, 3));
		assertFalse(gameBoard.getPiece(0, 4).validMove(0, 3, gameBoard)); 
	}
	
}
