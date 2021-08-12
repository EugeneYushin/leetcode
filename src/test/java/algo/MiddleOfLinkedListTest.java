package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MiddleOfLinkedListTest {

    @Test
    void middleNode() {
        MiddleOfLinkedList cl = new MiddleOfLinkedList();
        assertEquals(new ListNode(3, new ListNode(4, new ListNode(5))),
                cl.middleNode(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))));
    }
}