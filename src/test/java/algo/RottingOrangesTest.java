package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RottingOrangesTest {

    @Test
    void orangesRotting() {
        RottingOranges cl = new RottingOranges();
        assertEquals(4, cl.orangesRotting(new int[][]{
                new int[]{2, 1, 1},
                new int[]{1, 1, 0},
                new int[]{0, 1, 1},
        }));

        assertEquals(-1, cl.orangesRotting(new int[][]{new int[]{1}}));
        assertEquals(0, cl.orangesRotting(new int[][]{new int[]{0}}));
    }
}