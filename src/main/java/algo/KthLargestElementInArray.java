package algo;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        return findKthLargest_quickselect(nums, k);
    }

    /**
     * Quickselect (Divide and Conquer)
     * Time complexity:
     * T(N) = 1*T(N/2) + O(N)
     * logbA = log1 = 0
     * n^c = n^1 => c = 1
     * logba < n^c
     *
     * T(N) = O(n^c) = O(N)
     * or via geometric series: https://en.wikipedia.org/wiki/Geometric_series
     *
     * Space complexity: O(logN)
     */
    public int findKthLargest_quickselect(int[] nums, int k) {
        return quickselect(nums, 0, nums.length - 1, k);
    }

    private int quickselect(int[] nums, int lo, int hi, int k) {
        int p = partition(nums, lo, hi);

        if (k == p + 1) return nums[p];
        else if (k > p + 1) return quickselect(nums, p + 1, hi, k);
        else return quickselect(nums, lo, p - 1, k);
    }

    private int pivot(int[] nums, int lo, int hi) {
        int mid = lo + (hi - lo) / 2;
        if (nums[lo] < nums[mid]) swap(nums, lo, mid);
        if (nums[hi] < nums[lo]) swap(nums, lo, hi);
        if (nums[hi] < nums[mid]) swap(nums, hi, mid);
        return nums[hi];
    }

    // Lomuto partition
    private int partition(int[] nums, int lo, int hi) {
        int pivot = pivot(nums, lo, hi);
        int i = lo - 1;

        // descending order
        for (int j = lo; j < hi; j++) {
            if (nums[j] > pivot) swap(nums, ++i, j);
        }

        swap(nums, hi, ++i);
        return i;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * Heap base solution
     * Time complexity: O(N*logK)
     * Space complexity: O(logK)
     */
    public int findKthLargest_heap(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(k);
        for (int num : nums) {
            if (q.size() == k) {
                if (q.peek() < num) {
                    q.poll();
                    q.add(num);
                }
            } else {
                q.add(num);
            }
        }

        return q.poll();
    }

    /**
     * Sort base solution
     *
     * Time complexity: O(N*logN)
     * Space complexity: O(logN), depends on sort algo implementation
     * (quick sort is the default algo, but still might use/not use different optimizations)
     */
    public int findKthLargest_sort(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
