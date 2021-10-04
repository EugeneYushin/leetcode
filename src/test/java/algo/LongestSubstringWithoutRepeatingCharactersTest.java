package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubstringWithoutRepeatingCharactersTest {
    LongestSubstringWithoutRepeatingCharacters cl = new LongestSubstringWithoutRepeatingCharacters();

    @Test
    void lengthOfLongestSubstring() {
        assertEquals(3, cl.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(3, cl.lengthOfLongestSubstring("pwwkew"));
        assertEquals(2, cl.lengthOfLongestSubstring("abba"));
        assertEquals(1, cl.lengthOfLongestSubstring("bbbbb"));
        assertEquals(0, cl.lengthOfLongestSubstring(""));
        assertEquals(1, cl.lengthOfLongestSubstring(" "));
    }
}