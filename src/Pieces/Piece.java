package Pieces;
import java.awt.Color;

import MainClasses.Board;
/**
 * This is the super class for all of the different types of Pieces. Contains most of the
 * code and logic associated with how a piece is supposed to behave.
 */
public abstract class Piece {
	
	protected Color teamColor;
	protected int xCoordinate;
	protected int yCoordinate;
	
	public Piece(Color teamColor, int xCoordinate, int yCoordinate) {
		this.teamColor = teamColor;
		this.xCoordinate = xCoordinate; 
		this.yCoordinate = yCoordinate;
	}

	/**
	 * This is where most of the individuality of pieces is contained. Tests if a move is valid or not
	 * @param xNewCoordinate	the destination xCoordinate of the move
	 * @param yNewCoordinate	the destination yCoordinate of the move
	 * @param gameBoard		the board which the move is being made on
	 * @return	if the move is valid or not
	 */
	public abstract boolean validMove(int xNewCoordinate, int yNewCoordinate, Board gameBoard);
	
	/**
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public abstract boolean equals(Object other);
	
	/**
	 * @return	return what kind of Piece it is
	 */
	public abstract String toString();
	
	/**
	 * This base move algorithm is used by all of the individual types of pieces
	 * @param xNewCoordinate	the destination xCoordinate of the move
	 * @param yNewCoordinate	the destination yCoordinate of the move
	 * @param gameBoard		the board which the move is being made on
	 */
	public boolean move(int xNewCoordinate, int yNewCoordinate, Board gameBoard) {
		if(validMove(xNewCoordinate, yNewCoordinate, gameBoard))
		{
			gameBoard.movePiece(this.xCoordinate,this.yCoordinate, xNewCoordinate, yNewCoordinate);
			xCoordinate = xNewCoordinate;
			yCoordinate = yNewCoordinate;
			return true;			
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * @return Color The color of the piece
	 */
	public Color getColor() {
		return teamColor;
	}
	
	/**
	 * @return	int	The xCoordinate of the piece
	 */
	public int getXLocation() {
		return xCoordinate;
	}
	
	/**
	 * @return int	The yCoordinate of the piece
	 */
	public int getYLocation() {
		return yCoordinate;
	}
	
	/**
	 * sets the internal X location of the piece
	 * @param location	value to set x
	 */
	public void setX(int location) {
		xCoordinate = location;
	}
	/**
	 * sets the internal Y location of the piece
	 * @param location	value to set y
	 */
	public void setY(int location) {
		yCoordinate = location;
	}
	/**
	 * The following four functions ascertain if another piece is friendly or an enemy.
	 * @return boolean	whether the other piece is an enemy
	 */
	public boolean isEnemy(Piece targetPiece) {
		if(targetPiece == null)
		{
			return false; 
		}
		
		return !teamColor.equals(targetPiece.teamColor);
	}
	
	public boolean isEnemy(int xCoordinate,int yCoordinate, Board gameBoard) {
		if(gameBoard.isOccupied(xCoordinate, yCoordinate) == false) 
		{
			
			return false;
		}
		
		return !teamColor.equals(gameBoard.getPiece(xCoordinate, yCoordinate).teamColor);
	}
	
	public boolean isFriendly(Piece targetPiece) {
		if(targetPiece == null)
		{
			return false; 
		}
		
		return teamColor.equals(targetPiece.teamColor);
	}
	
	public boolean isFriendly(int xCoordinate,int yCoordinate, Board gameBoard) {
		if(gameBoard.isOccupied(xCoordinate, yCoordinate) == false) 
		{
			return false; 
		}
		return teamColor.equals(gameBoard.getPiece(xCoordinate, yCoordinate).teamColor);
	}
	
	/**
	 * @return String	Single letter abbreviation of the piece name
	 */
	public abstract String getLetterName(); 
}
