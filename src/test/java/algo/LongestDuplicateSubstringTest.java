package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestDuplicateSubstringTest {

    @Test
    void longestDupSubstring() {
        LongestDuplicateSubstring cl = new LongestDuplicateSubstring();

        assertEquals("", cl.longestDupSubstring(""));
        assertEquals("", cl.longestDupSubstring("a"));
        assertEquals("bb", cl.longestDupSubstring("bbb"));
        assertEquals("bb", cl.longestDupSubstring("abbb"));
        assertEquals("bb", cl.longestDupSubstring("abbba"));
        assertEquals("bb", cl.longestDupSubstring("bbba"));
        assertEquals("ana", cl.longestDupSubstring("banana"));
        assertEquals("a", cl.longestDupSubstring("banaka"));
        assertEquals("ana", cl.longestDupSubstring("banakana"));
        assertEquals("aka", cl.longestDupSubstring("banakaka"));
        assertEquals("nak", cl.longestDupSubstring("banaknak"));
        assertEquals("na", cl.longestDupSubstring("bnaaknak"));
        assertEquals("banana", cl.longestDupSubstring("bananabanana"));
    }
}