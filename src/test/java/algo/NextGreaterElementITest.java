package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NextGreaterElementITest {

    @Test
    void nextGreaterElement() {
        NextGreaterElementI cl = new NextGreaterElementI();
        assertArrayEquals(new int[]{-1, 3, -1}, cl.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2}));
        assertArrayEquals(new int[]{-1, 3, -1},
                cl.nextGreaterElement_bruteForce_onPlace(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2}));
        assertArrayEquals(new int[]{-1, 3, -1},
                cl.nextGreaterElement_bruteForce_extraMemory(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2}));
    }
}