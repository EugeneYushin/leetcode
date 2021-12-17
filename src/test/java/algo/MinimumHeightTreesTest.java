package algo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MinimumHeightTreesTest {

    @Test
    void findMinHeightTrees() {
        MinimumHeightTrees cl = new MinimumHeightTrees();
        assertEquals(Arrays.asList(1), cl.findMinHeightTrees(4, new int[][]{
                new int[]{1, 0},
                new int[]{1, 2},
                new int[]{1, 3}
        }));

        assertEquals(Arrays.asList(3, 4), cl.findMinHeightTrees(6, new int[][]{
                new int[]{3, 0},
                new int[]{3, 1},
                new int[]{3, 2},
                new int[]{3, 4},
                new int[]{5, 4},
        }));
    }
}