package algo;

/**
 * https://leetcode.com/problems/diameter-of-binary-tree/
 */
public class DiameterOfBinaryTree {
    private int diameter;

    /**
     * DFS solution
     * Time complexity: O(N)
     * Space complexity: O(logN), worst case O(N) when tree degenerated to linked list
     */
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        dfs(root);
        return diameter;
    }

    /**
     * Returns max path, updates global diameter
     */
    private int dfs(TreeNode head) {
        if (head == null) return 0;

        int l = dfs(head.left);
        int r = dfs(head.right);

        diameter = Math.max(diameter, l + r);
        return 1 + Math.max(l, r);
    }
}
