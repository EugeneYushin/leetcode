package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleNumber3Test {

    @Test
    void singleNumber() {
        SingleNumber3 cl = new SingleNumber3();
        assertArrayEquals(new int[] {10, 6}, cl.singleNumber(new int[] {25, 6, 10, 25}));
    }
}