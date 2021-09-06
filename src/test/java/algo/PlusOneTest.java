package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlusOneTest {

    @Test
    void plusOne() {
        PlusOne cl = new PlusOne();
        assertArrayEquals(new int[] {1}, cl.plusOne(new int[] {0}));
        assertArrayEquals(new int[] {2}, cl.plusOne(new int[] {1}));
        assertArrayEquals(new int[] {1, 0}, cl.plusOne(new int[] {9}));
        assertArrayEquals(new int[] {4, 3}, cl.plusOne(new int[] {4, 2}));
        assertArrayEquals(new int[] {1, 0, 0, 0}, cl.plusOne(new int[] {9, 9, 9}));
        assertArrayEquals(new int[] {9, 0, 0}, cl.plusOne(new int[] {8, 9, 9}));
    }
}