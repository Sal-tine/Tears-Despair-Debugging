package hw4.maze;


/**
 * single cell in a maze with four directions
 * each direction may be a wall, aperture or exit. 
 */
public class Cell{
	private CellComponents left;
	private CellComponents right;
	private CellComponents up;
	private CellComponents down;
	
	/**
	 * makes a new cell with given direction compomenents
	 * if the component is null default to wall
	 * 
	 * @param left left side of cell
	 * @param right right side of cell
	 * @param up up side of cell
	 * @param down down side of cell
	 */
	
	public Cell(CellComponents left,CellComponents right,CellComponents up,CellComponents down) {
		if(left == null) {
			this.left = CellComponents.WALL;
		} else {
			this.left = left;
		}
		
		if(right == null) {
			this.right = CellComponents.WALL;
		} else {
			this.right = right;
		}
		
		if(up == null) {
			this.up = CellComponents.WALL;
		} else {
			this.up = up;
		}
		
		if(down == null) {
			this.down = CellComponents.WALL;
		} else {
			this.down = down;
		}
	}

	/**
	 * returns the left component of cell
	 * 
	 * @return the left cell component value
	 */
	public CellComponents getLeft() {
		return left;
	}

	/**
	 * sets left component of the cell
	 * default to wall if null
	 * 
	 * @param left the new left cell component value
	 */
	public void setLeft(CellComponents left) {
		//System.out.println("setLeft called with: " + left);
		if(left == null) {
			this.left = CellComponents.WALL;
		} else {
			this.left = left;
		}
		
	}
	
	/**
	 * gets right component of the cell
	 * @return the right cell component value
	 */
	public CellComponents getRight() {
		return right;
	}
	
	/**
	 * sets right component of the cell
	 * default to wall if null
	 * 
	 * @param right the new left cell component value
	 */
	public void setRight(CellComponents right) {
		if(right == null) {
			this.right = CellComponents.WALL;
		} else {
			this.right = right;
		}
	}
	
	/**
	 * gets up component of the cell
	 * @return the down cell component value
	 */
	public CellComponents getUp() {
		return up;
	}

	/**
	 * sets up component of the cell
	 * default to wall if null
	 * 
	 * @param up the new left cell component value
	 */
	public void setUp(CellComponents up) {
		if(up == null) {
			this.up = CellComponents.WALL;
		} else {
			this.up = up;
		}
	}
	
	/**
	 * gets down component of the cell
	 * @return the down cell component value
	 */
	public CellComponents getDown() {
		return down;
	}

	/**
	 * sets down component of the cell
	 * default to wall if null
	 * 
	 * @param down the new left cell component value
	 */
	public void setDown(CellComponents down) {
		if(down == null) {
			this.down = CellComponents.WALL;
		} else {
			this.down = down;
		}
	}
	
	 /**
	  *Returns a string of the cell
	  * @return a string describing the game
	  */
	
	@Override
	public String toString() {
		String leftStr;
		String rightStr;
		String upStr;
		String downStr;
		
		if(left == null) {
			leftStr = "WALL";
		} else {
			leftStr = left.toString();
		}
		
		if(right == null) {
			rightStr = "WALL";
		} else {
			rightStr = right.toString();
		}
		
		if(up == null) {
			upStr = "WALL";
		} else {
			upStr = up.toString();
		}
		
		if(down == null) {
			downStr = "WALL";
		} else {
			downStr = down.toString();
		}
		
		
		
		return "Cell [left=" + leftStr + ", right=" + rightStr + ", up=" + upStr + ", down=" + downStr + "]";
	}
}
	
	