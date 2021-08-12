package algo;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/**
 * https://leetcode.com/problems/middle-of-the-linked-list/
 */
public class MiddleOfLinkedList {
    /**
     * Time complexity: O(N)
     * Space complexity: O(1)
     */
    public ListNode middleNode(ListNode head) {
        int counter = 1;
        ListNode middle = head;
        ListNode current = head;

        while (current.next != null) {
            current = current.next;
            counter++;
            if ((counter & 1) == 0) middle = middle.next;
        }

        return middle;
    }
}
