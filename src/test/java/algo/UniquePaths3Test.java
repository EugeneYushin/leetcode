package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UniquePaths3Test {

    @Test
    void uniquePathsIII() {
        UniquePaths3 cl = new UniquePaths3();
        assertEquals(2, cl.uniquePathsIII(new int[][] {
                new int[] {1,0,0,0},
                new int[] {0,0,0,0},
                new int[] {0,0,2,-1}
        }));
    }
}