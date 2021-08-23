package algo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortedArrayTest {

    @Test
    void merge() {
        MergeSortedArray cl = new MergeSortedArray();
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        cl.merge(
                nums1, 3,
                new int[]{2, 5, 6}, 3
        );
        assertArrayEquals(new int[]{1, 2, 2, 3, 5, 6}, nums1);

        nums1 = new int[] {1};
        cl.merge(
                nums1, 1,
                new int[]{}, 0
        );
        assertArrayEquals(new int[]{1}, nums1);

        nums1 = new int[] {0};
        cl.merge(
                nums1, 0,
                new int[]{1}, 1
        );
        assertArrayEquals(new int[]{1}, nums1);

        nums1 = new int[] {4,0,0,0,0,0};
        cl.merge(
                nums1, 1,
                new int[]{1,2,3,5,6}, 5
        );
        System.out.println("nums1 = " + Arrays.toString(nums1));
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, nums1);
    }

    @Test
    void merge_consequently_sorted() {
        MergeSortedArray cl = new MergeSortedArray();
        int[] nums1 = new int[] {1, 2, 3, 0, 0, 0};
        cl.merge(
                nums1, 3,
                new int[]{4, 5, 6}, 3
        );
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, nums1);
    }

    @Test
    void merge_consequently_sorted_reversed() {
        MergeSortedArray cl = new MergeSortedArray();
        int[] nums1 = new int[] {4, 5, 6, 0, 0, 0};
        cl.merge(
                nums1, 3,
                new int[]{1, 2, 3}, 3
        );
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, nums1);
    }
}