package algo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfValidWordsForEachPuzzleTest {
    @Test
    void findNumOfValidWords() {
        NumberOfValidWordsForEachPuzzle cl = new NumberOfValidWordsForEachPuzzle();
        assertEquals(Arrays.asList(1, 1, 3, 2, 4, 0), cl.findNumOfValidWords(
                new String[]{"aaaa", "asas", "able", "ability", "actt", "actor", "access"},
                new String[]{"aboveyz", "abrodyz", "abslute", "absoryz", "actresz", "gaswxyz"}
        ));

        assertEquals(Arrays.asList(0), cl.findNumOfValidWords(
                new String[]{"a"},
                new String[]{"b"}
        ));

        // duplicated words
        assertEquals(Arrays.asList(2), cl.findNumOfValidWords(
                new String[]{"a", "a"},
                new String[]{"abc"}
        ));
    }

    @Test
    void findNumOfValidWords_bruteForce() {
        NumberOfValidWordsForEachPuzzle cl = new NumberOfValidWordsForEachPuzzle();
        assertEquals(Arrays.asList(1, 1, 3, 2, 4, 0), cl.findNumOfValidWords_bruteForce(
                new String[]{"aaaa", "asas", "able", "ability", "actt", "actor", "access"},
                new String[]{"aboveyz", "abrodyz", "abslute", "absoryz", "actresz", "gaswxyz"}
        ));
        assertEquals(Arrays.asList(0), cl.findNumOfValidWords_bruteForce(
                new String[]{"a"},
                new String[]{"b"}
        ));
    }
}