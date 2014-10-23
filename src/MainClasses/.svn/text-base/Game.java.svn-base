package MainClasses;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import Pieces.Piece;
/**
 * The controller of the MVC pattern. Connects the model to the view, as well as implementing
 * all the user interactability. 
 * @author Andrew
 *
 */
public class Game implements MouseListener{
	private Board gameBoard;
	private Player playerWhite;
	private Player playerBlack;
	private JFrame graphicsWindow;
	private JFrame peripheryWindow;
	private Point firstPress;
	private Color turnColor = Color.white;
	private int blackScore = 0;
	private int whiteScore = 0;
	private boolean blackRestart = false;
	private boolean whiteRestart = false;
	private JLabel players, playerTurn;
	
	/**
	 * The main gameloop, although most of the logic is actually handled by the buttons and mouse presses.
	 */
	public void gameLoop() throws IOException, InterruptedException {
		while(true)
		{
			updateGame();
			//render moved down to mouse events
			Thread.sleep(1);
		}
	}
	/**
	 * Constantly update the score and who's turn it is.
	 */
	public void updateGame() {
		playerTurn.setText("Current turn: "+ (turnColor.equals(Color.white) ? "White" : "Black"));
		players.setText("PlayerWhite vs PlayerBlack" + ": "+ whiteScore + "-" + blackScore);
	}
	/**
	 * reset the game
	 */
	public void resetGame() throws IOException {
		gameBoard = new Board();
		playerWhite = new Player(Color.white, gameBoard);
		playerBlack = new Player(Color.black, gameBoard);
		graphicsWindow.setVisible(false);
		graphicsWindow.dispose();
		graphicsWindow = new JFrame();
		graphicsWindow.setVisible(true);
		graphicsWindow.addMouseListener(this);
		ChessGUI.initialize(gameBoard, graphicsWindow);
		peripheryWindow.revalidate();
		peripheryWindow.repaint();
	
		blackRestart = false;
		whiteRestart = false;
		turnColor = Color.white;
	}
	/**
	 * Init the board, players, and graphics windows, as well as all the buttons
	 */
	@SuppressWarnings("serial")
	public void init() throws IOException, InterruptedException {
		gameBoard = new Board();
		playerWhite = new Player(Color.white, gameBoard);
		playerBlack = new Player(Color.black, gameBoard);
		
		this.graphicsWindow = new JFrame();
		this.peripheryWindow = new JFrame();
		
		peripheryWindow.setLayout(new GridLayout(7, 1));
		peripheryWindow.setVisible(true);
		peripheryWindow.setResizable(false);
		
		graphicsWindow.setResizable(false);
		graphicsWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		graphicsWindow.setVisible(true);
		graphicsWindow.addMouseListener(this);
	
		ChessGUI.initialize(gameBoard, graphicsWindow);

		JButton whiteSurrenderButton = new JButton(new AbstractAction("WhiteSurrender") {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					resetGame();
				} catch (IOException e) {
				}
				blackScore++;
				peripheryWindow.repaint();
				JOptionPane.showMessageDialog(new JFrame(), "Black has won!", "Game Over", JOptionPane.PLAIN_MESSAGE);

			}
		});
		
		JButton blackSurrenderButton = new JButton(new AbstractAction("BlackSurrender") {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					resetGame();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				whiteScore++;
				peripheryWindow.repaint();
				JOptionPane.showMessageDialog(new JFrame(), "White has won!", "Game Over", JOptionPane.PLAIN_MESSAGE);
			}
		});
		
		JButton whiteRestartButton = new JButton(new AbstractAction("WhiteRestart") {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				whiteRestart = true;
				if(whiteRestart&&blackRestart)
					try {
						resetGame();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		});
		
		JButton blackRestartButton = new JButton(new AbstractAction("BlackRestart") {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				blackRestart = true;
				if(whiteRestart&&blackRestart)
					try {
						resetGame();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		});
		
		JButton undoButton = new JButton(new AbstractAction("Undo") {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(gameBoard.undo())
					turnColor = EnumColor.getOtherColor(turnColor);
				try {
					ChessGUI.render();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		players = new JLabel("PlayerWhite vs PlayerBlack" + ": "+ whiteScore + "-" + blackScore);
		playerTurn = new JLabel("Current turn: "+ (turnColor.equals(Color.white) ? "White" : "Black"));
		peripheryWindow.add(players);
		peripheryWindow.add(playerTurn);
		peripheryWindow.add(whiteSurrenderButton);
		peripheryWindow.add(blackSurrenderButton);
		peripheryWindow.add(whiteRestartButton);
		peripheryWindow.add(blackRestartButton);
		peripheryWindow.add(undoButton);
		peripheryWindow.pack();
		gameLoop();

	}
	public static void main(String[] args) throws IOException, InterruptedException {
		Game theGame = new Game();
		theGame.init();
	}
	/**
	 * Upon mouse press, should store the location of the mouse.
	 */
	public void mousePressed(MouseEvent mouse) {
		// TODO Auto-generated method stub
		//System.out.println(mouse.getX()+","+mouse.getY());
		Point location = getBoardLocation(mouse.getX(),mouse.getY());
		firstPress = location;	
	}

	public void mouseReleased(MouseEvent mouse) {
		// TODO Auto-generated method stub
		Piece pieceAtFirstClick = gameBoard.getPiece((int) firstPress.getX(), (int) firstPress.getY());
		boolean moveSuccess = false;
		if(pieceAtFirstClick != null )
		{
			if(!pieceAtFirstClick.getColor().equals(turnColor))
				return;
			Point location = getBoardLocation(mouse.getX(),mouse.getY());
			
			if(turnColor.equals(Color.black))
				moveSuccess = playerBlack.move((int) firstPress.getX(), (int) firstPress.getY(), (int)location.getX(), (int) location.getY());
			else
				moveSuccess = playerWhite.move((int) firstPress.getX(), (int) firstPress.getY(), (int)location.getX(), (int) location.getY());			
		}
		if(moveSuccess)
			turnColor = EnumColor.getOtherColor(turnColor);
		try {
			ChessGUI.render();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(gameBoard.pieceHasKillPotential(Color.black) && gameBoard.inCheckMate(Color.black))
		{
			JOptionPane.showMessageDialog(new JFrame(), "White has won!", "Game Over", JOptionPane.PLAIN_MESSAGE);
			whiteScore++;
			try {
				resetGame();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(gameBoard.pieceHasKillPotential(Color.white) && gameBoard.inCheckMate(Color.white))
		{
			JOptionPane.showMessageDialog(new JFrame(), "Black has won!", "Game Over", JOptionPane.PLAIN_MESSAGE);
			blackScore++;
			try {
				resetGame();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 
	 * @param x	the x location of the mouse
	 * @param y the y location of the mouse
	 * @return Point the location corresponding to the mouse x and y location
	 */
	private Point getBoardLocation(int x, int y) {
		int startXLocation = 8;
		int startYLocation = 31;
		int squareSize = 70;
		int xLocation = (x-startXLocation)/squareSize;
		int yLocation = (y-startYLocation)/squareSize;
		return new Point(xLocation, yLocation);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
