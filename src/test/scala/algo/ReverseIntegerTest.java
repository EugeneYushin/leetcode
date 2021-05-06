package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseIntegerTest {
    ReverseInteger ri = new ReverseInteger();

    @Test
    void reverse() {
        assertEquals(321, ri.reverse(123));
    }

    @Test
    void reverseNegative() {
        assertEquals(-321, ri.reverse(-123));
    }

    @Test
    void reverseZero() {
        assertEquals(0, ri.reverse(0));
    }

    @Test
    void reverseOverflow() {
        assertEquals(0, ri.reverse(1534236469));
    }
}