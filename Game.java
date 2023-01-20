import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

/**
 * Manages the game Tetris. Keeps track of the current piece and the grid.
 * Updates the display whenever the state of the game has changed.
 * 
 * @author CSC 143 Abel Sarabia-Miranda
 */
public class Game {

	private Grid grid; // the grid that makes up the Tetris board

	private Tetris display; // the visual for the Tetris game

	private AbstractPiece piece; 

	private boolean isOver; // has the game finished?

	
	private int randomPieceNum;

	Random rand = new Random();

	/**
	 * Creates a Tetris game
	 * 
	 * @param Tetris
	 *            the display
	 */
	public Game(Tetris display) {
		grid = new Grid();
		this.display = display;
		randomPieceNum = rand.nextInt(7) + 1; // from 1 to 7 for case numbers below
		// grabs random case # to display on window
		newRandomPiece(randomPieceNum);

		isOver = false;
	}


	public AbstractPiece newRandomPiece(int randomPieceNum) {

		switch (randomPieceNum) {

		case 1:
			piece = new LShape(1, Grid.WIDTH / 2 - 1, grid);
			break;

		case 2:
			piece = new JShape(1, Grid.WIDTH / 2 - 1, grid);
			break;

		case 3:
			piece = new ZShape(1, Grid.WIDTH / 2 - 1, grid);
			break;

		case 4:
			piece = new TShape(1, Grid.WIDTH / 2 - 1, grid);
			break;

		case 5:
			piece = new SquareShape(1, Grid.WIDTH / 2 - 1, grid);
			break;

		case 6:
			piece = new BarShape(1, Grid.WIDTH / 2 - 1, grid);
			break;

		case 7:
			piece = new SShape(1, Grid.WIDTH / 2 - 1, grid);
			break;

		}

		return piece;

	}

	/**
	 * Draws the current state of the game
	 * 
	 * @param g
	 *            the Graphics context on which to draw
	 */
	public void draw(Graphics g) {
		grid.draw(g);
		if (piece != null) {
			piece.draw(g);
		}
	}

	/**
	 * Moves the piece in the given direction
	 * 
	 * @param the
	 *            direction to move
	 */
	public void movePiece(Direction direction) {
		if (piece != null) {
			if (direction == Direction.ROTATE) {
				
				piece.rotate(direction);
			} else {
				piece.move(direction);
			}
		}
		updateDisplay();
		/*
		 * updatePiece(); display.update(); grid.checkRows();
		 */
	}

	public void dropPiece(Direction direction) {
		if (piece != null) {
			piece.drop(direction);
		}
		updateDisplay();
		/*
		 * updatePiece(); display.update(); grid.checkRows();
		 */
	}

	public void rotatePiece(Direction direction) {
		if (piece != null) {
			piece.rotate(direction);
		
		}
		updateDisplay();
	}


	public void updateDisplay() {
		updatePiece();
		display.update();
		grid.checkRows();
	}

	/**
	 * Returns true if the game is over
	 */
	public boolean isGameOver() {
		// game is over if the piece occupies the same space as some non-empty
		// part of the grid. Usually happens when a new piece is made
		if (piece == null) {
			return false;
		}

		// check if game is already over
		if (isOver) {
			return true;
		}

		// check every part of the piece
		Point[] p = piece.getLocations();
		for (int i = 0; i < p.length; i++) {
			if (grid.isSet((int) p[i].getX(), (int) p[i].getY())) {
				isOver = true;
				return true;
			}
		}
		return false;
	}

	/** Updates the piece */
	private void updatePiece() {
		if (piece == null) {
			//Creates new piece using random
			randomPieceNum = rand.nextInt(7) + 1;
			newRandomPiece(randomPieceNum);
		}

		// set Grid positions corresponding to frozen piece
		// and then release the piece
		else if (!piece.canMove(Direction.DOWN)) {
			Point[] p = piece.getLocations();
			Color c = piece.getColor();
			for (int i = 0; i < p.length; i++) {
				grid.set((int) p[i].getX(), (int) p[i].getY(), c);
			}
			piece = null;
		}

		

	}

}
