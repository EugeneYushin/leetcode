package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WordSearchTest {

    @Test
    void exist() {
        WordSearch cl = new WordSearch();

        assertTrue(cl.exist(new char[][]{
                new char[]{'A', 'B'},
                new char[]{'C', 'D'}
        }, "CDBA"));

        assertTrue(cl.exist(new char[][]{
                new char[]{'A', 'B', 'C', 'E'},
                new char[]{'S', 'F', 'C', 'S'},
                new char[]{'A', 'D', 'E', 'E'}
        }, "ABCCED"));

        assertTrue(cl.exist(new char[][]{
                new char[]{'A', 'B', 'C', 'E'},
                new char[]{'S', 'F', 'C', 'S'},
                new char[]{'A', 'D', 'E', 'E'}
        }, "SEE"));

        assertFalse(cl.exist(new char[][]{
                new char[]{'A', 'B', 'C', 'E'},
                new char[]{'S', 'F', 'C', 'S'},
                new char[]{'A', 'D', 'E', 'E'}
        }, "ABCB"));

        assertTrue(cl.exist(new char[][]{
                new char[]{'A', 'B', 'C', 'E'},
                new char[]{'S', 'F', 'C', 'S'},
                new char[]{'A', 'D', 'E', 'E'}
        }, "A"));

        assertFalse(cl.exist(new char[][]{
                new char[]{'A', 'B', 'C', 'E'},
                new char[]{'S', 'F', 'C', 'S'},
                new char[]{'A', 'D', 'E', 'E'}
        }, "Z"));
    }

    @Test
    void exist_worstCase() {
        WordSearch cl = new WordSearch();

        assertFalse(cl.exist(new char[][]{
                new char[]{'A', 'A', 'A'},
                new char[]{'A', 'A', 'A'},
                new char[]{'A', 'A', 'A'}
        }, "AAAAAAAAB"));
    }

    @Test
    void exist_cyclic() {
        WordSearch cl = new WordSearch();

        assertFalse(cl.exist(new char[][]{
                new char[]{'A', 'A', 'A'},
                new char[]{'B', 'B', 'B'},
                new char[]{'C', 'C', 'C'}
        }, "BBBAABC"));

        assertFalse(cl.exist(new char[][]{
                new char[]{'a','a','b','a','a','b'},
                new char[]{'a','a','b','b','b','a'},
                new char[]{'a','a','a','a','b','a'},
                new char[]{'b','a','b','b','a','b'},
                new char[]{'a','b','b','a','b','a'},
                new char[]{'b','a','a','a','a','b'}
        }, "bbbaabbbbbab"));
    }

    @Test
    void exist_bigWord() {
        WordSearch cl = new WordSearch();

        assertFalse(cl.exist(new char[][]{
                new char[]{'A', 'A', 'A'},
                new char[]{'A', 'A', 'A'},
                new char[]{'A', 'A', 'A'}
        }, "AAAAAAAAAA"));
    }
}