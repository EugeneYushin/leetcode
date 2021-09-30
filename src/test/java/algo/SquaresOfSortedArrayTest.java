package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SquaresOfSortedArrayTest {

    @Test
    void sortedSquares() {
        SquaresOfSortedArray cl = new SquaresOfSortedArray();
        assertArrayEquals(new int[]{0, 1, 4, 9, 16, 25}, cl.sortedSquares(new int[]{-4, -1, 0, 2, 3, 5}));
        assertArrayEquals(new int[]{0, 0, 0, 1, 4, 9, 16, 25}, cl.sortedSquares(new int[]{-4, -1, 0, 0, 0, 2, 3, 5}));
        assertArrayEquals(new int[]{0, 0, 1, 4, 4, 9, 16, 25}, cl.sortedSquares(new int[]{-4, -2, -1, 0, 0, 2, 3, 5}));
    }

    @Test
    void sortedSquares_bruteforce() {
        SquaresOfSortedArray cl = new SquaresOfSortedArray();
        assertArrayEquals(new int[]{0, 1, 4, 9, 16, 25}, cl.sortedSquares_bruteforce(new int[]{-4, -1, 0, 2, 3, 5}));
    }
}