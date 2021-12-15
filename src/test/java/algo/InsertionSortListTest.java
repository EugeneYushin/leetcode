package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InsertionSortListTest {

    @Test
    void insertionSortList() {
        InsertionSortList cl = new InsertionSortList();

        assertEquals(ListNode.fromArray(new int[]{1, 2, 2}), cl.insertionSortList(ListNode.fromArray(new int[]{2, 1, 2})));
        assertEquals(ListNode.fromArray(new int[]{2, 3, 4}), cl.insertionSortList(ListNode.fromArray(new int[]{3, 2, 4})));
        assertEquals(ListNode.fromArray(new int[]{1, 3, 4}), cl.insertionSortList(ListNode.fromArray(new int[]{3, 4, 1})));
        assertEquals(ListNode.fromArray(new int[]{1, 2, 3, 4}), cl.insertionSortList(ListNode.fromArray(new int[]{4, 2, 1, 3})));
    }
}