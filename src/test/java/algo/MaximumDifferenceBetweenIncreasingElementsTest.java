package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumDifferenceBetweenIncreasingElementsTest {

    @Test
    void maximumDifference() {
        MaximumDifferenceBetweenIncreasingElements cl = new MaximumDifferenceBetweenIncreasingElements();
        assertEquals(1, cl.maximumDifference(new int[]{1, 2}));
        assertEquals(4, cl.maximumDifference(new int[]{7, 1, 5, 4}));
        assertEquals(9, cl.maximumDifference(new int[]{1, 2, 5, 10}));
    }

    @Test
    void maximumDifference_decreasing() {
        MaximumDifferenceBetweenIncreasingElements cl = new MaximumDifferenceBetweenIncreasingElements();
        assertEquals(-1, cl.maximumDifference(new int[]{2, 1}));
        assertEquals(-1, cl.maximumDifference(new int[]{7, 6, 5, 4}));
    }
}