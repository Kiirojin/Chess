package Tests;
import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import MainClasses.Board;
import MainClasses.Player;
import Pieces.ArchBishop;
import Pieces.Bishop;
import Pieces.Camel;
import Pieces.King;
import Pieces.Knight;
import Pieces.Pawn;
import Pieces.Queen;
import Pieces.Rook;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BoardTest {
	private static Board gameBoard;
	@BeforeClass
	public static void setUp() {
		gameBoard = new Board();
		new Player(Color.white, gameBoard);
		new Player(Color.black, gameBoard);
		
	}
	
	public static void setUpEmpty() {
		gameBoard = new Board();
	}
	@Test
	public void AeverythingInRightPlace() {		
		/*
		 * Test that all pieces are in the right place initially
		 */
		assertEquals(gameBoard.getPiece(0, 0), new Rook(Color.black, 0, 0));
		assertEquals(gameBoard.getPiece(7, 0), new Rook(Color.black, 7, 0));
		assertEquals(gameBoard.getPiece(1, 0), new Camel(Color.black, 1, 0));
		assertEquals(gameBoard.getPiece(6, 0), new Knight(Color.black, 6, 0));
		assertEquals(gameBoard.getPiece(2, 0), new ArchBishop(Color.black, 2, 0));
		assertEquals(gameBoard.getPiece(5, 0), new Bishop(Color.black, 5, 0));
		assertEquals(gameBoard.getPiece(3, 0), new King(Color.black, 3, 0));
		assertEquals(gameBoard.getPiece(4, 0), new Queen(Color.black,4, 0));
		
		assertEquals(gameBoard.getPiece(0, 7), new Rook(Color.white, 0, 7));
		assertEquals(gameBoard.getPiece(7, 7), new Rook(Color.white, 7, 7));
		assertEquals(gameBoard.getPiece(1, 7), new Camel(Color.white, 1, 7));
		assertEquals(gameBoard.getPiece(6, 7), new Knight(Color.white, 6, 7));
		assertEquals(gameBoard.getPiece(2, 7), new ArchBishop(Color.white, 2, 7));
		assertEquals(gameBoard.getPiece(5, 7), new Bishop(Color.white, 5, 7));
		assertEquals(gameBoard.getPiece(3, 7), new King(Color.white, 3, 7));
		assertEquals(gameBoard.getPiece(4, 7), new Queen(Color.white,4, 7));
		
		for(int xIndex = 0; xIndex < 8; xIndex ++)
		{
			assertEquals(gameBoard.getPiece(xIndex, 1), new Pawn(Color.black, xIndex, 1));
			assertEquals(gameBoard.getPiece(xIndex, 6), new Pawn(Color.white, xIndex, 6));
		} 
	
	}
	
	@Test
	public void testCheck() {
		setUpEmpty();
		gameBoard.setPiece(new King(Color.black, 1, 1), 1, 1);
		gameBoard.setPiece(new Rook(Color.white, 0, 0), 0, 0);
		assertTrue(gameBoard.getPiece(1, 1).validMove(2, 2, gameBoard));
		assertFalse(gameBoard.getPiece(1, 1).validMove(1, 0, gameBoard));
		
		setUpEmpty();
		gameBoard.setPiece(new Rook(Color.white, 0, 0), 0, 0);
		gameBoard.setPiece(new Rook(Color.black, 1, 0), 1, 0);
		gameBoard.setPiece(new King(Color.black, 2, 0), 2, 0);
		gameBoard.movePiece(2, 0, 3, 0);
		assertFalse(gameBoard.getPiece(1, 0).validMove(1, 5, gameBoard));
	}
	
	@Test
	public void testValidCoordinate() {
		assertFalse(gameBoard.isValidCoordinate(0, 0, -1, 0));
		assertFalse(gameBoard.isValidCoordinate(0, 0, -1, -1));
		assertTrue(gameBoard.isValidCoordinate(0, 0, 1, 1));
		assertFalse(gameBoard.isValidCoordinate(0, 0, 0, 0));
	}
	
	@Test
	public void testSomethingInTheWay() {
		setUpEmpty();
		gameBoard.setPiece(new Pawn(Color.black, 4, 4), 4, 4);
		assertTrue(gameBoard.somethingInTheWay(3, 4, 5, 4));
		assertFalse(gameBoard.somethingInTheWay(3, 4, 4, 4));
		assertTrue(gameBoard.somethingInTheWay(2, 2, 7, 7));
	}
	
	@Test
	public void testMovePiece() {
		setUpEmpty();
		gameBoard.setPiece(new Pawn(Color.black, 4, 4), 4, 4);
		assertTrue(gameBoard.isOccupied(4, 4));
		gameBoard.movePiece(4, 4, 6, 4); 
		assertFalse(gameBoard.isOccupied(4, 4));
		assertTrue(gameBoard.isOccupied(6, 4));
	}
	
	@Test 
	public void testUndo() {
		setUpEmpty(); 
		gameBoard.setPiece(new Pawn(Color.black, 0, 1), 0, 1);
		gameBoard.movePiece(0, 1, 0, 3);
		assertTrue(gameBoard.isOccupied(0, 1) == false);
		assertTrue(gameBoard.isOccupied(0, 3));
		gameBoard.undo();
		assertTrue(gameBoard.isOccupied(0, 1));
		gameBoard.setPiece(new Pawn(Color.white, 1, 2), 1, 2);
		gameBoard.movePiece(0, 1, 1, 2);
		assertTrue(gameBoard.isOccupied(0, 1) == false);
		gameBoard.undo();
		assertTrue(gameBoard.isOccupied(0, 1));
		assertTrue(gameBoard.isOccupied(1, 2));

		
	}

}
