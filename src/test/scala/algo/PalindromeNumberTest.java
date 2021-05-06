package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeNumberTest {
    PalindromeNumber pn = new PalindromeNumber();

    @Test
    void isPalindrome() {
//        assertTrue(pn.isPalindrome(1221));
//        assertTrue(pn.isPalindrome(121));
//        assertTrue(pn.isPalindrome(11));
//        assertTrue(pn.isPalindrome(0));
//        assertTrue(pn.isPalindrome(5));
//
//        assertFalse(pn.isPalindrome(12));
//        assertFalse(pn.isPalindrome(-121));
        assertFalse(pn.isPalindrome(10));
    }
}