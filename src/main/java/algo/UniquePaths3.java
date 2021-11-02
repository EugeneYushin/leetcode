package algo;

/**
 * https://leetcode.com/problems/unique-paths-iii/
 */
public class UniquePaths3 {
    /**
     * Backtracking
     * Time complexity: O(3*n*m)
     * Space complexity: O(n*m)
     */
    public int uniquePathsIII(int[][] grid) {
        int startRow = 0, startCol = 0, emptySquares = 0;
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

        return traverse(grid, startRow, startCol, emptySquares + 1);
    }

    private int traverse(int[][] grid, int r, int c, int emptySquaresLeft) {
        if (r < 0 || r == grid.length || c < 0 || c == grid[0].length || grid[r][c] == -1) return 0;
        if (grid[r][c] == 2) {
            return emptySquaresLeft == 0 ? 1 : 0;
        }

        grid[r][c] = -1;
        int paths = traverse(grid, r - 1, c, emptySquaresLeft - 1) +
                traverse(grid, r + 1, c, emptySquaresLeft - 1) +
                traverse(grid, r, c - 1, emptySquaresLeft - 1) +
                traverse(grid, r, c + 1, emptySquaresLeft - 1);
        grid[r][c] = 0;

        return paths;
    }
}
