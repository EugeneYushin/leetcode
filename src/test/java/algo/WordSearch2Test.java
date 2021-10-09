package algo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordSearch2Test {

    @Test
    void findWords() {
        WordSearch2 cl = new WordSearch2();

        assertEquals(Arrays.asList("oath", "eat"), cl.findWords(new char[][]{
                new char[]{'o', 'a', 'a', 'n'},
                new char[]{'e', 't', 'a', 'e'},
                new char[]{'i', 'h', 'k', 'r'},
                new char[]{'i', 'f', 'l', 'v'}
        }, new String[]{"oath", "oak", "pea", "eat", "rain"}));

        assertEquals(Collections.emptyList(), cl.findWords(new char[][]{
                new char[]{'o', 'a', 'a', 'n'},
                new char[]{'e', 't', 'a', 'e'},
                new char[]{'i', 'h', 'k', 'r'},
                new char[]{'i', 'f', 'l', 'v'}
        }, new String[]{"oak", "pea", "rain"}));

        assertEquals(Collections.emptyList(), cl.findWords(new char[][]{
                new char[]{'a', 'a'},
        }, new String[]{"aaa"}));

        assertEquals(Arrays.asList("oath", "eat", "hf", "hklf"), cl.findWords(new char[][]{
                new char[]{'o', 'a', 'a', 'n'},
                new char[]{'e', 't', 'a', 'e'},
                new char[]{'i', 'h', 'k', 'r'},
                new char[]{'i', 'f', 'l', 'v'}
        }, new String[]{"oath", "pea", "eat", "rain", "hklf", "hf"}));
    }
}