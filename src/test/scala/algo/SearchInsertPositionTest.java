package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchInsertPositionTest {
    SearchInsertPosition cl = new SearchInsertPosition();

    @Test
    void searchInsert() {
        assertEquals(0, cl.searchInsert(new int[] {}, 0));
        assertEquals(0, cl.searchInsert(new int[] {1}, 0));
        assertEquals(0, cl.searchInsert(new int[] {1, 3, 5 ,6}, 0));
        assertEquals(2, cl.searchInsert(new int[] {1, 3, 5 ,6}, 5));
        assertEquals(4, cl.searchInsert(new int[] {1, 3, 5 ,6}, 7));
        assertEquals(3, cl.searchInsert(new int[] {1, 3, 5 ,7, 9}, 6));
        assertEquals(4, cl.searchInsert(new int[] {1, 3, 5 ,7, 9}, 8));
    }
}