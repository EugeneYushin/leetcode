package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BitwiseANDOfNumbersRangeTest {

    @Test
    void rangeBitwiseAnd() {
        BitwiseANDOfNumbersRange cl = new BitwiseANDOfNumbersRange();
        assertEquals(4, cl.rangeBitwiseAnd(4, 6));
        assertEquals(0, cl.rangeBitwiseAnd(0, 0));
        assertEquals(0, cl.rangeBitwiseAnd(1, 2147483647));
        assertEquals(2147483646, cl.rangeBitwiseAnd(2147483646, 2147483647));
        assertEquals(2147483647, cl.rangeBitwiseAnd(2147483647, 2147483647));
    }

    @Test
    void rangeBitwiseAnd_bruteforce() {
        BitwiseANDOfNumbersRange cl = new BitwiseANDOfNumbersRange();
        assertEquals(4, cl.rangeBitwiseAnd_bruteforce(4, 6));
        assertEquals(0, cl.rangeBitwiseAnd_bruteforce(0, 0));
        assertEquals(0, cl.rangeBitwiseAnd_bruteforce(1, 2147483647));
        assertEquals(2147483646, cl.rangeBitwiseAnd_bruteforce(2147483646, 2147483647));    // overflow
        assertEquals(2147483647, cl.rangeBitwiseAnd_bruteforce(2147483647, 2147483647));    // overflow
    }
}