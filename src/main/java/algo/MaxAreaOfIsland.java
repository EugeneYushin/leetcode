package algo;

public class MaxAreaOfIsland {
    /**
     * DFS solution
     * Time complexity: O(N*M)
     * Space complexity: O(N*M) to maintain stack for recursive calls
     */
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) maxArea = Math.max(maxArea, findArea(grid, r, c));
            }
        }

        return maxArea;
    }

    private int findArea(int[][] grid, int r, int c) {
        if (grid[r][c] == 0) return 0;
        grid[r][c] = 0;
        int area = 1;

        if (r - 1 >= 0) area += findArea(grid, r - 1, c);
        if (r + 1 < grid.length) area += findArea(grid, r + 1, c);
        if (c - 1 >= 0) area += findArea(grid, r, c - 1);
        if (c + 1 < grid[0].length) area += findArea(grid, r, c + 1);

        return area;
    }
}
