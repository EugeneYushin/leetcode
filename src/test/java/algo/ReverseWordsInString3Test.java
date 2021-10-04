package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseWordsInString3Test {

    @Test
    void reverseWords() {
        ReverseWordsInString3 cl = new ReverseWordsInString3();
        assertEquals("ih dlrow", cl.reverseWords("hi world"));
    }
}