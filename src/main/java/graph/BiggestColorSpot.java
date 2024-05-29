package graph;

import java.util.Random;

public class BiggestColorSpot {

    public int determineBiggestColorSpot(int[][] grid) {
        int biggestColorSpot = 0;
        int numRows = grid.length;
        int numCols = grid[0].length;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (grid[i][j] > 0) {
                    int colorSpotSize = computeColorSpot(grid, i, j, grid[i][j]);
                    biggestColorSpot = Math.max(biggestColorSpot, colorSpotSize);
                }
            }
        }
        return biggestColorSpot;
    }

    private int computeColorSpot(int[][] grid, int i, int j, int color) {
        if (i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || grid[i][j] != color) {
            return 0;
        }
        //Mark as visited by flipping to negative
        grid[i][j] = -grid[i][j];
        //Explore neighbours cells for same color
        int size = computeColorSpot(grid, i + 1, j, color) + computeColorSpot(grid, i - 1, j, color) +
                computeColorSpot(grid, i, j - 1, color) + computeColorSpot(grid, i, j + 1, color);
        return size + 1;
    }

    public static void main(String... args) {
        int cols = 5;

        int rows = 5;
        int colors = 3; // a spot can have the colors 1, 2 or 3

        Random rnd = new Random();

        int[][] a = new int[rows][cols];

        // add random colors
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                a[i][j] = 1 + rnd.nextInt(colors);
            }
        }

        // show the surface on screen
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(a[i][j] + "  ");
            }
            System.out.println();
        }

        BiggestColorSpot spots = new BiggestColorSpot();

        System.out.println("Biggest Color Spot: " + spots.determineBiggestColorSpot(a));
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(a[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
