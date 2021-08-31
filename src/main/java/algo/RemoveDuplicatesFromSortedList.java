package algo;

import java.util.HashSet;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/submissions/
 */
public class RemoveDuplicatesFromSortedList {
    /**
     * Time complexity: O(N)
     * Space complexity: O(1)
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = head;
        while (head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return dummy;
    }

    /**
     * Time complexity: O(N)
     * Space complexity: O(N)
     */
    public ListNode deleteDuplicates_generalSetBased(ListNode head) {
        if (head == null || head.next == null) return head;

        HashSet<Integer> set = new HashSet<>();
        set.add(head.val);

        ListNode dummy = head;

        while (head.next != null) {
            if (!set.add(head.next.val)) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }

        return dummy;
    }
}
