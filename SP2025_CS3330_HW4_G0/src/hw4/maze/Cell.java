package hw4.maze;

public class Cell{
	private CellComponents left;
	private CellComponents right;
	private CellComponents up;
	private CellComponents down;
	
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

	public CellComponents getLeft() {
		return left;
	}

	public void setLeft(CellComponents left) {
		//System.out.println("setLeft called with: " + left);
		if(left == null) {
			this.left = CellComponents.WALL;
		} else {
			this.left = left;
		}
		
	}

	public CellComponents getRight() {
		return right;
	}

	public void setRight(CellComponents right) {
		if(right == null) {
			this.right = CellComponents.WALL;
		} else {
			this.right = right;
		}
	}

	public CellComponents getUp() {
		return up;
	}

	public void setUp(CellComponents up) {
		if(up == null) {
			this.up = CellComponents.WALL;
		} else {
			this.up = up;
		}
	}

	public CellComponents getDown() {
		return down;
	}

	public void setDown(CellComponents down) {
		if(down == null) {
			this.down = CellComponents.WALL;
		} else {
			this.down = down;
		}
	}
	
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
	
	