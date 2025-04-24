package hw4.maze;

import java.util.ArrayList;

public class Row {
	/*create a list for cells*/
	private ArrayList<Cell> cells;
	
	/*each cell in the list is set to a cell in the row*/
	public Row(ArrayList<Cell> cells) {
		this.cells = cells;
	}
	
	/*getter method for cells*/
	public ArrayList<Cell> getCells() {
		return cells;
	}
	
	/*setter method for cells*/
	public void setCells(ArrayList<Cell> cells) {
		this.cells = cells;
	}
	
	
	@Override
	public String toString() {
		return "Row [cells=" + cells + "]";
	}

}
