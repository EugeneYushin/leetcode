package algo;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */


class Sum {
    int sum;
    boolean isBST;
    int max;
    int min;

    public Sum(int sum, boolean isBST, int max, int min) {
        this.sum = sum;
        this.isBST = isBST;
        this.max = max;
        this.min = min;
    }

    @Override
    public String toString() {
        return String.format("sum: %d isBST: %b max: %d min: %d",
                this.sum, this.isBST, this.max, this.min);
    }
}

/**
 * https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/
 */
public class MaximumSumBSTInBinaryTree {
    private int maxSum;

    /**
     * Time complexity: O(N), N - number of nodes, we iterate over each node once, each iteration takes O(1)
     * Space complexity: O(h), h - height of tree to handle stack during post-order traversal
     */
    public int maxSumBST(TreeNode root) {
        maxSum = 0;
        findSum(root);
        return maxSum;
    }

    private Sum findSum(TreeNode root) {
        // simplify null handling, -inf < root.val < +inf
        // ie, for [5,null,null] we have left.max = -inf < 5 < right.min = +inf
        if (root == null) return new Sum(0, true, Integer.MIN_VALUE, Integer.MAX_VALUE);

        // Post-order traversal
        Sum leftSum = findSum(root.left);
        Sum rightSum = findSum(root.right);

        boolean isBST = leftSum.max < root.val && root.val < rightSum.min && leftSum.isBST && rightSum.isBST;
        int currentSum = leftSum.sum + rightSum.sum + root.val;

        if (isBST) {
            // update result if it's the case
            maxSum = Math.max(maxSum, currentSum);
        }

        // we care of max/min values for BST case only
        return new Sum(currentSum, isBST, Math.max(root.val, rightSum.max), Math.min(root.val, leftSum.min));
    }
}
