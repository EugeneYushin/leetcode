package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveElementTest {
    RemoveElement cl = new RemoveElement();

    @Test
    void removeElement() {
        assertEquals(0, cl.removeElement(new int[] {}, 42));
        assertEquals(0, cl.removeElement(new int[] {1}, 1));
        assertEquals(1, cl.removeElement(new int[] {1}, 42));

        int[] nums = new int[] {1, 2, 2, 4};
        assertEquals(3, cl.removeElement(nums, 1));
        assertEquals(2, nums[0]);
        assertEquals(2, nums[1]);
        assertEquals(4, nums[2]);

        nums = new int[] {1, 2, 2, 4};
        assertEquals(2, cl.removeElement(nums, 2));
        assertEquals(1, nums[0]);
        assertEquals(4, nums[1]);
    }

    @Test
    void removeElementOptimized() {
        assertEquals(0, cl.removeElementOptimized(new int[] {}, 42));
        assertEquals(0, cl.removeElementOptimized(new int[] {1}, 1));
        assertEquals(1, cl.removeElementOptimized(new int[] {1}, 42));

        int[] nums = new int[] {1, 1, 1, 3, 3};
        assertEquals(2, cl.removeElement(nums, 1));
        assertEquals(3, nums[0]);
        assertEquals(3, nums[1]);

        nums = new int[] {1, 1, 3, 3, 3};
        assertEquals(3, cl.removeElement(nums, 1));
        assertEquals(3, nums[0]);
        assertEquals(3, nums[1]);
        assertEquals(3, nums[2]);
    }
}