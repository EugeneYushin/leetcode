package algo;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class BestTimeToBuyAndSellStock2 {
    /**
     * Find the areas of growth, adds the heights of this areas to profit
     * Time complexity: O(N)
     * Space complexity: O(1)
     */
    public int maxProfit(int[] prices) {
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) profit += prices[i] - prices[i - 1];
        }

        return profit;
    }

    /**
     * 2 pointers
     * Find the areas of growth, adds the heights of this areas to profit
     * Time complexity: O(N)
     * Space complexity: O(1)
     */
    public int maxProfit_2pointers(int[] prices) {
        if (prices.length < 2) return 0;

        int i = 0;
        int j = 1;

        int profit = 0;

        while (j < prices.length) {
            if (prices[j - 1] > prices[j]) {
                // it's time to sell
                profit += prices[j - 1] - prices[i];
                i = j;
            }
            j++;
        }

        if (prices[i] < prices[j - 1]) profit += prices[j - 1] - prices[i];

        return profit;
    }
}
