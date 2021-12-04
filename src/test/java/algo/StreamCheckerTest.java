package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StreamCheckerTest {

    @Test
    void query() {
        StreamChecker streamChecker = new StreamChecker(new String[]{"abc", "xyz"});
        assertFalse(streamChecker.query('a'));
        assertFalse(streamChecker.query('x'));
        assertFalse(streamChecker.query('y'));
        assertTrue(streamChecker.query('z'));
    }

    @Test
    void query2() {
        StreamChecker streamChecker = new StreamChecker(new String[]{"abaa", "abaab", "aabbb", "bab", "ab"});
        assertFalse(streamChecker.query('a'));
        assertFalse(streamChecker.query('a'));
        assertTrue(streamChecker.query('b'));
        assertFalse(streamChecker.query('b'));
        assertTrue(streamChecker.query('b'));
        assertFalse(streamChecker.query('a'));
        assertFalse(streamChecker.query('a'));
    }
}