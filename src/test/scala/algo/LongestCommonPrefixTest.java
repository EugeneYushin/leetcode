package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestCommonPrefixTest {
    LongestCommonPrefix lcp = new LongestCommonPrefix();

    @Test
    void longestCommonPrefix() {
        assertEquals("fl", lcp.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        assertEquals("", lcp.longestCommonPrefix(new String[]{}));
        assertEquals("", lcp.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        assertEquals("a", lcp.longestCommonPrefix(new String[]{"ab", "a"}));
        assertEquals("ab", lcp.longestCommonPrefix(new String[]{"abc", "ab"}));
        assertEquals("", lcp.longestCommonPrefix(new String[]{"abc", "ab", ""}));
    }
}