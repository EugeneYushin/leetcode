package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GridGameTest {

    @Test
    void gridGame() {
        GridGame cl = new GridGame();
        assertEquals(4, cl.gridGame(new int[][]{
                new int[]{2, 5, 4},
                new int[]{1, 5, 1}
        }));

        assertEquals(4, cl.gridGame(new int[][]{
                new int[]{3, 3, 1},
                new int[]{8, 5, 2}
        }));

        assertEquals(7, cl.gridGame(new int[][]{
                new int[]{1, 3, 1, 15},
                new int[]{1, 3, 3, 1}
        }));
    }
}