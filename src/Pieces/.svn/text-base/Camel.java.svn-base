package Pieces;
import java.awt.Color;

import MainClasses.Board;

/**
 * An elongated knight. Moves 1 in one direction and 3 in the other.
 * @author Andrew
 *
 */
public class Camel extends Piece {

	public Camel(Color teamColor, int xCoordinate, int yCoordinate) {
		super(teamColor, xCoordinate, yCoordinate);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean validMove(int xNewCoordinate, int yNewCoordinate,
			Board gameBoard) {
		int xCoordinateDiff = Math.abs(xNewCoordinate - xCoordinate);
		int yCoordinateDiff = Math.abs(yNewCoordinate - yCoordinate);
		if(gameBoard.isValidCoordinate(getXLocation(), getYLocation(), xNewCoordinate, yNewCoordinate) == false)
			return false;
		else if(!(Math.abs(xCoordinateDiff-yCoordinateDiff) == 2 && (xCoordinateDiff == 1 || xCoordinateDiff == 3)))
			return false;
		else return !isFriendly(xNewCoordinate, yNewCoordinate, gameBoard)
			&& gameBoard.checkForCheck(teamColor, xCoordinate, yCoordinate, xNewCoordinate, yNewCoordinate) == false;
	}

	@Override
	public boolean equals(Object other) {
		if(other == null) 
			return false;
		else if(! (other instanceof Camel))
			return false;
		else
			return teamColor.equals(((Piece) other).getColor()) && xCoordinate == ((Piece) other).getXLocation() 
			&& yCoordinate == ((Piece) other).getYLocation();
	}

	@Override
	public String toString() {
		return "Camel";
	}

	@Override
	public String getLetterName() {
		return "C";
	}

}
