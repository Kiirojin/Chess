package Pieces;
import java.awt.Color;

import MainClasses.Board;
/**
 * The all important king. Moves 1 in any direction. Game is over if captured.
 * @author Andrew
 *
 */
public class King extends Piece {

	

	public King(Color teamColor, int xCoordinate, int yCoordinate) {
		super(teamColor, xCoordinate, yCoordinate);
		// TODO Auto-generated constructor stub
	}

	@Override 
	public boolean validMove(int xNewCoordinate, int yNewCoordinate, Board gameBoard) {
		if(gameBoard.isValidCoordinate(getXLocation(), getYLocation(), xNewCoordinate, yNewCoordinate) == false)
			return false;
		else if( !(Math.abs(xNewCoordinate - xCoordinate) <= 1 && Math.abs(yNewCoordinate - yCoordinate) <= 1))
			return false;
		else return !isFriendly(xNewCoordinate, yNewCoordinate, gameBoard)
			&& gameBoard.checkForCheck(teamColor, xCoordinate, yCoordinate, xNewCoordinate, yNewCoordinate) == false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "King";
	}

	@Override
	public boolean equals(Object other) {
		if(other == null) 
			return false;
		else if(! (other instanceof King))
			return false;
		else
			return teamColor.equals(((Piece) other).getColor()) && xCoordinate == ((Piece) other).getXLocation() 
			&& yCoordinate == ((Piece) other).getYLocation();
		
	}

	@Override
	public String getLetterName() {
		return "K";
	}
}

