package algo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BinarySearchTest {

    @Test
    void search() {
        BinarySearch cl = new BinarySearch();
        assertEquals(1, cl.search(new int[] {1, 2, 3, 4, 5, 6}, 2));
        assertEquals(1, cl.search(new int[] {1, 2, 3, 4, 5, 6, 7}, 2));
        assertEquals(-1, cl.search(new int[] {1, 2, 3, 4, 5, 6}, 10));
    }
}
