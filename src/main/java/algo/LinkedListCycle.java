package algo;

import java.util.HashSet;

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */

/**
 * https://leetcode.com/problems/linked-list-cycle/
 */
public class LinkedListCycle {
    /**
     * Floyd's tortoise and hare
     * Time complexity: O(N)
     * Space complexity: O(1)
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }

        return false;
    }

    /**
     * Hash based solution
     * Time complexity: O(N)
     * Space complexity: O(N)
     */
    public boolean hasCycle_hashBased(ListNode head) {
        HashSet<ListNode> seen = new HashSet<>();
        while (head != null) {
            if (!seen.add(head)) return true;
            head = head.next;
        }
        return false;
    }
}
