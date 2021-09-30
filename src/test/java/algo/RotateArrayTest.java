package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RotateArrayTest {

    @Test
    void rotate_bruteforce() {
        RotateArray cl = new RotateArray();

        int[] nums = new int[]{1, 2, 3, 4};
        cl.rotate_bruteforce(nums, 2);
        assertArrayEquals(new int[]{3, 4, 1, 2}, nums);

        nums = new int[]{1, 2, 3, 4};
        cl.rotate_bruteforce(nums, 4);
        assertArrayEquals(new int[]{1, 2, 3, 4}, nums);
    }

    @Test
    void rotate_3timesReverse() {
        RotateArray cl = new RotateArray();

        int[] nums = new int[]{1, 2, 3, 4};
        cl.rotate_3timesReverse(nums, 2);
        assertArrayEquals(new int[]{3, 4, 1, 2}, nums);

        nums = new int[]{1, 2, 3, 4};
        cl.rotate_3timesReverse(nums, 4);
        assertArrayEquals(new int[]{1, 2, 3, 4}, nums);
    }
}