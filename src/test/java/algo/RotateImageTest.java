package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class RotateImageTest {
    @Test
    void rotate_1x1() {
        RotateImage cl = new RotateImage();
        int[][] matrix = {
                new int[]{1},
        };

        cl.rotate(matrix);
        assertArrayEquals(new int[][]{new int[]{1}}, matrix);
    }

    @Test
    void rotate_2x2() {
        RotateImage cl = new RotateImage();
        int[][] matrix = {
                new int[]{1, 2},
                new int[]{3, 4},
        };

        cl.rotate(matrix);
        assertArrayEquals(new int[][]{
                new int[]{3, 1},
                new int[]{4, 2}
        }, matrix);
    }

    @Test
    void rotate_3x3() {
        RotateImage cl = new RotateImage();
        int[][] matrix = {
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9},
        };

        cl.rotate(matrix);
        assertArrayEquals(new int[][]{
                new int[]{7, 4, 1},
                new int[]{8, 5, 2},
                new int[]{9, 6, 3}
        }, matrix);
    }

    @Test
    void rotate_4x4() {
        RotateImage cl = new RotateImage();
        int[][] matrix = {
                new int[]{1, 2, 3, 4},
                new int[]{5, 6, 7, 8},
                new int[]{9, 10, 11, 12},
                new int[]{13, 14, 15, 16},
        };

        cl.rotate(matrix);
        assertArrayEquals(new int[][]{
                new int[]{13, 9, 5, 1},
                new int[]{14, 10, 6, 2},
                new int[]{15, 11, 7, 3},
                new int[]{16, 12, 8, 4},
        }, matrix);
    }
}