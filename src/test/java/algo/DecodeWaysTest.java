package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecodeWaysTest {

    DecodeWays cl = new DecodeWays();

    @Test
    void numDecodings_recursive() {
        assertEquals(0, cl.numDecodings_recursive("0"));
        assertEquals(0, cl.numDecodings_recursive("01"));
        assertEquals(1, cl.numDecodings_recursive("1"));
        assertEquals(1, cl.numDecodings_recursive("10"));
        assertEquals(2, cl.numDecodings_recursive("15"));
        assertEquals(2, cl.numDecodings_recursive("26"));
        assertEquals(1, cl.numDecodings_recursive("27"));
        assertEquals(0, cl.numDecodings_recursive("30"));
        assertEquals(3, cl.numDecodings_recursive("226"));
        assertEquals(1, cl.numDecodings_recursive("106"));
        assertEquals(2, cl.numDecodings_recursive("311"));
        assertEquals(3, cl.numDecodings_recursive("1201234"));
        assertEquals(9, cl.numDecodings_recursive("123123"));
    }

    @Test
    void numDecodings_memoized() {
        assertEquals(0, cl.numDecodings_memoized("0"));
        assertEquals(0, cl.numDecodings_memoized("01"));
        assertEquals(1, cl.numDecodings_memoized("1"));
        assertEquals(1, cl.numDecodings_memoized("10"));
        assertEquals(2, cl.numDecodings_memoized("15"));
        assertEquals(2, cl.numDecodings_memoized("26"));
        assertEquals(1, cl.numDecodings_memoized("27"));
        assertEquals(0, cl.numDecodings_memoized("30"));
        assertEquals(3, cl.numDecodings_memoized("226"));
        assertEquals(1, cl.numDecodings_memoized("106"));
        assertEquals(2, cl.numDecodings_memoized("311"));
        assertEquals(3, cl.numDecodings_memoized("1201234"));
        assertEquals(9, cl.numDecodings_memoized("123123"));
    }
}