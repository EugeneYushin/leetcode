package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SurroundedRegionsTest {

    @Test
    void solve() {
        SurroundedRegions cl = new SurroundedRegions();
        char[][] matrix = {
                new char[]{'X', 'X', 'X', 'X'},
                new char[]{'X', 'O', 'O', 'X'},
                new char[]{'X', 'X', 'O', 'X'},
                new char[]{'X', 'O', 'X', 'X'},
        };
        cl.solve(matrix);

        assertArrayEquals(new char[][]{
                new char[]{'X', 'X', 'X', 'X'},
                new char[]{'X', 'X', 'X', 'X'},
                new char[]{'X', 'X', 'X', 'X'},
                new char[]{'X', 'O', 'X', 'X'}
        }, matrix);
    }

    @Test
    void solve_2() {
        SurroundedRegions cl = new SurroundedRegions();
        char[][] matrix = {
                new char[]{'O', 'O', 'X', 'X'},
                new char[]{'X', 'O', 'O', 'X'},
                new char[]{'X', 'X', 'O', 'X'},
                new char[]{'X', 'X', 'X', 'X'},
        };
        cl.solve(matrix);

        assertArrayEquals(new char[][]{
                new char[]{'O', 'O', 'X', 'X'},
                new char[]{'X', 'O', 'O', 'X'},
                new char[]{'X', 'X', 'O', 'X'},
                new char[]{'X', 'X', 'X', 'X'},
        }, matrix);
    }

    @Test
    void solve_3() {
        SurroundedRegions cl = new SurroundedRegions();
        char[][] matrix = {
                new char[]{'O'},
        };
        cl.solve(matrix);

        assertArrayEquals(new char[][]{
                new char[]{'O'},
        }, matrix);
    }

    @Test
    void solve_4() {
        SurroundedRegions cl = new SurroundedRegions();
        char[][] matrix = {
                new char[]{'O', 'O'},
                new char[]{'O', 'O'}
        };
        cl.solve(matrix);

        assertArrayEquals(new char[][]{
                new char[]{'O', 'O'},
                new char[]{'O', 'O'}
        }, matrix);
    }
}