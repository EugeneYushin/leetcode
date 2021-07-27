package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestPalindromicSubstringTest {
    LongestPalindromicSubstring cl = new LongestPalindromicSubstring();

    @Test
    void longestPalindrome_insideOut() {
        assertEquals("b", cl.longestPalindrome_insideOut("b"));
        assertEquals("a", cl.longestPalindrome_insideOut("ac"));
        assertEquals("bb", cl.longestPalindrome_insideOut("bb"));
        assertEquals("bb", cl.longestPalindrome_insideOut("cbb"));
        assertEquals("bb", cl.longestPalindrome_insideOut("cbbd"));
        assertEquals("aaaa", cl.longestPalindrome_insideOut("aaaa"));
        assertEquals("aba", cl.longestPalindrome_insideOut("babad"));
        assertEquals("aca", cl.longestPalindrome_insideOut("aacabdkacaa"));   // TODO fix me
    }

    @Test
    void longestPalindrome_dp() {
        assertEquals("b", cl.longestPalindrome_insideOut("b"));
        assertEquals("a", cl.longestPalindrome_insideOut("ac"));
        assertEquals("bb", cl.longestPalindrome_insideOut("bb"));
        assertEquals("bb", cl.longestPalindrome_insideOut("cbb"));
        assertEquals("bb", cl.longestPalindrome_insideOut("cbbd"));
        assertEquals("aaaa", cl.longestPalindrome_insideOut("aaaa"));
        assertEquals("aba", cl.longestPalindrome_insideOut("babad"));
    }
}