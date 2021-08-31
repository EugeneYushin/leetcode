package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveDuplicatesFromSortedListTest {
    @Test
    void deleteDuplicates() {
        RemoveDuplicatesFromSortedList cl = new RemoveDuplicatesFromSortedList();

        assertEquals(ListNode.fromArray(new int[]{1, 2}), cl.deleteDuplicates(ListNode.fromArray(new int[]{1, 1, 2})));
        assertEquals(ListNode.fromArray(new int[]{1, 2}), cl.deleteDuplicates(ListNode.fromArray(new int[]{1, 1, 2})));
        assertEquals(ListNode.fromArray(new int[]{1}), cl.deleteDuplicates(ListNode.fromArray(new int[]{1, 1, 1})));
        assertEquals(ListNode.fromArray(new int[]{1, 2, 3}), cl.deleteDuplicates(ListNode.fromArray(new int[]{1, 2, 3})));
    }

    @Test
    void deleteDuplicates_generalSetBased() {
        RemoveDuplicatesFromSortedList cl = new RemoveDuplicatesFromSortedList();

        assertEquals(ListNode.fromArray(new int[]{1, 2}), cl.deleteDuplicates_generalSetBased(ListNode.fromArray(new int[]{1, 1, 2})));
        assertEquals(ListNode.fromArray(new int[]{1, 2}), cl.deleteDuplicates_generalSetBased(ListNode.fromArray(new int[]{1, 2, 2})));
        assertEquals(ListNode.fromArray(new int[]{1}), cl.deleteDuplicates_generalSetBased(ListNode.fromArray(new int[]{1, 1, 1})));
        assertEquals(ListNode.fromArray(new int[]{1, 2, 3}), cl.deleteDuplicates_generalSetBased(ListNode.fromArray(new int[]{1, 2, 3})));
    }
}