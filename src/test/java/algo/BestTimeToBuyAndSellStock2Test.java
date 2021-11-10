package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BestTimeToBuyAndSellStock2Test {

    @Test
    void maxProfit() {
        BestTimeToBuyAndSellStock2 cl = new BestTimeToBuyAndSellStock2();
        assertEquals(7, cl.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        assertEquals(4, cl.maxProfit(new int[]{1, 2, 3, 4, 5}));
        assertEquals(0, cl.maxProfit(new int[]{3, 2, 1}));
    }
}