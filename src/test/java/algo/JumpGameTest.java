package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JumpGameTest {
    JumpGame cl = new JumpGame();

    @Test
    void canJumpExponential() {
        assertTrue(cl.canJumpExponential(new int[]{2, 3, 1, 1, 4}));
        assertFalse(cl.canJumpExponential(new int[]{3,2,1,0,4}));
    }

    @Test
    void canJumpDP() {
        assertTrue(cl.canJumpDP(new int[]{2, 3, 1, 1, 4}));
        assertFalse(cl.canJumpDP(new int[]{3,2,1,0,4}));
    }

    @Test
    void canJumpEager() {
        assertTrue(cl.canJumpEager(new int[]{2, 3, 1, 1, 4}));
        assertFalse(cl.canJumpEager(new int[]{3,2,1,0,4}));
    }
}