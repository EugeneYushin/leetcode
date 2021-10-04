package algo;

/**
 * https://leetcode.com/problems/island-perimeter/
 */
public class IslandPerimeter {
    private int[][] yx = new int[][]{
            new int[]{-1, 0},   // up
            new int[]{0, 1},   // right
            new int[]{1, 0},  // down
            new int[]{0, -1},  // left
    };

    /**
     * DFS-based solution
     * Time complexity: O(N^2) worst case
     * Space complexity: O(N^2) worst case to maintain stack for recursive calls
     */
    public int islandPerimeter(int[][] grid) {
        int[] startYx = findStart(grid);
        return 1 + dfs(grid, startYx[0], startYx[1], 1);
    }

    private int dfs(int[][] grid, int y, int x, int direction) {
        if (y == -1 || x == -1 || y == grid.length || x == grid[0].length || grid[y][x] == 0) return 1;
        if (grid[y][x] == -1) return 0; // already processed

        // we're on the land
        grid[y][x] = -1;    // mark as processed
        int p = 0;
        int d = 0;
        while (d < 4) {
            if (d != (direction + 2) % 4) {
                p += dfs(grid, y + yx[d][0], x + yx[d][1], d);
            }
            d++;
        }

        return p;
    }

    private int[] findStart(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * Naive, iterate over all elements 1 by 1
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     */
    public int islandPerimeter_naive(int[][] grid) {
        int p = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 0) continue;

                if (col == 0 || grid[row][col - 1] == 0) p++;
                if (col == grid[0].length - 1 || grid[row][col + 1] == 0) p++;
                if (row == 0 || grid[row - 1][col] == 0) p++;
                if (row == grid.length - 1 || grid[row + 1][col] == 0) p++;
            }
        }

        return p;
    }
}
