package algo;

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
 * https://leetcode.com/problems/split-linked-list-in-parts
 */
public class SplitLinkedListInParts {
    /**
     * Find number of hops for each subset, and then iterate over these numbers and make hops
     * Time complexity: O(N)
     * Space complexity: O(k) not counting space for resulting array
     */
    public ListNode[] splitListToParts(ListNode head, int k) {
        int[] nums = new int[k];
        ListNode dummy = head;

        int m = 0;
        while (dummy != null && m < k) {
            nums[m++] = 1;
            dummy = dummy.next;
        }

        while (dummy != null) {
            int pos = m % k;
            nums[pos]++;
            m++;
            dummy = dummy.next;
        }

        ListNode[] result = new ListNode[k];
        for (int i = 0; i < nums.length && nums[i] > 0; i++) {
            int n = nums[i];
            result[i] = head;
            ListNode pointer = result[i];
            while (--n > 0) {
                pointer = pointer.next;
                head = head.next;
            }
            head = head.next;
            pointer.next = null;
        }

        return result;
    }
}
