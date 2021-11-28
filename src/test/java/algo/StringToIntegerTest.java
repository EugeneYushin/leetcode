package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringToIntegerTest {

    @Test
    void myAtoi() {
        StringToInteger cl = new StringToInteger();
        assertEquals(0, cl.myAtoi(""));
        assertEquals(0, cl.myAtoi(" "));
        assertEquals(0, cl.myAtoi(" +"));
        assertEquals(0, cl.myAtoi(" -"));
        assertEquals(0, cl.myAtoi(" hello world "));
        assertEquals(42, cl.myAtoi(" 42hello world "));
        assertEquals(42, cl.myAtoi("42"));
        assertEquals(-42, cl.myAtoi("-42"));
        assertEquals(-2147483648, cl.myAtoi("-2147483649"));
        assertEquals(Integer.MAX_VALUE, cl.myAtoi(String.valueOf(Integer.MAX_VALUE)));
        assertEquals(Integer.MIN_VALUE, cl.myAtoi(String.valueOf(Integer.MIN_VALUE)));
        assertEquals(Integer.MAX_VALUE, cl.myAtoi("9" + Integer.MAX_VALUE));
        assertEquals(Integer.MIN_VALUE, cl.myAtoi(Integer.MIN_VALUE + "9"));
    }
}