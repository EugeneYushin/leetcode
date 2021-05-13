package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidParenthesesTest {
    ValidParentheses vp = new ValidParentheses();

    @Test
    void isValid() {
        assertTrue(vp.isValid("()"));
        assertTrue(vp.isValid(""));
        assertTrue(vp.isValid("[](){}"));
        assertTrue(vp.isValid("[({})]"));

        assertFalse(vp.isValid("]"));
        assertFalse(vp.isValid("{]"));
        assertFalse(vp.isValid("{}["));
        assertFalse(vp.isValid("([)]"));
    }
}