package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeTwoSortedListsTest {

    @Test
    void mergeTwoLists() {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        MergeTwoSortedLists cl = new MergeTwoSortedLists();

        assertEquals(new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(4)))))), cl.mergeTwoLists(l1, l2));
    }

    @Test
    void mergeTwoListsIterative() {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(5)));
        ListNode l2 = new ListNode(3, new ListNode(4, new ListNode(6)));
        MergeTwoSortedLists cl = new MergeTwoSortedLists();

        assertEquals(new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5, new ListNode(6)))))), cl.mergeTwoListsIterative(l1, l2));
    }
}