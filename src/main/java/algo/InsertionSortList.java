package algo;

public class InsertionSortList {
    /**
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     */
    public ListNode insertionSortList(ListNode head) {
        ListNode sortedHead = new ListNode(head.val);   // set sorted head next to null
        ListNode current = sortedHead;
        ListNode previous = null;
        head = head.next;

        while (head != null) {
            while (current != null && current.val < head.val) {
                previous = current;
                current = current.next;
            }

            ListNode tmp = head.next;
            head.next = current;
            if (previous == null) sortedHead = head;
            else previous.next = head;
            head = tmp;
            current = sortedHead;
            previous = null;
        }

        return sortedHead;
    }
}
