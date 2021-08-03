package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumPathSumTest {

    MinimumPathSum cl = new MinimumPathSum();

    @Test
    void minPathSum_ramN2() {
        assertEquals(7, cl.minPathSum_ramN2(new int[][] {
                new int[] {1,3,1},
                new int[] {1,5,1},
                new int[] {4,2,1},
        }));
    }

    @Test
    void minPathSum_ramN() {
//        assertEquals(7, cl.minPathSum_ramN(new int[][] {
//                new int[] {1,3,1},
//                new int[] {1,5,1},
//                new int[] {4,2,1},
//        }));

        assertEquals(3, cl.minPathSum_ramN(new int[][] {
                new int[] {1,2},
                new int[] {1,1},
        }));
    }
}