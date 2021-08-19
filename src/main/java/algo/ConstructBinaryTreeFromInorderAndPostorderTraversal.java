package algo;

import java.util.*;

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
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    private int rootPos;
    private Map<Integer, Integer> mapping;

    /**
     *  Time complexity:
     *  T(N) = 2*T(N/2) + O(1)
     *  c=0 < logbA=1 ==> O(N^log2) = O(N^1) = O(N)
     *
     *  Space complexity: O(N) for mapping + O(N)/O(logN) for stack ==> O(N)
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        rootPos = postorder.length - 1;
        mapping = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            mapping.put(inorder[i], i);
        }

        return traverse(postorder, 0, rootPos);
    }

    private TreeNode traverse(int[] postorder, int lo, int hi) {
        if (lo > hi) return null;

        TreeNode head = new TreeNode(postorder[rootPos--]);
        Integer splitPos = mapping.get(head.val);
        head.right = traverse(postorder, splitPos + 1, hi);
        head.left = traverse(postorder, lo, splitPos -1);

        return head;
    }
}
