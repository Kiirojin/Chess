package Pieces;
import java.awt.Color;

import MainClasses.Board;

/**
 * A standard Knight. Moves 1 in a direction and 2 in another.
 */
public class Knight extends Piece {

	
	public Knight(Color teamColor, int xCoordinate, int yCoordinate) {
		super(teamColor, xCoordinate, yCoordinate);
		// TODO Auto-generated constructor stub
	}

	@Override 
	public boolean validMove(int xNewCoordinate, int yNewCoordinate, Board gameBoard) {
		int xCoordinateDiff = Math.abs(xNewCoordinate - xCoordinate);
		int yCoordinateDiff = Math.abs(yNewCoordinate - yCoordinate);
		if(gameBoard.isValidCoordinate(getXLocation(), getYLocation(), xNewCoordinate, yNewCoordinate) == false)
			return false;
		else if(!(Math.abs(xCoordinateDiff-yCoordinateDiff) == 1 && (xCoordinateDiff == 1 || xCoordinateDiff == 2)))
			return false;
		else return !isFriendly(xNewCoordinate, yNewCoordinate, gameBoard)
			&& gameBoard.checkForCheck(teamColor, xCoordinate, yCoordinate, xNewCoordinate, yNewCoordinate) == false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Knight";
	}

	@Override
	public boolean equals(Object other) {
		if(other == null) 
			return false;
		else if(! (other instanceof Knight))
			return false;
		else
			return teamColor.equals(((Piece) other).getColor()) && xCoordinate == ((Piece) other).getXLocation() 
			&& yCoordinate == ((Piece) other).getYLocation();
		
	}

	@Override
	public String getLetterName() {
		// TODO Auto-generated method stub
		return "k";
	}
}
