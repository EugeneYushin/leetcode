package algo;

/**
 * https://leetcode.com/problems/cherry-pickup/
 */
public class CherryPickup {
    /**
     * Greedy solution. WON'T WORK for:
     * 1 1 0 0
     * 0 1 0 1
     * 1 1 0 0
     * 0 1 1 1
     */
    public int cherryPickup(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        int result = 0;

        dp[0][0] = grid[0][0];
        for (int i = 1; i < rows; i++) {
            dp[i][0] = grid[i][0] == -1 || dp[i - 1][0] == -1 ? -1 : grid[i][0] + dp[i - 1][0];
        }

        for (int i = 1; i < cols; i++) {
            dp[0][i] = grid[0][i] == -1 || dp[0][i - 1] == -1 ? -1 : grid[0][i] + dp[0][i - 1];
        }

        // find the 1st path (greedy)
        for (int r = 1; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                if (grid[r][c] == -1 || (dp[r-1][c] == -1 && dp[r][c-1] == -1)) {
                    dp[r][c] = -1;
                } else {
                    dp[r][c] = Math.max(dp[r - 1][c], dp[r][c - 1]) + grid[r][c];
                }
            }
        }

        if (dp[rows - 1][cols - 1] <= 0) return 0;
        result += dp[rows - 1][cols - 1];

        // traverse back
        int ri = rows - 1;
        int ci = cols - 1;

        while (ri >= 0 && ci >= 0) {
            grid[ri][ci] = 0;

            if (ri == 0) ci--;
            else if (ci == 0) ri--;
            else {
                if (dp[ri-1][ci] > dp[ri][ci-1]) ri--;
                else ci--;
            }
        }

        // find the 2nd path (greedy)
        dp[0][0] = 0;
        for (int i = 1; i < rows; i++) {
            dp[i][0] = grid[i][0] == -1 || dp[i - 1][0] == -1 ? -1 : grid[i][0] + dp[i - 1][0];
        }

        for (int i = 1; i < cols; i++) {
            dp[0][i] = grid[0][i] == -1 || dp[0][i - 1] == -1 ? -1 : grid[0][i] + dp[0][i - 1];
        }

        for (int r = 1; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                if (grid[r][c] == -1) continue;
                dp[r][c] = Math.max(dp[r - 1][c], dp[r][c - 1]) + grid[r][c];
            }
        }

        result += dp[rows - 1][cols - 1];

        return result;
    }
}
