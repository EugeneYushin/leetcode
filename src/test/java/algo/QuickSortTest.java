package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @Test
    void sortLomuto() {
        QuickSort quickSort = new QuickSort();
        int[] a = {9, 7, 6, 3, 4, 9, 7, 8, 5};
        quickSort.sortLomuto(a, 0, a.length - 1);
        assertArrayEquals(new int[] {3, 4, 5, 6, 7, 7, 8, 9, 9}, a);
    }
}