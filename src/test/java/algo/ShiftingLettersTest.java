package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShiftingLettersTest {

    @Test
    void shiftingLetters() {
        ShiftingLetters cl = new ShiftingLetters();
        assertEquals("b", cl.shiftingLetters("a", new int[]{1}));
        assertEquals("z", cl.shiftingLetters("a", new int[]{25}));
        assertEquals("a", cl.shiftingLetters("z", new int[]{1}));
        assertEquals("a", cl.shiftingLetters("a", new int[]{26}));
        assertEquals("rpl", cl.shiftingLetters("abc", new int[]{3, 5, 9}));
    }

    @Test
    void shiftingLetters_sumOverflow() {
        ShiftingLetters cl = new ShiftingLetters();
        assertEquals("b", cl.shiftingLetters("a", new int[]{1}));
        assertEquals("z", cl.shiftingLetters("a", new int[]{25}));
        assertEquals("a", cl.shiftingLetters("z", new int[]{1}));
        assertEquals("a", cl.shiftingLetters("a", new int[]{26}));
        assertEquals("rpl", cl.shiftingLetters("abc", new int[]{3, 5, 9}));
        assertEquals("wqqwlcjnkphhsyvrkdod", cl.shiftingLetters("mkgfzkkuxownxvfvxasy", new int[]{505870226, 437526072, 266740649, 224336793, 532917782, 311122363, 567754492, 595798950, 81520022, 684110326, 137742843, 275267355, 856903962, 148291585, 919054234, 467541837, 622939912, 116899933, 983296461, 536563513}));
    }
}