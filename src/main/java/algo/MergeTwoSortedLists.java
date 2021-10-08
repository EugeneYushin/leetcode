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
class MergeTwoSortedLists {
    /**
     * Recursive version
     * Time complexity: O(l1 + l2)
     * Space complexity: O(l1 + l2)
     */
    public ListNode mergeTwoListsIterative(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        else if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoListsIterative(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsIterative(l1, l2.next);
            return l2;
        }
    }

    /**
     * Iterative
     * Time complexity: O(l1 + l2)
     * Space complexity: O(1)
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode sorted = new ListNode();
        ListNode handler = sorted;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                handler.next = l2;
                l2 = l2.next;
            } else {
                handler.next = l1;
                l1 = l1.next;
            }

            handler = handler.next;
        }

        handler.next = l1 == null ? l2 : l1;
        return sorted.next;
    }
}