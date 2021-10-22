package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomizedSetTest {

    @Test
    void getRandom() {
        RandomizedSet cl = new RandomizedSet();
//        assertTrue(cl.insert(1));
//        assertFalse(cl.remove(2));
//        assertTrue(cl.insert(2));
//        System.out.println(cl.getRandom());
//        assertTrue(cl.remove(1));
//        assertFalse(cl.insert(2));
//        assertEquals(2, cl.getRandom());

        cl = new RandomizedSet();
        assertTrue(cl.insert(0));
        assertTrue(cl.insert(1));
        assertTrue(cl.remove(0));
        assertTrue(cl.insert(2));
        assertTrue(cl.remove(1));
        assertEquals(2, cl.getRandom());
    }
}