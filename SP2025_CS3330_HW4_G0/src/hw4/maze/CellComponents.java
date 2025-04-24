package hw4.maze;

/**
 * the components of the maze cell in any of the directions
 * 
 */
public enum CellComponents {
	/**
	 * Wall movement. Blocked in this direction
	 */
	WALL,
	
	/**
	 * APERTURE movement. Allowed in this direction
	 */
	APERTURE, 
	
	/**
	 * EXIT!!! leads out of maze in this direction
	 */
	EXIT,
}
