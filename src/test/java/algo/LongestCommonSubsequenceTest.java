package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestCommonSubsequenceTest {

    @Test
    void longestCommonSubsequence() {
        LongestCommonSubsequence cl = new LongestCommonSubsequence();
        assertEquals(3, cl.longestCommonSubsequence("abcde", "ace"));
        assertEquals(3, cl.longestCommonSubsequence("ace", "abcde"));
        assertEquals(2, cl.longestCommonSubsequence("bcde", "ceby"));
        assertEquals(1, cl.longestCommonSubsequence("bcde", "ecby"));
        assertEquals(1, cl.longestCommonSubsequence("bbcde", "ecby"));
        assertEquals(0, cl.longestCommonSubsequence("bcde", "xxx"));
        assertEquals(5, cl.longestCommonSubsequence("abcba", "abcbcba"));
        assertEquals(4, cl.longestCommonSubsequence("pmjghexybyrgzczy", "hafcdqbgncrcbihkd"));
    }
}