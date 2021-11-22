package algo;

/**
 * https://leetcode.com/problems/delete-node-in-a-bst/
 */
public class DeleteNodeInBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (root.val < key) root.right = deleteNode(root.right, key);
        else if (root.val > key) root.left = deleteNode(root.left, key);
        else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            else {
                // 2 children
                TreeNode minToTheRight = root.right;
                TreeNode prev = null;
                while (minToTheRight.left != null) {
                    prev = minToTheRight;
                    minToTheRight = minToTheRight.left;
                }

                // re-map
                if (prev == null) {
                    minToTheRight.left = root.left;
                    return minToTheRight;
                }

                prev.left = minToTheRight.right;
                minToTheRight.left = root.left;
                minToTheRight.right = root.right;
                return minToTheRight;
            }
        }

        return root;
    }
}
