package algo;

import java.util.Stack;

/**
 * https://leetcode.com/problems/invert-binary-tree/
 */
public class InvertBinaryTree {
    /**
     * Iterative solution
     * Time complexity: O(N)
     * Space complexity: O(logN)
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            TreeNode head = stack.pop();

            TreeNode right = head.right;
            head.right = head.left;
            head.left = right;

            if (head.right != null) stack.push(head.right);
            if (head.left != null) stack.push(head.left);
        }

        return root;
    }

    /**
     * Recursive solution
     * Time complexity: O(N)
     * Space complexity: O(logN)
     */
    public TreeNode invertTree_recursive(TreeNode root) {
        if (root == null) return null;

        TreeNode right = root.right;
        root.right = invertTree_recursive(root.left);
        root.left = invertTree_recursive(right);
        return root;
    }
}
