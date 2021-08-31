package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestHappyStringTest {

    @Test
    void longestDiverseString() {
        LongestHappyString cl = new LongestHappyString();
        assertEquals("aa", cl.longestDiverseString(2, 0, 0));
        assertEquals("aa", cl.longestDiverseString(3, 0, 0));
        assertEquals("aabaabababac", cl.longestDiverseString(7, 4, 1));
        System.out.println("s = " + cl.longestDiverseString(3, 0, 0));
    }
}