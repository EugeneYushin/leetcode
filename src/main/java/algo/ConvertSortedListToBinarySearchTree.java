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
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/**
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 */
public class ConvertSortedListToBinarySearchTree {
    /**
     * Time complexity:
     * T(N) = 2T(T/2) + O(1)
     * log2 = 1 > N^0 (c=0)
     * T(N) = O(N^log2) = O(N)
     *
     * Space complexity: O(logN)
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        else if (head.next == null) return new TreeNode(head.val);

        // find mid element and assign set as the current head
        ListNode mid = splitAtMiddle(head);
        TreeNode treeHead = new TreeNode(mid.val);

        // left = repeat the same for left sub-list
        treeHead.left = sortedListToBST(head);

        // right = repeat the same for right sub-list
        treeHead.right = sortedListToBST(mid.next);

        return treeHead;
    }

    private ListNode splitAtMiddle(ListNode node) {
        ListNode prevMid = null;
        ListNode fast = node;
        while (fast != null && fast.next != null) {
            prevMid = prevMid == null ? node : prevMid.next;
            fast = fast.next.next;
        }

        ListNode mid = prevMid.next;
        prevMid.next = null;
        return mid;
    }
}
