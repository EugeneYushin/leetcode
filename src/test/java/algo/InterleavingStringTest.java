package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InterleavingStringTest {
    @Test
    void isInterleave() {
        InterleavingString cl = new InterleavingString();
        assertTrue(cl.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        assertTrue(cl.isInterleave("", "", ""));
        assertFalse(cl.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
        assertFalse(cl.isInterleave("a", "b", "aba"));
        assertFalse(cl.isInterleave("db", "b", "cbb"));
    }

    @Test
    void isInterleave_dp() {
        InterleavingString cl = new InterleavingString();
        assertTrue(cl.isInterleave_dp("aabcc", "dbbca", "aadbbcbcac"));
        assertTrue(cl.isInterleave_dp("", "", ""));
        assertFalse(cl.isInterleave_dp("aabcc", "dbbca", "aadbbbaccc"));
        assertFalse(cl.isInterleave_dp("a", "b", "aba"));
        assertFalse(cl.isInterleave_dp("db", "b", "cbb"));
    }
}