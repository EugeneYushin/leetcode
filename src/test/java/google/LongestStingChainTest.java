package google;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestStingChainTest {
    LongestStingChain cl = new LongestStingChain();

    @Test
    void longestStrChain() {
        assertEquals(1, cl.longestStrChain(new String[]{"a"}));
        assertEquals(1, cl.longestStrChain(new String[]{"a", "b"}));
        assertEquals(2, cl.longestStrChain(new String[]{"a", "ab"}));
        assertEquals(4, cl.longestStrChain(new String[]{"a", "b", "ba", "bca", "bda", "bdca"}));
    }
}