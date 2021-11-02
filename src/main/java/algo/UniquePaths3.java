package algo;

/**
 * https://leetcode.com/problems/unique-paths-iii/
 */
public class UniquePaths3 {
    private int uniquePaths;
    private int emptySquares;

    /**
     * Backtracking
     * Time complexity: O(3*n*m)
     * Space complexity: O(n*m)
     */
    public int uniquePathsIII(int[][] grid) {
        uniquePaths = 0;
        emptySquares = 0;

        int startRow = 0, startCol = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    startRow = r;
                    startCol = c;
                } else if (grid[r][c] == 0) {
                    emptySquares++;
                }
            }
        }

        traverse(grid, startRow, startCol, -1);
        return uniquePaths;
    }

    private void traverse(int[][] grid, int r, int c, int count) {
        if (r < 0 || r == grid.length || c < 0 || c == grid[0].length || grid[r][c] == -1) return;
        if (grid[r][c] == 2) {
            if (count == emptySquares) uniquePaths++;
            return;
        }

        grid[r][c] = -1;
        traverse(grid, r - 1, c, count + 1);
        traverse(grid, r + 1, c, count + 1);
        traverse(grid, r, c - 1, count + 1);
        traverse(grid, r, c + 1, count + 1);
        grid[r][c] = 0;
    }
}
