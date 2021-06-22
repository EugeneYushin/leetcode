package google;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DecodeStringTest {
    DecodeString cl = new DecodeString();

    @Test
    void decodeStringRecursive() {
        assertEquals("aaabcbc", cl.decodeStringRecursive("3[a]2[bc]"));
        assertEquals("accaccacc", cl.decodeStringRecursive("3[a2[c]]"));
        assertEquals("abcabccdcdcdef", cl.decodeStringRecursive("2[abc]3[cd]ef"));
        assertEquals("abccdcdcdxyz", cl.decodeStringRecursive("abc3[cd]xyz"));
    }

    @Test
    void decodeStringStack() {
        assertEquals("aaabcbc", cl.decodeStringStack("3[a]2[bc]"));
        assertEquals("accaccacc", cl.decodeStringStack("3[a2[c]]"));
        assertEquals("abcabccdcdcdef", cl.decodeStringStack("2[abc]3[cd]ef"));
        assertEquals("abccdcdcdxyz", cl.decodeStringStack("abc3[cd]xyz"));
    }
}