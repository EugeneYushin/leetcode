package algo;

public class PerfectSquares {
    /**
     * DP solution
     * Time complexity: O(n*sqrt(n))
     * Space complexity: O(n)
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[dp.length - 1];
    }
}
