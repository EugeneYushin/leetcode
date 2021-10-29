package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DungeonGameTest {

    @Test
    void calculateMinimumHP() {
        DungeonGame cl = new DungeonGame();
        assertEquals(7, cl.calculateMinimumHP(new int[][]{
                new int[]{-2, -3, 3},
                new int[]{-5, -10, 1},
                new int[]{10, 30, -5}
        }));

        assertEquals(1, cl.calculateMinimumHP(new int[][]{new int[]{0}}));
        assertEquals(1, cl.calculateMinimumHP(new int[][]{
                new int[]{1},
                new int[]{2},
                new int[]{3}
        }));
        assertEquals(1, cl.calculateMinimumHP(new int[][]{new int[]{1, 2, 3}}));
        assertEquals(7, cl.calculateMinimumHP(new int[][]{new int[]{-1, -2, -3}}));
    }
}