package algo;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/find-median-from-data-stream/
 */
class MedianFinder {
    PriorityQueue<Integer> left;    // max heap
    PriorityQueue<Integer> right;   // min heap

    public MedianFinder() {
        left = new PriorityQueue<>(Comparator.reverseOrder());
        right = new PriorityQueue<>();
    }

    /**
     * Time complexity: O(logN)
     * Space complexity: O(logN)
     * N - current size of the stream
     */
    public void addNum(int num) {
        left.add(num);
        right.add(left.poll());

        if (left.size() < right.size()) {
            left.add(right.poll());
        }
    }

    /**
     * Time complexity: O(1)
     */
    public double findMedian() {
        if (left.size() == right.size()) return (left.peek() + right.peek()) / 2.0;
        else return left.peek();
    }
}
