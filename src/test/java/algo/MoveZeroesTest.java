package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MoveZeroesTest {

    @Test
    void moveZeroes() {
        MoveZeroes cl = new MoveZeroes();

        int[] nums = {0, 1, 0, 3, 12};
        cl.moveZeroes(nums);
        assertArrayEquals(new int[]{1, 3, 12, 0, 0}, nums);

        nums = new int[]{0, 0, 0, 1};
        cl.moveZeroes(nums);
        assertArrayEquals(new int[]{1, 0, 0, 0}, nums);

        nums = new int[]{1};
        cl.moveZeroes(nums);
        assertArrayEquals(new int[]{1}, nums);
    }
}