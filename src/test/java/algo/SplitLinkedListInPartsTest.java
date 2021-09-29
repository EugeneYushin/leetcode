package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SplitLinkedListInPartsTest {

    @Test
    void splitListToParts() {
        SplitLinkedListInParts cl = new SplitLinkedListInParts();
        assertArrayEquals(new ListNode[]{
                ListNode.fromArray(new int[]{1, 2, 3, 4}),
                ListNode.fromArray(new int[]{5, 6, 7}),
                ListNode.fromArray(new int[]{8, 9, 10})
        }, cl.splitListToParts(ListNode.fromArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}), 3));
    }

    @Test
    void splitListToParts_bigK() {
        SplitLinkedListInParts cl = new SplitLinkedListInParts();
        assertArrayEquals(new ListNode[]{new ListNode(1), new ListNode(2), new ListNode(3), null, null},
                cl.splitListToParts(ListNode.fromArray(new int[]{1, 2, 3}), 5));
    }
}