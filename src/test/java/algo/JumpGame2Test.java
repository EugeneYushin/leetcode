package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JumpGame2Test {
    JumpGame2 cl = new JumpGame2();

    @Test
    void jump_linear() {
        assertEquals(2, cl.jump_linear(new int[]{2, 3, 1, 1, 4}));
        assertEquals(3, cl.jump_linear(new int[]{2, 1, 3, 3, 2, 0, 5}));
        assertEquals(1, cl.jump_linear(new int[]{100, 0, 0, 0, 0}));
    }

    @Test
    void jump_dp() {
        assertEquals(2, cl.jump_linear(new int[]{2, 3, 1, 1, 4}));
        assertEquals(3, cl.jump_linear(new int[]{2, 1, 3, 3, 2, 0, 5}));
        assertEquals(1, cl.jump_linear(new int[]{100, 0, 0, 0, 0}));
    }
}