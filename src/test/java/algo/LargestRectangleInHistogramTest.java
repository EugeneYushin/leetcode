package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LargestRectangleInHistogramTest {

    @Test
    void largestRectangleArea() {
        LargestRectangleInHistogram cl = new LargestRectangleInHistogram();
        assertEquals(6, cl.largestRectangleArea(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        assertEquals(6, cl.largestRectangleArea(new int[]{1, 2, 3, 4}));
        assertEquals(100, cl.largestRectangleArea(new int[]{1, 2, 3, 4, 0, 0, 100}));
        assertEquals(6, cl.largestRectangleArea(new int[]{4, 3, 2, 1}));
        assertEquals(4, cl.largestRectangleArea(new int[]{2, 3}));
        assertEquals(2, cl.largestRectangleArea(new int[]{0, 2, 0}));
        assertEquals(3, cl.largestRectangleArea(new int[]{2, 1, 2}));
    }
}