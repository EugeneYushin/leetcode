package algo;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 */
public class BestTimeToBuyAndSellStockWithCooldown {
    /**
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/75928/Share-my-DP-solution-(By-State-Machine-Thinking)
     * Time complexity: O(N)
     * Space complexity: O(1)
     */
    public int maxProfit(int[] prices) {
        int readyToBuy = 0;
        int readyToSell = -prices[0];
        int sold = 0;

        for (int i = 1; i < prices.length; i++) {
            int prevReadyToSell = readyToSell;
            readyToSell = Math.max(readyToSell, readyToBuy - prices[i]);
            readyToBuy = Math.max(readyToBuy, sold);
            sold = prevReadyToSell + prices[i];
        }

        return Math.max(readyToBuy, sold);
    }
}
