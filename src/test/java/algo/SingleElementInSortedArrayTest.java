package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleElementInSortedArrayTest {

    @Test
    void singleNonDuplicate() {
        SingleElementInSortedArray cl = new SingleElementInSortedArray();
        assertEquals(42, cl.singleNonDuplicate(new int[]{42}));
        assertEquals(2, cl.singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
        assertEquals(10, cl.singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11}));
    }
}