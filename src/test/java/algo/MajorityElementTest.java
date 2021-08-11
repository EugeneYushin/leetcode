package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MajorityElementTest {
    @Test
    void majorityElement() {
        MajorityElement cl = new MajorityElement();
        assertEquals(3, cl.majorityElement(new int[]{3, 2, 3}));
        assertEquals(2, cl.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

    @Test
    void majorityElement_divideAndConquer() {
        MajorityElement cl = new MajorityElement();
        assertEquals(3, cl.majorityElement_divideAndConquer(new int[]{3, 2, 3}));
        assertEquals(2, cl.majorityElement_divideAndConquer(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

    @Test
    void majorityElement_hashMap() {
        MajorityElement cl = new MajorityElement();
        assertEquals(3, cl.majorityElement_hashMap(new int[]{3, 2, 3}));
        assertEquals(2, cl.majorityElement_hashMap(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

    @Test
    void majorityElement_sort() {
        MajorityElement cl = new MajorityElement();
        assertEquals(3, cl.majorityElement_sort(new int[]{3, 2, 3}));
        assertEquals(2, cl.majorityElement_sort(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }
}