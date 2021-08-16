package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConvertSortedListToBinarySearchTreeTest {

    @Test
    void sortedListToBST() {
        ConvertSortedListToBinarySearchTree cl = new ConvertSortedListToBinarySearchTree();
        assertEquals(
                new TreeNode(0,
                        new TreeNode(-3, new TreeNode(-10), null),
                        new TreeNode(9, new TreeNode(5), null)
                ),
                cl.sortedListToBST(ListNode.fromArray(new int[]{-10, -3, 0, 5, 9}))
        );
    }
}