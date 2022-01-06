package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CarPoolingTest {

    @Test
    void carPooling() {
        CarPooling cl = new CarPooling();
        assertFalse(cl.carPooling(new int[][]{
                new int[]{2, 1, 5},
                new int[]{3, 3, 7}
        }, 4));

        assertTrue(cl.carPooling(new int[][]{
                new int[]{2, 1, 5},
                new int[]{3, 3, 7}
        }, 5));

        assertFalse(cl.carPooling(new int[][]{
                new int[]{9, 3, 6},
                new int[]{8, 1, 7},
                new int[]{6, 6, 8},
                new int[]{8, 4, 9},
                new int[]{4, 2, 9}
        }, 28));
    }

    @Test
    void carPooling_bruteForce() {
        CarPooling cl = new CarPooling();
        assertFalse(cl.carPooling_bruteForce(new int[][]{
                new int[]{2, 1, 5},
                new int[]{3, 3, 7}
        }, 4));

        assertTrue(cl.carPooling_bruteForce(new int[][]{
                new int[]{2, 1, 5},
                new int[]{3, 3, 7}
        }, 5));
    }
}