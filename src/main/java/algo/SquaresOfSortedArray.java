package algo;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 */
public class SquaresOfSortedArray {
    /**
     * 2-pointers solution
     * Time complexity: O(N)
     * Space complexity: O(1) not counting space for result
     */
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int start = 0, end = nums.length - 1;
        int pointer = end;

        while (start <= end) {
            if (Math.abs(nums[start]) > Math.abs(nums[end])) res[pointer--] = nums[start] * nums[start++];
            else res[pointer--] = nums[end] * nums[end--];
        }

        return res;
    }

    /**
     * Time complexity: O(NlogN)
     * Space complexity: O(1)
     */
    public int[] sortedSquares_bruteforce(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] *= nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}
