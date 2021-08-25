package algo;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthNodeFromEndOfList {
    /**
     * Still 2 passes, just another technique
     */
    public ListNode removeNthFromEnd_2pointers(ListNode head, int n) {
        ListNode start = head, end = head;

        // make a gap of N between start and end pointers
        while (n > 0) {
            end = end.next;
            n--;
        }

        // handle the case when n == length of list
        if (end == null) return head == null ? null : head.next;

        // move pointers with the same pace till the end
        while (end.next != null) {
            end = end.next;
            start = start.next;
        }

        start.next = start.next.next;
        return head;
    }

    public ListNode removeNthFromEnd_2passes(ListNode head, int n) {
        ListNode pointer = head;
        int length = 0;
        while (pointer != null) {
            length++;
            pointer = pointer.next;
        }

        if (length == n) return head == null ? null : head.next;

        pointer = head;
        while (length - n > 1) {
            pointer = pointer.next;
            length--;
        }

        if (pointer.next != null) {
            pointer.next = pointer.next.next;
        }
        return head;
    }
}
