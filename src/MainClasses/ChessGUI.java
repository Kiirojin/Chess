package MainClasses;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import Pieces.Bishop;
import Pieces.King;
import Pieces.Knight;
import Pieces.Pawn;
import Pieces.Piece;
import Pieces.Queen;
import Pieces.Rook;

/**
 * The view portion of the MVC model. Just renders the main game board.
 */
public class ChessGUI {

	static JFrame graphicsWindow;
	static Board gameBoard = null;
	static JPanel[][] panels;
	
	static void initialize(Board gameBoard, JFrame graphicsWindow) throws IOException {
		ChessGUI.graphicsWindow = graphicsWindow;
		graphicsWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		graphicsWindow.setVisible(true);
		graphicsWindow.setLayout(new GridLayout(gameBoard.getHeight(),gameBoard.getWidth()));
		panels = new JPanel[gameBoard.getHeight()][gameBoard.getWidth()];
		ChessGUI.gameBoard = gameBoard; 
		
		for(int yIndex = 0; yIndex < gameBoard.getHeight(); yIndex++)
		{
			for(int xIndex = 0; xIndex < gameBoard.getWidth(); xIndex++)	
			{
				ImageIcon pieceIcon;
				BufferedImage pieceImage = getImage(xIndex, yIndex, gameBoard);
				if(pieceImage != null)
					pieceIcon = new ImageIcon(getImage(xIndex, yIndex, gameBoard));
				else 
					pieceIcon = new ImageIcon();
				JPanel square = new JPanel();
				square.add(new JLabel(pieceIcon));
				if(xIndex%2 != yIndex%2)
					square.setBackground(new Color(215, 149, 91));
				else
					square.setBackground(new Color(255, 212, 173));
				graphicsWindow.add(square);
				panels[yIndex][xIndex] = square;
			}
		}
		graphicsWindow.pack();
		
	}
	/**
	 * rerenders the board
	 * @param gameBoard the board to render
	 * @throws IOException 
	 */
	static void render() throws IOException {
		if(gameBoard == null || panels == null)
			return;
		for(int yIndex = 0; yIndex < gameBoard.getHeight(); yIndex++)
		{
			for(int xIndex = 0; xIndex < gameBoard.getWidth(); xIndex++)	
			{
				if(panels[yIndex][xIndex] == null)
					return;
				ImageIcon pieceIcon;
				BufferedImage pieceImage = getImage(xIndex, yIndex, gameBoard);
				if(pieceImage != null)
					pieceIcon = new ImageIcon(getImage(xIndex, yIndex, gameBoard));
				else 
					pieceIcon = new ImageIcon();
				if(panels[yIndex][xIndex] != null)
				{
					panels[yIndex][xIndex].removeAll();
					panels[yIndex][xIndex].add(new JLabel(pieceIcon));
					panels[yIndex][xIndex].revalidate();	
				}
				
			}
		}
		graphicsWindow.repaint();
		return;
		
	}

	/**
	 * Returns the appropriate image asset for given coordinate
	 * @param	int xCoordinate	the x coordinate to the gameBoard
	 * @param 	int yCoordinate	the y coordinate to the gameBoard
	 * @param 	Board gameBoard	the gameBoard which to read the image 
	 * @return 	BufferedImage	the image associated with those coordinates on the board
	 */
	private static BufferedImage getImage(int xCoordinate, int yCoordinate, Board gameBoard) throws IOException {
		Piece pieceToCheck = gameBoard.getPiece(xCoordinate, yCoordinate);
		if(pieceToCheck == null)
			return null;
		else if(pieceToCheck.getColor().equals(Color.black))
			return ImageIO.read(new File("Images\\Black"+pieceToCheck.toString()+".png"));
		else 
			return ImageIO.read(new File("Images\\White"+pieceToCheck.toString()+".png"));
		
	}
	
}
