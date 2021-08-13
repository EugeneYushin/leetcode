package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortListTest {

    @Test
    void sortList() {
        SortList cl = new SortList();
        assertEquals(
                new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))),
                cl.sortList(new ListNode(5, new ListNode(2, new ListNode(6, new ListNode(4, new ListNode(3))))))
        );
    }
}