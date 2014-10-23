package Pieces;
import java.awt.Color;

import MainClasses.Board;

/**
 * An ordinary bishop. Moves in any diagonal direction.
 * @author Andrew
 *
 */
public class Bishop extends Piece {


	public Bishop(Color teamColor, int xCoordinate, int yCoordinate) {
		super(teamColor, xCoordinate, yCoordinate);
		// TODO Auto-generated constructor stub
	}

	@Override 
	public boolean validMove(int xNewCoordinate, int yNewCoordinate, Board gameBoard) {
		
		if(gameBoard.isValidCoordinate(getXLocation(), getYLocation(), xNewCoordinate, yNewCoordinate) == false)
			return false;
		else if(Math.abs(xNewCoordinate - xCoordinate) - Math.abs(yNewCoordinate - yCoordinate) != 0)
		{
			return false;
		}
		else 
		{
			return (!gameBoard.somethingInTheWay(xCoordinate, yCoordinate, xNewCoordinate, yNewCoordinate)
			&& !isFriendly(xNewCoordinate, yNewCoordinate, gameBoard))
			&& gameBoard.checkForCheck(teamColor, xCoordinate, yCoordinate, xNewCoordinate, yNewCoordinate) == false;
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Bishop";
	}

	@Override
	public boolean equals(Object other) {
		if(other == null) 
			return false;
		else if(! (other instanceof Bishop))
			return false;
		else
			return teamColor.equals(((Piece) other).getColor()) && xCoordinate == ((Piece) other).getXLocation() 
			&& yCoordinate == ((Piece) other).getYLocation();
		
	}
	@Override
	public String getLetterName()
	{
		return "B"; 
	}
}
