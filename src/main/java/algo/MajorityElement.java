package algo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/majority-element/
 */
public class MajorityElement {
    /**
     * Boyer-Moore Voting Algorithm
     * Time complexity: O(N)
     * Space complexity: O(1)
     */
    public int majorityElement(int[] nums) {
        int count = 1;
        int majority = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (count == 0) majority = nums[i];
            count += nums[i] == majority ? 1 : -1;
        }

        return majority;
    }

    /**
     * Divide and Conquer
     * Time complexity:
     *  T(N) = a*T(N/b) + pow(n,c)
     *  1. c > logbA, T(N) = O(pow(n,c))
     *  2. c = logbA, T(N) = O(pow(n,c)*logN)
     *  3. c < logbA, T(N) = O(pow(n,logbA))
     *
     *  T(N) = 2*T(N/2) + 2*N
     *  logbA = 1, c = 1 => 2nd case
     *
     *  O(N*logN)
     *
     * Space complexity: O(logN) for recursive calls (stack)
     */
    public int majorityElement_divideAndConquer(int[] nums) {
        if (nums.length < 3) return nums[0];
        return divideAndConquer(nums, 0, nums.length - 1);
    }

    private int divideAndConquer(int[] nums, int lo, int hi) {
        if (lo == hi) return nums[lo];

        int mid = lo + (hi - lo) / 2;
        int left = divideAndConquer(nums, lo, mid);
        int right = divideAndConquer(nums, mid + 1, hi);

        if (left == right) return left;

        int leftCount = count(left, nums, lo, hi);
        int rightCount = count(right, nums, lo, hi);

        return leftCount > rightCount ? left : right;
    }

    private int count(int value, int[] nums, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == value) count++;
        }
        return count;
    }

    /**
     * Sort based solution
     * Time complexity: O(N*logN)
     * Space complexity: O(1)
     */
    public int majorityElement_sort(int[] nums) {
        if (nums.length < 3) return nums[0];

        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * Hash map based solution
     * Time complexity: O(N)
     * Space complexity: O(N)
     */
    public int majorityElement_hashMap(int[] nums) {
        Map<Integer, Integer> hash = new HashMap<>();

        int majorityElement = -1;
        int maxCount = -1;

        for (int i : nums) {
            int count = hash.compute(i, (k, v) -> (v == null) ? 1 : v + 1);
            if (count > maxCount) {
                maxCount = count;
                majorityElement = i;
            }
        }

        return majorityElement;
    }
}
