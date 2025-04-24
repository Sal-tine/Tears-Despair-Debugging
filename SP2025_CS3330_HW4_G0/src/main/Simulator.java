package main;

import hw4.maze.*;

import hw4.game.*;

import hw4.player.*;



import java.util.ArrayList;



public class Simulator {
	
	/*initialized the grid*/
    public static void main(String[] args) {

        // Create a 5x5 grid manually

        ArrayList<Row> rows = new ArrayList<>();



        for (int i = 0; i < 5; i++) {

            ArrayList<Cell> cells = new ArrayList<>();

            for (int j = 0; j < 5; j++) {

                // Use S = APERTURE for all directions

                Cell cell = new Cell(CellComponents.APERTURE, CellComponents.APERTURE,

                                     CellComponents.APERTURE, CellComponents.APERTURE);

                cells.add(cell);

            }

            rows.add(new Row(cells));

        }



        // Set Exit on top-left

        rows.get(0).getCells().get(0).setLeft(CellComponents.EXIT);



        // Place Player (agent) at bottom-right

        Cell agentCell = rows.get(4).getCells().get(4);

        Row agentRow = rows.get(4);

        Player player = new Player(agentRow, agentCell);



        // Initialize Game

        Grid grid = new Grid(rows);

        Game game = new Game(grid);



        // Display initial grid

        System.out.println("Initial Grid:");

        displayGrid(grid, player);



        // Move UP

        game.play(Movement.UP, player);



        // Display grid after moving UP

        System.out.println("\nGrid After Agent Moved UP:");

        displayGrid(grid, player);

    }


    /*displays the grid*/
    public static void displayGrid(Grid grid, Player player) {

        for (Row row : grid.getRows()) {

            for (Cell cell : row.getCells()) {

                if (cell == player.getCurrentCell()) {

                    System.out.print("A ");

                } else if (cell.getLeft() == CellComponents.EXIT) {

                    System.out.print("E ");

                } else {

                    System.out.print("S ");

                }

            }

            System.out.println();

        }

    }

}