package algo;

/**
 * https://leetcode.com/problems/minimum-path-sum/submissions/
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        return minPathSum_ramN(grid);
    }

    public int minPathSum_ramN2(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (row == 0 && col == 0) dp[row][col] = grid[row][col];
                else if (row == 0) dp[row][col] = dp[row][col - 1] + grid[row][col];
                else if (col == 0) dp[row][col] = dp[row - 1][col] + grid[row][col];
                else dp[row][col] = Math.min(dp[row - 1][col], dp[row][col - 1]) + grid[row][col];
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }

    /**
     * The idea is to store only the most recent data in DP.
     * Col0 is being put first in DP,
     * and then Min function is applied to this value (DP[col - 1]) vs the value from the same col but previous row (DP[col]).
     * The value in DP is adjusted respectively on each col iteration
     */
    public int minPathSum_ramN(int[][] grid) {
        int[] dp = new int[grid[0].length];
        dp[0] = grid[0][0];
        for (int i = 1; i < grid[0].length; i++) {
            dp[i] = dp[i - 1] + grid[0][i];
        }

        for (int row = 1; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (col == 0) dp[col] += grid[row][col];
                else dp[col] = Math.min(dp[col], dp[col - 1]) + grid[row][col];
            }
        }

        return dp[dp.length - 1];
    }
}
