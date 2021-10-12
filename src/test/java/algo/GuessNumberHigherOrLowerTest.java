package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuessNumberHigherOrLowerTest {

    @Test
    void guessNumber() {
        GuessNumberHigherOrLower cl6 = new GuessNumberHigherOrLower(6);
        assertEquals(6, cl6.guessNumber_recursive(10));
        assertEquals(6, cl6.guessNumber(10));
    }
}