package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeLinkedListTest {

    @Test
    void isPalindrome() {
        PalindromeLinkedList cl = new PalindromeLinkedList();
        assertTrue(cl.isPalindrome(ListNode.fromArray(new int[] {1, 1})));
        assertFalse(cl.isPalindrome(ListNode.fromArray(new int[] {1, 2})));
        assertFalse(cl.isPalindrome(ListNode.fromArray(new int[] {1, 2, 3, 1})));
        assertTrue(cl.isPalindrome(ListNode.fromArray(new int[] {1, 2, 1})));
        assertTrue(cl.isPalindrome(ListNode.fromArray(new int[] {1, 2, 2, 1})));
        assertTrue(cl.isPalindrome(ListNode.fromArray(new int[] {1, 2, 3, 2, 1})));
        assertTrue(cl.isPalindrome(ListNode.fromArray(new int[] {1, 2, 3, 3, 2, 1})));
    }
}