package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiameterOfBinaryTreeTest {

    @Test
    void diameterOfBinaryTree() {
        DiameterOfBinaryTree cl = new DiameterOfBinaryTree();
        assertEquals(3, cl.diameterOfBinaryTree(
                new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3))));
    }
}