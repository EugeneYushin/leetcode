package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FloodFillTest {

    @Test
    void floodFill() {
        FloodFill cl = new FloodFill();
        assertArrayEquals(new int[][]{
                new int[]{2, 2, 2},
                new int[]{2, 2, 0},
                new int[]{2, 0, 1},
        }, cl.floodFill(new int[][]{
                new int[]{1, 1, 1},
                new int[]{1, 1, 0},
                new int[]{1, 0, 1},
        }, 1, 1, 2));

        assertArrayEquals(new int[][]{
                new int[]{1, 1, 1},
                new int[]{1, 1, 0},
                new int[]{1, 0, 1},
        }, cl.floodFill(new int[][]{
                new int[]{1, 1, 1},
                new int[]{1, 1, 0},
                new int[]{1, 0, 1},
        }, 1, 1, 1));
    }
}