package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OddEvenLinkedListTest {

    @Test
    void oddEvenList() {
        OddEvenLinkedList cl = new OddEvenLinkedList();
        assertNull(cl.oddEvenList(null));
        assertEquals(new ListNode(1), cl.oddEvenList(new ListNode(1)));
        assertEquals(ListNode.fromArray(new int[]{1, 2}), cl.oddEvenList(ListNode.fromArray(new int[]{1, 2})));
        assertEquals(ListNode.fromArray(new int[]{1, 3, 2}), cl.oddEvenList(ListNode.fromArray(new int[]{1, 2, 3})));
        assertEquals(ListNode.fromArray(new int[]{1, 3, 2, 4}), cl.oddEvenList(ListNode.fromArray(new int[]{1, 2, 3, 4})));
        assertEquals(ListNode.fromArray(new int[]{1, 3, 5, 2, 4}), cl.oddEvenList(ListNode.fromArray(new int[]{1, 2, 3, 4, 5})));
        assertEquals(ListNode.fromArray(new int[]{1, 3, 5, 2, 4, 6}), cl.oddEvenList(ListNode.fromArray(new int[]{1, 2, 3, 4, 5, 6})));
    }
}