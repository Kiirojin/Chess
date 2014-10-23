package Pieces;
import java.awt.Color;

import MainClasses.Board;
/**
 * A standard pawn. Kills by moving 1 on a forward diagonal. Can move forward 2 if on its first move. 
 * Otherwise can only move 1 forwards.
 * @author Andrew
 *
 */
public class Pawn extends Piece {

	private boolean hasMoved = false;
	
	public Pawn(Color teamColor, int xCoordinate, int yCoordinate) {
		super(teamColor, xCoordinate, yCoordinate);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean validMove(int xNewCoordinate, int yNewCoordinate, Board gameBoard)
	{
		if(gameBoard.isValidCoordinate(getXLocation(), getYLocation(), xNewCoordinate, yNewCoordinate) == false)
		{
			return false;
		}
		boolean returnValue = false;
		if(teamColor.equals(Color.white))
		{
			if(yNewCoordinate == yCoordinate-2 && xNewCoordinate == xCoordinate)
			{
				returnValue = hasMoved == false && !gameBoard.isOccupied(xCoordinate, yCoordinate-1) && !gameBoard.isOccupied(xCoordinate, yCoordinate-2)
				&& gameBoard.checkForCheck(teamColor, xCoordinate, yCoordinate, xNewCoordinate, yNewCoordinate) == false;
			}
			else if(yNewCoordinate == yCoordinate-1 && xNewCoordinate == xCoordinate)
			{
				returnValue =  !gameBoard.isOccupied(xNewCoordinate, yNewCoordinate)
				&& gameBoard.checkForCheck(teamColor, xCoordinate, yCoordinate, xNewCoordinate, yNewCoordinate) == false;
			}
			else if(yNewCoordinate == yCoordinate-1 && (xNewCoordinate == xCoordinate-1 || xNewCoordinate == xCoordinate+1))
			{
				returnValue = isEnemy(xNewCoordinate, yNewCoordinate, gameBoard)
				&& gameBoard.checkForCheck(teamColor, xCoordinate, yCoordinate, xNewCoordinate, yNewCoordinate) == false;
			}
		}
		else if(teamColor.equals(Color.black))
		{
			if(yNewCoordinate == yCoordinate+2 && xNewCoordinate == xCoordinate)
			{
				returnValue = hasMoved == false && !gameBoard.isOccupied(xCoordinate, yCoordinate+1) && !gameBoard.isOccupied(xCoordinate, yCoordinate+2)
				&& gameBoard.checkForCheck(teamColor, xCoordinate, yCoordinate, xNewCoordinate, yNewCoordinate) == false;
			}
			else if(yNewCoordinate == yCoordinate+1 && xNewCoordinate == xCoordinate)
			{
				returnValue = !gameBoard.isOccupied(xNewCoordinate, yNewCoordinate)
				&& gameBoard.checkForCheck(teamColor, xCoordinate, yCoordinate, xNewCoordinate, yNewCoordinate) == false;
			}
			else if(yNewCoordinate == yCoordinate+1 && (xNewCoordinate == xCoordinate-1 || xNewCoordinate == xCoordinate+1))
			{
				returnValue = isEnemy(xNewCoordinate, yNewCoordinate, gameBoard)
				&& gameBoard.checkForCheck(teamColor, xCoordinate, yCoordinate, xNewCoordinate, yNewCoordinate) == false;
			}
		}
		if(returnValue == true)
			hasMoved = true;
		return returnValue;
	}
	@Override
	public String toString() {
		return "Pawn";
	}

	@Override
	public boolean equals(Object other) {
		if(other == null) 
			return false;
		else if(! (other instanceof Pawn))
			return false;
		else
			return teamColor.equals(((Piece) other).getColor()) && xCoordinate == ((Piece) other).getXLocation() 
			&& yCoordinate == ((Piece) other).getYLocation();
		
	}
	public void setHasntMoved() {
		hasMoved = false; System.out.println(hasMoved);
	}
	public String getLetterName()
	{
		return "P"; 
	}
}
