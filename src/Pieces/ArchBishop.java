package Pieces;
import java.awt.Color;

import MainClasses.Board;

/**
 *A combination of a Bishop and a Knight. Can move anywhere a bishop or knight could.
 * @author Andrew
 *
 */
public class ArchBishop extends Piece {

	public ArchBishop(Color teamColor, int xCoordinate, int yCoordinate) {
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
		else if(!(Math.abs(xCoordinateDiff-yCoordinateDiff) == 1 && (xCoordinateDiff == 1 || xCoordinateDiff == 2))
				&& (xCoordinateDiff-yCoordinateDiff!= 0))
			return false;
		else return (!gameBoard.somethingInTheWay(xCoordinate, yCoordinate, xNewCoordinate, yNewCoordinate)
				&& !isFriendly(xNewCoordinate, yNewCoordinate, gameBoard))
				&& gameBoard.checkForCheck(teamColor, xCoordinate, yCoordinate, xNewCoordinate, yNewCoordinate) == false;
	}

	@Override
	public boolean equals(Object other) {
		// TODO Auto-generated method stub
		if(other == null) 
			return false;
		else if(! (other instanceof ArchBishop))
			return false;
		else
			return teamColor.equals(((Piece) other).getColor()) && xCoordinate == ((Piece) other).getXLocation() 
			&& yCoordinate == ((Piece) other).getYLocation();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ArchBishop";
	}

	@Override
	public String getLetterName() {
		// TODO Auto-generated method stub
		return "A";
	}

}
