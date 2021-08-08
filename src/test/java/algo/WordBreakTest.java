package algo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class WordBreakTest {
    WordBreak cl = new WordBreak();

    @Test
    void wordBreak() {
        assertTrue(cl.wordBreak("a", Arrays.asList("a")));
        assertFalse(cl.wordBreak("a", Arrays.asList("b")));
        assertTrue(cl.wordBreak("leetcode", Arrays.asList("leet", "code")));
        assertTrue(cl.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        assertTrue(cl.wordBreak("abcd", Arrays.asList("a", "abc", "b", "cd")));
        assertTrue(cl.wordBreak("aaaaaaa", Arrays.asList("aaaa", "aaa")));
        assertFalse(cl.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
        assertFalse(cl.wordBreak(
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")
        ));
    }

    @Test
    void wordBreak_bruteForce() {
        assertTrue(cl.wordBreak_bruteForce("a", Arrays.asList("a")));
        assertFalse(cl.wordBreak_bruteForce("a", Arrays.asList("b")));
        assertTrue(cl.wordBreak_bruteForce("leetcode", Arrays.asList("leet", "code")));
        assertTrue(cl.wordBreak_bruteForce("applepenapple", Arrays.asList("apple", "pen")));
        assertTrue(cl.wordBreak_bruteForce("abcd", Arrays.asList("a", "abc", "b", "cd")));
        assertTrue(cl.wordBreak_bruteForce("aaaaaaa", Arrays.asList("aaaa", "aaa")));
        assertFalse(cl.wordBreak_bruteForce("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }

    @Test
    @Tag("slow")
    @Disabled
    void wordBreak_bruteForce_slow() {
        assertFalse(cl.wordBreak_bruteForce(
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")
        ));
    }
}