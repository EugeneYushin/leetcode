package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanToIntegerTest {
    RomanToInteger ri = new RomanToInteger();

    @Test
    void romanToInt() {
        assertEquals(1, ri.romanToInt("I"));
        assertEquals(4, ri.romanToInt("IV"));
        assertEquals(5, ri.romanToInt("V"));
        assertEquals(9, ri.romanToInt("IX"));
        assertEquals(25, ri.romanToInt("XXV"));
        assertEquals(58, ri.romanToInt("LVIII"));
        assertEquals(1994, ri.romanToInt("MCMXCIV"));
    }
}