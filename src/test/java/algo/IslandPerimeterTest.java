package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IslandPerimeterTest {

    @Test
    void islandPerimeter() {
        IslandPerimeter cl = new IslandPerimeter();
        assertEquals(16, cl.islandPerimeter(new int[][]{
                new int[]{0, 1, 0, 0},
                new int[]{1, 1, 1, 0},
                new int[]{0, 1, 0, 0},
                new int[]{1, 1, 0, 0},
        }));

        assertEquals(6, cl.islandPerimeter(new int[][]{new int[]{1, 1}}));
    }

    @Test
    void islandPerimeter_naive() {
        IslandPerimeter cl = new IslandPerimeter();
        assertEquals(16, cl.islandPerimeter_naive(new int[][]{
                new int[]{0, 1, 0, 0},
                new int[]{1, 1, 1, 0},
                new int[]{0, 1, 0, 0},
                new int[]{1, 1, 0, 0},
        }));
    }
}