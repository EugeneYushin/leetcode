package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntervalListIntersectionsTest {

    @Test
    void intervalIntersection() {
        IntervalListIntersections cl = new IntervalListIntersections();
        assertArrayEquals(new int[][]{
                new int[]{1, 2},
                new int[]{5, 5},
                new int[]{8, 10},
                new int[]{15, 23},
                new int[]{24, 24},
                new int[]{25, 25}
        }, cl.intervalIntersection(new int[][]{
                new int[]{0, 2},
                new int[]{5, 10},
                new int[]{13, 23},
                new int[]{24, 25}
        }, new int[][]{
                new int[]{1, 5},
                new int[]{8, 12},
                new int[]{15, 24},
                new int[]{25, 26}
        }));
    }
}