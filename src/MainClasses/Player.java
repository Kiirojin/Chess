package MainClasses;
import java.awt.Color;
/*
 * This class is expected to be the class that player's use to play the game. All move 
 * calls should be done through this class.
 */










import Pieces.ArchBishop;
import Pieces.Bishop;
import Pieces.Camel;
import Pieces.King;
import Pieces.Knight;
import Pieces.Pawn;
import Pieces.Piece;
import Pieces.Queen;
import Pieces.Rook;

/**
 * The main interface to which pieces will be moved around on the board.
 * Ideally under normal gameplay each player would call move from this class to play the game. 
 */
public class Player {

	private Color teamColor;
	private Board gameBoard;
	
	/**
	 * Player constructor sets all of the pieces onto the board
	 * @param teamColor	The color of the player
	 * @param boardInstance	The board which the player is playing on 
	 */
	public Player(Color teamColor, Board boardInstance) {
		this.teamColor = teamColor;
		this.gameBoard = boardInstance;
		
		if(teamColor.equals(Color.white)) //instantiate all of the black pieces
		{
			gameBoard.setPiece(new Rook(teamColor, 0, 7), 0, 7);
			gameBoard.setPiece(new Rook(teamColor, 7, 7), 7, 7);
			gameBoard.setPiece(new Camel(teamColor, 1, 7), 1, 7);
			gameBoard.setPiece(new Knight(teamColor, 6, 7), 6, 7);
			gameBoard.setPiece(new ArchBishop(teamColor, 2, 7), 2, 7);
			gameBoard.setPiece(new Bishop(teamColor, 5, 7), 5, 7);
			gameBoard.setPiece(new King(teamColor, 3, 7), 3, 7);
			gameBoard.setPiece(new Queen(teamColor, 4, 7), 4, 7);
			for(int xLocation = 0; xLocation < 8; xLocation++)
				gameBoard.setPiece(new Pawn(teamColor, xLocation, 6), xLocation, 6);
		}
		else if(teamColor.equals(Color.black)) //instantiate all of the white pieces
		{
			gameBoard.setPiece(new Rook(teamColor, 0, 0), 0, 0);
			gameBoard.setPiece(new Rook(teamColor, 7, 0), 7, 0);
			gameBoard.setPiece(new Camel(teamColor, 1, 0), 1, 0);
			gameBoard.setPiece(new Knight(teamColor, 6, 0), 6, 0);
			gameBoard.setPiece(new ArchBishop(teamColor, 2, 0), 2, 0);
			gameBoard.setPiece(new Bishop(teamColor, 5, 0), 5, 0);
			gameBoard.setPiece(new King(teamColor, 3, 0), 3, 0);
			gameBoard.setPiece(new Queen(teamColor, 4, 0), 4, 0);
			for(int xLocation = 0; xLocation < 8; xLocation++)
				gameBoard.setPiece(new Pawn(teamColor, xLocation, 1), xLocation, 1);
		}
	}
	
	/**
	 * The uppermost move call. This move will call piece's move, which will verify the move and call board's move.
	 * Returns true on success and false on failure.
	 * @param xCoordinate		The initial xCoordinate of the move
	 * @param yCoordinate		The initial yCoordinate of the move
	 * @param xNewCoordinate 	The destination xCoordinate of the move
	 * @param yNewCoordinate	The destination yCoordinate of the move
	 * @return	boolean 			if the move was successful or not
	 */
	public boolean move(int xCoordinate, int yCoordinate, int xNewCoordinate, int yNewCoordinate) {
		if(!gameBoard.isOccupied(xCoordinate, yCoordinate))
			return false;
		Piece pieceToMove = gameBoard.getPiece(xCoordinate, yCoordinate);
		if(!teamColor.equals(pieceToMove.getColor()))
			return false;
		boolean moveSuccess = pieceToMove.move(xNewCoordinate, yNewCoordinate, gameBoard);
		return moveSuccess;
	}
	public Color getColor()
	{
		return teamColor;
	}

}
