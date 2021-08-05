package algo;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BestTimeToBuyAndSellStock {
    /**
     * Time complexity: O(N)
     * Space complexity: O(1)
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int profit = 0;
        int minValue = prices[0];

        for (int i = 1; i < prices.length; i++) {
            // check if current value is min, or update max profit if we found the next peak
            // (if it's greater then the previous max profit)
            if (prices[i] < minValue) {
                minValue = prices[i];
            } else {
                profit = Math.max(profit, prices[i] - minValue);
            }
        }

        return profit;
    }

    /**
     * Time complexity: O(N) to fill in DP + O(N) to find Max => O(N)
     * Space complexity: O(N) for DP
     */
    public int maxProfit_dp(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int[] maxSellingPrice = new int[prices.length];
        maxSellingPrice[maxSellingPrice.length - 1] = prices[prices.length - 1];

        for (int i = maxSellingPrice.length - 2; i >= 0; i--) {
            maxSellingPrice[i] = Math.max(prices[i], maxSellingPrice[i + 1]);
        }

        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            profit = Math.max(profit, maxSellingPrice[i] - prices[i]);
        }

        return profit;
    }
}
