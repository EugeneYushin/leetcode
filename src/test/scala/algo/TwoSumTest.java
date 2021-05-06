package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoSumTest {

    TwoSum twoSum = new TwoSum();

    @Test
    void twoSum() {
        assertArrayEquals(twoSum.twoSum(new int[]{2, 7, 11, 15}, 9), new int[]{0, 1});
    }

    @Test
    void twoSumSameElement() {
        assertThrows(IllegalArgumentException.class, () -> twoSum.twoSum(new int[]{7, 2, 11, 15}, 4));
    }
}