package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedianFinderTest {

    @Test
    void findMedian() {
        MedianFinder cl = new MedianFinder();
        cl.addNum(1);
        assertEquals(1.0, cl.findMedian());

        cl.addNum(2);
        assertEquals(1.5, cl.findMedian());

        cl.addNum(3);
        assertEquals(2.0, cl.findMedian());
    }

    @Test
    void findMedian_1() {
        MedianFinder cl = new MedianFinder();
        cl.addNum(6);
        assertEquals(6, cl.findMedian());

        cl.addNum(10);
        assertEquals(8.0, cl.findMedian());

        cl.addNum(2);
        assertEquals(6.0, cl.findMedian());
    }

    @Test
    void findMedian_2() {
        MedianFinder cl = new MedianFinder();
        cl.addNum(12);
        assertEquals(12, cl.findMedian());

        cl.addNum(10);
        assertEquals(11, cl.findMedian());

        cl.addNum(13);
        assertEquals(12, cl.findMedian());

        cl.addNum(11);
        assertEquals(11.5, cl.findMedian());

        cl.addNum(5);
        assertEquals(11, cl.findMedian());
    }
}