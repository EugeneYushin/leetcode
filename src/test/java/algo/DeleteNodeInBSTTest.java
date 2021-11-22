package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeleteNodeInBSTTest {

    @Test
    void deleteNode() {
        DeleteNodeInBST cl = new DeleteNodeInBST();
        TreeNode x = cl.deleteNode(new TreeNode(50,
                        new TreeNode(30, null, new TreeNode(40)),
                        new TreeNode(70, new TreeNode(60), new TreeNode(80))
                ), 50);
        assertEquals(60, x.val);
    }
}