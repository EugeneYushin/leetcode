package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindMinimumInRotatedSortedArrayTest {

    @Test
    void findMin() {
        FindMinimumInRotatedSortedArray cl = new FindMinimumInRotatedSortedArray();
        assertEquals(1, cl.findMin(new int[]{1}));
        assertEquals(1, cl.findMin(new int[]{1, 2}));
        assertEquals(0, cl.findMin(new int[]{0, 1, 2, 3}));
        assertEquals(0, cl.findMin(new int[]{3, 0, 1, 2}));
        assertEquals(0, cl.findMin(new int[]{2, 3, 0, 1}));
        assertEquals(0, cl.findMin(new int[]{1, 2, 3, 0}));
    }
}