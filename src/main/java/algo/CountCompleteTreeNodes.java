package algo;

import java.util.function.Function;

/**
 * https://leetcode.com/problems/count-complete-tree-nodes/
 */
public class CountCompleteTreeNodes {
    /**
     * Time complexity: O(logN ^ 2)
     * Space complexity: O(logN)
     */
    public int countNodes(TreeNode root) {
        int leftHeight = height(root, treeNode -> treeNode.left);
        int rightHeight = height(root, treeNode -> treeNode.right);

        if (leftHeight == rightHeight) return (1 << leftHeight) - 1;
        else return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int height(TreeNode head, Function<TreeNode, TreeNode> f) {
        TreeNode node = head;
        int h = 0;
        while (node != null) {
            node = f.apply(node);
            h++;
        }
        return h;
    }
}
