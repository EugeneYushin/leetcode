package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrieTest {

    @Test
    void e2e() {
        Trie t = new Trie();
        t.insert("hello");

        assertFalse(t.search("hi"));
        assertFalse(t.search("hilarious"));

        t.insert("hi");
        assertTrue(t.search("hi"));

        assertFalse(t.startsWith("a"));
        assertFalse(t.startsWith("ha"));
        assertFalse(t.startsWith("helloz"));
        assertTrue(t.startsWith("hel"));

        t.insert("zoo");
        assertFalse(t.startsWith("y"));
        assertTrue(t.startsWith("z"));
        assertTrue(t.startsWith("zo"));
        assertTrue(t.startsWith("zoo"));
    }

    @Test
    void testCase1() {
        Trie t = new Trie();
        t.insert("ab");
        t.search("abc");
        t.search("ab");
        t.startsWith("abc");
        t.startsWith("ab");

        t.insert("ab");
        t.search("abc");
        t.startsWith("abc");
        t.insert("abc");
        t.search("abc");
        t.startsWith("abc");
    }
}