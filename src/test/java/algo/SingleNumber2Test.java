package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleNumber2Test {

    @Test
    void singleNumber() {
        SingleNumber2 cl = new SingleNumber2();
        assertEquals(3, cl.singleNumber(new int[] {1, 2, 3, 15, 2, 15, 15, 1, 1, 2}));
        assertEquals(99, cl.singleNumber(new int[] {0, 1, 0, 1, 0, 1, 99}));
        assertEquals(99, cl.singleNumber(new int[] {99}));
        assertEquals(1, cl.singleNumber(new int[] {-2, -2, -2, 1}));
        assertEquals(-4, cl.singleNumber(new int[] {-2, -2, -2, -4}));
        assertEquals(-4, cl.singleNumber(new int[]{-2, -2, 1, 1, 4, 1, 4, 4, -4, -2}));
    }
}