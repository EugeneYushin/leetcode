package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShortEncodingOfWordsTest {

    @Test
    void minimumLengthEncoding() {
        ShortEncodingOfWords cl = new ShortEncodingOfWords();
        assertEquals(10, cl.minimumLengthEncoding(new String[] {"me", "time", "bell"}));
        assertEquals(2, cl.minimumLengthEncoding(new String[] {"t"}));
    }

    @Test
    void minimumLengthEncoding_set() {
        ShortEncodingOfWords cl = new ShortEncodingOfWords();
        assertEquals(10, cl.minimumLengthEncoding_set(new String[] {"me", "time", "bell"}));
        assertEquals(2, cl.minimumLengthEncoding_set(new String[] {"t"}));
    }
}