package MainClasses;
import Pieces.Piece;

public class Square {

	/**
	 * This class is solely used for holding a piece. 
	 */
	private Piece occupyingPiece;
	
	public Square() {
		occupyingPiece = null;
	}
	
	/**
	 * Is this Square holding a piece
	 * @return boolean
	 */
	public boolean isOccupied() {
		return this.occupyingPiece != null;
	}
	
	/**
	 * @return Piece	the piece that this Square is holding
	 */
	public Piece getPiece() {
		return this.occupyingPiece;
	}
	
	/**
	 * Override the piece that this Square is holding with a new one
	 */
	public void setPiece(Piece newPiece) {
		this.occupyingPiece = newPiece;
	}
	
	/**
	 * Set the square to holding no piece
	 * @return	Piece	The piece that this Square was previously holding
	 */
	public Piece removePiece() {
		Piece pieceToReturn = this.occupyingPiece;
		this.occupyingPiece = null;
		return pieceToReturn;
	}
	
	
}
