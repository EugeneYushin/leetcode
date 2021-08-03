package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClimbingStairsTest {
    ClimbingStairs cl = new ClimbingStairs();

    @Test
    void climbStairs() {
        assertEquals(1, cl.climbStairs(1));
        assertEquals(2, cl.climbStairs(2));
        assertEquals(3, cl.climbStairs(3));
        assertEquals(5, cl.climbStairs(4));
    }
}