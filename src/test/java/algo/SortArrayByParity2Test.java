package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SortArrayByParity2Test {

    @Test
    void sortArrayByParityII_2queues() {
        SortArrayByParity2 cl = new SortArrayByParity2();
        assertArrayEquals(new int[]{4, 5, 2, 7}, cl.sortArrayByParityII_2queues(new int[]{4, 2, 5, 7}));
    }

    @Test
    void sortArrayByParityII_2heads() {
        SortArrayByParity2 cl = new SortArrayByParity2();
        assertArrayEquals(new int[]{4, 5, 2, 7}, cl.sortArrayByParityII_2heads(new int[]{4, 2, 5, 7}));
        assertArrayEquals(new int[]{4, 1, 0, 1, 0, 1}, cl.sortArrayByParityII_2heads(new int[]{4, 1, 1, 0, 1, 0}));
    }
}