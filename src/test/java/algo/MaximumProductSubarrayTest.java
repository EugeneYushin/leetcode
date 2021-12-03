package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumProductSubarrayTest {

    @Test
    void maxProduct() {
        MaximumProductSubarray cl = new MaximumProductSubarray();
        assertEquals(6, cl.maxProduct(new int[] {2, 3, -2, 4}));
        assertEquals(0, cl.maxProduct(new int[] {-2, 0, -1}));
        assertEquals(6, cl.maxProduct(new int[] {-2, -3, -1}));
        assertEquals(-1, cl.maxProduct(new int[] {-1}));
        assertEquals(12, cl.maxProduct(new int[] {-4, -3}));
        assertEquals(6, cl.maxProduct(new int[] {3, 2}));
        assertEquals(0, cl.maxProduct(new int[] {-2, 0}));
    }
}