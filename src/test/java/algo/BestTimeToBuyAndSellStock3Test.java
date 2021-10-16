package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BestTimeToBuyAndSellStock3Test {

    @Test
    void maxProfit() {
        BestTimeToBuyAndSellStock3 cl = new BestTimeToBuyAndSellStock3();
        assertEquals(6, cl.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
    }
}