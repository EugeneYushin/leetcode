package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KthLargestElementInArrayTest {

    @Test
    void findKthLargest_heap() {
        KthLargestElementInArray cl = new KthLargestElementInArray();
        assertEquals(5, cl.findKthLargest_heap(new int[]{3, 2, 1, 5, 6, 4}, 2));
        assertEquals(1, cl.findKthLargest_heap(new int[]{1}, 1));
    }

    @Test
    void findKthLargest_sort() {
        KthLargestElementInArray cl = new KthLargestElementInArray();
        assertEquals(5, cl.findKthLargest_sort(new int[]{3, 2, 1, 5, 6, 4}, 2));
        assertEquals(1, cl.findKthLargest_sort(new int[]{1}, 1));
    }

    @Test
    void findKthLargest_quickselect() {
        KthLargestElementInArray cl = new KthLargestElementInArray();
        assertEquals(5, cl.findKthLargest_quickselect(new int[]{3, 2, 1, 5, 6, 4}, 2));
        assertEquals(1, cl.findKthLargest_quickselect(new int[]{1}, 1));
    }
}