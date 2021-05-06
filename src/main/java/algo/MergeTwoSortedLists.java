package algo;

import java.util.List;
import java.util.Objects;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val &&
                Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }
}


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
     * Iterative version, could cause StackOverflow for O(n) time compelxity
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

    // 2,4,5        3,4,6
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

        if (l1 == null) handler.next = l2;
        else handler.next = l1;

        return sorted.next;
    }
}