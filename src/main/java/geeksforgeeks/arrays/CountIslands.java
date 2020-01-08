package geeksforgeeks.arrays;

import java.util.ArrayDeque;
import java.util.Queue;

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class CountIslands {
    // Below arrays details all 8 possible movements from a cell
    // (top, right, bottom, left and 4 diagonal moves)
    private static final int[] row = {-1, -1, -1, 0, 1, 0, 1, 1};
    private static final int[] col = {-1, 1, 0, -1, -1, 1, 0, 1};

    // Function to check if it is safe to go to position (x, y)
    // from current position. The function returns false if (x, y)
    // is not valid matrix coordinates or (x, y) represents water or
    // position (x, y) is already processed
    public static boolean isSafe(int[][] mat, int x, int y,
                                 boolean[][] processed) {
        return (x >= 0) && (x < processed.length) &&
                (y >= 0) && (y < processed[0].length) &&
                (mat[x][y] == 1 && !processed[x][y]);
    }

    public static void BFS(int[][] mat, boolean[][] processed, int i, int j) {
        // create an empty queue and enqueue source node
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(i, j));

        // mark source node as processed
        processed[i][j] = true;

        // run till queue is not empty
        while (!q.isEmpty()) {
            // pop front node from queue and process it
            int x = q.peek().x;
            int y = q.peek().y;
            q.poll();

            // check for all 8 possible movements from current cell
            // and enqueue each valid movement
            for (int k = 0; k < 8; k++) {
                // Skip if location is invalid or already processed
                // or has water
                if (isSafe(mat, x + row[k], y + col[k], processed)) {
                    // skip if location is invalid or it is already
                    // processed or consists of water
                    processed[x + row[k]][y + col[k]] = true;
                    q.add(new Pair(x + row[k], y + col[k]));
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] mat =

/*
                {
                        {1, 0, 1, 0, 0},
                        {0, 0, 0, 0, 1},
                        {1, 1, 0, 0, 0},
                        {0, 0, 1, 0, 0},
                        {1, 1, 0, 1, 0},
                        {0, 1, 0, 1, 0}
                };
*/

               {
                        {1, 0, 1, 0, 0, 0, 1, 1, 1, 1},
                        {0, 0, 1, 0, 1, 0, 1, 0, 0, 0},
                        {1, 1, 1, 1, 0, 0, 1, 0, 0, 0},
                        {1, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                        {1, 1, 1, 1, 0, 0, 0, 1, 1, 1},
                        {0, 1, 0, 1, 0, 0, 1, 1, 1, 1},
                        {0, 0, 0, 0, 0, 1, 1, 1, 0, 0},
                        {0, 0, 0, 1, 0, 0, 1, 1, 1, 0},
                        {1, 0, 1, 0, 1, 0, 0, 1, 0, 0},
                        {1, 1, 1, 1, 0, 0, 0, 1, 1, 1}
                };


        int M = mat.length;
        int N = mat[0].length;

        // stores if cell is processed or not
        boolean[][] processed = new boolean[M][N];

        int island = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                // start BFS from each unprocessed node and
                // increment island count
                if (mat[i][j] == 1 && !processed[i][j]) {
                    BFS(mat, processed, i, j);
                    island++;
                }
            }
        }

        System.out.println("Number of islands are " + island + ". ");
        System.out.println(numIsLands(mat) + " but original matrix is spoiled now.");


        // create a copy of the original array
        int[][] copyMat = new int[mat.length][mat[0].length];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
               copyMat[i][j] = mat[i][j];
            }
        }
        System.out.println(numIsLands(copyMat) + " but original matrix is spoiled now.");

    }

    /**
     * Important : if we can manipulate/update the matrix.
     * @param grid
     * @return
     */
    private static int numIsLands(int[][] grid) {
        if (grid == null) {
            return 0;
        }

        int islandCount = 0;
        // iterate throgh the grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    // increase number of island count
                    islandCount++;

                    // change any other land connected to it to zero.. given
                    // if we can manipulate/update the matrix.
                    changeLandToWater(grid, i, j);
                }
            }
        }
        return islandCount;
    }

    private static void changeLandToWater(int[][] grid, int i, int j) {
        // boundary conditions
        /*
         * 1. row < 0
         * 2. row greater than grid.length (row length)
         * 3. column < 0
         * 4. column greater than grid[0].length (column length)
         * 5. if position is a '0'
         */

        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return;
        }

        // we know that the value is a '1'
        grid[i][j] = 0;
        changeLandToWater(grid, i + 1, j); // down
        changeLandToWater(grid, i - 1, j); // up
        changeLandToWater(grid, i, j + 1); // right
        changeLandToWater(grid, i, j - 1); // left

        changeLandToWater(grid, i - 1, j - 1); // left
        changeLandToWater(grid, i + 1, j - 1); // left
        changeLandToWater(grid, i - 1, j + 1); // left
        changeLandToWater(grid, i + 1, j + 1); // left

    }
}