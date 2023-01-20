import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public interface Piece {

	/**
	 * Draws the piece on the given Graphics context
	 */
	public default void draw(Graphics g) {
		
		}
	

	/**
	 * Moves the piece if possible Freeze the piece if it cannot move down
	 * anymore
	 * 
	 * @param direction
	 *            the direction to move
	 */
	void move() ;
		
	

	
	void drop();  //DROP DOWN.  MODIFIED THE CODE FROM move()

	
	
	void rotate() ;//ROTATE.  MODIFIED THE CODE FROM move()

	
	
	
	/**
	 * Returns the (row,col) grid coordinates occupied by this Piece
	 * 
	 * @return an Array of (row,col) Points
	 */
	Point[] getLocations();
	
	

	/**
	 * Return the color of this piece
	 */
	Color getColor();
		
	
	

	/**
	 * Returns if this piece can move in the given direction
	 * 
	 */
	public default boolean canMove(Direction direction) {
		return false;
	
	}
}