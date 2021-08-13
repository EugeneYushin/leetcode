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
 * https://leetcode.com/problems/sort-list/
 */
public class SortList {
    /**
     * Merge sort (divide and conquer, top-down)
     * Time complexity: O(N*logN)
     * Space complexity: O(logN)
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode middle = splitMiddle(head);
        ListNode left = sortList(head);
        ListNode right = sortList(middle);

        return merge(left, right);
    }

    private ListNode splitMiddle(ListNode node) {
        ListNode slow = null;
        ListNode fast = node;

        while (fast != null && fast.next != null) {
            slow = slow == null ? node : slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow.next;
        slow.next = null;
        return mid;
    }

    private ListNode merge(ListNode left, ListNode right) {
        if (left == null) return right;
        else if (right == null) return left;

        if (left.val > right.val) {
            right.next = merge(left, right.next);
            return right;
        } else {
            left.next = merge(left.next, right);
            return left;
        }
    }
}
