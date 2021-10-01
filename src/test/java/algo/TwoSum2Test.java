package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoSum2Test {

    @Test
    void twoSum() {
        TwoSum2 cl = new TwoSum2();
        assertArrayEquals(new int[] {1, 2}, cl.twoSum(new int[] {2, 7, 11, 15}, 9));
        assertArrayEquals(new int[] {1, 2}, cl.twoSum(new int[] {-1, 0}, -1));
        assertArrayEquals(new int[] {1, 2}, cl.twoSum(new int[] {-3, 3, 4, 90}, 0));
    }

    @Test
    void twoSum_hash() {
        TwoSum2 cl = new TwoSum2();
        assertArrayEquals(new int[] {1, 2}, cl.twoSum_hash(new int[] {2, 7, 11, 15}, 9));
        assertArrayEquals(new int[] {1, 2}, cl.twoSum_hash(new int[] {-1, 0}, -1));
        assertArrayEquals(new int[] {1, 2}, cl.twoSum_hash(new int[] {-3, 3, 4, 90}, 0));
    }
}