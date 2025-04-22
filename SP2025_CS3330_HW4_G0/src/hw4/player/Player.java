package hw4.player;

import hw4.maze.Cell;
import hw4.maze.Row;


/**
 * Represents the player in the maze. Holds the current row and cell.
 */

public class Player {
	private Row currentRow;
	private Cell currentCell;
	
    /**
     * Constructs a Player with a starting position.
     *
     * @param currentRow  The row the player starts in.
     * @param currentCell The cell the player starts in.
     */
	
	public Player(Row currentRow, Cell currentCell) {
		this.currentRow = currentRow;
		this.currentCell = currentCell;
	}
	
	public Row getCurrentRow() {
		return currentRow;
	}
	
	public Cell getCurrentCell() {
		return currentCell;
	}
	
	public void setCurrentRow(Row row) {
		this.currentRow = row;
	}
	
	public void setCurrentCell(Cell cell) {
		this.currentCell = cell;
	}
	
	@Override
	public String toString() {
		return "Player [currentCell=" + currentCell + ", currentRow=" + currentRow + "]";
	}

}
