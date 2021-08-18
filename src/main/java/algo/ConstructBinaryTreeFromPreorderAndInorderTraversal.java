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

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    int headPos;
    Map<Integer, Integer> indexMapping;

    /**
     * Time complexity:
     * O(N) to build an Map + O(1)*N to build a Tree => O(N)
     * Space complexity:
     * O(N) to store a Map + O(N), worst case/O(logN), average to handle a stack for recursive calls => O(N)
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        headPos = 0;
        indexMapping = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMapping.put(inorder[i], i);
        }

        return traverse(preorder, 0, inorder.length - 1);
    }

    private TreeNode traverse(int[] preorder, int lo, int hi) {
        if (lo > hi) return null;
        int headValue = preorder[headPos++];
        int headIndex = indexMapping.get(headValue);
        TreeNode head = new TreeNode(headValue);

        head.left = traverse(preorder, lo, headIndex - 1);
        head.right = traverse(preorder, headIndex + 1, hi);

        return head;
    }
}
