package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConstructBinaryTreeFromInorderAndPostorderTraversalTest {

    @Test
    void buildTree() {
        ConstructBinaryTreeFromInorderAndPostorderTraversal cl = new ConstructBinaryTreeFromInorderAndPostorderTraversal();

        assertEquals(
                new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7))),
                cl.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3})
        );

        assertEquals(
                new TreeNode(1),
                cl.buildTree(new int[]{1}, new int[]{1})
        );

        assertEquals(
                new TreeNode(1, new TreeNode(2), null),
                cl.buildTree(new int[]{2, 1}, new int[]{2, 1})
        );

        assertEquals(
                new TreeNode(10,
                        new TreeNode(5, new TreeNode(2) , new TreeNode(4)),
                        new TreeNode(17, new TreeNode(12), new TreeNode(21))
                ),
                cl.buildTree(new int[]{2, 5, 4, 10, 12, 17, 21}, new int[]{2, 4, 5, 12, 21, 17, 10})
        );
    }
}