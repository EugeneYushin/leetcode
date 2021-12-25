package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasicCalculator2Test {

    @Test
    void calculate_simple() {
        BasicCalculator2 cl = new BasicCalculator2();
        assertEquals(3, cl.calculate("1+2"));
        assertEquals(1, cl.calculate("1+0"));
        assertEquals(1, cl.calculate("2-1"));
        assertEquals(-1, cl.calculate("0-1"));
        assertEquals(1, cl.calculate("1-1+1"));
    }

    @Test
    void calculate() {
        BasicCalculator2 cl = new BasicCalculator2();
        assertEquals(2, cl.calculate("2*3-4"));
        assertEquals(10, cl.calculate("1+2+3*4-5"));
        assertEquals(22, cl.calculate("1+2+3*4*2-5"));
        assertEquals(1, cl.calculate("1+2+3*2/2-5"));
        assertEquals(1, cl.calculate("1+2+3*2/2-5/1"));
    }

    @Test
    void calculate_round() {
        BasicCalculator2 cl = new BasicCalculator2();
        assertEquals(1, cl.calculate("3/2"));
    }

    @Test
    void calculate_withSpaces() {
        BasicCalculator2 cl = new BasicCalculator2();
        assertEquals(10, cl.calculate("1 + 2 + 3 * 4 - 5"));
    }

    @Test
    void calculate_wrapsWithSpaces() {
        BasicCalculator2 cl = new BasicCalculator2();
        assertEquals(10, cl.calculate(" 1 + 2 + 3 * 4 - 5 "));
    }
}