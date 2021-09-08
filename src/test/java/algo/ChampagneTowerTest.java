package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChampagneTowerTest {

    @Test
    void champagneTower() {
        ChampagneTower cl = new ChampagneTower();
//        assertEquals(1.0, cl.champagneTower(1, 0, 0));
//        assertEquals(1.0, cl.champagneTower(2, 0, 0));
//        assertEquals(0.5, cl.champagneTower(2, 1, 0));
        assertEquals(0.5, cl.champagneTower(2, 1, 1));
        assertEquals(1.0, cl.champagneTower(3, 1, 1));
        assertEquals(0.0, cl.champagneTower(3, 2, 1));
        assertEquals(0.25, cl.champagneTower(4, 2, 0));
        assertEquals(0.5, cl.champagneTower(4, 2, 1));

        assertEquals(1.0, cl.champagneTower(100000009, 33, 17));
    }
}