package algo;

public class InsertionSortList {
    /**
     * Optimized for pre-sorted nodes
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     */
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode current = head;

        while (current.next != null) {
            // skip pre-sorted range
            if (current.val <= current.next.val) {
                current = current.next;
                continue;
            }

            // we don't adjust `current` below, meaning we will process last element no matter while-loop condition
            ListNode previous = dummy;
            while (previous.next.val < current.next.val) {
                previous = previous.next;
            }

            ListNode tmp = current.next;
            current.next = current.next.next;

            tmp.next = previous.next;
            previous.next = tmp;
        }

        return dummy.next;
    }

    /**
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     */
    public ListNode insertionSortList_classic(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode current = head;

        while (current != null) {
            ListNode prev = dummy;

            while (prev.next != null && prev.next.val < current.val) {
                prev = prev.next;
            }

            ListNode tmp = current.next;
            current.next = prev.next;
            prev.next = current;

            current = tmp;
        }

        return dummy.next;
    }
}
