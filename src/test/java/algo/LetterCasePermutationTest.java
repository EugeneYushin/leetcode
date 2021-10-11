package algo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LetterCasePermutationTest {

    @Test
    void letterCasePermutation() {
        LetterCasePermutation cl = new LetterCasePermutation();
        assertEquals(Arrays.asList("a1b2", "a1B2", "A1b2", "A1B2"), cl.letterCasePermutation("a1b2"));
        assertEquals(Arrays.asList("a1b2", "a1B2", "A1b2", "A1B2"), cl.letterCasePermutation_iterative("a1b2"));
    }
}