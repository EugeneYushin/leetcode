package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumbersAtMostNGivenDigitSetTest {

    @Test
    void atMostNGivenDigitSet() {
        NumbersAtMostNGivenDigitSet cl = new NumbersAtMostNGivenDigitSet();
        assertEquals(32, cl.atMostNGivenDigitSet(new String[] {"1", "3", "5", "7"}, 160));
        assertEquals(2, cl.atMostNGivenDigitSet(new String[] {"1"}, 11));
    }
}