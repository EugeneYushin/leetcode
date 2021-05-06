package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicatesFromSortedArrayTest {
    RemoveDuplicatesFromSortedArray cl = new RemoveDuplicatesFromSortedArray();

    @Test
    void removeDuplicates() {
        assertEquals(0, cl.removeDuplicates(new int[] {}));
        assertEquals(1, cl.removeDuplicates(new int[] {1}));

        int[] nums = new int[] {1, 1, 2};
        assertEquals(2, cl.removeDuplicates(nums));
        assertEquals(1, nums[0]);
        assertEquals(2, nums[1]);

        nums = new int[] {1, 2, 2};
        assertEquals(2, cl.removeDuplicates(nums));
        assertEquals(1, nums[0]);
        assertEquals(2, nums[1]);

        nums = new int[] {1, 2, 3};
        assertEquals(3, cl.removeDuplicates(nums));
        assertEquals(1, nums[0]);
        assertEquals(2, nums[1]);
        assertEquals(3, nums[2]);

        nums = new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        assertEquals(1, cl.removeDuplicates(nums));
        assertEquals(1, nums[0]);
    }
}