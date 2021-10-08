package algo;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReverseLinkedListTest {

    @Test
    void reverseList() {
        ReverseLinkedList cl = new ReverseLinkedList();
        assertEquals(ListNode.fromArray(new int[]{4, 3, 2, 1}),
                cl.reverseList(ListNode.fromArray(new int[]{1, 2, 3, 4})));
        assertEquals(ListNode.fromArray(new int[]{}), cl.reverseList(ListNode.fromArray(new int[]{})));

        assertEquals(ListNode.fromArray(new int[]{4, 3, 2, 1}),
                cl.reverseList_recursive(ListNode.fromArray(new int[]{1, 2, 3, 4})));
        assertEquals(ListNode.fromArray(new int[]{}), cl.reverseList_recursive(ListNode.fromArray(new int[]{})));

        assertEquals(ListNode.fromArray(new int[]{4, 3, 2, 1}),
                cl.reverseList_iterativeExtraSpace(ListNode.fromArray(new int[]{1, 2, 3, 4})));
        assertEquals(ListNode.fromArray(new int[]{}),
                cl.reverseList_iterativeExtraSpace(ListNode.fromArray(new int[]{})));
    }
}