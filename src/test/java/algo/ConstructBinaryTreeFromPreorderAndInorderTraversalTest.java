package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConstructBinaryTreeFromPreorderAndInorderTraversalTest {

    @Test
    void buildTree() {
        ConstructBinaryTreeFromPreorderAndInorderTraversal cl = new ConstructBinaryTreeFromPreorderAndInorderTraversal();

        assertEquals(
                // [3,9,20,null,null,15,7]
                new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7))),
                cl.buildTree(
                        new int[]{3, 9, 20, 15, 7},
                        new int[]{9, 3, 15, 20, 7}
                )
        );

        assertEquals(
                new TreeNode(-1),
                cl.buildTree(
                        new int[]{-1},
                        new int[]{-1}
                )
        );

        assertEquals(
                new TreeNode(1, new TreeNode(2), null),
                cl.buildTree(
                        new int[]{1, 2},
                        new int[]{2, 1}
                )
        );

        assertEquals(
                // [5,8,14,3,12,2,19]
                new TreeNode(5,
                        new TreeNode(8, new TreeNode(14), new TreeNode(3)),
                        new TreeNode(12, new TreeNode(2), new TreeNode(19))
                ),
                cl.buildTree(
                        new int[]{5, 8, 14, 3, 12, 2, 19},
                        new int[]{14, 8, 3, 5, 2, 12, 19}
                )
        );
    }
}