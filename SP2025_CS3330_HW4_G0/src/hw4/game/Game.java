package hw4.game;

import hw4.maze.Cell;
import hw4.maze.CellComponents;
import hw4.maze.Grid;
import hw4.maze.Row;
import hw4.player.Movement;
import hw4.player.Player;

import java.util.ArrayList;
import java.util.Random;

/**
 * The {@code Game} class controls the maze game logic by intializing a maze
 * movement and play actions.
 */

public class Game{
	
	private Grid grid;
	private static final int MinGrid = 3;
	private static final int MaxGrid = 7;
	
	/**
	 * Makes a game with grid
	 * 
	 * @param grid the grid to be used for the game
	 */
	public Game(Grid grid) {
		this.grid = grid;
	}
	
	/**
	 * creates a game with a random size grid between 3 and 7.
	 * if the grid is outside the range it'll be null
	 * 
	 * @param size the size of the grid
	 */
	
	public Game(int size) {
		if(size >= MinGrid && size <= MaxGrid) {
			this.grid = createRandomGrid(size);
		} else {
			this.grid = null;
		}
	}
	
	
	/**
	 * returns current grid.
	 * @return the games grid
	 */
	 public Grid getGrid() {
	        return grid;
	    }
	 /**
	  * Sets a new grid.
	  * @param grid the grid to be used
	  */
	 public void setGrid(Grid grid) {
	        this.grid = grid;
	    }
	 
	 
	 /**
	  * creates grid with wall and aperture consistency.
	  * makes sure there is always one exit cell on the left most side.
	  * 
	  * @param size the size of the grid.
	  * @return the generated grid. Or null if size was too big.
	  */
	 public Grid createRandomGrid(int size) {
		 if (size < MinGrid || size > MaxGrid) {
			 return null;
		 }
		 
		 Random rand = new Random();
		 ArrayList<Row> rows = new ArrayList<>();
		 
		 for(int i = 0; i < size; i++) {
			 ArrayList<Cell> cells = new ArrayList<>();
			 for(int j = 0; j < size; j++) {
				 CellComponents left = null;
				 CellComponents right = null;
				 CellComponents up = null;
				 CellComponents down = null;
				 
				 if(j == 0) {
					 left = CellComponents.WALL;
				 } else {
					 left = cells.get(j - 1).getRight();
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
					 up = rows.get(i -1).getCells().get(j).getDown();
				 }
				 
				 if(right == null) {
					 if(rand.nextBoolean()) {
						 right = CellComponents.WALL;
					 } else {
						 right = CellComponents.APERTURE;
					 }
				 }
				 if(down == null) {
					 if(rand.nextBoolean()) {
						 down = CellComponents.WALL;
					 } else {
						 down = CellComponents.APERTURE;
					 }
				 }
				 
				 Cell cell = new Cell(left,right,up,down);
				 cells.add(cell);
			
			 }
			 Row row = new Row(cells);
			 rows.add(row);
		 }
		 
		 int exitRow = rand.nextInt(size);
		 Cell exitCell= rows.get(exitRow).getCells().get(0);
		 exitCell.setLeft(CellComponents.EXIT);
		 
		 return new Grid(rows);
	 }
	 /**
		 * moves the player in the direction specified
		 * @param move the movement direction
		 * @param player the player that is moving
		 * @return true if the movement worked, otherwise false
		 */
	 public boolean play(Movement move, Player player) {
		    if (move == null || player == null) {
		        return false;
		    }

		    player.setGrid(grid); // inject the grid every time

		    boolean result = player.move(move);
		    //System.out.println("Attempted move: " + move + " → " + result);
		    return result;
		}

	 /**
	  *Returns a string of the game
	  * @return a string describing the game
	  */
	 @Override
	 public String toString() {
		 return "Game [grid=" + grid + "]";
	 }
	    
}