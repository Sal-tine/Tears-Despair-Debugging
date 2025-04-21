package hw4.game;

import hw4.maze.Cell;
import hw4.maze.CellComponents;
import hw4.maze.Grid;
import hw4.maze.Row;
import hw4.player.Movement;
import hw4.player.Player;

import java.util.ArrayList;
import java.util.Random;


public class Game{
	
	private Grid grid;
	private static final int MinGrid = 3;
	private static final int MaxGrid = 7;
	
	public Game(Grid grid) {
		this.grid = grid;
	}
	
	public Game(int size) {
		if(size >= MinGrid && size <= MaxGrid) {
			this.grid = randomGrid(size);
		} else {
			this.grid = null;
		}
	}
	
	 public Grid getGrid() {
	        return grid;
	    }

	 public void setGrid(Grid grid) {
	        this.grid = grid;
	    }
	 public Grid randomGrid(int size) {
		 if (size < MinGrid || size > MaxGrid) {
			 return null;
		 }
		 
		 Random rand = new Random();
		 ArrayList<Row> rows = new ArrayList<>();
		 
		 for(int i = 0; i < size; i++) {
			 ArrayList<Cell> cells = new Arraylist<>();
			 for(int j = 0; j < size; j++) {
				 CellComponents left = null;
				 CellComponents right = null;
				 CellComponents up = null;
				 CellComponents down = null;
				 
				 if(j == 0) {
					 left = CellComponents.WALL;
				 }
				 if(j == size - 1) {
					 right = CellComponents.WALL;
				 }
				 if(i == 0) {
					 up = CellComponents.WALL;
				 }
				 if(i == 0) {
					 down = CellComponents.WALL;
				 }
				 
				 if(i >0) {
					 up = rows.get(i -1).getCells().get(j).getDown()
				 }
				 
				 if(right == null) {
					 if(rand.nextBoolean()) {
						 right = CellComponents.WALL;
					 } else {
						 right = CellComponents.APERATURE;
					 }
				 }
				 if(down == null) {
					 if(rand.nextBoolean()) {
						 down = CellComponents.WALL;
					 } else {
						 down = CellComponents.APERATURE;
					 }
				 }
				 
				 Cell cell = new Cell(left,right,up,down);
				 cells.add(cell);
			
			 }
			 Row row = new row(cells);
			 rows.add(row);
		 }
		 
		 int exitRow = rand.nextInt(size);
		 Cell exitCell= rows.get(exitrow).getCells().get(0);
		 exitCell.setleft(CellComponents.EXIT);
		 
		 return new Grid(rows);
	 }
	 
	 public boolean play(Movement move, Player player) {
		 if(move == null || player == null) {
			 return false;
		 }
		 return player.move(move);
	 }
	 
	 @Override
	 public String toString() {
		 return "Game [grid=" + grid + "]";
	 }
	    
}