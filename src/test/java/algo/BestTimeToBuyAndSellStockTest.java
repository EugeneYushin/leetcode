package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BestTimeToBuyAndSellStockTest {
    BestTimeToBuyAndSellStock cl = new BestTimeToBuyAndSellStock();

    @Test
    void maxProfit() {
        assertEquals(0, cl.maxProfit(new int[] {}));
        assertEquals(0, cl.maxProfit(new int[]{3, 2, 1}));
        assertEquals(5, cl.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    @Test
    void maxProfit_dp() {
        assertEquals(0, cl.maxProfit_dp(new int[] {}));
        assertEquals(0, cl.maxProfit_dp(new int[]{3, 2, 1}));
        assertEquals(5, cl.maxProfit_dp(new int[]{7, 1, 5, 3, 6, 4}));
    }
}