package algo;

/**
 * https://leetcode.com/problems/palindrome-linked-list/
 */
public class PalindromeLinkedList {
    /**
     * Reverse either first or second half of the list
     * Here I reverse the first half
     *
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        ListNode tail = null;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;

            // reverse first half
            ListNode next = slow.next;
            slow.next = tail;
            tail = slow;
            slow = next;
        }

        ListNode left;
        ListNode right;

        if (fast.next == null) {
            // size is odd, skip mid element from comparison
            left = tail;
            right = slow.next;
        } else {
            // size is even
            right = slow.next;
            slow.next = tail;
            left = slow;
        }

        while (left != null && left.val == right.val) {
            left = left.next;
            right = right.next;
        }

        return left == null;
    }
}
