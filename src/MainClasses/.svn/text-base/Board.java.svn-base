package MainClasses;
import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

import Pieces.King;
import Pieces.Pawn;
import Pieces.Piece;

/**
 * The main model class. Contains most or all of the representation of the game data structure wise.
 * @author Andrew
 *
 */
public class Board {
	final int width = 8;
	final int height = 8;
	private Square[][] boardArray; //first index is height/yCoordinate, second index is width/xCoordinate
	private int whiteKingXLocation; 
	private int blackKingXLocation;
	private int whiteKingYLocation; 
	private int blackKingYLocation;
	
	private Point previousPosition = null;
	private Point newPosition = null;
	private Piece lastPiece = null;
	private Piece lastOtherPiece = null;
	
	public Board() {
		boardArray = new Square[height][width];
	
		whiteKingXLocation =  -1; whiteKingYLocation = -1;
		blackKingXLocation =  -1; blackKingYLocation = -1;
		
		for(int xIndex = 0; xIndex < width; xIndex++)
			for(int yIndex = 0; yIndex < height; yIndex++)
				boardArray[yIndex][xIndex] = new Square();
	}
	
	/**
	 * Gets a piece at a specified location
	 * @param xCoordinate	the xCoordinate to query the board
	 * @param yCoordinate 	the yCoordinate to query the board
	 * @return Piece 			a piece stored in the board. null if there is nothing
	 */
	public Piece getPiece(int xCoordinate, int yCoordinate) {
		return boardArray[yCoordinate][xCoordinate].getPiece();
	}
	
	/**
	 * Is there a piece at that location?
	 * @param xCoordinate	the xCoordinate to query the board
	 * @param yCoordinate 	the yCoordinate to query the board
	 * @return boolean			true if piece exists, false if no piece exists
	 */
	public boolean isOccupied(int xCoordinate, int yCoordinate) {
		return boardArray[yCoordinate][xCoordinate].isOccupied();
	}
	
	/**
	 * Used in the Piece constructor to set the pieces on the board, sets a piece on the boardArray
	 * @param xCoordinate	the xCoordinate to set the board
	 * @param yCoordinate 	the yCoordinate to set the board
	 */
	public void setPiece(Piece newPiece, int xCoordinate, int yCoordinate) {
		boardArray[yCoordinate][xCoordinate].setPiece(newPiece);
		if(newPiece instanceof King)
			setKingLocation(newPiece.getColor(), xCoordinate, yCoordinate);
	}
	
	/**
	 *  Move a piece from one location to another
	 * @param xCoordinate		the xCoordinate of the piece to move
	 * @param yCoordinate		the yCoordinate of the piece to move
	 * @param xNewCoordinate	the destination in the x location
	 * @param yNewCoordinate	the destination in the y location
	 */
	public void movePiece(int xCoordinate, int yCoordinate, int xNewCoordinate, int yNewCoordinate) {
		if(boardArray[yCoordinate][xCoordinate].isOccupied())
		{
			Piece pieceToMove = boardArray[yCoordinate][xCoordinate].removePiece();
			if(pieceToMove instanceof King)
			{
				setKingLocation(pieceToMove.getColor(), xNewCoordinate, yNewCoordinate);
			}
			lastPiece = pieceToMove;
			lastOtherPiece = getPiece(xNewCoordinate, yNewCoordinate);
			previousPosition = new Point(xCoordinate, yCoordinate);
			newPosition = new Point(xNewCoordinate, yNewCoordinate);
			
			boardArray[yNewCoordinate][xNewCoordinate].setPiece(pieceToMove);
			
			
		}
		else
		{
			System.out.println("There is nothing at " + xCoordinate + "," + yCoordinate + " to move." );
		}
	}

	/**
	 * @return width of the board
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * @return height of the board
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * @param kingColor the color of the king
	 * @return the xLocation of a king
	 */
	public int getKingXLocation(Color kingColor) {
		if(kingColor.equals(Color.white))
			return whiteKingXLocation;
		else if(kingColor.equals(Color.black))
			return blackKingXLocation;
		return -1;
	}
	
	/**
	 * @param kingColor the color of the king
	 * return the yLocation of a king
	 */
	public int getKingYLocation(Color kingColor) {
		if(kingColor.equals(Color.white))
			return whiteKingYLocation;
		else if(kingColor.equals(Color.black))
			return blackKingYLocation;
		return -1;
	}
	
	/**
	 *  Get an ArrayList containing all of the pieces of a specific team
	 * @Param teamColor	the color of the team to get
	 * @eturn ArrayList 		the list of pieces of a specific team
	 */
	public ArrayList<Piece> getPieceList(Color teamColor) {
		ArrayList<Piece> listToReturn = new ArrayList<Piece>();
		for(int xIndex = 0; xIndex < width; xIndex++)
		{
			for(int yIndex = 0; yIndex < height; yIndex++)
			{
				if(boardArray[xIndex][yIndex].isOccupied())
				{
					Piece pieceToCheck = boardArray[xIndex][yIndex].getPiece();
					if(teamColor.equals(pieceToCheck.getColor()))
						listToReturn.add(pieceToCheck);
				}
				
			}
		}
		return listToReturn;
	}
	
	/*
	 * Prints the board out in a rudimentary text based manner
	 */
	public void printBoard() {
		for(int yIndex = 0; yIndex < height; yIndex++)
		{
			for(int xIndex = 0; xIndex < width; xIndex++)
			{
				if(boardArray[yIndex][xIndex].isOccupied())
				{
					System.out.print(boardArray[yIndex][xIndex].getPiece().getLetterName());
				}
				else
				{
					System.out.print(".");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
	/**
	 * Checks if the given coordinates are in bound
	 * @param yNewCoordinate 	the new x location
	 * @param xNewCoordinate 	the new y location
	 * @param xCoordinate		the old x location
	 * @param yCoordinate		the old y location
	 * @param gameBoard			the board which to check
	 * @return Boolean 			if the coordinate is valid or not
	 */
	public boolean isValidCoordinate(int xCoordinate, int yCoordinate, int xNewCoordinate, int yNewCoordinate) {	
		if(xNewCoordinate < 0 || yNewCoordinate < 0 || xNewCoordinate >= getHeight() || yNewCoordinate >= getWidth())
			return false;
		else if(xCoordinate == xNewCoordinate && yCoordinate == yNewCoordinate)
			return false;
		return true;
	}
	/**
	 * Calculates if something is between the origin and destination.
	 * A big function for the knight, bishop, and queen.
	 * @param xCoordinate		The initial xCoordinate of the move
	 * @param yCoordinate		The initial yCoordinate of the move
	 * @param xNewCoordinate 	The destination xCoordinate of the move
	 * @param yNewCoordinate	The destination yCoordinate of the move
	 * @return	boolean 			if something was in between the original and final coordinates
	 */
	public boolean somethingInTheWay(int xCoordinate, int yCoordinate, int xNewCoordinate, int yNewCoordinate) {
		
		boolean movingDown = false, movingUp = false, movingLeft = false, movingRight = false;
		if(xNewCoordinate > xCoordinate)
			movingRight = true;
		if(yNewCoordinate > yCoordinate)
			movingDown = true;
		if(xNewCoordinate < xCoordinate)
			movingLeft = true;
		if(yNewCoordinate < yCoordinate)
			movingUp = true;
		
		if(movingUp && !(movingRight||movingLeft)) //moving Up
		{
			for(int yCoordinateIterator = yCoordinate-1; yCoordinateIterator > yNewCoordinate; yCoordinateIterator--)
				if(isOccupied(xNewCoordinate, yCoordinateIterator))
				{
					return true;
				}
		}
		else if(movingDown && !(movingRight||movingLeft)) //moving Down
		{
			
			for(int yCoordinateIterator = yCoordinate+1; yCoordinateIterator < yNewCoordinate; yCoordinateIterator++)
				if(isOccupied(xNewCoordinate, yCoordinateIterator))
				{
					return true;
				}
		}
		else if(movingRight && !(movingUp||movingDown)) //moving Right
		{
			for(int xCoordinateIterator = xCoordinate+1; xCoordinateIterator < xNewCoordinate; xCoordinateIterator++)
				if(isOccupied(xCoordinateIterator, yNewCoordinate))
				{
					return true;
				}
		}
		else if(movingLeft && !(movingUp||movingDown)) //moving Left
		{
			for(int xCoordinateIterator = xCoordinate-1; xCoordinateIterator > xNewCoordinate; xCoordinateIterator--)
				if(isOccupied(xCoordinateIterator, yNewCoordinate))
				{
					return true;
				}
		}
		else if(movingLeft && movingUp) //moving Left+Up
		{
			for(int coordinateIterator = 0; coordinateIterator < xCoordinate-xNewCoordinate-1; coordinateIterator++)
				if(isOccupied(xCoordinate-1-coordinateIterator, yCoordinate-1-coordinateIterator))
				{
					return true;
				}
		}
		else if(movingRight && movingUp) //moving Right+Up
		{
			for(int coordinateIterator = 0; coordinateIterator < xNewCoordinate-xCoordinate-1; coordinateIterator++)
				if(isOccupied(xCoordinate+1+coordinateIterator, yCoordinate-1-coordinateIterator))
				{
					return true;
				}
		}
		else if(movingLeft && movingDown) //moving Left+Down
		{
			for(int coordinateIterator = 0; coordinateIterator < xCoordinate-xNewCoordinate-1; coordinateIterator++)
				if(isOccupied(xCoordinate-1-coordinateIterator, yCoordinate+1+coordinateIterator))
				{
					return true;
				}
		}
		else if(movingRight && movingDown) //moving Right+Down
		{
			for(int coordinateIterator = 0; coordinateIterator < xNewCoordinate-xCoordinate-1; coordinateIterator++)
			{
				if(isOccupied(xCoordinate+1+coordinateIterator, yCoordinate+1+coordinateIterator))
				{
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Checks if the inputted move will put the friendly team in check or not
	 * @param teamColor		the color of the friendly team
	 * @param xCoordinate		the xCoordinate of the piece to move
	 * @param yCoordinate		the yCoordinate of the piece to move
	 * @param xNewCoordinate	the destination in the x location
	 * @param yNewCoordinate	the destination in the y location
	 * @return boolean				true if the move will put the friendly team in check (illegal), false if not
	 */
	public boolean checkForCheck(Color teamColor, int xCoordinate, int yCoordinate, int xNewCoordinate, int yNewCoordinate) {
		boolean answer = false;
		Piece tempPiece = boardArray[yCoordinate][xCoordinate].getPiece();
		Piece newTempPiece = boardArray[yNewCoordinate][xNewCoordinate].getPiece();
		
		this.movePiece(xCoordinate, yCoordinate, xNewCoordinate, yNewCoordinate);
		
		if(teamColor.equals(Color.white))
		{
			ArrayList<Piece> enemyTeamPieces = getPieceList(Color.black);
			int whiteKingXLocation = getKingXLocation(Color.white);
			int whiteKingYLocation = getKingYLocation(Color.white);
			for(int pieceNumber = 0; pieceNumber < enemyTeamPieces.size(); pieceNumber++)
			{
				Piece pieceToCheck = enemyTeamPieces.get(pieceNumber);
				if(pieceToCheck.validMove(whiteKingXLocation, whiteKingYLocation, this))
					answer = true;
			}
		}
		else if(teamColor.equals(Color.black))
		{
			ArrayList<Piece> enemyTeamPieces = getPieceList(Color.white);
			int blackKingXLocation = getKingXLocation(Color.black);
			int blackKingYLocation = getKingYLocation(Color.black);
			for(int pieceNumber = 0; pieceNumber < enemyTeamPieces.size(); pieceNumber++)
			{
				Piece pieceToCheck = enemyTeamPieces.get(pieceNumber);
				if(pieceToCheck.validMove(blackKingXLocation, blackKingYLocation, this))
					answer = true;
			}
		}
		this.setPiece(tempPiece, xCoordinate, yCoordinate);
		this.setPiece(newTempPiece, xNewCoordinate, yNewCoordinate);
		return answer;
	}
	/**
	 * Undo the last move. Only allow an undo before the next opponent moves, and is restricted to the most recent move.
	 * @return true on successful undo, false on failure
	 */
	public boolean undo() {
		if(lastPiece == null)
			return false;
		if(lastPiece instanceof Pawn)
			((Pawn) lastPiece).setHasntMoved();
		setPiece(lastPiece, (int)previousPosition.getX(), (int)previousPosition.getY());
		lastPiece.setX((int)previousPosition.getX());
		lastPiece.setY((int)previousPosition.getY());
		setPiece(lastOtherPiece, (int)newPosition.getX(), (int)newPosition.getY());
		if(lastOtherPiece != null)
		{
			lastOtherPiece.setX((int)previousPosition.getX());
			lastOtherPiece.setY((int)previousPosition.getY());
		}
		lastPiece = null;
		lastOtherPiece = null;
		previousPosition = null;
		newPosition = null;
		return true;
	}
	public boolean pieceHasKillPotential(Color teamColor) {
		boolean answer = false;
		if(teamColor.equals(Color.white))
		{
			ArrayList<Piece> enemyTeamPieces = getPieceList(Color.black);
			int whiteKingXLocation = getKingXLocation(Color.white);
			int whiteKingYLocation = getKingYLocation(Color.white);
			for(int pieceNumber = 0; pieceNumber < enemyTeamPieces.size(); pieceNumber++)
			{
				Piece pieceToCheck = enemyTeamPieces.get(pieceNumber);
				if(pieceToCheck.validMove(whiteKingXLocation, whiteKingYLocation, this))
					answer = true;
			}
		}
		else if(teamColor.equals(Color.black))
		{
			ArrayList<Piece> enemyTeamPieces = getPieceList(Color.white);
			int blackKingXLocation = getKingXLocation(Color.black);
			int blackKingYLocation = getKingYLocation(Color.black);
			for(int pieceNumber = 0; pieceNumber < enemyTeamPieces.size(); pieceNumber++)
			{
				Piece pieceToCheck = enemyTeamPieces.get(pieceNumber);
				if(pieceToCheck.validMove(blackKingXLocation, blackKingYLocation, this))
					answer = true;
			}
		}
		return answer;
	}
	public boolean inCheckMate(Color teamColor) {
		Piece king;
		if(teamColor.equals(Color.black))
			king = getPiece(blackKingXLocation, blackKingYLocation);
		else
			king = getPiece(whiteKingXLocation, whiteKingYLocation);
		for(int x = king.getXLocation() - 1; x <= king.getXLocation()+1; x++)
			for(int y = king.getYLocation() - 1; y <= king.getXLocation()+1; y++)
				if(king.validMove(x, y, this))
					return false;
		return true;
	}
	/*
	 * Private Function for the board class
	 */
	private void setKingLocation(Color kingColor, int xCoordinate, int yCoordinate) {
		if(kingColor.equals(Color.white))
		{
			whiteKingXLocation = xCoordinate;
			whiteKingYLocation = yCoordinate;
		}
		else if(kingColor.equals(Color.black))
		{
			blackKingXLocation = xCoordinate;
			blackKingYLocation = yCoordinate;
		}
	}
	
}
