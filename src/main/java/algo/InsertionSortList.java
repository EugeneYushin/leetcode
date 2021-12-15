package algo;

public class InsertionSortList {
    /**
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     */
    public ListNode insertionSortList(ListNode head) {
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
