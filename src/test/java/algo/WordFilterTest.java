package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordFilterTest {

    @Test
    void f() {
        WordFilter cl = new WordFilter(new String[]{
                "cabaabaaaa",
                "ccbcababac",
                "bacaabccba",
                "bcbbcbacaa",
                "abcaccbcaa",
                "accabaccaa",
                "cabcbbbcca",
                "ababccabcb",
                "caccbbcbab",
                "bccbacbcba"
        });

        assertEquals(5, cl.f("a", "aa"));
    }
}