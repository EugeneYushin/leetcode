package algo;

/**
 * https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
 */
public class ConstructBSTFromPreorderTraversal {
    private int pos;

    /**
     * Time complexity: O(N)
     * Space complexity: O(N) worst case when Tree degenerates to list
     */
    public TreeNode bstFromPreorder(int[] preorder) {
        pos = 0;
        return next(preorder, Integer.MAX_VALUE);
    }

    private TreeNode next(int[] preorder, int bound) {
        if (pos == preorder.length || preorder[pos] > bound) return null;

        TreeNode head = new TreeNode(preorder[pos]);
        pos++;
        head.left = next(preorder, head.val);
        head.right = next(preorder, bound);

        return head;
    }
}
