package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueReconstructionByHeightTest {

    @Test
    void reconstructQueue() {
        QueueReconstructionByHeight cl = new QueueReconstructionByHeight();
        assertArrayEquals(new int[][]{
                // [5,0],[7,0],[5,2],[6,1],[4,4],[7,1]
                new int[]{5, 0},
                new int[]{7, 0},
                new int[]{5, 2},
                new int[]{6, 1},
                new int[]{4, 4},
                new int[]{7, 1},
        }, cl.reconstructQueue(new int[][]{
                // [7,0],[4,4],[7,1],[5,0],[6,1],[5,2]
                new int[]{7, 0},
                new int[]{4, 4},
                new int[]{7, 1},
                new int[]{5, 0},
                new int[]{6, 1},
                new int[]{5, 2},
        }));
    }
}