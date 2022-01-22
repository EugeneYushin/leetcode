package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerToEnglishWordsTest {
    @Test
    void numberToWords() {
        IntegerToEnglishWords cl = new IntegerToEnglishWords();
        assertEquals("One", cl.numberToWords(1));
        assertEquals("Eleven", cl.numberToWords(11));
        assertEquals("Twenty", cl.numberToWords(20));
        assertEquals("Twenty Three", cl.numberToWords(23));
        assertEquals("One Hundred Twenty Three", cl.numberToWords(123));
        assertEquals("One Thousand Two Hundred Thirty Four", cl.numberToWords(1234));
    }

    @Test
    void numberToWords_edgeCases() {
        IntegerToEnglishWords cl = new IntegerToEnglishWords();
        assertEquals("One Hundred", cl.numberToWords(100));
        assertEquals("One Hundred One", cl.numberToWords(101));
        assertEquals("One Thousand", cl.numberToWords(1000));
        assertEquals("One Million", cl.numberToWords(1000000));
        assertEquals("One Hundred Thousand", cl.numberToWords(100000));
    }
}
