package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveNthNodeFromEndOfListTest {

    @Test
    void removeNthFromEnd_2passes() {
        RemoveNthNodeFromEndOfList cl = new RemoveNthNodeFromEndOfList();
        assertNull(cl.removeNthFromEnd_2passes(ListNode.fromArray(new int[]{1}), 1));
        assertEquals(new ListNode(2),
                cl.removeNthFromEnd_2passes(ListNode.fromArray(new int[]{1, 2}), 2));
        assertEquals(ListNode.fromArray(new int[]{1, 2, 3, 5}),
                cl.removeNthFromEnd_2passes(ListNode.fromArray(new int[]{1, 2, 3, 4, 5}), 2));
    }

    @Test
    void removeNthFromEnd_2pointers() {
        RemoveNthNodeFromEndOfList cl = new RemoveNthNodeFromEndOfList();
        assertNull(cl.removeNthFromEnd_2pointers(ListNode.fromArray(new int[]{1}), 1));
        assertEquals(new ListNode(2),
                cl.removeNthFromEnd_2pointers(ListNode.fromArray(new int[]{1, 2}), 2));
        assertEquals(ListNode.fromArray(new int[]{1, 2, 3, 5}),
                cl.removeNthFromEnd_2pointers(ListNode.fromArray(new int[]{1, 2, 3, 4, 5}), 2));
    }
}