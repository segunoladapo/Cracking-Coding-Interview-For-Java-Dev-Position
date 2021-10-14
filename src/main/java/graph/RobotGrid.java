package graph;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class RobotGrid {

    public static boolean computePath(int m, int n, boolean[][] maze, List<Point> paths) {
        System.out.println("Entering Computing Path...");
        if (m < 0 || n < 0) {
            return false;
        }

        if (maze[m][n]) {
            return false;
        }
        if ((m == 0 && n == 0) || computePath(m - 1, n, maze, paths) || computePath(m, n - 1, maze, paths)) {
            paths.add(new Point(m, n));
            return true;
        }
        return false;
    }


    public static void main(String... args) {
        List<Point> paths = new ArrayList<>();
        boolean[][] maze = new boolean[6][6];
        System.out.println(maze[3][0]);
       // maze[0][0] = true;
        // maze[5][5] = true;
        maze[4][5] = true;
        maze[4][4] = true;
        maze[3][4] = true;
        maze[3][3] = true;
        maze[3][2] = true;
        maze[3][1] = true;
        maze[2][1] = true;
        maze[1][1] = true;
        maze[0][1] = true;
        computePath(5, 5, maze, paths);
        System.out.println(paths);
    }
}
