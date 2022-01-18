package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NextPermutationTest {

    @Test
    void nextPermutation() {
        NextPermutation cl = new NextPermutation();
        int[] input = new int[] {1, 2, 3};
        cl.nextPermutation(input);
        assertArrayEquals(new int[] {1, 3, 2}, input);

        input = new int[] {1, 3, 2};
        cl.nextPermutation(input);
        assertArrayEquals(new int[] {2, 1, 3}, input);

        input = new int[] {2, 3, 1};
        cl.nextPermutation(input);
        assertArrayEquals(new int[] {3, 1, 2}, input);

        input = new int[] {1, 1, 5};
        cl.nextPermutation(input);
        assertArrayEquals(new int[] {1, 5, 1}, input);

        input = new int[] {1, 5, 1};
        cl.nextPermutation(input);
        assertArrayEquals(new int[] {5, 1, 1}, input);
    }

    @Test
    void nextPermutation_noPermutation() {
        NextPermutation cl = new NextPermutation();
        int[] input = new int[]{3, 2, 1};
        cl.nextPermutation(input);
        assertArrayEquals(new int[]{1, 2, 3}, input);
    }

    @Test
    void nextPermutation_edgeCase() {
        NextPermutation cl = new NextPermutation();
        int[] input = new int[]{1, 1};
        cl.nextPermutation(input);
        assertArrayEquals(new int[]{1, 1}, input);
    }

    @Test
    void nextPermutation_custom() {
        NextPermutation cl = new NextPermutation();
        int[] input = new int[]{9, 1, 7, 6, 4, 5, 3};
        cl.nextPermutation(input);
        assertArrayEquals(new int[]{9, 1, 7, 6, 5, 3, 4}, input);
    }
}