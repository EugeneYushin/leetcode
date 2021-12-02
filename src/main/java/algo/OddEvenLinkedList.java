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
 * https://leetcode.com/problems/odd-even-linked-list/submissions/
 */
public class OddEvenLinkedList {
    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head;

        ListNode odd = head;

        ListNode even = head.next;
        ListNode dummyEven = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;

            even.next = even.next.next;
            even = even.next;
        }

        odd.next = dummyEven;
        return head;
    }
}
