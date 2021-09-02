package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumSumBSTInBinaryTreeTest {
    @Test
    void maxSumBST_completeBST() {
        MaximumSumBSTInBinaryTree cl = new MaximumSumBSTInBinaryTree();
        assertEquals(15, cl.maxSumBST(new TreeNode(5, new TreeNode(3), new TreeNode(7))));
    }

    @Test
    void maxSumBST_rightSubTree() {
        MaximumSumBSTInBinaryTree cl = new MaximumSumBSTInBinaryTree();
        assertEquals(22, cl.maxSumBST(new TreeNode(8,
                new TreeNode(6, new TreeNode(2), new TreeNode(5)),
                new TreeNode(10, null, new TreeNode(12))
        )));
    }

    @Test
    void maxSumBST_leftSubTree() {
        MaximumSumBSTInBinaryTree cl = new MaximumSumBSTInBinaryTree();
        assertEquals(7, cl.maxSumBST(new TreeNode(5,
                new TreeNode(4, new TreeNode(3), null),
                new TreeNode(8, new TreeNode(6), new TreeNode(3))
        )));
    }

    @Test
    void maxSumBST_leafCase() {
        MaximumSumBSTInBinaryTree cl = new MaximumSumBSTInBinaryTree();
        assertEquals(2, cl.maxSumBST(new TreeNode(4,
                new TreeNode(3, new TreeNode(1), new TreeNode(2)),
                null
        )));
    }

    @Test
    void maxSumBST_emptyInput() {
        MaximumSumBSTInBinaryTree cl = new MaximumSumBSTInBinaryTree();
        assertEquals(0, cl.maxSumBST(new TreeNode()));
        assertEquals(0, cl.maxSumBST(null));
    }

    @Test
    void maxSumBST_singleNode() {
        MaximumSumBSTInBinaryTree cl = new MaximumSumBSTInBinaryTree();
        assertEquals(1, cl.maxSumBST(new TreeNode(1)));
    }

    @Test
    void maxSumBST_allNegative() {
        MaximumSumBSTInBinaryTree cl = new MaximumSumBSTInBinaryTree();
        assertEquals(0, cl.maxSumBST(new TreeNode(-4, new TreeNode(-2), new TreeNode(-5))));
    }

    @Test
    void maxSumBST_allNegativeBST() {
        MaximumSumBSTInBinaryTree cl = new MaximumSumBSTInBinaryTree();
        assertEquals(0, cl.maxSumBST(new TreeNode(-4, new TreeNode(-5), new TreeNode(-2))));
    }

    @Test
    void maxSumBST_containsNegative() {
        MaximumSumBSTInBinaryTree cl = new MaximumSumBSTInBinaryTree();
        assertEquals(25, cl.maxSumBST(new TreeNode(1, null, new TreeNode(10, new TreeNode(-5), new TreeNode(20)))));
    }

    @Test
    void maxSumBST_negativeSubTree() {
        MaximumSumBSTInBinaryTree cl = new MaximumSumBSTInBinaryTree();
        assertEquals(14, cl.maxSumBST(new TreeNode(1,
                new TreeNode(-5, null, new TreeNode(-3)),
                new TreeNode(4, null, new TreeNode(10)))));
    }
}