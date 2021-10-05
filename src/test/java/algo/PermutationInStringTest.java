package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PermutationInStringTest {

    @Test
    void checkInclusion() {
        PermutationInString cl = new PermutationInString();
        assertTrue(cl.checkInclusion("adc", "dcda"));
        assertTrue(cl.checkInclusion("ab", "eidbaooo"));
        assertTrue(cl.checkInclusion("abb", "eidbabooo"));
        assertTrue(cl.checkInclusion("abb", "eidbaobab"));
        assertTrue(cl.checkInclusion("a", "a"));
        assertTrue(cl.checkInclusion("aa", "aa"));
        assertTrue(cl.checkInclusion("ab", "ba"));
        assertTrue(cl.checkInclusion("a", "ab"));

        assertFalse(cl.checkInclusion("ab", "a"));
        assertFalse(cl.checkInclusion("x", "eidbaobab"));
        assertFalse(cl.checkInclusion("bba", "eidbaoba"));
    }
}