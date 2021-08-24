package algo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class LetterCombinationsOfPhoneNumberTest {
    @Test
    void letterCombinations() {
        LetterCombinationsOfPhoneNumber cl = new LetterCombinationsOfPhoneNumber();
        assertEquals(Collections.emptyList(), cl.letterCombinations(""));
        assertEquals(Arrays.asList("a", "b", "c"), cl.letterCombinations("2"));
        assertEquals(Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"), cl.letterCombinations("23"));
        assertEquals(Arrays.asList("ap", "aq", "ar", "as", "bp", "bq", "br", "bs", "cp", "cq", "cr", "cs"), cl.letterCombinations("27"));
    }

    @Test
    void letterCombinations_iterative() {
        LetterCombinationsOfPhoneNumber cl = new LetterCombinationsOfPhoneNumber();
        assertEquals(Collections.emptyList(), cl.letterCombinations_iterative(""));
        assertEquals(Arrays.asList("a", "b", "c"), cl.letterCombinations_iterative("2"));
        assertEquals(Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"), cl.letterCombinations_iterative("23"));
        assertEquals(Arrays.asList("ap", "aq", "ar", "as", "bp", "bq", "br", "bs", "cp", "cq", "cr", "cs"), cl.letterCombinations_iterative("27"));
    }
}