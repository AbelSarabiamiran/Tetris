import java.awt.Color;

public class TShape extends AbstractPiece {

	
	/**
	 * An T-Shape piece in the Tetris Game.
	* This piece is made up of 4 squares in the following configuration:
 * 
 * Sq <br>
 * Sq <br>
 * Sq Sq <br>
 * 
 * The game piece "floats above" the Grid. The (row, col) coordinates are the
 * location of the middle Square on the side within the Grid
 * 
	 * @author Abel Sarabia-Miranda
	 */
	
	public TShape(int r, int c, Grid g) {
		/**
		 * Creates an T-Shape piece. See class description for actual location of r
		 * and c
		 * 
		 * @param r
		 *            row location for this piece
		 * @param c
		 *            column location for this piece
		 * @param g
		 *            the grid for this game piece
		 * 
		 */
			
		super(r, c, g);
		// TODO Auto-generated constructor stub
		
		// Create the squares
		square[0] = new Square(g, r, c - 1, Color.yellow, true);
		square[1] = new Square(g, r, c, Color.yellow, true);
		square[2] = new Square(g, r, c + 1, Color.yellow, true);
		square[3] = new Square(g, r - 1, c, Color.yellow, true);
	}
	
	/* 
	 
	 // HELP FROM F. LEPEINTRE:
	 //THIS ROTATE METHOD IS NOT NECESSARY
	 //THE CLASS AUTOMATICALLY HAS THE ROTATE METHOD BECAUSE IT EXTENDS AbstractPiece
	 //INHERITANCE  - REMEMBER?
	 //SO, ALL THIS METHOD DOES IS BLOAT THE CLASS
	 //GET RID OF IT
	  
	public void rotate(Direction direction) { //ROTATE.  GETS THE SUPER ROTATE METHOD
		
		super.rotate(direction);
				
	}
	
	*/
	
	
}