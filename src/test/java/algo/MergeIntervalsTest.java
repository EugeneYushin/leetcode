package algo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MergeIntervalsTest {

    @Test
    void merge() {
        MergeIntervals cl = new MergeIntervals();
        assertArrayEquals(new int[][]{
                        new int[]{1, 6},
                        new int[]{8, 10},
                        new int[]{15, 18}
                },
                cl.merge(new int[][]{
                        new int[]{1, 3},
                        new int[]{2, 6},
                        new int[]{8, 10},
                        new int[]{15, 18}
                }));
    }

    @Test
    void merge_single() {
        MergeIntervals cl = new MergeIntervals();
        assertArrayEquals(new int[][]{new int[]{1, 6}}, cl.merge(new int[][]{new int[]{1, 6}}));
    }

    @Test
    void merge_nonOverlapping() {
        MergeIntervals cl = new MergeIntervals();
        assertArrayEquals(new int[][]{
                        new int[]{1, 3},
                        new int[]{8, 10},
                        new int[]{15, 18}
                },
                cl.merge(new int[][]{
                        new int[]{1, 3},
                        new int[]{8, 10},
                        new int[]{15, 18}
                }));
    }

    @Test
    void merge_allOverlapping() {
        MergeIntervals cl = new MergeIntervals();
        assertArrayEquals(new int[][]{new int[]{1, 6}},
                cl.merge(new int[][]{
                        new int[]{1, 3},
                        new int[]{2, 4},
                        new int[]{3, 6}
                }));
    }

    @Test
    void merge_supperInterval() {
        MergeIntervals cl = new MergeIntervals();
        assertArrayEquals(new int[][]{new int[]{1, 4}},
                cl.merge(new int[][]{
                        new int[]{1, 4},
                        new int[]{2, 3}
                }));
    }
}