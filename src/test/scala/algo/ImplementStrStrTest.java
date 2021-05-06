package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImplementStrStrTest {
    ImplementStrStr cl = new ImplementStrStr();

    @Test
    void strStr() {
        assertEquals(2, cl.strStr("abc", "c"));
        assertEquals(2, cl.strStr("hello", "ll"));
        assertEquals(0, cl.strStr("hello", "hello"));
        assertEquals(4, cl.strStr("mississippi", "issip"));
        assertEquals(-1, cl.strStr("mississippi", "issipi"));
        assertEquals(-1, cl.strStr("aaaaa", "baa"));
        assertEquals(0, cl.strStr("", ""));
        assertEquals(-1, cl.strStr("b", "bb"));
    }
}