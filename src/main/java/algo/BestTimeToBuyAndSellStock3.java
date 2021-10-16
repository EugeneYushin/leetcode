package algo;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii
 */
public class BestTimeToBuyAndSellStock3 {
    /**
     * Time complexity: O(kn)
     * Space complexity: O(kn)
     */
    public int maxProfit(int[] prices) {
        int[][] dp = new int[3][prices.length];
        for (int k = 1; k <= 2; k++) {
            int max = dp[k - 1][0] - prices[0];
            for (int i = 1; i < prices.length; i++) {
                dp[k][i] = Math.max(dp[k][i - 1], prices[i] + max);
                max = Math.max(max, dp[k - 1][i] - prices[i]);
            }
        }

        return dp[2][dp[0].length - 1];
    }
}
