package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SymmetricTreeTest {

    @Test
    void isSymmetric() {
        SymmetricTree cl = new SymmetricTree();
        assertTrue(cl.isSymmetric(new TreeNode(1, new TreeNode(2), new TreeNode(2))));
        assertFalse(cl.isSymmetric(new TreeNode(1, new TreeNode(2), new TreeNode(3))));
        assertFalse(cl.isSymmetric(new TreeNode(1, new TreeNode(0), null)));
    }
}