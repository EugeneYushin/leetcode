package algo;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 */
public class ReverseLinkedList {
    /**
     * Iterative in-place
     * Time complexity: O(N)
     * Space complexity: O(1)
     */
    public ListNode reverseList(ListNode head) {
        ListNode tail = null;
        while (head != null) {
            ListNode tmp = head.next;   // save link to next node
            head.next = tail;           // reverse
            tail = head;                // update tail
            head = tmp;                 // move to next node
        }

        return tail;
    }

    /**
     * Iterative
     * Time complexity: O(N)
     * Space complexity: O(1) not counting space for result
     */
    public ListNode reverseList_iterativeExtraSpace(ListNode head) {
        ListNode tail = null;
        while (head != null) {
            tail = new ListNode(head.val, tail);
            head = head.next;
        }

        return tail;
    }

    /**
     * Recursive approach
     * Time complexity: O(N)
     * Space complexity: O(N) to maintain stack for recursive calls
     */
    public ListNode reverseList_recursive(ListNode head) {
        return recursive(head, null);
    }

    private ListNode recursive(ListNode head, ListNode tail) {
        if (head == null) return tail;
        ListNode next = head.next;
        head.next = tail;
        return recursive(next, head);
    }
}
