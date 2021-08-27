package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindFirstAndLastPositionOfElementInSortedArrayTest {

    @Test
    void searchRange() {
        FindFirstAndLastPositionOfElementInSortedArray cl = new FindFirstAndLastPositionOfElementInSortedArray();
        assertArrayEquals(new int[]{-1, -1}, cl.searchRange(new int[]{}, 1));
        assertArrayEquals(new int[]{-1, -1}, cl.searchRange(new int[]{1, 2, 3}, 4));
        assertArrayEquals(new int[]{0, 0}, cl.searchRange(new int[]{1, 2, 3}, 1));
        assertArrayEquals(new int[]{3, 4}, cl.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8));
        assertArrayEquals(new int[]{3, 5}, cl.searchRange(new int[]{5, 7, 7, 8, 8, 8}, 8));
        assertArrayEquals(new int[]{2, 5}, cl.searchRange(new int[]{5, 7, 8, 8, 8, 8}, 8));
    }
}