package google;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DecodeStringTest {
    DecodeString cl = new DecodeString();

    @Test
    void decodeString() {
        assertEquals("aaabcbc", cl.decodeString("3[a]2[bc]"));
        assertEquals("accaccacc", cl.decodeString("3[a2[c]]"));
        assertEquals("abcabccdcdcdef", cl.decodeString("2[abc]3[cd]ef"));
        assertEquals("abccdcdcdxyz", cl.decodeString("abc3[cd]xyz"));
    }
}