package algo;

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
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 */
public class SumRootToLeafNumbers {
    /**
     * DFS solution
     * Time complexity: O(N)
     * Space complexity: O(H), H - height of the tree (logN in general, N - for tree degenerated in a list)
     */
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int prefix) {
        if (node == null) return 0;

        int newPrefix = prefix * 10 + node.val;
        if (node.left == null && node.right == null) return newPrefix;

        return dfs(node.left, newPrefix) + dfs(node.right, newPrefix);
    }
}
