package hw4.player;

import hw4.maze.*;
import java.util.List;

/**
 * Represents the player in the maze. Holds the current row and cell.
 */

public class Player {
	private Row currentRow;
	private Cell currentCell;
	private Grid grid;
	
    /**
     * Constructs a Player with a starting position.
     *
     * @param currentRow  The row the player starts in.
     * @param currentCell The cell the player starts in.
     */
	
	public Player(Row currentRow, Cell currentCell) {
		this.currentRow = currentRow;
		this.currentCell = currentCell;
		this.grid = null;
	}
	
	
	public Row getCurrentRow() {
		return currentRow;
	}


	public void setCurrentRow(Row currentRow) {
		this.currentRow = currentRow;
	}


	public Cell getCurrentCell() {
		return currentCell;
	}


	public void setCurrentCell(Cell currentCell) {
		this.currentCell = currentCell;
	}
	
	public void setGrid(Grid grid) {
	    this.grid = grid;
	}

	
	public boolean move(Movement move) {
		List<Cell> cells = currentRow.getCells();
		int curColumn = cells.indexOf(currentCell);

		int curRowIndex = -1;
		List<Row> allRows = null;

		if (grid != null) {
		    allRows = grid.getRows();
		    curRowIndex = allRows.indexOf(currentRow);
		}

		

		
		switch (move) {
		case LEFT:
		    //System.out.println("Trying LEFT, curColumn=" + curColumn + ", left=" + currentCell.getLeft());
		    
		    if (currentCell.getLeft() == CellComponents.EXIT) {
		        // special case: exit at edge of the grid
		        return true;
		    }

		    if (curColumn > 0 && currentCell.getLeft() != CellComponents.WALL) {
		        Cell target = cells.get(curColumn - 1);
		        if (target.getRight() != CellComponents.WALL) {
		            currentCell = target;
		            return true;
		        }
		    }
		    break;

			case RIGHT:
				//System.out.println("Trying RIGHT, curColumn=" + curColumn + ", right=" + currentCell.getRight());

				if(curColumn < cells.size() -1 && currentCell.getRight() != CellComponents.WALL) {
					Cell target = cells.get(curColumn +1);
					if(target.getLeft() != CellComponents.WALL) {
						currentCell = target;
						return true;
					}
				}
				break;
			case UP:
			    if (grid != null && curRowIndex > 0 && currentCell.getUp() != CellComponents.WALL) {
			        Row above = allRows.get(curRowIndex - 1);
			        Cell target = above.getCells().get(curColumn);
			        if (target.getDown() != CellComponents.WALL) {
			            currentRow = above;
			            currentCell = target;
			            return true;
			        }
			    }
			    break;

				
			case DOWN:
			    if (grid != null && curRowIndex < allRows.size() - 1 && currentCell.getDown() != CellComponents.WALL) {
			        Row below = allRows.get(curRowIndex + 1);
			        Cell target = below.getCells().get(curColumn);
			        if (target.getUp() != CellComponents.WALL) {
			            currentRow = below;
			            currentCell = target;
			            return true;
			        }
			    }
			    break;
		}
		return false;
	
	}


	@Override
	public String toString() {
		
		return "Player [currentCell=" + currentCell + ", currentRow=" + currentRow + "]";
	}

}
