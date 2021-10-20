package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseWordsInStringTest {

    @Test
    void reverseWords() {
        ReverseWordsInString cl = new ReverseWordsInString();
        assertEquals("blue is sky the", cl.reverseWords("the sky is blue"));
        assertEquals("world hello", cl.reverseWords("   hello world  "));
        assertEquals("blue is sky the", cl.reverseWords_naive("the sky is blue"));
        assertEquals("world hello", cl.reverseWords_naive("   hello world  "));
    }
}