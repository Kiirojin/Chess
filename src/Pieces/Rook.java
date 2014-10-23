package Pieces;
import java.awt.Color;

import MainClasses.Board;
/**
 * A standard Rook. Can move in any cardinal direction infinitely.
 * @author Andrew
 *
 */
public class Rook extends Piece {

	public Rook(Color teamColor, int xCoordinate, int yCoordinate) {
		super(teamColor, xCoordinate, yCoordinate);
		// TODO Auto-generated constructor stub
	}

	@Override 
	public boolean validMove(int xNewCoordinate, int yNewCoordinate, Board gameBoard)
	{
		if(gameBoard.isValidCoordinate(getXLocation(), getYLocation(), xNewCoordinate, yNewCoordinate) == false)
			return false;
		else if(xCoordinate != xNewCoordinate && yCoordinate != yNewCoordinate)
			return false;
		else return (!gameBoard.somethingInTheWay(xCoordinate, yCoordinate, xNewCoordinate, yNewCoordinate)
						&& !isFriendly(xNewCoordinate, yNewCoordinate, gameBoard))
						&& gameBoard.checkForCheck(teamColor, xCoordinate, yCoordinate, xNewCoordinate, yNewCoordinate) == false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Rook";
	}

	@Override
	public boolean equals(Object other) {
		if(other == null) 
			return false;
		else if(! (other instanceof Rook))
			return false;
		else
			return teamColor.equals(((Piece) other).getColor()) && xCoordinate == ((Piece) other).getXLocation() 
			&& yCoordinate == ((Piece) other).getYLocation();
		
	}

	@Override
	public String getLetterName() {
		// TODO Auto-generated method stub
		return "R";
	}
}
