package algo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/cousins-in-binary-tree/
 */
public class CousinsInBinaryTree {
    /**
     * BFS solution
     * Time complexity: O(N)
     * Space complexity: O(N)
     */
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int p1 = -1;

        while (!q.isEmpty()) {
            int size = q.size();
            int i = 0;
            while (i < size) {
                TreeNode node = q.poll();

                if (node != null) {
                    if (p1 >= 0 && (node.val == x || node.val == y)) return size > 2 && p1 / 2 != i / 2;
                    else if (node.val == x || node.val == y) p1 = i;

                    q.add(node.left);
                    q.add(node.right);
                }

                i++;
            }

            if (p1 >= 0) return false;
        }

        return false;
    }
}
